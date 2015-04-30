package de.hdm.kramer.fahrtenbuch.shared.bo;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Ein PKW zeichnet sich durch seinen Modellnamen und seinem Baujahr aus.
 * 
 */

public class Pkw extends BusinessObject implements IsSerializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Fahrzeugmodell des PKWs (z. Bsp.VW Golf VI, VW Golf Passat B8)
	 */
	private String modell;
	
	/**
	 * Baujahr des PKWs
	 */
	private int baujahr;
	
	
	/**
	 * Auslesen des Modellnamens
	 */
	public String getModellName(){
		return modell;
	}
	
	/**
	 * Methode zum Setzen des Modellnamens des PKWs 
	 */
	public void setModellName(String modell) {
		this.modell = modell;
	}
	
	/**
	 * Auslesen des Baujahres
	 */
	public int getBaujahr(){
		return baujahr;
	}
	
	/**
	 * Methode zum Setzen des Baujahres 
	 */
	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
	
	/**
	 * Repräsentierung einer PKWinstanz als String
	 */
		public String toString() {
		    return "PKW-Modell "+ this.modell + "Baujahr" + this.baujahr;
		  }

}