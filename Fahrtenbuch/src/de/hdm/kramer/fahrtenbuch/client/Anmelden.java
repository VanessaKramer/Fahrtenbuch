package de.hdm.kramer.fahrtenbuch.client;


/**
 * @author Bharti Kumar, �zlem G�l, Michael Schelkle, Andreas Sakulidis, Gezim Krasniqi, Ezgi Demirbilek
 *
 * Die Klasse Anmelden erh�lt das Formular Anmelden. Der User kann sich hier registrieren oder mit seinem bereits bestehenden Konto einloggen.
 */
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.hdm.gruppe6.itprojekt.shared.PinnwandVerwaltungService;
import de.hdm.gruppe6.itprojekt.shared.PinnwandVerwaltungServiceAsync;
import de.hdm.gruppe6.itprojekt.shared.bo.User;
import de.hdm.kramer.fahrtenbuch.shared.FahrtenbuchAdministration;
import de.hdm.kramer.fahrtenbuch.shared.FahrtenbuchAdministrationAsync;
import de.hdm.kramer.fahrtenbuch.shared.bo.Nutzer;

public class Anmelden {
	/**
	 * Hier werden die Panels und die Widgets f�r die Anmeldung festgelegt.
	 */

	private HorizontalPanel hPanel = new HorizontalPanel();

//	private Label hinweis = new Label(
//			"*Nickname kann nur einmal festgelegt werden");
//	private Label lbname = new Label("Nickname : ");
	private TextBox tbName = new TextBox();
	private Label lbPasswort = new Label("Passwort : ");
	private PasswordTextBox tbPasswort = new PasswordTextBox();
	private Button loginButton = new Button("Anmelden");
	private HorizontalPanel loginPanel = new HorizontalPanel();

	/**
	 * Hier werden die Panels und die Widgets f�r die Registrierung festgelegt.
	 */
//	private VerticalPanel vPanel = new VerticalPanel();
//	private Label lbRname = new Label("Name");
//	private TextBox tbRname = new TextBox();
//	private Label lbRs = new Label("Nachname");
//	private TextBox tbNachname = new TextBox();
//	private Label lbNick = new Label("Nickname");
//	private TextBox tbNick = new TextBox();
//	private Label lbEmail = new Label("Email-Adresse");
//	private TextBox tbEmail = new TextBox();
//	private Label lbRPasswort = new Label("Passwort");
//	private PasswordTextBox tbRPasswort = new PasswordTextBox();
//	private Button regButton = new Button("Registrieren");
//	private Label regi = new Label("Registrierung: ");
//
//	private VerticalPanel addPanel = new VerticalPanel();
//	private HorizontalPanel horziPanel = new HorizontalPanel();
//
 private FahrtenbuchAdministrationAsync fahrtenbuch = GWT
		 .create(FahrtenbuchAdministration.class);
//
//	static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public Widget anmelden() {

//		hinweis.addStyleName("hinweis");

		/**
		 * Die Widgets f�r die Anmeldung werden dem loginPanel hinzugef�gt.
		 */
//		loginPanel.add(lbname);
		loginPanel.add(tbName);

		loginPanel.add(lbPasswort);
		lbPasswort.setStyleName("loginPasswortLabel");
		loginPanel.add(tbPasswort);
		loginPanel.add(loginButton);
		loginButton.setStyleName("loginButton");

		// public void setFocus(boolean focus) {
		// tbName.setFocus(focus);
		// }
		loginPanel.addStyleName("loginPanel");
		RootPanel.get("Details").add(loginPanel);
		// for(int i = 0; i<10; i++){
		// addPanel.add(lTrennWand);
		// }
		// vPanel.add(addPanel);

		/**
		 * Die Widgets f�r die Registrierung werden dem addPanel hinzugef�gt.
		 */
//		addPanel.add(regi);
//		addPanel.add(lbRname);
//		addPanel.add(tbRname);
//		addPanel.add(lbRs);
//		addPanel.add(tbNachname);
//		addPanel.add(lbNick);
//		addPanel.add(tbNick);
//		addPanel.add(hinweis);
//		addPanel.add(lbRPasswort);
//		addPanel.add(tbRPasswort);
//		addPanel.add(lbEmail);
//		addPanel.add(tbEmail);
//		addPanel.add(regButton);
//		regButton.setStyleName("regButton");
//
//		addPanel.addStyleName("addPanelAnmelden");

		/**
		 * Mit einem Klick auf den Registrierung Button kann sich der User
		 * registrieren.
		 */
//		regButton.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				String a = "";
//
//				System.out.println("Email: " + tbEmail.getText() + " Vorname "
//						+ tbRname.getText() + " Nachname "
//						+ tbNachname.getText() + " Nickname "
//						+ tbNick.getText() + " Passwort " + tbRPasswort);
//				if (!tbEmail.getText().matches(EMAIL_PATTERN)
//						|| tbRname.getText().equals(a)
//						|| tbNachname.getText().equals(a)
//						|| tbNick.getText().equals(a) || tbRPasswort.equals(a)) {
//					Window.alert("Gib eine g�ltige E-Mail Adresse ein!");
//				} else {
//
//					socialmedia.userAnlegen(tbRname.getText(),
//							tbNachname.getText(), tbNick.getText(),
//							tbEmail.getText(), tbRPasswort.getText(),
//							new AsyncCallback<User>() {
//
//								@Override
//								public void onFailure(Throwable caught) {
//									ClientsideSettings.getLogger().severe("Anlegen Fehlgeschlagen" + caught.getMessage());
//									Window.alert("Anlegen Fehlgeschlagen: "
//											+ caught.getMessage());
//
//								}
//
//								@Override
//								public void onSuccess(User result) {
//									if (result == null) {
//										Window.alert("Nickname exisitert bereits!");
//									} else {
//										Window.alert("Anlegen erfolgreich!");
//										addPanel.clear();
//										tbName.setFocus(true);
//									}
//								}
//							});
//				}
//			}
//		});
//
//		// addPanel.add(addPanel);
//		tbName.setFocus(true);
//		RootPanel.get("Details").add(addPanel);
//		// RootPanel.get().add(vPanel);
//
//		// hPanel.add(anmelden);
		/**
		 * Mit einem Klick auf den Anmelden Button kann sich der bereits
		 * registrierter User einloggen.
		 */
		loginButton.addClickHandler(new ClickHandler() {

			   @Override
			   public void onClick(ClickEvent event) {
			    fahrtenbuch.anmelden(tbName.getText(),
			      tbPasswort.getText(), new AsyncCallback<Nutzer>() {

			       @Override
			       public void onFailure(Throwable caught) {
			        Window.alert("Ein fehler ist aufgetreten: "
			          + caught.getMessage());

			       }

			       @Override
			       public void onSuccess(Nutzer result) {

			        // ------------------------------------------------------------------
			        try{
			        if (result.getId() != 0) {

			         Cookies.setCookie("Fb",
			           result.getEmail());
			         Cookies.setCookie("FbID",
			           String.valueOf(result.getId()));

			         RootPanel.get("Details").clear();

			         // Window.alert("Erfolgreich angemeldet... Nickname: "
			         // + result.getNickname());
			         // + " und Passwort"
			         // + result.getPasswort());
			         tbName.setVisible(false);
			         tbPasswort.setVisible(false);
			         loginButton.setVisible(false);

//			         lbRname.setVisible(false);
//			         tbRname.setVisible(false);
//			         lbRs.setVisible(false);
//			         tbNachname.setVisible(false);
//			         lbNick.setVisible(false);
//			         tbNick.setVisible(false);
//			         lbRPasswort.setVisible(false);
//			         tbRPasswort.setVisible(false);
//			         lbEmail.setVisible(false);
//			         tbEmail.setVisible(false);
//			         regButton.setVisible(false);
//			         regi.setVisible(false);

			         // Die Startseite wird aufgerufen
			         Fahrtenbuch start = new Fahrtenbuch();
			         start.angemeldet();
			         // --------------------------------------------------------------------------------------------------------
			         
			        }
			        } catch (Exception e) {
			         Window.alert("Anmeldung fehlgeschlagen!");
			        }
			       }

			      });

			   }
			  });

		/**
		 * Der tbEmail Textbox wird der KeyPressHandler hinzugef�gt.
		 */

		tbEmail.addKeyPressHandler(new KeyPressHandler() {
			String a = "";

			public void onKeyPress(KeyPressEvent event) {
				System.out.println("Email: " + tbEmail.getText() + " Vorname "
						+ tbRname.getText() + " Nachname "
						+ tbNachname.getText() + " Nickname "
						+ tbNick.getText() + " Passwort " + tbRPasswort);
				if (event.getCharCode() == KeyCodes.KEY_ENTER) {
					if (!tbEmail.getText().matches(EMAIL_PATTERN)
							|| tbRname.getText().equals(a)
							|| tbNachname.getText().equals(a)
							|| tbNick.getText().equals(a)
							|| tbRPasswort.equals(a)) {
						Window.alert("Gib eine g�ltige E-Mail Adresse ein!");
					} else {

						socialmedia.userAnlegen(tbRname.getText(),
								tbNachname.getText(), tbNick.getText(),
								tbEmail.getText(), tbRPasswort.getText(),
								new AsyncCallback<User>() {

									@Override
									public void onFailure(Throwable caught) {
										ClientsideSettings.getLogger().severe("Anlegen fehlgeschlaten" + caught.getMessage());
										Window.alert("Anlegen Fehlgeschlagen: "
												+ caught.getMessage());

									}

									@Override
									public void onSuccess(User result) {
										if (result == null) {
											Window.alert("Nickname exisert bereits!");
										} else {
											Window.alert("Anlegen erfolgreich!");
											addPanel.clear();
											tbName.setFocus(true);
										}
									}
								});
					}

				}
			}
		});

		/**
		 * Dem Passworttextbox wird der KeyPressHandler hinzugef�gt.
		 */

		 tbPasswort.addKeyPressHandler(new KeyPressHandler() {
			   public void onKeyPress(KeyPressEvent event) {

			    if (event.getCharCode() == KeyCodes.KEY_ENTER) {

			     socialmedia.userAnmelden(tbName.getText(),
			       tbPasswort.getText(), new AsyncCallback<User>() {

			        public void onSuccess(User result) {

			         // ------------------------------------------------------------------
			         try {
			          if (result.getId() != 0) {

			           Cookies.setCookie("SocialMedia6",
			             result.getNickname());
			           Cookies.setCookie("SocialMedia6ID",
			             String.valueOf(result
			               .getId()));

			           RootPanel.get("Details").clear();

			           // Window.alert("Erfolgreich angemeldet... Nickname: "
			           // + result.getNickname());
			           // + " und Passwort"
			           // + result.getPasswort());
			           tbName.setVisible(false);
			           tbPasswort.setVisible(false);
			           loginButton.setVisible(false);

			           lbRname.setVisible(false);
			           tbRname.setVisible(false);
			           lbRs.setVisible(false);
			           tbNachname.setVisible(false);
			           lbNick.setVisible(false);
			           tbNick.setVisible(false);
			           lbRPasswort.setVisible(false);
			           tbRPasswort.setVisible(false);
			           lbEmail.setVisible(false);
			           tbEmail.setVisible(false);
			           regButton.setVisible(false);
			           regi.setVisible(false);

			           // Die Startseite wird aufgerufen
			           SocialMediaFrontend smf = new SocialMediaFrontend();
			           smf.angemeldet();
			           // --------------------------------------------------------------------------------------------------------
			          }

			         } catch (Exception e) {
			          Window.alert("Anmeldung fehlgeschlagen!");
			         }
			        }

			        @Override
			        public void onFailure(Throwable caught) {
			         Window.alert("Ein Fehler ist aufgetreten: "
			           + caught.getMessage());

			        }
			       });
			    }// NEUU
			   }
			  });
		/**
		 * Dem Widgets werden Stylenames zugeordnet.
		 */

		regi.addStyleName("regi");
		// anmelden.addStyleName("Anmelde�ber");
		// hPanel.addStyleName("Anmelden");
		// vPanel.addStyleName("Regi");
		//
		horziPanel.add(hPanel);
		horziPanel.add(vPanel);

		return horziPanel;
	}
}

