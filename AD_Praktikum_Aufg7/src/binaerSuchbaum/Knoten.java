/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package binaerSuchbaum;

/**
 * Interface f�r die darstellung der Knoten
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
}
