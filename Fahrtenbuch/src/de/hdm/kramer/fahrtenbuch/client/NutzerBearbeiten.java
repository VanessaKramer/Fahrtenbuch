package de.hdm.kramer.fahrtenbuch.client;


import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.hdm.kramer.fahrtenbuch.shared.FahrtenbuchAdministration;
import de.hdm.kramer.fahrtenbuch.shared.FahrtenbuchAdministrationAsync;
import de.hdm.kramer.fahrtenbuch.shared.bo.*;


public class NutzerBearbeiten {

private VerticalPanel vPanel = new VerticalPanel();
private Label lbRname = new Label("Name");
private TextBox tbRname = new TextBox();
private Label lbRs = new Label("Nachname");
private TextBox tbNachname = new TextBox();
private TextBox tbNick = new TextBox();
private Label lbEmail = new Label("Email-Adresse");
private TextBox tbEmail = new TextBox();
private Label lbRPasswort = new Label("Passwort");
private PasswordTextBox tbRPasswort = new PasswordTextBox();
private Label bearbeiten = new Label("User Einstellungen bearbeiten: ");
private Button bbutton = new Button("Bearbeiten");
private VerticalPanel mainPanel = new VerticalPanel();


FahrtenbuchAdministrationAsync fb = GWT
		.create(FahrtenbuchAdministration.class);

public NutzerBearbeiten() {

}

/**
 * Hier wird der angemeldete User mit seinen Daten ausgelesen, sodass diese abgeändert werden können
 */
public Widget bearbeiteProfil() {
	
	//angemeldeten User rauslesen
	final String id = Cookies.getCookie("FbID");
	int uid = Integer.parseInt(id);
	fb.getNutzerById(uid, new AsyncCallback<Nutzer>() {
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Fehler beim loeschen!");
		}
		//dem Panel werden die Labels und Textboxen für das Formular hinzugefügt
		@Override
		public void onSuccess(Nutzer result) {
			vPanel.add(bearbeiten);
			bearbeiten.addStyleName("bearbeitenLabel");
			vPanel.add(lbRname);
			vPanel.add(tbRname);
			tbRname.setText(result.getVorname());
			vPanel.add(lbRs);
			vPanel.add(tbNachname);
			tbNachname.setText(result.getName());
			vPanel.add(lbEmail);
			vPanel.add(tbEmail);
			tbEmail.setText(result.getEmail());
			vPanel.add(lbRPasswort);
			vPanel.add(tbRPasswort);
			tbRPasswort.setText(result.getPasswort());
			vPanel.add(bbutton);
			bbutton.setStyleName("editButton");
			
			mainPanel.add(vPanel);
			mainPanel.addStyleName("einstellungenPanel");
			RootPanel.get("Details").add(mainPanel);

		}
	});

	
	//ClickHandler für den Bearbeiten Button
	
	bbutton.addClickHandler(new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			
			int uid = Integer.parseInt(id);
			String vorname = tbRname.getText();
			String nachname = tbNachname.getText();
			String email = tbEmail.getText();
			String passwort = tbRPasswort.getText();
			
			fb.updateNutzer(uid, vorname, nachname, email,passwort, new AsyncCallback<Nutzer>() {
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Fehler beim Editieren!");
						}

						@Override
						public void onSuccess(Nutzer result) {
							Window.alert("Deine Profildaten wurden erfolgreich editiert!");

						}
					});
		}

	});

	return mainPanel;
	
}
}

