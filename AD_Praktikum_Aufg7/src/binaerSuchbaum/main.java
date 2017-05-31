/**
 * PM2 Praktikum
 * @author Johannes Kruber
 * @author Luis Nickel 
 */
package binaerSuchbaum;

import java.util.Iterator;

import org.AD_Praktikum_Aufg7.ArrayTree.AKnoten;
import org.AD_Praktikum_Aufg7.ArrayTree.ArrayTree;
import org.AD_Praktikum_Aufg7.ArrayTree.AusgabeAuswahl;
import binaerSuchbaum.pointerTree.*;

public class main
{
	public static void main(String[] args)
	{
//		BinSuchbaum<Integer> a = new ArrayTree<Integer>(new AKnoten<Integer>(6)
//		{
//		});
//
//		a.insertKnoten((Knoten) new AKnoten<Integer>(4));
//		a.insertKnoten((Knoten) new AKnoten<Integer>(9));
//		a.insertKnoten((Knoten) new AKnoten<Integer>(10));
//		a.insertKnoten((Knoten) new AKnoten<Integer>(7));
//		a.insertKnoten((Knoten) new AKnoten<Integer>(8));
//		a.insertKnoten((Knoten) new AKnoten<Integer>(3));
//		a.insertKnoten((Knoten) new AKnoten<Integer>(5));
//		a.insertKnoten((Knoten) new AKnoten<Integer>(2));
//
//		System.out.println("Summe 3- 9:" + a.sum(3, 9));
		
		BinSuchbaum<Integer> b = new ArrayTree(new AKnoten<Integer>(6));

		b.insertKnoten(new AKnoten<Integer>(4));
		b.insertKnoten(new AKnoten<Integer>(9));
		b.insertKnoten(new AKnoten<Integer>(7));
		b.insertKnoten(new AKnoten<Integer>(8));
		b.insertKnoten(new AKnoten<Integer>(3));
		b.insertKnoten(new AKnoten<Integer>(5));
		
		b.inorder(b.wurzel);
		System.out.println("Sum: "+b.sum(8, 9));
		
	}

}
