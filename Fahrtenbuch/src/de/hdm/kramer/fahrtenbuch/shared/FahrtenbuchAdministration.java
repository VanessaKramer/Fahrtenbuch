package de.hdm.kramer.fahrtenbuch.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;

import de.hdm.kramer.fahrtenbuch.shared.bo.Fahrt;
import de.hdm.kramer.fahrtenbuch.shared.bo.Fahrtenbuch;
import de.hdm.kramer.fahrtenbuch.shared.bo.Nutzer;
import de.hdm.kramer.fahrtenbuch.shared.bo.Pkw;

public interface FahrtenbuchAdministration extends RemoteService {
	
	public void init() throws IllegalArgumentException;
	
	/** 
	 * Einen neuen Nutzer einfügen
	 * @param n Nutzer
	 * @return Nutzer-Objekt
	 * @throws IllegalArgumentException
	 */
	
	public Nutzer insertNutzer (Nutzer n) throws IllegalArgumentException;
	
	/**
	 * Nutzer meldet sich an
	 * @param name, passwort
	 * @return Nutzer
	 * @throws IllegalArgumentException
	 * 
	 */
	
	public Nutzer anmelden(String name, String passwort) throws IllegalArgumentException;
	
	
	/** 
	 * Einen Nutzer aktualisieren
	 * @param n Nutzer
	 * @return aktualisiertes Nutzer-Objekt
	 * @throws IllegalArgumentException 
	 */
	
	public Nutzer updateNutzer (Nutzer n) throws IllegalArgumentException;
	
	/**
	 *  Einen Nutzer löschen
	 * @param Nutzer n
	 * @throws IllegalArgumentException
	 */
	public void deleteNutzer (Nutzer n) throws IllegalArgumentException;
	
	/** Einen Nutzer anhand seiner ID finden.
	 * @param int id
	 * @return n Nutzer
	 * throws IllegalArgumentException */
	
	public Nutzer getNutzerById (int id) throws IllegalArgumentException;
	
	/** 
	 * Alle Nutzer finden
	 * @param 
	 * @return ArrayList aller Nutzer  
	 * @throws IllegalArgumentException
	 */
	
	public ArrayList <Nutzer> getAllNutzer() throws IllegalArgumentException;
	
	/**
	 * Fahrtenbuchobjekte in das Fahrtenbuch eintragen.
	 * @param Fahrtenbuch fb
	 * @return gespeicherte Fahrtenbuchobjekt
	 * @throws IllegalArgumentException
	 */
	
	public Fahrtenbuch insertFahrtenbuch (Fahrtenbuch fb) throws IllegalArgumentException;
	
	/**
	 * Fahrtenbuch anhand de ID suchen.
	 * @param int id
	 * @return ein Fahrtenbuchobjekt
	 * @throws IllegalArgumentException
	 */
	 
	public Fahrtenbuch getFahrtenbuchById(int id) throws IllegalArgumentException;
	
	
	/**
	 * Fahrt-Objekte eintragen.
	 * @param Fahrt f
	 * @return gespeicherte Fahrt-Objekt
	 * @throws IllegalArgumentException
	 */
	
	public void insertFahrt (Fahrt f) throws IllegalArgumentException;
	
	
	/**
	 * Fahrt-Objekte aktualisieren.
	 * @param Fahrt f
	 * @return aktualisiertes Fahrt-Objekt
	 * @throws IllegalArgumentException
	 */
	
	public Fahrt updateFahrt(Fahrt f) throws IllegalArgumentException;
	
	
	/**
	 * Sucht eine Fahrt anhand seiner ID.
	 * @param int id
	 * @return Fahrt-Objekt
	 * @throws IllegalArgumentException
	 */
	public Fahrt getFahrtById(int id) throws IllegalArgumentException;
	
	
	/**
	 * Gibt alle Fahrten eines bestimmten Nutzers wieder.
	 * @param int id
	 * @return ArrayList mit Fahrt-Objekten
	 * @throws IllegalArgumentException
	 */
	public ArrayList <Fahrt> getFahrtenByNutzer(int id) throws IllegalArgumentException;

	
	/**
	 * Speichert Pkw-Objekte in die DB.
	 * @param Pkw p
	 * @return das gespeicherte Pkw-Objekt
	 * @throws IllegalArgumentException
	 */

	public void insertPkw (Pkw p) throws IllegalArgumentException;
	
	/**
	 * Löscht Pkw-Objekte aus der DB.
	 * @param Pkw p
	 * @throws IllegalArgumentException
	 */
	public void deletePkw (Pkw p) throws IllegalArgumentException;
	
	/**
	 * Sucht einen Pkw anhand seiner ID.
	 * @param Pkw ID
	 * @return Pkw-Objekt
	 * @throws IllegalArgumentException
	 */
	
	public Pkw getPkwById (int id) throws IllegalArgumentException;
	
	/**
	 * Sucht alle Pkws.
	 * @param -
	 * @return ArrayListe mit allen Pkw-Objekten
	 * @throws IllegalArgumentException
	 */

	public ArrayList <Pkw> getAllPkws() throws IllegalArgumentException;



}
	
	
	
	
	
	


