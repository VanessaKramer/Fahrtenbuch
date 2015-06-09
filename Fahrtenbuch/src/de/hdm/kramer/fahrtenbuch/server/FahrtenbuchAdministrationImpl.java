package de.hdm.kramer.fahrtenbuch.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.hdm.kramer.fahrtenbuch.server.db.FahrtMapper;
import de.hdm.kramer.fahrtenbuch.server.db.FahrtenbuchMapper;
import de.hdm.kramer.fahrtenbuch.server.db.NutzerMapper;
import de.hdm.kramer.fahrtenbuch.server.db.PkwMapper;
import de.hdm.kramer.fahrtenbuch.shared.FahrtenbuchAdministration;
import de.hdm.kramer.fahrtenbuch.shared.bo.Fahrt;
import de.hdm.kramer.fahrtenbuch.shared.bo.Fahrtenbuch;
import de.hdm.kramer.fahrtenbuch.shared.bo.Nutzer;
import de.hdm.kramer.fahrtenbuch.shared.bo.Pkw;

public class FahrtenbuchAdministrationImpl extends RemoteServiceServlet implements FahrtenbuchAdministration {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Referenz auf den FahrtenbuchMapper in der Datenbank.
	 */
	private FahrtenbuchMapper fahrtenbuchMapper = null;

	/**
	 * Referenz auf den FahrtMapper in der Datenbank.
	 */

	private FahrtMapper fahrtMapper = null;

	/**
	 * Referenz auf den NutzerMapper in der Datenbank.
	 */
	private NutzerMapper nutzerMapper = null;

	/**
	 * Referenz auf den PkwMapper in der Datenbank.
	 */

	private PkwMapper pkwMapper = null;
	

	public FahrtenbuchAdministrationImpl() throws IllegalArgumentException {
	
	}
	public void init() throws IllegalArgumentException {

		/**
		 * Die Kommunikation mit Datenbank wird aufgebaut.
		 */

		fahrtenbuchMapper = FahrtenbuchMapper.fahrtenbuchMapper();
		fahrtMapper = FahrtMapper.fahrtMapper();
		nutzerMapper = NutzerMapper.nutzerMapper();
		pkwMapper = PkwMapper.pkwMapper();
		
	}
	
	
	
	@Override
	public Nutzer anmelden(String email, String passwort) throws Exception {
		return this.nutzerMapper.anmelden(email, passwort);
	}
	
	@Override
	public Nutzer insertNutzer(Nutzer n) throws IllegalArgumentException {
		return this.nutzerMapper.insertNutzer(n);
		
	}
	@Override
	public Nutzer updateNutzer(Nutzer n) throws IllegalArgumentException {
		return this.nutzerMapper.updateNutzer(n);
	}
	@Override
	public void deleteNutzer(Nutzer n) throws IllegalArgumentException {
		nutzerMapper.deleteNutzer(n);
	}
	@Override
	public Nutzer getNutzerById(int id) throws IllegalArgumentException {
		return this.nutzerMapper.getNutzerById(id);
	}
	@Override
	public ArrayList<Nutzer> getAllNutzer() throws IllegalArgumentException {
		return this.nutzerMapper.getAllNutzer();
	}
	@Override
	public Fahrtenbuch insertFahrtenbuch(Fahrtenbuch fb)
			throws IllegalArgumentException {
		
		return fahrtenbuchMapper.insertFahrtenbuch(fb);
	}
	@Override
	public Fahrtenbuch getFahrtenbuchById(int id)
			throws IllegalArgumentException {
		
		return this.fahrtenbuchMapper.getFahrtenbuchById(id);
	}
	@Override
	public void insertFahrt(Fahrt f) throws IllegalArgumentException {
		
		fahrtMapper.insertFahrt(f);
		
	}
	@Override
	public Fahrt updateFahrt(Fahrt f) throws IllegalArgumentException {
		
		return fahrtMapper.updateFahrt(f);
	}
	@Override
	public Fahrt getFahrtById(int id) throws IllegalArgumentException {
		
		return this.fahrtMapper.getFahrtById(id);
	}
	@Override
	public ArrayList<Fahrt> getFahrtenByNutzer(int id)
			throws IllegalArgumentException {
		
		return this.fahrtMapper.getFahrtenByNutzer(id);
	}
	@Override
	public void insertPkw(Pkw p) throws IllegalArgumentException {
		
		pkwMapper.insertPkw(p);
		
	}
	@Override
	public void deletePkw(Pkw p) throws IllegalArgumentException {
		
		pkwMapper.deletePkw(p);
		
	}
	@Override
	public Pkw getPkwById(int id) throws IllegalArgumentException {
		
		return this.pkwMapper.getPkwById(id);
	}
	@Override
	public ArrayList<Pkw> getAllPkws() throws IllegalArgumentException {
		
		return this.pkwMapper.getAllPkws();
	}
	
	

}
