/**
 * PM2 Praktikum
 * @author Johannes Kruber
 */
package binaerSuchbaum;

public abstract class BinSuchbaum<T extends Comparable<T>>
{
	private Knoten<T> wurzel;
	
	public abstract void insertKnoten(Knoten<T> knoten);
	
	public T[] getInsort()
	{
		return null;
	}
	
	public T[] getPresort()
	{
		return null;
	}
	
	public T[] getPostsort()
	{
		return null;
	}
}
