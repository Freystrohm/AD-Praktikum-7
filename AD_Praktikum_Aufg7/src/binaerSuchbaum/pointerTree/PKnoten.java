/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package binaerSuchbaum.pointerTree;

import binaerSuchbaum.Knoten;

class PKnoten<T extends Comparable<T>> implements Knoten<T>
{
	PKnoten <T> father, sonLinks, sonRechts;
	T element;

	@Override
	public T getElement()
	{
		return element;
	}

	@Override
	public Knoten<T> getKnotenSonLinks()
	{
		return sonLinks;
	}

	@Override
	public Knoten<T> getKnotenSonRechts()
	{
		return sonRechts;
	}

	@Override
	public Knoten<T> getKnotenFather()
	{
		return father;
	}

}
