package de.hdm.kramer.fahrtenbuch.shared.bo;

import java.sql.Time;
import java.sql.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

//
// NOCH ZU BEARBEITEN
//


public class Fahrt extends BusinessObject implements IsSerializable, Comparable<Fahrt> {

	private static final long serialVersionUID = 1L;
	
	private Nutzer nutzer;
	
	private Pkw pkw;
	
	private Fahrtenbuch fahrtenbuch;
	
	private Date datum;
	
	private Time abfahrtsZeit;
	
	private Time ankunftsZeit;
	
	private String abfahrtsOrt;
	
	private String ankunftsOrt;
	
	private String fahrtZweck;
	
	private int kmStandAnfang;
	
	private int kmStandEnde;
	
	private int gefahreneKm;
	
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
	 * 
	 * Auslesen des Pkws 
	 */
	public Pkw getPkw() {
		return pkw;
	}
	
	/**
	 * Setzen des Pws
	 * 
	 */
	public void setPkw(Pkw pkw) {
		this.pkw = pkw;
	}
	
	/**
	 * 
	 * Auslesen der Fahrtenbuch 
	 */
	public Fahrtenbuch getFahrtenbuch() {
		return fahrtenbuch;
	}
	
	/**
	 * Setzen der Fahrtenbuch
	 * 
	 */
	public void setFahrtenbuch(Fahrtenbuch fahrtenbuch) {
		this.fahrtenbuch = fahrtenbuch;
	}
	
	/**
	 * Methode zum Aulesen der Fahrt_Id
	 */
	public int getFahrtId() {
		return FahrtId;
	}
	
	/**
	 * Methode zum Setzen der Fahrt_Id
	 */
	public void setFahrtId(int fahrtId) {
		this.FahrtId = fahrtId;
	}
	
	
	public Date getDate(){
		return datum;
	}
	
	public void setDate(Date datum){
		this.datum = datum;
	}
	
	public Time getAbfahrtsZeit(){
		return abfahrtsZeit;
	}
	
	public void setAbfahrtsZeit(Time abfahrtsZeit){
		this.abfahrtsZeit= abfahrtsZeit;
	}
	
	public Time getAnkunftsZeit(){
		return ankunftsZeit;
	}
	
	public void setAnkunftsZeit(Time ankunftsZeit){
		this.ankunftsZeit= ankunftsZeit;
	}
	
	public String getAbfahrtsOrt(){
		return abfahrtsOrt;
	}
	
	public void setAbfahrtsOrt(String abfahrtsOrt){
		this.abfahrtsOrt= abfahrtsOrt;
	}
	
	public String getAnkunftsOrt(){
		return ankunftsOrt;
	}
	
	public void setAnkunftsOrt(String ankunftsOrt){
		this.ankunftsOrt= ankunftsOrt;
	}
	
	public String getFahrtZweck(){
		return fahrtZweck;
	}
	
	public void setFahrtZweck(String fahrtZweck){
		this.fahrtZweck = fahrtZweck;
	}
	
	public int getKmStandAnfang(){
		return kmStandAnfang;
	}
	
	public void setKmStandAnfang(int kmStandAnfang){
		this.kmStandAnfang = kmStandAnfang;
	}
	
	public int getKmStandEnde(){
		return kmStandEnde;
	}
	
	public void setKmStandEnde(int kmStandEnde){
		this.kmStandEnde = kmStandEnde;
	}
	
	public int getGefahreneKm(){
		return gefahreneKm;
	}
	
	public void setGefahreneKm(int gefahreneKm){
		this.gefahreneKm = gefahreneKm;
	}
	
	/**
	 * Wandelt ein Fahrtobjekt in ein Stringobjekt um. 
	 */
	@Override
	public String toString() {
		return "Erstellungszeitpunnkt" + getErstellungsZeitpunkt() + "Datum:" + getDate() + "Abfahrtszeit:" + getAbfahrtsZeit() +
				"Ankunftszeit" + getAnkunftsZeit() + "Abfahrtsort" + getAbfahrtsOrt() + "Ankunftsort" + getAnkunftsOrt() +
				"Fahrtzweck" + getFahrtZweck() + "km-Stand Anfang" + getKmStandAnfang() + "km-Stand Ende" + getKmStandEnde() +
				"Gefahrene km" + getGefahreneKm();
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
