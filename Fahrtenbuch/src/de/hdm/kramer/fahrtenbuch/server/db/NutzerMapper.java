package de.hdm.kramer.fahrtenbuch.server.db;

import java.sql.*;
import java.util.ArrayList;

import de.hdm.kramer.fahrtenbuch.shared.*;
import de.hdm.kramer.fahrtenbuch.shared.bo.Nutzer;
import de.hdm.kramer.fahrtenbuch.shared.bo.Fahrtenbuch;

/*
 * Methoden:
 * nutzerMapper()
 * getNutzerById(int id)
 * getAllNutzer()
 * insertNutzer(Nutzer n)
 * deleteNutzer(Nutzer n)
 * updateNutzer(Nutzer n)
 */

public class NutzerMapper {
	
	 /*
	  * Die Klasse NutzerMapper wird nur einmal instantiiert. Man spricht hierbei
	  * von einem sogenannten Singleton.
	  *
	  * Diese Variable ist durch den Bezeichner static nur einmal f�r
	  * s�mtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	  * einzige Instanz dieser Klasse.
	  */
	 private static NutzerMapper nutzerMapper = null;
	
	 
	 // Gesch�tzter Konstruktor - verhindert die M�glichkeit, mit new neue
	 // Instanzen dieser Klasse zu erzeugen.
	 
	 protected NutzerMapper() {
		 
	 }

	 
	 // Singleton "Konstruktor"-methode
	 // NutzerMapper sollte nicht mittels new
	 // instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.
	 
	 public static NutzerMapper nutzerMapper(){
		 if (nutzerMapper==null){
			 nutzerMapper= new NutzerMapper();
		 }
		 return nutzerMapper;
	 }
	 
	 
	/*
	 * @see 	getNutzerById(int id): Sucht Nutzer anhand der id 
	 * @param 	int id
	 * @return 	1 Nutzerobjekt entweder mit Ergebnis oder leer 
	 */
	 public Nutzer getNutzerById(int id){
		
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
		
		//Versuch der Abfrage
		try{
			Statement stmt = con.createStatement();
			//Suche alle Felder der Nutzertabelle anhand von ID
			ResultSet rs = stmt.executeQuery("SELECT * FROM nutzer WHERE nutzer_ID=" + id );

		    //Maximal ein R�ckgabewert da Id Prim�rschl�ssel
			if (rs.next()) {
		        // Ergebnis in Nutzerobjekt umwandeln
		        Nutzer n = new Nutzer();
		        n.setId(rs.getInt("nutzer_ID"));
		        n.setErstellungsZeitpunkt(rs.getDate("erstellung"));
		        n.setVorname(rs.getString("vorname"));
		        n.setName(rs.getString("name"));
		        n.setEmail(rs.getString("email"));
		        return n;
		      }
		}
		
	    catch (SQLException e) {
   		e.printStackTrace();
   		return null;
	    }
	//Falls keines gefunden, leere Liste
	return null;
	}
	 
	 
	 /*
	 * @see 	getAllNutzer(): Sucht alle Nutzer
	 * @param 	-
	 * @return 	ArrayList mit Nutzerobjekten
	 */
	 public ArrayList<Nutzer> getAllNutzer(){
			
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
		ArrayList <Nutzer> nutzerListe= new ArrayList<Nutzer>();
			
		//Versuch der Abfrage
		try{
			Statement stmt = con.createStatement();
			//Suche alle Nutzer
			ResultSet rs = stmt.executeQuery("SELECT * FROM nutzer");

			while (rs.next()) {
				// Ergebnis in Nutzerobjekt umwandeln
		        Nutzer n = new Nutzer();
		        n.setId(rs.getInt("nutzer_ID"));
			    n.setErstellungsZeitpunkt(rs.getDate("erstellung"));
			    n.setVorname(rs.getString("vorname"));
			    n.setName(rs.getString("name"));
			    n.setEmail(rs.getString("email"));
			        		        
			    //NutzerObjekte der ArrayList hinzuf�gen
			    nutzerListe.add(n);
			}
			return nutzerListe;
		}
	    catch (SQLException e) {
		   		e.printStackTrace();
	    }
	//Falls keines gefunden leeres Objekt
	return nutzerListe;
	}
	
	 
	/*
	* @see		insertNutzer(Nutzer n): Speichert Nutzerobjekt in DB
	* @param 	Nutzerobjekt
	* @return 	Das gespeicherte Nutzerobjekt
	*/ 
	public Nutzer insertNutzer(Nutzer n){
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
		int maxid = 0;
						
		//Versuch der Abfrage
		try{
			Statement stmt = con.createStatement();

	      /*
	       * Zun�chst schauen wir nach, welches der momentan h�chste
	       * Prim�rschl�sselwert ist.
	       */
	      ResultSet rs = stmt.executeQuery("SELECT MAX(nutzer_ID) AS maxid "
	          + "FROM nutzer ");

	      // Wenn wir etwas zur�ckerhalten, kann dies nur einzeilig sein
	      if (rs.next()) {
		        //n erh�lt um 1 h�here ID als das maximale Element in der Tabelle
	    	  	maxid=rs.getInt("maxid");
		        n.setId(rs.getInt("maxid") + 1);
	
		        stmt = con.createStatement();
		        // Jetzt erst erfolgt die tats�chliche Einf�geoperation
		        stmt.executeUpdate("INSERT INTO nutzer (nutzer_ID, vorname, name, email) "
		            + "VALUES (" + n.getId() + ",'" + n.getVorname() + "','"
		            + n.getName() + "','" + n.getEmail() +"')");
	      	}
	    }
		
	    catch (SQLException e) {
	      e.printStackTrace();
	    }
		
		Fahrtenbuch fb = new Fahrtenbuch();
		fb.setNutzer(getNutzerById(maxid+1));
		FahrtenbuchMapper.fahrtenbuchMapper().insertFahrtenbuch(fb);
				
	    return getNutzerById(maxid+1);
	}
	
	
	/*
	* @see 		deleteNutzer(Nutzer n): L�scht Nutzer aus der Datenbank
	* @param 	Nutzerobjekt
	* @return 	-
	*/ 
	public void deleteNutzer(Nutzer n){
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
		
		//Versuch der Abfrage
	    try {
	      Statement stmt = con.createStatement();
	      //L�sche Nutzer aus Tabelle mit gleicher ID
	      stmt.executeUpdate("DELETE FROM nutzer WHERE nutzer_ID=" + n.getId());
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    } 
	}
	
	
	/*
	* @see		updateNutzer(Nutzwr n): Aktualisiert Nutzerinformationen in der Datenbank
	* @param	zu aktualisierendes Nutzerobjekt
	* @return 	aktualisiertes Nutzerobjekt
	*/ 
	public Nutzer updateNutzer(Nutzer n){
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
		
		//Versuch der Abfrage
	    try {
	      Statement stmt = con.createStatement();
	      //Aktualisieren des Vornamens, Nachnamens und der Email
	      stmt.executeUpdate("UPDATE nutzer " + "SET vorname= \"" 
	          + n.getVorname() + "\", " + "name=\"" + n.getName() + "\", " + "email= \"" + n.getEmail() + 
	          "\"" + "WHERE nutzer_ID=" + n.getId());

	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	    }

	    // Zur�ckgeben des aktuellen Nutzerobjektes
	    return getNutzerById(n.getId());
	}
	 
}
