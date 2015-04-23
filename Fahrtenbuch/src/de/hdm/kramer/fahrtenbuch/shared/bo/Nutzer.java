package de.hdm.kramer.fahrtenbuch.shared.bo;

import com.google.gwt.user.client.rpc.IsSerializable;


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
		    return super.toString() + " " + this.vorname + " " + this.name+ " "+ this.email;
		  }

		
}
