package de.hdm.kramer.fahrtenbuch.shared.bo;

import java.sql.Date;
import java.text.SimpleDateFormat;

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
	* Datumsformatierung mit SimpleDateFormat, um das Datum und die Uhrzeit für
	* die Abfahrtzeit und Ankunftszeit auszugeben.
	*/
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	
	/**
	 * Die Abfahrtszeit der Fahrt
	 */
	private Date abfahrtsZeit;
	
	/**
	 * Die Ankunftszeit der Fahrt
	 */
	private Date ankunftsZeit;
	
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
	 * Auslesen der Fahrtenbuch 
	 */
	public Fahrtenbuch getFahrtenbuch() {
		return fahrtenbuch;
	}
	
	/**
	 * Setzen der Fahrtenbuch
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
	public Date getAbfahrtsZeit(){
		return abfahrtsZeit;
	}
	
	/**
	 * Methode zum Setzen der Abfahrtszeit
	 */
	public void setAbfahrtsZeit(Date abfahrtsZeit){
		this.abfahrtsZeit= abfahrtsZeit;
	}
	
	/**
	 * Auslesen der Ankunftszeit 
	 */
	public Date getAnkunftsZeit(){
		return ankunftsZeit;
	}
	
	/**
	 * Methode zum Setzen der Ankunftszeit
	 */
	public void setAnkunftsZeit(Date ankunftsZeit){
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
		return "Erstellungszeitpunkt" + getErstellungsZeitpunkt() + "Fahrer" + this.nutzer +
				"PKW"+ this.nutzer.getPkw().getModellName() + "Abfahrtszeit" + simpleDateFormat.format(abfahrtsZeit) +
				"Ankunftszeit" + simpleDateFormat.format(ankunftsZeit) + "Abfahrtsort" + this.abfahrtsOrt + "Ankunftsort" + this.ankunftsOrt +
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
	
}
