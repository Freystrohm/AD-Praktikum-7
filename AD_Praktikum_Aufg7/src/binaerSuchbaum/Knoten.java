/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package binaerSuchbaum;

public interface Knoten<T extends Comparable<T>> {
	public T getElement();

	public Knoten<T> getKnotenLinks();

	public Knoten<T> getKnotenRechts();
}
