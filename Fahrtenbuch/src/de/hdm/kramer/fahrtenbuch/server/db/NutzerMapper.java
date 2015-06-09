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
 * anmelden(String email, String passwort)
 */

public class NutzerMapper {
	
	 /*
	  * Die Klasse NutzerMapper wird nur einmal instantiiert. Man spricht hierbei
	  * von einem sogenannten Singleton.
	  *
	  * Diese Variable ist durch den Bezeichner static nur einmal für
	  * sämtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	  * einzige Instanz dieser Klasse.
	  */
	 private static NutzerMapper nutzerMapper = null;
	
	 
	 // Geschützter Konstruktor - verhindert die Möglichkeit, mit new neue
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

		    //Maximal ein Rückgabewert da Id Primärschlüssel
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
			        		        
			    //NutzerObjekte der ArrayList hinzufügen
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
	       * Zunächst schauen wir nach, welches der momentan höchste
	       * Primärschlüsselwert ist.
	       */
	      ResultSet rs = stmt.executeQuery("SELECT MAX(nutzer_ID) AS maxid "
	          + "FROM nutzer ");

	      // Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
	      if (rs.next()) {
		        //n erhält um 1 höhere ID als das maximale Element in der Tabelle
	    	  	maxid=rs.getInt("maxid");
		        n.setId(rs.getInt("maxid") + 1);
	
		        stmt = con.createStatement();
		        // Jetzt erst erfolgt die tatsächliche Einfügeoperation
		        stmt.executeUpdate("INSERT INTO nutzer (nutzer_ID, vorname, name, email, passwort) "
		            + "VALUES (" + n.getId() + ",'" + n.getVorname() + "','"
		            + n.getName() + "','" + n.getEmail() + "','" + n.getPasswort() +"')");
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
	
	
	
	public Nutzer anmelden(String email, String passwort) throws Exception {
		Connection con = DBConnection.connection();
		Statement stmt = null;

		try {
			 stmt = con.createStatement();

			 ResultSet rs = stmt.executeQuery("SELECT * FROM nutzer WHERE email="+ email );
			 
			 //System.out.println("User in Try");
			if (rs.next()) {
				Nutzer n = new Nutzer();
				n.setId(rs.getInt("nutzer_ID"));
				n.setVorname(rs.getString("vorname"));
				n.setName(rs.getString("name"));
				n.setPasswort(rs.getString("passwort"));
				n.setEmail(rs.getString("email"));
				n.setErstellungsZeitpunkt(rs.getDate("erstellung"));
				
				//System.out.println("in dem ersten if Block passwort von DB: "+n.getPasswort()+" und passwort von Parameter: "+passwort);
				if(n.getPasswort().equals(passwort)){
					//System.out.println("Passwort ist richtig...Passwort von DB " + n.getPasswort()+" Passswort von user: " + passwort );
					return n;
				
				}else { 
					//System.out.println("Passwort ist falsch...Passwort von Datenbank: " +n.getPasswort());
					return null;
				}

				// System.out.println("erster If User Mapper Name von User: "+ n.getNickname());
			//	System.out.println("erster If User Mapper Passwort von User: "+n.getPasswort());
				
				//return n;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new Exception("Datenbank fehler!" + e2.toString());
		} 
//		Nur ben�tzen, wenn man mit Google SQL Cloud verbidet!!!
//		finally {
//			DBVerbindung.closeAll(rs, stmt, con);
//		}

		return null;
	}
	
	/*
	* @see 		deleteNutzer(Nutzer n): Löscht Nutzer aus der Datenbank
	* @param 	Nutzerobjekt
	* @return 	-
	*/ 
	public void deleteNutzer(Nutzer n){
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
		
		//Versuch der Abfrage
	    try {
	      Statement stmt = con.createStatement();
	      //Lösche Nutzer aus Tabelle mit gleicher ID
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

	    // Zurückgeben des aktuellen Nutzerobjektes
	    return getNutzerById(n.getId());
	}
	 
}
