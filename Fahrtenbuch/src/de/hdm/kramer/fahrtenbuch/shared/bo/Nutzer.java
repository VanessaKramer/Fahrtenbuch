package de.hdm.kramer.fahrtenbuch.shared.bo;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Ein Nutzer ggf. Fahrer zeichnet sich durch einen Vornamen, Nachnamen, Emailadresse, 
 * einem Fahrtenbuch und einem PKW aus.  
 * 
 * @author Vanessa Kramer
 */


public class Nutzer extends BusinessObject implements IsSerializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 *  Vorname eines Nutzers 	
	 */
		private String vorname;
	/**
	 * Nachname eines Nutzers
	 */
		private String name;
	/**
	 * Emailadresse eines Nutzers
	 */
		private String email;
	/**
	 * Fahrtenbuch eines Nutzers
	 */
		private Fahrtenbuch fahrtenbuch;
	/**
	 * Pkw eines Nutzer
	 */
		private Pkw pkw;
	
		/**
		 *  Passwort eines Nutzers. 
		 */
	
		private String passwort;
		
	/**
	 * 
	 * Auslesen des Vornamens 
	 */
		public String getVorname() {
			return vorname;
		}
			
	/**
	 * 
	 * Setzen eines Vornamens 
	 */
		public void setVorname(String vorname) {
			this.vorname = vorname;
		}
		
	/**
	 * Auslesen eines Nachnamens
	 */
		public String getName() {
			return name;
		}
			
	/**
	 * Setzen eines Nachnamens 
	 */
		public void setName(String name) {
			this.name = name;
		}
			
	/**
	 * 
	 * Auslesen der Emailadresse eines Nutzers 
	 */
		public String getEmail() {
			return email;
		}
			
	/**
	 * 
	 * Setzen einer Emailadresse
	 */
		public void setEmail(String email) {
			this.email = email;
		}
		
	/**
	 * 
	 * Auslesen des Fahrtenbuchs
	 */
		public Fahrtenbuch getFahrtenbuch() {
			return fahrtenbuch;
		}
		
	/**
	 * Setzen des Fahrtenbuchs
	 */
		public void setFahrtenbuch(Fahrtenbuch fahrtenbuch) {
			this.fahrtenbuch = fahrtenbuch;
		}
		
	/**
	 * 
	 * Auslesen des Pkws
	 */
		public Pkw getPkw() {
			return pkw;
		}
			
	/**
	 * Setzen des Pkws
	 */
		public void setPkw(Pkw pkw) {
			this.pkw = pkw;
		}

	/**
	 * Repräsentierung einer Nutzerinstanz als String
	 */
		public String toString() {
		    return this.vorname + " " + this.name+ " "+ this.email;
		  }

		//Konstruktor
		
		public Nutzer(){
			
		};
		
	 	public Nutzer (String vorname, String nachname, String email, String passwort){
	 		this.vorname=vorname;
	 		this.name= nachname;
	 		this.email=email;
	 		this.passwort=passwort;
	 	}
	 	
	 	// Für den Mapper beim Auslesen aus der Datenbank, da id und erstellungsZeitpunkt von DB vergeben werden

		
	 	
	 	/** 
		 * Auslesen des Passworts.
		 * @return
		 */

		public String getPasswort() {
			return passwort;
		}

		/**
		 * Setzen des Passworts.
		 * @param passwort
		 */

		public void setPasswort(String passwort) {
			this.passwort = passwort;
		}
		
		
		/**
		 * User Attribute auf null setzen und Cookies entfernen beim ausloggen.
		 */
		public void abmelden(){
			vorname = null;
			name = null;
			email = null;
			passwort = null;
			

			Cookies.removeCookie("Fb");
		}
			
}
