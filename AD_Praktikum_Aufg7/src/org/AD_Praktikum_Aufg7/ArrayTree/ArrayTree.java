package org.AD_Praktikum_Aufg7.ArrayTree;

import binaerSuchbaum.BinSuchbaum;
import binaerSuchbaum.Knoten;

public class ArrayTree<T extends Comparable<T>> extends BinSuchbaum<T> {

	// Array zum speichernd es Binären Suchbaums
	AKnoten[] array = new AKnoten[1000];

	public ArrayTree(AKnoten<T> wurzel) {
		super(wurzel);
		array[0] = wurzel;
		wurzel.setIndex(0);
	}

	/**
	 * Rekursive Hilfsmethode zum einsortieren Eines valuees.
	 * 
	 * @param knoten
	 *            welcher hinzugefügt werden soll
	 * @param index
	 *            an welchem der Knoten in das Array eingfügt werden soll
	 */
	@SuppressWarnings("unchecked")
	private void knotenEinfügen(AKnoten knoten, int index) {
		if (index >= array.length) {
			AKnoten[] tmpArray = new AKnoten[array.length * 10];
			System.arraycopy(array, 0, tmpArray, 0, array.length);
			array = tmpArray;
		}
		if (array[index] == null) {
			knoten.setIndex(index);
			array[index] = knoten;
		} else if (knoten.getElement().compareTo(array[index].getElement()) < 0) {
			array[index].sumlinks+=(int)knoten.getElement();
			knotenEinfügen(knoten, index * 2 + 1);
		} else {
			array[index].sumrechts+=(int)knoten.getElement();
			knotenEinfügen(knoten, index * 2 + 2);
		}

	}

	public void ausgabe(AusgabeAuswahl auswahl) {
		if (auswahl == AusgabeAuswahl.INORDER) {
			getInorder(0);
		} else if (auswahl == AusgabeAuswahl.PREORDER) {
			getPreorder(0);
		} else if (auswahl == AusgabeAuswahl.POSTORDER) {
			getPostorder(0);
		} else {
			System.out.println("wrong value");
		}

	}

	/**
	 * Hilfsmethode zum Ausgeben der Symmetrischenreihenfolge.
	 * 
	 * @param index:
	 *            Index im Array
	 */
	public void getInorder(int index) {
		if (array[index * 2 + 1] != null) {
			getInorder(index * 2 + 1);
		}
		System.out.print(array[index].getElement() + " ");

		if (array[index * 2 + 2] != null) {
			getInorder(index * 2 + 2);
		}

	}

	/**
	 * Hilfsmethode zum Ausgeben der Hauptreihenfolge.
	 * 
	 * @param index:
	 *            Index im Array
	 */
	private void getPreorder(int index) {
		System.out.print(array[index].getElement() + " ");
		if (array[index * 2 + 1] != null) {
			getPreorder(index * 2 + 1);
		}

		if (array[index * 2 + 2] != null) {
			getPreorder(index * 2 + 2);
		}

	}

	/**
	 * Hilfsmethode zum Ausgeben der Nebenreihenfolge.
	 * 
	 * @param index:
	 *            Index im Array
	 */
	private void getPostorder(int index) {

		if (array[index * 2 + 1] != null) {
			getPostorder(index * 2 + 1);
		}

		if (array[index * 2 + 2] != null) {
			getPostorder(index * 2 + 2);
		}
		System.out.print(array[index].getElement() + " ");

	}

	@Override
	public void insertKnoten(Knoten<T> knoten) {
		((AKnoten) knoten).array = array;
		if (array[0] == null) {
			array[0] = (AKnoten) knoten;
		} else if (knoten.getElement().compareTo((T) array[0].getElement()) < 0) {
			array[0].sumlinks+=(int)knoten.getElement();
			knotenEinfügen((AKnoten) knoten, 1);
		} else {
			array[0].sumrechts+=(int)knoten.getElement();
			knotenEinfügen((AKnoten) knoten, 2);
		}

	}

	private int getSummeAllerKinder(int index) {
		int summe = 0;
		if (array.length > index * 2 + 1 && array[index * 2 + 1] != null) {
			summe += getSummeAllerKinder(index * 2 + 1);
		}
		if (array.length > index * 2 + 2 && array[index * 2 + 2] != null) {
			summe += getSummeAllerKinder(index * 2 + 2);
		}
		return summe + (int) array[index].getElement();

	}

	/**
	 * identifyTreeSide
	 * 
	 * Identifys in which side of the tree the value is captured.
	 * 
	 * @param posArray
	 * @return 0 Value is root knode
	 * @return -1 Value is on the left side
	 * @return 1 Value is on the right side
	 */
	private int identitfyTreeSide(int posArray) {
		if (array[posArray].getElement().compareTo(array[0].getElement()) == 0) {
			return 0;
		} else if (array[posArray].getElement().compareTo(array[0].getElement()) < 0) {
			return -1;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		ArrayTree<Integer> a = new ArrayTree<Integer>(new AKnoten<Integer>(5) {
		});

		a.insertKnoten((Knoten) new AKnoten<Integer>(10));
		a.insertKnoten((Knoten) new AKnoten<Integer>(12));
		a.insertKnoten((Knoten) new AKnoten<Integer>(1));
		a.insertKnoten((Knoten) new AKnoten<Integer>(9));
		a.insertKnoten((Knoten) new AKnoten<Integer>(17));
		a.insertKnoten((Knoten) new AKnoten<Integer>(18));
		a.insertKnoten((Knoten) new AKnoten<Integer>(37));

		a.ausgabe(AusgabeAuswahl.INORDER);
		System.out.println("Summe aller Kinder" + a.getSummeAllerKinder(0));
	}

}