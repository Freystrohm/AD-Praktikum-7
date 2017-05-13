/**
 * PM2 Praktikum
 * @author Johannes Kruber
 */
package binaerSuchbaum;

public abstract class BinSuchbaum<T extends Comparable<T>>
{
	private Knoten<T> wurzel;
	
	public BinSuchbaum(Knoten<T> wurzel)
	{
		this.wurzel = wurzel;
	}
	
	public abstract void insertKnoten(Knoten<T> knoten);
	
	public T[] getInorder()
	{
		return null;
	}
	
	public T[] getPreorder()
	{
		return null;
	}
	
	public T[] getPostorder()
	{
		return null;
	}
}
