/**
 * 
 * @author Johannes Kruber
 *
 */

package binaerSuchbaum;

/**
 * Interface für die darstellung der Knoten
 * 
 * @author Johannes
 *
 * @param <T>
 */
public interface Knoten<T extends Comparable<T>>
{
	public T getElement();
	

	public Knoten<T> getKnotenSonLinks();

	public Knoten<T> getKnotenSonRechts();

	public Knoten<T> getKnotenFather();
	
	public void setSumUeberKnoten(int sum);
	
	public void addToSumUeberKnoten(int toAdd);
	
	public int getSumUeberKnoten();
}
