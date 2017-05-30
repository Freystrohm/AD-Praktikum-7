/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Luis Nickel 
 */

package binaerSuchbaum.pointerTree;

import binaerSuchbaum.Knoten;

public class PKnoten<T extends Comparable<T>> implements Knoten<T>
{
	public  PKnoten <T> father, sonLinks, sonRechts;
	public T element;
	public int sumUeberKnoten;

	public PKnoten (T value){
		element = value;
	}
	
	public PKnoten (){
		
	}
	
	@Override
	public T getElement()
	{
		return element;
	}

	@Override
	public Knoten<T> getKnotenSonLinks()
	{
		return sonLinks;
	}

	@Override
	public Knoten<T> getKnotenSonRechts()
	{
		return sonRechts;
	}

	@Override
	public Knoten<T> getKnotenFather()
	{
		return father;
	}

	@Override
	public void setSumUeberKnoten(int sum) {
		this.sumUeberKnoten = sum;
		
	}

	@Override
	public void addToSumUeberKnoten(int toAdd) {
		sumUeberKnoten+=toAdd;
	}
	
	@Override
	public int getSumUeberKnoten() {
		// TODO Auto-generated method stub
		return sumUeberKnoten;
	}
	
	public void setFather(PKnoten node){
		father=node;
	}
	

}
