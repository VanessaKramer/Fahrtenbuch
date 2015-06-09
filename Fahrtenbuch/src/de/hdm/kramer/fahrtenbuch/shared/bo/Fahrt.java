package de.hdm.kramer.fahrtenbuch.shared.bo;

import java.sql.Timestamp;
import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Mit dieser Klasse werden Fahrtobjekte realisiert. Eine Fahrt besteht aus einem PKW,
 * einer Abfahrtszeit, einer Ankunftszeit, einem Abfahrtsort, einem Ankunftsort, einem Fahrtzweck
 * einem Anfangskilometer-Stand und einem Endkilometer-Stand.
 *
 * @author Vanessa Kramer
 */


public class Fahrt extends BusinessObject implements IsSerializable, Comparable<Fahrt> {

	private static final long serialVersionUID = 1L;
	
	/**
	* Der Fahrer der Fahrt
	*/
	private Nutzer nutzer;
	
	/**
	* Der PKW der Fahrt
	*/
	private Pkw pkw;
	
	/**
	* Das Fahrtenbuch, die einer Fahrteninstanz zugeordnet ist.
	*/
	private Fahrtenbuch fahrtenbuch;
	
	
	/**
	 * Die Abfahrtszeit der Fahrt
	 */
	private Timestamp abfahrtsZeit;
	
	/**
	 * Die Ankunftszeit der Fahrt
	 */
	private Timestamp ankunftsZeit;
	
	/**
	 * Die Abfahrtsort der Fahrt
	 */
	private String abfahrtsOrt;
	
	/**
	 * Die Ankunftsort der Fahrt
	 */
	private String ankunftsOrt;
	
	/**
	 * Zweck der Fahrt (z.Bsp privat, geschäftlich)
	 */
	private String fahrtZweck;
	
	/**
	 * km-Stand zu Beginn der Fahrt
	 */
	private int kmStandAnfang;
	
	/**
	 * km-Stand am Ende der Fahrt
	 */
	private int kmStandEnde;
	
	/**
	 * Eindeutige Identifikation einer Fahrt
	 */
	private int FahrtId;
	
	
	/**
	 * Methode zum Aulesen eines Nutzers 
	 */
	public Nutzer getNutzer() {
		return nutzer;
	}
	
	/**
	 * Methode zum Setzen eines Nutzers 
	 */
	public void setNutzer(Nutzer nutzer) {
		this.nutzer = nutzer;
	}
	
	/**
	 * Auslesen des Pkws 
	 */
	public Pkw getPkw() {
		return pkw;
	}
	
	/**
	 * Setzen des Pws
	 */
	public void setPkw(Pkw pkw) {
		this.pkw = pkw;
	}
	
	/**
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
	 * Methode zum Aulesen der FahrtId
	 */
	public int getFahrtId() {
		return FahrtId;
	}
	
	/**
	 * Methode zum Setzen der FahrtId
	 */
	public void setFahrtId(int fahrtId) {
		this.FahrtId = fahrtId;
	}
	
	/**
	 * Auslesen der Abfahrtszeit 
	 */
	public Timestamp getAbfahrtsZeit(){
		return abfahrtsZeit;
	}
	
	/**
	 * Methode zum Setzen der Abfahrtszeit
	 */
	public void setAbfahrtsZeit(Timestamp abfahrtsZeit){
		this.abfahrtsZeit= abfahrtsZeit;
	}
	
	/**
	 * Auslesen der Ankunftszeit 
	 */
	public Timestamp getAnkunftsZeit(){
		return ankunftsZeit;
	}
	
	/**
	 * Methode zum Setzen der Ankunftszeit
	 */
	public void setAnkunftsZeit(Timestamp ankunftsZeit){
		this.ankunftsZeit= ankunftsZeit;
	}
	
	/**
	 * Auslesen des Abfahrtsortes 
	 */
	public String getAbfahrtsOrt(){
		return abfahrtsOrt;
	}
	
	/**
	 * Methode zum Setzen des Abfahrtortes
	 */
	public void setAbfahrtsOrt(String abfahrtsOrt){
		this.abfahrtsOrt= abfahrtsOrt;
	}
	
	/**
	 * Auslesen des Ankunftsortes 
	 */
	public String getAnkunftsOrt(){
		return ankunftsOrt;
	}
	
	/**
	 * Methode zum Setzen des Ankunftsortes
	 */
	public void setAnkunftsOrt(String ankunftsOrt){
		this.ankunftsOrt= ankunftsOrt;
	}
	
	/**
	 * Auslesen des Fahrtzwecks
	 */
	public String getFahrtZweck(){
		return fahrtZweck;
	}
	
	/**
	 * Methode zum Setzen des Fahrtzwecks
	 */
	public void setFahrtZweck(String fahrtZweck){
		this.fahrtZweck = fahrtZweck;
	}
	
	/**
	 * Auslesen des km-Stands zu Beginn der Fahrt
	 */
	public int getKmStandAnfang(){
		return kmStandAnfang;
	}
	
	/**
	 * Methode zum Setzen des km-Stands zu Beginn der Fahrt
	 */
	public void setKmStandAnfang(int kmStandAnfang){
		this.kmStandAnfang = kmStandAnfang;
	}
	
	/**
	 * Auslesen des km-Stands am Ende der Fahrt
	 */
	public int getKmStandEnde(){
		return kmStandEnde;
	}
	
	/**
	 * Methode zum Setzen des km-Stands am Ende der Fahrt
	 */
	public void setKmStandEnde(int kmStandEnde){
		this.kmStandEnde = kmStandEnde;
	}
	
	
	/**
	 * Wandelt ein Fahrtobjekt in ein Stringobjekt um. 
	 */
	@Override
	public String toString() {
		
			// Use SimpleDateFormat 
		
		//String abZeit = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(abfahrtsZeit);
		//String anZeit = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(ankunftsZeit);
		
		String abZeit = this.abfahrtsZeit.toString();
		String anZeit = this.ankunftsZeit.toString();
		
		return "Erstellungszeitpunkt" + getErstellungsZeitpunkt() + "Fahrer" + this.nutzer +
				"PKW"+ this.pkw.getModellName() + "Abfahrtszeit" + abZeit + "Ankunftszeit" + anZeit +
				"Abfahrtsort" + this.abfahrtsOrt + "Ankunftsort" + this.ankunftsOrt +
				"Fahrtzweck" + this.fahrtZweck + "km-Stand Anfang" + this.kmStandAnfang + "km-Stand Ende" + this.kmStandEnde;

	}
	

	/**
	 * Notwendig um Arraylisten ordnen zu können
	 * Regulär würden Fahrten von ältestem zu neuestem geordnet werden, daher umdrehen der Rückgabewerte
	 */
	@Override
	public int compareTo(Fahrt f) {
		if(this.getErstellungsZeitpunkt().compareTo(f.getErstellungsZeitpunkt())==1){
			return -1;
		}
		if(this.getErstellungsZeitpunkt().compareTo(f.getErstellungsZeitpunkt())==-1){
			return 1;
		}
		else{
			return this.getErstellungsZeitpunkt().compareTo(f.getErstellungsZeitpunkt());
			}
		}
	
	//Konstruktor
	
	public Fahrt(){
				
	};
			
	public Fahrt (Timestamp abfahrtsZeit, Timestamp ankunftsZeit, String abfahrtsOrt, String ankunftsOrt, String fahrtZweck,
			int kmStandAnfang, int kmStandEnde){
		 this.abfahrtsZeit=abfahrtsZeit;
		 this.ankunftsZeit=ankunftsZeit;
		 this.abfahrtsOrt=abfahrtsOrt;
		 this.ankunftsOrt=ankunftsOrt;
		 this.fahrtZweck=fahrtZweck;
		 this.kmStandAnfang=kmStandAnfang;
		 this.kmStandEnde=kmStandEnde;
	}
		 	
	// Für den Mapper beim Auslesen aus der Datenbank, da id und erstellungsZeitpunkt von DB vergeben werden
	
}
