package de.hdm.kramer.fahrtenbuch.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
/**
 * 
 * 
 * Die Klasse Fahrtenbuch ist die EntryPointKlasse die die Methode onModuleLoad enthält.
 * Die Klasse wird beim Start des Programs als erstes geladen.
*/



public class Fahrtenbuch implements EntryPoint {
 
	int zahl = 0;
	FahrtenbuchFrontend an = new FahrtenbuchFrontend();
	Anmelden a = new Anmelden();


	public void onModuleLoad() {

//		try{
//		String cookie=Cookies.getCookie("Fb");
//		System.out.println("On Module Load cookie: "+cookie);
//		
//		if(!cookie.equals(null)){
			
		an.angemeldet();
//		}
//
//		}
//		catch(Exception e){
//			a.anmelden();
			
			

		}

		
	}
		

	
//}
