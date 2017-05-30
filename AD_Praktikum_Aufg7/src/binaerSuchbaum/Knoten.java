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

	public int getSumRechts();

	public int getSumLinks();
}
