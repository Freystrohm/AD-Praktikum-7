/**
*AD Paktikum
*@autor Daniel Nisch
*@autor Luis Nickel
*/
package org.AD_Praktikum_Aufg7.ArrayTree;

import binaerSuchbaum.Knoten;

public class AKnoten<T extends Comparable<T>> implements Knoten<T> {
	private AKnoten<T> linkerKindKnoten;
	private AKnoten<T> rechterKindKnoten;
	private T wert;
	private int sumUeberKnoten = 0;
	AKnoten[] array;
	private int indexImArray;
	int sumlinks, sumrechts, sumAlleKleinereZahlen;

	public AKnoten(T wert) {
		this.wert = wert;
		sumlinks = 0;
		sumrechts = 0;
		sumAlleKleinereZahlen = 0;
	}

	public T getElement() {
		return wert;
	}

	public AKnoten<T> getLinkenKindKnoten() {
		return linkerKindKnoten;
	}

	public AKnoten<T> getRechtenKindKnoten() {
		return rechterKindKnoten;
	}

	public void setLinkenKindKnoten(AKnoten<T> linkerKindKnoten) {
		this.linkerKindKnoten = linkerKindKnoten;
	}

	public void setRechtenKindKnoten(AKnoten<T> rechterKindKnoten) {
		this.rechterKindKnoten = rechterKindKnoten;
	}

	@Override
	public Knoten<T> getKnotenSonLinks() {
		// TODO Auto-generated method stub
		if (indexImArray * 2 + 1 >= array.length) {
			return null;
		}
		return array[indexImArray * 2 + 1];
	}

	@Override
	public Knoten<T> getKnotenSonRechts() {
		// TODO Auto-generated method stub
		return array[indexImArray * 2 + 2];
	}

	@Override
	public Knoten<T> getKnotenFather() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSumRechts() {
		// TODO Auto-generated method stub
		return sumrechts;
	}

	@Override
	public int getSumLinks() {
		// TODO Auto-generated method stub
		return sumlinks;
	}

	public void setIndex(int index) {
		this.indexImArray = index;
	}

	@Override
	public void addAlleZahlenKleiner(int toAdd) {
		sumAlleKleinereZahlen+=toAdd;
		
	}

	@Override
	public int getAlleZahlenKleiner() {
		// TODO Auto-generated method stub
		return sumAlleKleinereZahlen;
	}

}