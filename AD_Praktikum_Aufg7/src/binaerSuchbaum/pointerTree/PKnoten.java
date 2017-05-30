/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package binaerSuchbaum.pointerTree;

import binaerSuchbaum.Knoten;

public class PKnoten<T extends Comparable<T>> implements Knoten<T>
{
	PKnoten<T> father, sonLinks, sonRechts;
	public T element;
	int sumlinks, sumrechts;

	public PKnoten(T value)
	{
		element = value;
		sumlinks = 0;
		sumrechts = 0;
	}

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

	@Override
	public int getSumRechts()
	{
		return sumrechts;
	}

	@Override
	public int getSumLinks()
	{
		return sumlinks;
	}

}
