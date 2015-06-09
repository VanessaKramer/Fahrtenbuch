package de.hdm.kramer.fahrtenbuch.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

//import de.hdm.kramer.fahrtenbuch.client.User;
import de.hdm.kramer.fahrtenbuch.shared.bo.Fahrt;
import de.hdm.kramer.fahrtenbuch.shared.bo.Fahrtenbuch;
import de.hdm.kramer.fahrtenbuch.shared.bo.Nutzer;
import de.hdm.kramer.fahrtenbuch.shared.bo.Pkw;

public interface FahrtenbuchAdministrationAsync {

	void deleteNutzer(Nutzer n, AsyncCallback<Void> callback);

	void deletePkw(Pkw p, AsyncCallback<Void> callback);

	void getAllNutzer(AsyncCallback<ArrayList<Nutzer>> callback);

	void getAllPkws(AsyncCallback<ArrayList<Pkw>> callback);

	void getFahrtById(int id, AsyncCallback<Fahrt> callback);

	void getFahrtenByNutzer(int id, AsyncCallback<ArrayList<Fahrt>> callback);

	void getFahrtenbuchById(int id, AsyncCallback<Fahrtenbuch> callback);

	void getNutzerById(int id, AsyncCallback<Nutzer> callback);

	void getPkwById(int id, AsyncCallback<Pkw> callback);

	void init(AsyncCallback<Void> callback);

	void insertFahrt(Fahrt f, AsyncCallback<Void> callback);

	void insertFahrtenbuch(Fahrtenbuch fb, AsyncCallback<Fahrtenbuch> callback);

	void insertNutzer(Nutzer n, AsyncCallback<Nutzer> callback);

	void insertPkw(Pkw p, AsyncCallback<Void> callback);

	void updateFahrt(Fahrt f, AsyncCallback<Fahrt> callback);

	void updateNutzer(Nutzer n, AsyncCallback<Nutzer> callback);

	void anmelden(String email, String passwort, AsyncCallback<Nutzer> callback);

	

}
