package de.hdm.kramer.fahrtenbuch.server.db;

import java.sql.*;
import java.util.ArrayList;

import de.hdm.kramer.fahrtenbuch.shared.*;
import de.hdm.kramer.fahrtenbuch.shared.bo.Fahrt;

/*
 * Methoden:
 * fahrtMapper()
 * getFahrtById(int id)
 * getFahrtenByNutzer(int id)
 * insertFahrt(Fahrt f)
 * updateFahrt(Fahrt f)
 */

public class FahrtMapper {
	
	/*
	  * Die Klasse FahrtMapper wird nur einmal instantiiert. Man spricht hierbei
	  * von einem sogenannten Singleton.
	  *
	  * Diese Variable ist durch den Bezeichner static nur einmal für
	  * sämtliche eventuellen Instanzen dieser Klasse vorhanden. Sie speichert die
	  * einzige Instanz dieser Klasse.
	  */
	 private static FahrtMapper fahrtMapper = null;
	
	 
	 // Geschützter Konstruktor - verhindert die Möglichkeit, mit new neue
	 // Instanzen dieser Klasse zu erzeugen.
	 
	 protected FahrtMapper() {
		 
	 }

	 
	 // Singleton "Konstruktor"-methode
	 // FahrtMapper sollte nicht mittels new
	 // instantiiert werden, sondern stets durch Aufruf dieser statischen Methode.
	 
	 public static FahrtMapper fahrtMapper(){
		 if (fahrtMapper==null){
			 fahrtMapper= new FahrtMapper();
		 }
		 return fahrtMapper;
	 }

	 
	 
	 /**
	  * @see 	getFahrtById (int id): Sucht Fahrt anhand von ID
	  * @param 	Fahrt ID
	  * @return Fahrt-Objekt
	  */
	 public Fahrt getFahrtById(int id){
			
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
			
		//Versuch der Abfrage
		try{
			Statement stmt = con.createStatement();
			//Suche alle Felder der Fahrttabelle anhand von ID
			ResultSet rs = stmt.executeQuery("SELECT * FROM fahrt WHERE fahrt_ID=" + id );
				
			//Maximal ein Rückgabewert da Id Primärschlüssel
			if (rs.next()) {
			    // Ergebnis in Fahrt-Objekt umwandeln
				Fahrt f = new Fahrt();
			    f.setId(rs.getInt("fahrt_ID"));
			    f.setErstellungsZeitpunkt(rs.getTimestamp("erstellung"));
			    f.setAbfahrtsZeit(rs.getTimestamp("abfahrtszeit"));
			    f.setAnkunftsZeit(rs.getTimestamp("ankunftszeit"));
			    f.setAbfahrtsOrt(rs.getString("abfahrtsort"));
			    f.setAnkunftsOrt(rs.getString("ankunftsort"));
			    f.setFahrtZweck(rs.getString("fahrtzweck"));
			    f.setKmStandAnfang(rs.getInt("kmstandanfang"));
			    f.setKmStandEnde(rs.getInt("kmstandende"));
			    f.setNutzer(NutzerMapper.nutzerMapper().getNutzerById(rs.getInt("nutzer_ID")));
			    f.setPkw(PkwMapper.pkwMapper().getPkwById(rs.getInt("pkw_ID")));
			    return f;
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
	* @see 		getFahrtByNutzer(int id): gibt komplette Liste an Fahrten zurück, die ein Nutzer dokumentiert hat
	* @param 	Nutzer Id
	* @return 	ArrayList mit Fahrt-Objekten
	*/ 
	public ArrayList<Fahrt> getFahrtenByNutzer(int id){
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
		ArrayList <Fahrt> fahrtListe= new ArrayList<Fahrt>();
			
		//Versuch der Abfrage
		try{
			Statement stmt = con.createStatement();
			//Suche alle Fahrten von einem Nutzer
			ResultSet rs = stmt.executeQuery("SELECT * FROM fahrt WHERE nutzer_ID="+id);

			while (rs.next()) {
				// Ergebnis in Fahrt-Objekt umwandeln
				Fahrt f = new Fahrt();
				f.setId(rs.getInt("fahrt_ID"));
			    f.setErstellungsZeitpunkt(rs.getTimestamp("erstellung"));
			    f.setAbfahrtsZeit(rs.getTimestamp("abfahrtszeit"));
			    f.setAnkunftsZeit(rs.getTimestamp("ankunftszeit"));
			    f.setAbfahrtsOrt(rs.getString("abfahrtsort"));
			    f.setAnkunftsOrt(rs.getString("ankunftsort"));
			    f.setFahrtZweck(rs.getString("fahrtzweck"));
			    f.setKmStandAnfang(rs.getInt("kmstandanfang"));
			    f.setKmStandEnde(rs.getInt("kmstandende"));
			    f.setNutzer(NutzerMapper.nutzerMapper().getNutzerById(rs.getInt("nutzer_ID")));
			    f.setPkw(PkwMapper.pkwMapper().getPkwById(rs.getInt("pkw_ID")));

			    //Fahrt-Objekt zur Fahrtliste hinzufï¿½gen
			    fahrtListe.add(f);
			       
			  	}
			return fahrtListe;
		}
			
		catch (SQLException e) {
			e.printStackTrace();
		}
		//Falls keines gefunden leere Liste
	return fahrtListe;
			
	}
		
		
	/**
	* @see 	insertFahrt(Fahrt f): Speichert Fahrt-Objekt in DB
	* @param 	Fahrt-Objekt
	* @return Das gespeicherte Fahrt-Objekt
	*/ 
	public void insertFahrt(Fahrt f){
	
		//Aufbau der DBVerbindung	
		Connection con = DBConnection.connection();
							
		//Versuch der Abfrage
		try{
			Statement stmt = con.createStatement();

			/**
			 * Zunächst schauen wir nach, welches der momentan höchste
			 * Primärschlüsselwert ist.
			 */
			ResultSet rs = stmt.executeQuery("SELECT MAX(fahrt_ID) AS maxid "
					+ "FROM fahrt ");

			// Wenn wir etwas zurückerhalten, kann dies nur einzeilig sein
			if (rs.next()) {
				//f erhält um 1 höhere ID als das maximale Element in der Tabelle
				f.setId(rs.getInt("maxid") + 1);
		
				stmt = con.createStatement();
				
				// Jetzt erst erfolgt die tatsächliche Einfügeoperation
				stmt.executeUpdate("INSERT INTO fahrt (fahrt_ID, abfahrtszeit, ankunftszeit, abfahrtsort, ankunftsort, fahrtzweck, kmstandanfang, kmstandende, nutzer_ID, pkw_ID) "
						+ "VALUES (" + f.getId() + ",'"  + f.getAbfahrtsZeit() + "','" + f.getAnkunftsZeit() + "','" +
						f.getAbfahrtsOrt() +  "','" + f.getAnkunftsOrt() +  "','" + f.getFahrtZweck() + "','" + 
						f.getKmStandAnfang() + "','" + f.getKmStandEnde() + "','" + f.getNutzer().getId()+ "','" +
						f.getPkw().getId() +"')");
			}
		      
		}
			
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	* @see		updateFahrt(Fahrt f): Aktualisiert Fahrtinformationen in der Datenbank
	* @param	zu aktualisierendes Fahrt-Objekt
	* @return	aktualisiertes Fahrt-Objekt
	*/ 
	public Fahrt updateFahrt(Fahrt f){
		//Aufbau der DBVerbindung
		Connection con = DBConnection.connection();
				
			//Versuch der Abfrage
			try {
				Statement stmt = con.createStatement();
			    //Aktualisieren der Fahrt
			    stmt.executeUpdate("UPDATE fahrt " + "SET abfahrtszeit= \"" 
				          + f.getAbfahrtsZeit() + "\", " + "ankunftszeit=\"" + f.getAnkunftsZeit() + "\", " + "abfahrtsort= \"" + f.getAbfahrtsOrt() + 
				          "\", " + "ankunftsort= \""+ f.getAnkunftsOrt() + "\", " + "fahrtzweck= \"" + f.getFahrtZweck() +
				          "\", " + "kmstandanfang= \""+ f.getKmStandAnfang() + "\", " + "kmstandende= \"" + f.getKmStandEnde() +
				          "\", " + "pkw_ID= \""+ f.getPkw().getId() + "\", " + "nutzer_ID= \""+ f.getNutzer().getId() +
				          "\" WHERE fahrt_ID=" + f.getId());
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

		// Zurückgeben des aktuellen Fahrt-Objektes
		return getFahrtById(f.getId());
	}

}
