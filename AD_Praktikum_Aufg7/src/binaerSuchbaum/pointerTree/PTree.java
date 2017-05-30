/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package binaerSuchbaum.pointerTree;

import java.util.Iterator;
import java.util.LinkedList;

import binaerSuchbaum.BinSuchbaum;
import binaerSuchbaum.Knoten;

public class PTree<T extends Comparable<T>> extends BinSuchbaum<T> {

	public LinkedList<PKnoten<T>> sumList = new LinkedList<>(); 
	
	public PTree(PKnoten<T> wurzel) {
		super(wurzel);
		wurzel.addToSumUeberKnoten((Integer)wurzel.getElement());
		sumList.add((PKnoten<T>) wurzel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertKnoten(Knoten<T> knoten) {
		if (knoten instanceof PKnoten) {
			PKnoten<T> father = (PKnoten<T>) super.wurzel;
			while (true) {
				if (knoten.getElement().compareTo(father.getElement()) > 0) {
					if (father.getKnotenSonRechts() == null) {
						father.sonRechts = (PKnoten<T>) knoten;
						father.addToSumUeberKnoten((Integer)knoten.getElement());
						knoten.addToSumUeberKnoten((Integer)knoten.getElement());
						((PKnoten) knoten).setFather(father);
						sumList.add((PKnoten<T>) knoten);
						break;
					} else {
						father.addToSumUeberKnoten((Integer)knoten.getElement());
						father = father.sonRechts;
					}

				} else if (knoten.getElement().compareTo(father.getElement()) < 0) {
					if (father.sonLinks == null) {
						father.sonLinks = (PKnoten<T>) knoten;
						father.addToSumUeberKnoten((Integer)knoten.getElement());
						knoten.addToSumUeberKnoten((Integer)knoten.getElement());
						((PKnoten) knoten).setFather(father);
						sumList.add((PKnoten<T>) knoten);
						break;
					} else {
						father.addToSumUeberKnoten((Integer)knoten.getElement());
						father = father.sonLinks;
					}
				} else {
					System.out.println("Knoten schon vorhanden");
					break;
				}
			}

		} else {
			System.out.println("Falscher Knoten");
		}
	}

	/**
	 * Hilfsmethode zum Ausgeben der Symmetrischenreihenfolge.
	 * 
	 * @param k
	 */
	public void inorder(PKnoten<T> k) {
		if (k.getKnotenSonLinks() != null) {
			inorder((PKnoten<T>) k.getKnotenSonLinks());
		}
		System.out.print(k.getElement() + " ");

		if (k.getKnotenSonRechts() != null) {
			inorder((PKnoten<T>) k.getKnotenSonRechts());
		}

	}
	
	/**
	 * Hilfsmethode zum Ausgeben der Hauptreihenfolge.
	 * 
	 * @param k
	 */
	public void preorder(PKnoten<T> k) {
		System.out.print(k.getElement() + " ");
		if (k.getKnotenSonLinks() != null) {
			preorder((PKnoten<T>) k.getKnotenSonLinks());
		}
		if (k.getKnotenSonRechts() != null) {
			preorder((PKnoten<T>) k.getKnotenSonRechts());
		}

	}

	/**
	 * Hilfsmethode zum Ausgeben der Nebenreihenfolge.
	 * 
	 * @param k
	 */
	public void postorder(PKnoten<T> k) {

		if (k.getKnotenSonLinks() != null) {
			postorder((PKnoten)k.getKnotenSonLinks());
		}
		if (k.getKnotenSonRechts() != null) {
			postorder((PKnoten)k.getKnotenSonRechts());
		}
		System.out.print(k.getElement() + " ");

	}
	
	private int identitfyTreeSide(PKnoten node){
		if (node.getElement().compareTo(this.wurzel.getElement()) == 0) {
			return 0;
		} else if (node.getElement().compareTo(this.wurzel.getElement()) < 0) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public PKnoten findValueNodeNearM(int m){
		PKnoten smallestDiffNode =	null;
		Integer smallestDiff = wurzel.getSumUeberKnoten();
		Iterator<PKnoten<T>> iterator = sumList.iterator();
		do{
			PKnoten node = iterator.next();
			if((Integer) node.getElement()- m >= 0 && (Integer) node.getElement()- m <= smallestDiff){
				smallestDiffNode = node;
				smallestDiff =  (Integer) node.getElement()- m;
			}
		}while(iterator.hasNext());
		
		return smallestDiffNode;
	}
	
	public int getSummeZwischenKnonten(int m, int M){
		int sum = 0;
		
		PKnoten nodeA = findValueNodeNearM(m);
		PKnoten nodeB = findValueNodeNearM(M);
		
		int knotenAistAufSeite = identitfyTreeSide(nodeA);
		int knotenBistAufSeite = identitfyTreeSide(nodeB);

		if (knotenAistAufSeite == 1 && knotenBistAufSeite == 1) {
			sum = wurzel.getSumUeberKnoten() - wurzel.getKnotenSonLinks().getSumUeberKnoten() - (nodeA.getSumUeberKnoten()
					+ nodeB.getSumUeberKnoten() + (Integer) wurzel.getElement());
		} else {
			sum = (Integer) wurzel.getSumUeberKnoten()
					- ((Integer) nodeA.getSumUeberKnoten() + (Integer) nodeB.getSumUeberKnoten());
		}
		
		return sum;
	}

	public static void main(String[] args) {
		PTree<Integer> tree = new PTree(new PKnoten<Integer>(3));
		tree.insertKnoten(new PKnoten<Integer>(2));
		tree.insertKnoten(new PKnoten<Integer>(5));
		tree.insertKnoten(new PKnoten<Integer>(6));
		int a = 0;
		tree.postorder((PKnoten) tree.wurzel);
		System.out.println("Summe zwischen Knoten: "+tree.getSummeZwischenKnonten(1, 6));
	}

}
