/**
 * @author Johannes Kruber
 */
package binaerSuchbaum;

/**
 * Abstracte Klasse, die als Interface f�r die beiden Implementationen des
 * Bin�rbaumes fungiert und die verschiedenen Order Methoden bereitstellt
 * 
 * @author Johannes
 *
 * @param <T>
 */
public abstract class BinSuchbaum<T extends Comparable<T>>
{
	private Knoten<T> wurzel;

	
	public BinSuchbaum(Knoten<T> wurzel)
	{
		this.wurzel = wurzel;
	}
	
	/**
	 * Funktion zum einf�gen eines Knotens in den Bin�rbaum
	 * 
	 * @param knoten:
	 *            einzuf�gender Knoten
	 */
	public abstract void insertKnoten(Knoten<T> knoten);
	
	public T[] getInorder()
	{
		return null;
	}

	/**
	 * Funktion f�r die Array darstellung des baumes nach dem Preorder Prinzip
	 * 
	 * @return: Der Baum dargestellt als nach preorder sortiertes Array
	 */
	public T[] getPreorder()
	{
		return null;
	}

	/**
	 * Funktion f�r die Array darstellung des baumes nach dem Postorder Prinzip
	 * 
	 * @return: Der Baum dargestellt als nach postorder sortiertes Array
	 */
	public T[] getPostorder()
	{
		return null;
	}
}
