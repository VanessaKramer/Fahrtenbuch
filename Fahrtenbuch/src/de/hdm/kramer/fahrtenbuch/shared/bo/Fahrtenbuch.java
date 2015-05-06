package de.hdm.kramer.fahrtenbuch.shared.bo;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Die Fahrtenbuchklasse ist die Darstellungsfläche von jenem Nutzer. 
 * Auf dem Fahrtenbuch werden die dokumentierten Fahrten des Nutzers dargestellt. 
 * Ein Fahrtenbuch hat somit einen Nutzer(Betreiber) und eine Liste mit Fahrten.
 * 
 * @author Vanessa Kramer
 *
 */

public class Fahrtenbuch extends BusinessObject implements IsSerializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Liste für Fahrten
	 *
	 */
	private ArrayList<Fahrt> fahrten;
	
	/**
	 * Liste für PKWs
	 *
	 */
	private ArrayList<Pkw> pkws;
	
	/**
	 * Betreiber und Inhaber des Fahrtenbuchs
	 */
	private Nutzer nutzer;
	
	/**
	 * Methode zum Auslesen der Fahrten
	 *
	 */
	public ArrayList<Fahrt> getFahrten() {
		return fahrten;
	}
	/**
	 * Methode zum Setzen der Fahrten
	 *
	 */
	public void setFahrten(ArrayList<Fahrt> fahrten) {
		this.fahrten = fahrten;
	}
	/**
	 * Methode zum Auslesen der PKWs
	 *
	 */
	public ArrayList<Pkw> getPkws() {
		return pkws;
	}
	/**
	 * Methode zum Setzen der PKWs
	 *
	 */
	public void setPkws(ArrayList<Pkw> pkws) {
		this.pkws = pkws;
	}
	/**
	 * Methode zum Auslesen der Nutzer
	 *
	 */
	public Nutzer getNutzer() {
		return nutzer;
	}
	/**
	 * Methode zum Setzen der Nutzer
	 *
	 */
	public void setNutzer(Nutzer nutzer) {
		this.nutzer = nutzer;
	}
	
	
	/**
	 * Methode zum Auslesen aller Fahrten, welche als String zurückgegeben werden.
	 *
	 */
	public String getAllFahrten() {
		String allFahrten = "";
		for(int i= 0; i <= fahrten.size(); i++) {
			allFahrten += "Fahrt:"+ i + fahrten.get(i).toString() + "\n";
		}
		return allFahrten;
	}
	
	/**
	 * Methode zum Auslesen aller Pkws, welche als String zurückgegeben werden.
	 *
	 */
	public String getAllPkws() {
		String allPkws = "";
		for(int i= 0; i <= pkws.size(); i++) {
			allPkws += "PKW:"+ i + pkws.get(i).toString() + "\n";
		}
		return allPkws;
	}
	
	/**
	 * Umwandlung einer Fahrtenbuchinstanz in einen String
	 */
	@Override
	public String toString() {
		return "Fahrtenbuch vom Nutzer:" + nutzer + "\n Fahrten: \n " + getAllFahrten() +
				"\n Abteilungs-Fahrzeuge: \n " + getAllPkws();
	}
	
	
	//Konstruktor
	
	public Fahrtenbuch(){
				
	};

}
