/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package binaerSuchbaum;

interface Knoten<T extends Comparable<T>>
{
	public T getElement();
	public T getKnotenLinks();
	public T getKnotenRechts();
}
