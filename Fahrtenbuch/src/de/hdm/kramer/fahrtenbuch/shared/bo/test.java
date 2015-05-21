package de.hdm.kramer.fahrtenbuch.shared.bo;

import de.hdm.kramer.fahrtenbuch.server.db.*;


public class test {
	
	public static void main(String[] args) {
		
		//NUTZERMAPPER
		
		/*
		 * Nutzer-Methoden:
		 * getNutzerById(int id)	x
		 * getAllNutzer()			x
		 * insertNutzer(Nutzer n)	x
		 * deleteNutzer(Nutzer n)	x
		 * updateNutzer(Nutzer n)	x	
		 */
			
		//Nutzer karl= new Nutzer("Karl","Heinz","karl_heinz@web.de");
		//Nutzer max= new Nutzer("Max", "Mustermann", "max.mustermann@gmail.com");
		//Nutzer hans= new Nutzer("Hans", "Fritz", "fritz@gmail.com");
		
		//NutzerMapper.nutzerMapper().insertNutzer(karl);
		//NutzerMapper.nutzerMapper().insertNutzer(max);
		//NutzerMapper.nutzerMapper().insertNutzer(hans);
		
		Nutzer n=NutzerMapper.nutzerMapper().getNutzerById(1);
		n.setName("Fritz"); 
		n.setVorname("Sebastian");
		NutzerMapper.nutzerMapper().updateNutzer(n);
		//NutzerMapper.nutzerMapper().deleteNutzer(n);
		System.out.println(NutzerMapper.nutzerMapper().getAllNutzer());
		
		
		
		//FAHRTENBUCHMAPPER
		
		/*
		 * Methoden:
		 * fahrtenbuchMapper()				x
		 * getFahrtenbuchById(int id)		x
		 * insertFahrtenbuch(Fahrtenbuch fb)x
		 */
		
		
		//Fahrtenbuch fb1= new Fahrtenbuch();
		//fb1.setNutzer(NutzerMapper.nutzerMapper().getNutzerById(1));
		
		//Fahrtenbuch fb2= new Fahrtenbuch();	
		//fb2.setNutzer(NutzerMapper.nutzerMapper().getNutzerById(2));
		
		//FahrtenbuchMapper.fahrtenbuchMapper().insertFahrtenbuch(fb1);
		//FahrtenbuchMapper.fahrtenbuchMapper().insertFahrtenbuch(fb2);	
		
		//Fahrtenbuch fb3= new Fahrtenbuch();
		//fb3.setNutzer(NutzerMapper.nutzerMapper().getNutzerById(3));
		
		//System.out.println(FahrtenbuchMapper.fahrtenbuchMapper().getFahrtenbuchById(1).getNutzer().getName());
		//System.out.println(FahrtenbuchMapper.fahrtenbuchMapper().getFahrtenbuchById(1).getErstellungsZeitpunkt().toString());
		
		
	
		//PKWMAPPER
		
		/*
		 * Methoden:
		 * getPkwById(int id)	x
		 * getAllPkws()			x
		 * insertPkw(Pkw p)		x
		 * deletePkw(Pkw p)		x
		 */
		
		//Pkw audi= new Pkw("Audi A3",2014);
		//audi.setFahrtenbuch(FahrtenbuchMapper.fahrtenbuchMapper().getFahrtenbuchById(1));
				
		//Pkw porsche= new Pkw("Porsche 911 Turbo",2013);
		//vw.setFahrtenbuch(FahrtenbuchMapper.fahrtenbuchMapper().getFahrtenbuchById(2));
				
		//PkwMapper.pkwMapper().insertPkw(audi);
		//PkwMapper.pkwMapper().insertPkw(porsche);	
		
		//Pkw p=PkwMapper.pkwMapper().getPkwById(3);
		//PkwMapper.pkwMapper().deletePkw(p);
		//System.out.println(PkwMapper.pkwMapper().getAllPkws());
		
		
		
		//FAHRTMAPPER funktioniert, nur Abfahrtszeit und Ankunftszeit-Eingabe in Java unklar
		
		/*
		 * Methoden:
		 * getFahrtById(int id)			x
		 * getFahrtenByNutzer(int id)	x
		 * getAllFahrten()				x
		 * insertFahrt(Fahrt f)
		 * updateFahrt(Fahrt f)			x
		 */
		
		
		
		//Fahrt b= new Fahrt(Timestamp.valueOf("2015-04-25 09:30:00.000000"), Timestamp.valueOf("2015-04-26 09:30:00.000000"), "BOSCH Feuerbach", "Hamburg",
		//"Meeting", 7088, 8130);
		//b.setNutzer(NutzerMapper.nutzerMapper().getNutzerById(2));
		//b.setPkw(PkwMapper.pkwMapper().getPkwById(1));
		
		//Fahrt f=FahrtMapper.fahrtMapper().getFahrtById(2);
		//f.setAnkunftsOrt("Köln");
		//f.setKmStandAnfang(8566);
		//f.setKmStandEnde(8874);
		//FahrtMapper.fahrtMapper().updateFahrt(f);
		//System.out.println(FahrtMapper.fahrtMapper().getFahrtById(1).getNutzer().getName());
		//System.out.println(FahrtMapper.fahrtMapper().getFahrtById(1).getPkw().getModellName());
		//System.out.println(FahrtMapper.fahrtMapper().getFahrtById(1).getAbfahrtsZeit().toString());
		
		//System.out.println(FahrtMapper.fahrtMapper().getFahrtenByNutzer(1));
		
		
		
		
	}
}

