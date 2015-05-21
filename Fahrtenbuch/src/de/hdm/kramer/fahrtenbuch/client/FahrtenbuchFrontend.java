package de.hdm.kramer.fahrtenbuch.client;


import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.hdm.kramer.fahrtenbuch.shared.FahrtenbuchAdministration;
import de.hdm.kramer.fahrtenbuch.shared.FahrtenbuchAdministrationAsync;
import de.hdm.kramer.fahrtenbuch.shared.bo.Nutzer;



public class FahrtenbuchFrontend extends Composite {
	
	FahrtenbuchAdministrationAsync fahrtenbuchAdmin = GWT
			.create(FahrtenbuchAdministration.class);
	
	/**
	 * Hier werden die Panels und die Widgets festgelegt.
	 */

	private VerticalPanel mainPanel = new VerticalPanel();
	private VerticalPanel suchePanel = new VerticalPanel();
	private TextBox tbName = new TextBox();
	private FahrtenbuchAdministrationAsync fb = GWT.create(FahrtenbuchAdministration.class);


	static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	// public SocialMediaFrontend() {

	public Widget angemeldet() {

		Command reportMenu = new Command() {
			public void execute() {
				mainPanel.clear();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(mainPanel);
				Report rep = new Report();
				mainPanel.add(rep);
			}
		};

		Command logout = new Command() {
			public void execute() {

				mainPanel.clear();
				suchePanel.clear();
				RootPanel.get("Header").clear();
				RootPanel.get("Details").clear();
				RootPanel.get().clear();
				Nutzer n = new Nutzer();
				n.abmelden();
				tbName.setVisible(true);
				Cookies.removeCookie("Fb");
				Cookies.removeCookie("FbID");

				Anmelden startseite = new Anmelden();
				startseite.anmelden();

			}
		};
		
		Command fahrtenbuchMenu = new Command() {
			public void execute() {
				mainPanel.clear();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(mainPanel);
				Fahrtenliste fl = new Fahrtenliste();
				fl.anzeigen();
				mainPanel.add(fl.zeigePost());
			}
		};
		
		Fahrtenliste fahrtenliste = new Fahrtenliste();
//		fahrtenliste.zeigePost();
//
//		fahrtenliste.anzeigen();


		Command bearb = new Command() {
			public void execute() {
				mainPanel.clear();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(mainPanel);
				NutzerBearbeiten nB = new NutzerBearbeiten();
			//	mainPanel.add(nB.bearbeiteProfil());

			}
		};


		MenuBar menu = new MenuBar();
		menu.addItem("Pinnwand", fahrtenbuchMenu);
		menu.addItem("Reports", reportMenu);
		menu.addItem("Mein Profil", bearb);
		menu.addItem("LogOut", logout);

		RootPanel.get("Header").add(menu);

		return mainPanel;
	}

}
