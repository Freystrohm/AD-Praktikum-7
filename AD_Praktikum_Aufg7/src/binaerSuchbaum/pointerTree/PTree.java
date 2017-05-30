/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package binaerSuchbaum.pointerTree;

import binaerSuchbaum.BinSuchbaum;
import binaerSuchbaum.Knoten;

public class PTree<T extends Comparable<T>> extends BinSuchbaum<T>
{

	public PTree(PKnoten<T> wurzel)
	{
		super(wurzel);
		wurzel.sumlinks = 0;
		wurzel.sumrechts = 0;
	}

	@Override
	public void insertKnoten(Knoten<T> knoten)
	{
		if (knoten instanceof PKnoten)
		{
			PKnoten<T> father = (PKnoten<T>) super.wurzel;
			while (true)
			{
				if (knoten.getElement().compareTo(father.getElement()) < 0)
				{
					if (knoten.getElement() instanceof Integer)
					{
						father.sumlinks += (int) knoten.getElement();
					}
					if (father.getKnotenSonLinks() == null)
					{
						father.sonLinks = (PKnoten<T>) knoten;
						break;
					}
					else
					{
						father = father.sonLinks;
					}

				}
				else if (father.getElement().compareTo(knoten.getElement()) > 0)
				{
					if (knoten.getElement() instanceof Integer)
					{
						father.sumrechts += (int) knoten.getElement();
					}
					if (father.sonRechts == null)
					{
						father.sonRechts = (PKnoten<T>) knoten;
						break;
					}
					else
					{
						father = father.sonRechts;
					}
				}
				else
				{
					System.out.println("Knoten schon vorhanden");
					break;
				}
			}

			((PKnoten) knoten).father = father;
		}
		else
		{
			System.out.println("Falscher Knoten");
		}
	}

}
