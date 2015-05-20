package de.hdm.kramer.fahrtenbuch.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
/**
 * 
 * 
 * Die Klasse SocialMediaPinnwandSystem06 ist die EntryPointKlasse die die Methode onModuleLoad enthält.
 */

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;



public class Entry implements EntryPoint {
 
	int zahl = 0;
	Fahrtenbuch an = new Fahrtenbuch();
	Anmelden a = new Anmelden();


	public void onModuleLoad() {

		try{
		String cookie=Cookies.getCookie("Fb");
		System.out.println("On Module Load cookie: "+cookie);
		if(!cookie.equals(null)){
//			
		an.angemeldet();
		}

		}
		catch(Exception e){
			a.anmelden();
			
			

		}

		
	}
		

	
}
