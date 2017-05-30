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

	public AKnoten(T wert) {
		this.wert = wert;
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
		return null;
	}

	@Override
	public Knoten<T> getKnotenSonRechts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Knoten<T> getKnotenFather() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSumUeberKnoten(int sum) {
		this.sumUeberKnoten = sum;

	}

	@Override
	public void addToSumUeberKnoten(int toAdd) {
		sumUeberKnoten += toAdd;
	}

	@Override
	public int getSumUeberKnoten() {
		// TODO Auto-generated method stub
		return sumUeberKnoten;
	}

}