/**
 * @author Johannes Kruber
 */
package binaerSuchbaum;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Abstracte Klasse, die als Interface für die beiden Implementationen des
 * Binärbaumes fungiert und die verschiedenen Order Methoden bereitstellt
 * 
 * @author Johannes
 *
 * @param <T>
 */
public abstract class BinSuchbaum<T extends Comparable<T>>
{
	protected Knoten<T> wurzel;
	private LinkedList<Knoten<T>> list;

	public BinSuchbaum(Knoten<T> wurzel)
	{
		this.wurzel = wurzel;
	}

	/**
	 * Funktion zum einfügen eines Knotens in den Binärbaum
	 * 
	 * @param knoten:
	 *            einzufügender Knoten
	 */
	public abstract void insertKnoten(Knoten<T> knoten);

	/**
	 * Funktion für die Array darstellung des baumes nach dem Inorder Prinzip
	 * 
	 * @return: Der Baum dargestellt als nach inorder sortiertes Array
	 */
	public T[] getInorder()
	{
		list = new LinkedList<Knoten<T>>();

		if (wurzel.getKnotenSonLinks() != null)
		{
			inorderLeft(wurzel.getKnotenSonLinks());
		}
		if (wurzel.getKnotenSonRechts() != null)
		{
			inorderRight(wurzel.getKnotenSonRechts());
		}

		return listToTArray();
	}

	/**
	 * wandelt die Liste in ein T[] array um
	 * 
	 * @return T[]
	 */
	private T[] listToTArray()
	{
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[list.size()];

		for (int i = 0; i < array.length; i++)
		{
			array[i] = list.get(i).getElement();
		}
		return array;
	}

	/**
	 * Funktion für die linken Teilbäume
	 * 
	 * @param k
	 */
	private void inorderLeft(Knoten<T> k)
	{
		list.add(list.indexOf(k.getKnotenFather()), k);
		if (k.getKnotenSonLinks() != null)
		{
			inorderLeft(k.getKnotenSonLinks());
		}
		if (k.getKnotenSonRechts() != null)
		{
			inorderRight(k.getKnotenSonRechts());
		}
	}

	/**
	 * Funktion für die rechten Teilbäume
	 * 
	 * @param k
	 */
	private void inorderRight(Knoten<T> k)
	{
		list.add(list.indexOf(k.getKnotenFather()) + 1, k);
		if (k.getKnotenSonLinks() != null)
		{
			inorderLeft(k.getKnotenSonLinks());
		}
		if (k.getKnotenSonRechts() != null)
		{
			inorderRight(k.getKnotenSonRechts());
		}
	}

	/**
	 * Funktion für die Array Darstellung des Baumes nach dem Preorder Prinzip
	 * 
	 * @return: Der Baum dargestellt als nach preorder sortiertes Array
	 */
	public T[] getPreorder()
	{
		return null;
	}

	/**
	 * Funktion für die Array Darstellung des Baumes nach dem Postorder Prinzip
	 * 
	 * @return: Der Baum dargestellt als nach postorder sortiertes Array
	 */
	public T[] getPostorder()
	{
		return null;
	}

	public int sum(int min, int max)
	{
		Knoten<T> minKnoten, maxKnoten, wurzel = this.wurzel;
		if (wurzel.getElement() instanceof Integer)
		{
			while ((int) wurzel.getElement() > max
					|| (int) wurzel.getElement() < min)
			{
				if ((int) wurzel.getElement() > max)
				{
					wurzel = wurzel.getKnotenSonLinks();
				}
				else if ((int) wurzel.getElement() < min)
				{
					wurzel = wurzel.getKnotenSonRechts();
				}
			}

			minKnoten = wurzel;
			maxKnoten = wurzel;

			while ((int) minKnoten.getKnotenSonLinks().getElement() >= min)
			{
				minKnoten = minKnoten.getKnotenSonLinks();
			}

			while ((int) maxKnoten.getKnotenSonRechts().getElement() >= min)
			{
				minKnoten = minKnoten.getKnotenSonRechts();
			}

			return wurzel.getSumLinks() + wurzel.getSumRechts()
					- minKnoten.getSumLinks() - maxKnoten.getSumRechts() + (int)wurzel.getElement();

		}
		return 0;
	}
}
