package de.hdm.kramer.fahrtenbuch.server.db;

import java.sql.*;

import de.hdm.kramer.fahrtenbuch.shared.*;
import de.hdm.kramer.fahrtenbuch.shared.bo.Fahrtenbuch;

/*
 * Methoden:
 * fahrtenbuchMapper()
 * getFahrtenbuchById(int id)
 * insertFahrtenbuch(Fahrtenbuch fb)
 */

public class FahrtenbuchMapper {
	 
	/*
	  * Die Klasse FahrtenbuchMapper wird nur einmal instantiiert. Man spricht hierbei
	  * von einem sogenannten Singleton.
	  *
	  * Diese Variable ist durch den Bezeichner static nur einmal für
	  * sämtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	  * einzige Instanz dieser Klasse.
	  */   
	 private static FahrtenbuchMapper fahrtenbuchMapper = null;
	
	 
	 // Geschützter Konstruktor - verhindert die Möglichkeit, mit new neue
	 // Instanzen dieser Klasse zu erzeugen.
	 
	 protected FahrtenbuchMapper() {
		 
	 }

	 
	 // Singleton "Konstruktor"-methode
	 // FahrtenbuchMapper sollte nicht mittels new
	 // instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.
	 
	 public static FahrtenbuchMapper fahrtenbuchMapper(){
		 if (fahrtenbuchMapper==null){
			 fahrtenbuchMapper= new FahrtenbuchMapper();
		 }
		 return fahrtenbuchMapper;
	 }
	 
	 /**
		* @see 		getFahrtenbuchById(int id): Sucht Fahrtenbuch anhand der Id 
		* @param 	int id
		* @return 	1 Fahrtenbuchobjekt entweder mit Ergebnis oder leer 
		*/
		public Fahrtenbuch getFahrtenbuchById(int id){
				
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
				
		//Versuch der Abfrage
		try{
			Statement stmt = con.createStatement();
			//Suche alle Felder der Fahrtenbuchtabelle anhand von ID
			ResultSet rs = stmt.executeQuery("SELECT * FROM fahrtenbuch " + "WHERE fahrtenbuch_ID=" + id );

			 //Maximal ein Rückgabewert, da Id Primärschlüssel
			if (rs.next()) {
				// Ergebnis in Fahrtenbuchobjekt umwandeln
				Fahrtenbuch fb = new Fahrtenbuch();
				fb.setId(rs.getInt("fahrtenbuch_ID"));
				fb.setErstellungsZeitpunkt(rs.getDate("erstellung"));
				fb.setNutzer(NutzerMapper.nutzerMapper().getNutzerById(rs.getInt("nutzer_ID")));
				return fb;
				}
			}
				
			catch (SQLException e) {
			   e.printStackTrace();
			   return null;
			  }
		//Falls keines gefunden leeres Objekt
		return null;
		}
		
		
		/**
		* @see 		insertFahrtenbuch(Fahrtenbuch fb): Speichert Fahrtenbuchobjekt in DB
		* @param 	Fahrtenbuchobjekt
		* @return 	Das gespeicherte Fahrtenbuchobjekt
		*/ 
		public Fahrtenbuch insertFahrtenbuch(Fahrtenbuch fb){
			//Aufbau der DBVerbindung
			Connection con = DBConnection.connection();
			int maxid=0;				
			//Versuch der Abfrage
			try{
				Statement stmt = con.createStatement();
				
		      /**
		       * Zunächst schauen wir nach, welches der momentan höchste
		       * Primärschlüsselwert ist.
		       */
		      ResultSet rs = stmt.executeQuery("SELECT MAX(fahrtenbuch_ID) AS maxid "
		          + "FROM fahrtenbuch ");

		      // Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
		      if (rs.next()) {
			        /**
			         * f erhält den bisher maximalen, nun um 1 inkrementierten
			         * Primärschlüssel.
			         */
		    	  	maxid=rs.getInt("maxid");
			        fb.setId(rs.getInt("maxid") + 1);
		
			        stmt = con.createStatement();
		
			        // Jetzt erst erfolgt die tatsächliche Einfügeoperation
			        stmt.executeUpdate("INSERT INTO fahrtenbuch (fahrtenbuch_ID, nutzer_ID) "
			            + "VALUES (" + fb.getId() + ",'" + fb.getNutzer().getId() + "')");
		      	}
		    }
			
		    catch (SQLException e) {
		      e.printStackTrace();
		    }

		    return getFahrtenbuchById(maxid+1);
		}
}
