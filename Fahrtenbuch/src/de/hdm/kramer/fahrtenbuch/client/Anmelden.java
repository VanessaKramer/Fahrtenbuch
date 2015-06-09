package de.hdm.kramer.fahrtenbuch.client;


/**
 * 
 * Die Klasse Anmelden erh�lt das Formular Anmelden. Der User kann sich hier mit seinem bereits bestehenden Konto einloggen.
 */
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import de.hdm.kramer.fahrtenbuch.shared.FahrtenbuchAdministration;
import de.hdm.kramer.fahrtenbuch.shared.FahrtenbuchAdministrationAsync;
import de.hdm.kramer.fahrtenbuch.client.FahrtenbuchFrontend;
import de.hdm.kramer.fahrtenbuch.shared.bo.Nutzer;

public class Anmelden {
	/**
	 * Hier werden die Panels und die Widgets f�r die Anmeldung festgelegt.
	 */

	private HorizontalPanel hPanel = new HorizontalPanel();
	private TextBox textName = new TextBox();
	private Label lbPasswort = new Label("Passwort : ");
	private PasswordTextBox tbPasswort = new PasswordTextBox();
	private Button loginButton = new Button("Anmelden");



 private FahrtenbuchAdministrationAsync fahrtenbuch = GWT
		 .create(FahrtenbuchAdministration.class);

static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public Widget anmelden() {

//		hinweis.addStyleName("hinweis");

		/**
		 * Die Widgets f�r die Anmeldung werden dem loginPanel hinzugef�gt.
		 */

		hPanel.add(textName);

		hPanel.add(lbPasswort);
		lbPasswort.setStyleName("loginPasswortLabel");
		hPanel.add(tbPasswort);
		hPanel.add(loginButton);
		loginButton.setStyleName("loginButton");
		hPanel.addStyleName("loginPanel");
		RootPanel.get("Details").add(hPanel);


		/**
		 * Mit einem Klick auf den Anmelden Button kann sich der Nutzer einloggen.
		 */
		loginButton.addClickHandler(new ClickHandler() {

			   @Override
			   public void onClick(ClickEvent event) {
			    fahrtenbuch.anmelden(textName.getText(),
			      tbPasswort.getText(), new AsyncCallback<Nutzer>() {

			       @Override
			       public void onFailure(Throwable caught) {
			        Window.alert("Ein Fehler ist aufgetreten: "
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
			         textName.setVisible(false);
			         tbPasswort.setVisible(false);
			         loginButton.setVisible(false);


			         // Die Startseite wird aufgerufen
			         FahrtenbuchFrontend start = new FahrtenbuchFrontend();
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

	
	
		return hPanel;
	}
}

