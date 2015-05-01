package de.hdm.kramer.fahrtenbuch.server.db;

import java.sql.*;
import java.util.ArrayList;

import de.hdm.kramer.fahrtenbuch.shared.*;
import de.hdm.kramer.fahrtenbuch.shared.bo.Pkw;

/*
 * Methoden:
 * pkwMapper()
 * getPkwById(int id)
 * getAllPkws()
 * insertPkw(Pkw p)
 * deletePkw(Pkw p)
 */

public class PkwMapper {
	
	/*
	  * Die Klasse PkwMapper wird nur einmal instantiiert. Man spricht hierbei
	  * von einem sogenannten Singleton.
	  *
	  * Diese Variable ist durch den Bezeichner static nur einmal für
	  * sämtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	  * einzige Instanz dieser Klasse.
	  */
	 private static PkwMapper pkwMapper = null;
	
	 
	 // Geschützter Konstruktor - verhindert die Möglichkeit, mit new neue
	 // Instanzen dieser Klasse zu erzeugen.
	 
	 protected PkwMapper() {
		 
	 }

	 
	 // Singleton "Konstruktor"-methode
	 // PkwMapper sollte nicht mittels new
	 // instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.
	 
	 public static PkwMapper pkwMapper(){
		 if (pkwMapper==null){
			 pkwMapper= new PkwMapper();
		 }
		 return pkwMapper;
	 }
	 
	 
	 /**
	  * @see 	getPkwById (int id): Sucht Pkw anhand von ID
	  * @param 	Pkw ID
	  * @return Pkw-Objekt
	  */
	 public Pkw getPkwById(int id){
			
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
			
		//Versuch der Abfrage
		try{
			Statement stmt = con.createStatement();
			//Suche alle Felder der Pkwtabelle anhand von ID
			ResultSet rs = stmt.executeQuery("SELECT * FROM pkw WHERE pkw_ID=" + id );
				
			//Maximal ein Rückgabewert da Id Primärschlüssel
			if (rs.next()) {
			    // Ergebnis in Beitrag- Objekt umwandeln
				Pkw p = new Pkw();
			    p.setId(rs.getInt("pkw_ID"));
			    p.setErstellungsZeitpunkt(rs.getTimestamp("erstellung"));
			    p.setModellName(rs.getString("modell"));
			    p.setBaujahr(rs.getInt("baujahr"));
			    p.setFahrtenbuch(FahrtenbuchMapper.fahrtenbuchMapper().getFahrtenbuchById(rs.getInt("fahrtenbuch_ID")));
			    return p;
			}
		}
			
		catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
		}
	//Falls keines gefunden leere Liste
	return null;
	}
	 

	 
	/**
	* @see		getAllPkws: Sucht alle Pkws
	* @param 	Pkw Id
	* @return 	ArrayList mit Pkw-Objekten
	*/
	public ArrayList<Pkw> getAllPkws(){
				
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
		ArrayList <Pkw> pkwListe= new ArrayList<Pkw>();
				
		//Versuch der Abfrage
		try{
			Statement stmt = con.createStatement();
			//Suche alle Pkws
			ResultSet rs = stmt.executeQuery("SELECT * FROM pkw");

			while (rs.next()) {
				// Ergebnis in Pkw-Objekt umwandeln
				Pkw p = new Pkw();
				p.setId(rs.getInt("pkw_ID"));
			    p.setErstellungsZeitpunkt(rs.getTimestamp("erstellung"));
			    p.setModellName(rs.getString("modell"));
			    p.setBaujahr(rs.getInt("baujahr"));	 
			    p.setFahrtenbuch(FahrtenbuchMapper.fahrtenbuchMapper().getFahrtenbuchById(rs.getInt("fahrtenbuch_ID")));

				//Pkw-Objekte der ArrayList hinzufügen
				pkwListe.add(p);
			}
			return pkwListe;
		}
				
		catch (SQLException e) {
			e.printStackTrace();
		}
	//Falls keines gefunden leere Liste
	return pkwListe;
	}
	
	
	 /**
	  * @see 	insertPkw(Pkw p): Speichert Pkw-Objekt in DB
	  * @param 	Pkw-Objekt
	  * @return Das gespeicherte Pkw-Objekt
	  */ 
	 public void insertPkw(Pkw p){
		//Aufbau der DBVerbindung
		
		Connection con = DBConnection.connection();
		
						
		//Versuch der Abfrage
		try{
			Statement stmt = con.createStatement();

	      /**
	       * Zunächst schauen wir nach, welches der momentan höchste
	       * Primärschlüsselwert ist.
	       */
	      ResultSet rs = stmt.executeQuery("SELECT MAX(pkw_ID) AS maxid "
	          + "FROM pkw ");

	      // Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
	      if (rs.next()) {
	    	  	//p erhält um 1 höhere ID als das maximale Element in der Tabelle
		        p.setId(rs.getInt("maxid") + 1);
	
		        stmt = con.createStatement();
	
		        // Jetzt erst erfolgt die tatsächliche Einfügeoperation
		        stmt.executeUpdate("INSERT INTO pkw (pkw_ID, modell, baujahr, fahrtenbuch_ID) "
		            + "VALUES (" + p.getId() + ",'"  + p.getModellName() + "','" + p.getBaujahr() + "','" +
		        		p.getFahrtenbuch().getId() +"')");
	      }
	      
	    }
		
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	}

	
	/**
	* @see 		deletePkw(Pkw p): Löscht Pkw aus der Datenbank
	* @param 	Pkw-Objekt
	* @return 		-
	*/ 
	 public void deletePkw(Pkw p){
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
		
		//Versuch der Abfrage
	    try {
	      Statement stmt = con.createStatement();
	      //Lösche Pkw mit gleicher ID aus Tabelle
	      stmt.executeUpdate("DELETE FROM pkw WHERE pkw_ID=" + p.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    } 
	 }
	
		
	 


	
}
