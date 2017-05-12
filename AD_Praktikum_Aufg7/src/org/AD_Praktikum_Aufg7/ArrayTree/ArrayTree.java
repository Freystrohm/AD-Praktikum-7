package org.AD_Praktikum_Aufg7.ArrayTree;

import binaerSuchbaum.BinSuchbaum;
import binaerSuchbaum.Knoten;
import org.AD_Praktikum_Aufg7.HeapSort.*;
/**
 * ArrayTree
 * 
 * Contains an array with tree logic.
 * @author Beck Philipps
 *
 * @param <T>
 */
public class ArrayTree<T extends Comparable<T>> extends BinSuchbaum<T> {

	// hoehe des Baums
	private int height;

	// insertpointer
	int insertPointer = 0;

	// Baumrepräsentierendes Array
	private Knoten[] array;

	public ArrayTree(int height) {
		this.height = height;

		// calculaiting the length of the array
		int arrayLength = (int) (Math.pow(2, height + 1) - 1);

		array = new Knoten[arrayLength];

	}

	@Override
	public void insertKnoten(Knoten<T> knoten) {
		array[insertPointer++] = knoten;
		Heap.sort((Comparable[]) array);

	}

	@Override
	public int getNumberOfNodes() {
		return array.length;
	}

	public static void main(String[] args) {
		ArrayTree<Integer> tree = new ArrayTree(3);
		System.out.println(tree.getNumberOfNodes());
	}

}
