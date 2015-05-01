package de.hdm.kramer.fahrtenbuch.server.db;

import java.sql.*;

public class DBConnection {
	
	//Singleton Variable, damit es nur eine DB Verbindung gibt
	private static Connection con = null;
	
	//Geschützter Konstruktor zum verhindern einer Instanziierung via new
	protected DBConnection(){
	}
	
	
	//lokale Datenbank URL
	private static String url = "jdbc:mysql://localhost/fahrtenbuch";
	
	//Nutzerdaten für DB-Login
	private static String name="root";
	private static String password="";
	
	//Ersatz für Konstruktor zum Erstellen einer Verbindung
	public static Connection connection() {
		// Wenn es bisher keine Conncetion zur DB gab, ... 
		if ( con == null ) {
			try {
				//Installieren des geeigneten DB-Treibers
				DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
				
				con = DriverManager.getConnection(url, name, password);
			} 
			// Wenn die Verbindung scheitert
			catch (SQLException e1) {
				con = null;
				System.out.println("Verbindung fehlgeschlagen!");
				e1.printStackTrace();
	
			}
		}
		
		// Zurückgegeben der Verbindung
		return con;
	}
}
