package de.hdm.kramer.fahrtenbuch.client;


import java.util.ArrayList;

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
	
	FahrtenbuchAdministrationAsync fbVerwaltung = GWT
			.create(FahrtenbuchAdministration.class);
	
	/**
	 * Hier werden die Panels und die Widgets festgelegt.
	 */

	private VerticalPanel mainPanel = new VerticalPanel();
	private Label userSuchen = new Label("User nach Nickname suchen:");
	private Label nicknameAnzeigen = new Label();
	private VerticalPanel suchePanel = new VerticalPanel();
	final VerticalPanel aboPanel = new VerticalPanel();
	private TextBox tbName = new TextBox();
	private FahrtenbuchAdministrationAsync fb = GWT.create(FahrtenbuchAdministration.class);


	static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	// public SocialMediaFrontend() {

	public Widget angemeldet() {


		/**
		 * Hier wird die Menuleiste mit den Commands erstellt .
		 */
		Command cmd1 = new Command() {
			public void execute() {
				mainPanel.clear();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(mainPanel);
				FormInfosVonPinnwandReport eins = new FormInfosVonPinnwandReport("");
				mainPanel.add(eins);
			}
		};

		Command cmd2 = new Command() {
			public void execute() {
				mainPanel.clear();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(mainPanel);
				FormInfosVonAllenPinnwaendenReport zwei = new FormInfosVonAllenPinnwaendenReport(
						"");
				mainPanel.add(zwei);
			}
		};

		Command cmd3 = new Command() {
			public void execute() {
				mainPanel.clear();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(mainPanel);
				FormInfosVonBeitragReport drei = new FormInfosVonBeitragReport(
						"");
				mainPanel.add(drei);
			}
		};

		Command cmd4 = new Command() {
			public void execute() {
				mainPanel.clear();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(mainPanel);
				FormInfosVonAllenBeitraegenReport vier = new FormInfosVonAllenBeitraegenReport(
						"");
				mainPanel.add(vier);
			}
		};

		Command logout = new Command() {
			public void execute() {

				mainPanel.clear();
				suchePanel.clear();
				RootPanel.get("Header").clear();
				RootPanel.get("Details").clear();
				RootPanel.get().clear();
				Nutzer u = new Nutzer();
				u.abmelden();
				tbName.setVisible(true);
				Cookies.removeCookie("Fb");
				Cookies.removeCookie("FbID");

				Anmelden startseite = new Anmelden();
				startseite.anmelden();

			}
		};
		
		Command pinnwandMenu = new Command() {
			public void execute() {
				mainPanel.clear();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(mainPanel);
				PinnwandForm pF = new PinnwandForm();
				pF.anzeigen();
				mainPanel.add(pF.zeigePost());
			}
		};
		
		PinnwandForm pinnform = new PinnwandForm();
		pinnform.zeigePost();

		pinnform.anzeigen();


//		Command bearb = new Command() {
//			public void execute() {
//				mainPanel.clear();
//				RootPanel.get("Details").clear();
//				RootPanel.get("Details").add(mainPanel);
//				UserBearbeiten uB = new UserBearbeiten();
//				mainPanel.add(uB.bearbeiteProfil());
//
//			}
		};

		MenuBar reportMenu = new MenuBar(true);
		reportMenu.addItem("Infoausgabe von Pinnwand", cmd1);
		reportMenu.addItem("Infoausgabe aller Pinnwaende", cmd2);
//		reportMenu.addItem("Infosausgabe von Beitrag", cmd3);
//		reportMenu.addItem("Infosausgabe aller Beitreage", cmd4);
		reportMenu.addStyleName("reportmenu");

		MenuBar menu = new MenuBar();
		menu.addItem("Pinnwand", pinnwandMenu);
		menu.addItem("Reports", reportMenu);
		menu.addItem("Mein Profil", bearb);
		menu.addItem("LogOut", logout);

		RootPanel.get("Header").add(menu);
			
		final Button sendSucheButton = new Button("Suchen");
		final TextBox nameField = new TextBox();
//		VerticalPanel aboPanel = new VerticalPanel();
//		sendSucheButton.addStyleName("sendSucheButton");
//		suchePanel.add(nicknameAnzeigen);
//		suchePanel.add(userSuchen);
//		suchePanel.add(nameField);
//		suchePanel.add(sendSucheButton);
//		sendSucheButton.setStyleName("sendSucheButton");
//		suchePanel.add(aboPanel);
//		aboPanel.addStyleName("abo");
//		
		
		
		final FlexTable aboTable = new FlexTable();
		initWidget(this.aboPanel);
		
		Label aboLabel = new Label("Abonnierte User: ");
		suchePanel.add(aboLabel);

		// Erstelle Tabelle f�r Infos von einem bestimmten Beitrag in
		// einem
		// bestimmten Zeitraum
		aboTable.setText(0, 0, "Nickname");
		aboTable.setText(0, 1, "Löschen");
	
		final String id = Cookies.getCookie("SocialMedia6ID");
		int uid = Integer.parseInt(id);
		
//		pinnwandVerwaltung.findeAbosAnhandUser(uid, new AsyncCallback<ArrayList<User>>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("Ein Fehler ist aufgetreten! - " + caught.getMessage());
//				
//			}
//
//			@Override
//			public void onSuccess(ArrayList<User> result) {
//				int rowCounter = 1;
//				System.out.println("TESTTESTTESTTEST");
////				System.out.println("result test: "+result.toString());
//                // Hier werden die Objekte durchlaufen. 
//				//User ist final, da es in Inner Class ClickHandler verwendet  werden soll			
//				
//				for (final User u : result) {
//
//					Button a = new Button("-");
//					a.setStyleName("loeschbutton");
//
//					String nickname;
//					
//
//					nickname = u.getNickname();
//
//					
//					// Das Label soll mit Inhalt gef�llt werden
//
//					Label labNick = new Label(nickname);
//
//					// Hier werden die Labels in der Tabelle positioniert
//
//					aboTable.setWidget(rowCounter, 0, labNick);
//					aboTable.setWidget(rowCounter, 1, a);
//
//					a.addClickHandler(new ClickHandler() {
//
//						@Override
//						public void onClick(ClickEvent event) {
//							
//							
//							String nick = u.getNickname();
//							pinnwandVerwaltung.findePinnwandIDAnhandNickname(nick, new AsyncCallback<Integer>() {
//								@Override
//								public void onFailure(Throwable caught) {
//									System.out
//											.println("hat nicht geklappt mit den Post ausgaben: "
//													+ caught.getMessage());
//								}
//								
//								@Override
//								public void onSuccess(Integer result) {
//									String id = Cookies.getCookie("SocialMedia6ID");
//									int uid = Integer.parseInt(id);
//									pinnwandVerwaltung.findeAboIDAnhandPinnwandUserID(uid, result, new AsyncCallback<Integer>() {
//										@Override
//										public void onFailure(Throwable caught) {
//											Window.alert("Fehler beim Posten!");
//										}
//
//										@Override
//										public void onSuccess(Integer result) {
//											pinnwandVerwaltung.aboLoeschen(result, new AsyncCallback<Void>() {
//
//												@Override
//												public void onFailure(Throwable caught) {
//													Window.alert("Fehler beim Löschen des Abos!");
//												}
//
//												@Override
//												public void onSuccess(Void result) {
//
//													Window.alert("Das Abo wurde gelöscht!");
//													Window.Location.reload();
//												}
//											});
//
//										}
//									});
//									
//									
////									Window.alert("Abo wurde angelegt");
////									Window.Location.reload();
//									
//									
//								
//								}
//								
//							});
//							
//							
//						}
//
//					});
//
//					//Zeile hochzählen
//					rowCounter++;
//				}
//
//				
//				
//				
//			}
//		});
//
//		suchePanel.add(aboTable);
//		aboTable.addStyleName("flextable");
//		aboTable.getRowFormatter().addStyleName(0, "aboliste");

		/**
		 * Mit einem Klick auf den Button Aboliste werden die von dem
		 * angemeldeten User abonnierten User in einer Flextable angezeigt.
		 */
//		abo.addClickHandler(new ClickHandler() {
//			VerticalPanel aboPanel = new VerticalPanel();
//
//			public void onClick(ClickEvent event) {
//
//				final FlexTable aboTable = new FlexTable();
//				initWidget(this.aboPanel);
//				
//				Label aboLabel = new Label("Abonnierte User: ");
//				suchePanel.add(aboLabel);
//
//				// Erstelle Tabelle f�r Infos von einem bestimmten Beitrag in
//				// einem
//				// bestimmten Zeitraum
//				aboTable.setText(0, 0, "Nickname");
//				aboTable.setText(0, 1, "Löschen");
//				
//				final String id = Cookies.getCookie("SocialMedia6ID");
//				int uid = Integer.parseInt(id);
//				
//				pinnwandVerwaltung.findeAbosAnhandUser(uid, new AsyncCallback<ArrayList<User>>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						Window.alert("Ein Fehler ist aufgetreten! - " + caught.getMessage());
//						
//					}
//
//					@Override
//					public void onSuccess(ArrayList<User> result) {
//						int rowCounter = 1;
//						System.out.println("TESTTESTTESTTEST");
////						System.out.println("result test: "+result.toString());
//		                // Hier werden die Objekte durchlaufen. 
//						//User ist final, da es in Inner Class ClickHandler verwendet  werden soll			
//						
//						for (final User u : result) {
//
//							Button a = new Button("-");
//
//							String nickname;
//							
//
//							nickname = u.getNickname();
//
//							
//							// Das Label soll mit Inhalt gef�llt werden
//
//							Label labNick = new Label(nickname);
//
//							// Hier werden die Labels in der Tabelle positioniert
//
//							aboTable.setWidget(rowCounter, 0, labNick);
//							aboTable.setWidget(rowCounter, 1, a);
//
//							a.addClickHandler(new ClickHandler() {
//
//								@Override
//								public void onClick(ClickEvent event) {
//									//abonnieren
//								}
//
//							});
//
//							//Zeile hochzählen
//							rowCounter++;
//						}
//
//						
//						
//						
//					}
//				});
//
//				suchePanel.add(aboTable);
//				aboTable.addStyleName("flextable");
//
//			}
//
//		});
		
		
		

		/**
		 * Hier kann der angemeldeter User andere User �ber ihren Nachnamen
		 * suchen. Dabei wird eine Trefferliste erstellt.
		 */

		sendSucheButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println("On Click in der User Trefferliste ");
				System.out.println(nameField.getText());
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(mainPanel);

				String text = nameField.getText();

				if (text.isEmpty()) {

					UserTrefferliste ut = new UserTrefferliste();

					mainPanel.clear();
					mainPanel.add(ut.zeigeTabelle());

				} else {
					mainPanel.clear();
					System.out.println("Else Block, Namefeld ist: "
							+ nameField.getText());
					UserTrefferliste ut = new UserTrefferliste();
					mainPanel.add(ut.zeigeUserNameTabelle(text));


				}

			}
		});

		RootPanel.get("Details").add(mainPanel);

		nameField.addKeyPressHandler(new KeyPressHandler() {
			public void onKeyPress(KeyPressEvent event) {
				System.out.println("Keypress ");
				System.out.println(nameField.getText());
				String text = nameField.getText();
				System.out.println(("Event von Key: " + event.getCharCode()));
				if (text.isEmpty() && event.getCharCode() == KeyCodes.KEY_ENTER) {

					UserTrefferliste ut = new UserTrefferliste();
					mainPanel.clear();
					mainPanel.add(ut.zeigeTabelle());

				} else if (event.getCharCode() == KeyCodes.KEY_ENTER) {

					// boolean test = nameField.equals("");
					System.out.println("Else Block, Keypress ist: "
							+ nameField.getText());
					UserTrefferliste ut = new UserTrefferliste();
					mainPanel.clear();
					mainPanel.add(ut.zeigeUserNameTabelle(text));

				}

			}

		});

		final String userNickname = Cookies.getCookie("SocialMedia6ID");
		int userID = Integer.parseInt(userNickname);
		nicknameAnzeigen.addStyleName("nicknameAnzeigen");
		socialmedia.findeUserAnhandID(userID, new AsyncCallback<User>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(User result) {
				nicknameAnzeigen.setText(result.getNickname());				
			}
		});
		
		
		// Add it to the root panel.
		RootPanel.get("Navigator").add(suchePanel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		return mainPanel;
	}

}
