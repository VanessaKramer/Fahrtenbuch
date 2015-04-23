package de.hdm.kramer.fahrtenbuch.shared.bo;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

// NOCH ZU BEARBEITEN

public class Fahrtenbuch extends BusinessObject implements IsSerializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Liste für Fahrten
	 *
	 */
	private ArrayList<Fahrt> fahrten;
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
	
	
	// muss evtl. noch geändert werden
	
	public String getAllFahrten() {
		String allFahrten = "";
		for(int i= 0; i <= fahrten.size(); i++) {
			allFahrten += "Fahrt:"+ i + fahrten + "\n";
		}
		return allFahrten;
	}
	
	/**
	 * Umwandlung einer Fahrtenbuchinstanz in einen String
	 */
	@Override
	public String toString() {
		return "Fahrtenbuch vom Nutzer:" + nutzer + "\n Fahrten: \n " + getAllFahrten();
	}
}
