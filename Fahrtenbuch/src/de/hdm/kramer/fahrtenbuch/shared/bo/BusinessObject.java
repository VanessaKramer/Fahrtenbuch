package de.hdm.kramer.fahrtenbuch.shared.bo;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * <p>
 * Die Klasse <code>BusinessObject</code> stellt die Basisklasse aller in diesem
 * Projekt f�r die Umsetzung des Fachkonzepts relevanten Klassen dar.
 * </p>
 * Zentrales Merkmal ist, dass jedes <code>BusinessObject</code> eine Nummer
 * besitzt, die man in einer relationalen Datenbank auch als Prim�rschl�ssel
 * bezeichnen w�rde. Ferner ist jedes <code>BusinessObject</code> als
 * {@link Serializable} gekennzeichnet. Durch diese Eigenschaft kann jedes
 * <code>BusinessObject</code> automatisch in eine textuelle Form �berf�hrt und
 * z.B. zwischen Client und Server transportiert werden. Bei GWT RPC ist diese
 * textuelle Notation in JSON (siehe http://www.json.org/) kodiert.
 * </p>
 * 
 * @version 1.0
 */

public abstract class BusinessObject implements IsSerializable {
	
	private static final long serialVersionUID = 1L;
	
		/**
		 * Erstellungszeitpunkt der Instanz
		 */
	private Date erstellungsZeitpunkt;
	
		/**
		 * Die eindeutige Identifikationsnummer einer Instanz
		 */
	private int id;
	
	/**
	 * Auslesen des Erstellungszeitpunktes
	 * 
	 */
	public Date getErstellungsZeitpunkt() {
		return erstellungsZeitpunkt;
	}

	/**
	 * Setzen des Erstellungszeitpunkt
	 * 
	 */
	public void setErstellungsZeitpunkt(Date erstellungsZeitpunkt) {
		this.erstellungsZeitpunkt = erstellungsZeitpunkt;
	}

	/**
	 * Auslesen der Identifikationsnummer
	 *
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setzten der Identifikationsnummer
	 * 
	 */
	public void setId(int id) {
		this.id = id;
	} 
	
	/** Erzeugen einer einfachen textuellen Darstellung der jeweiligen Instanz.
	 * Dies kann selbstverst�ndlich in Subklassen �berschrieben werden.
	 */
	  public String toString() {
	    /*
	     * Wir geben den Klassennamen gefolgt von der ID des Objekts zur�ck.
	     */
	    return this.getClass().getName() + " #" + this.id;
	  }
	  
	  /**
	   * <p>
	   * Feststellen der <em>inhaltlichen</em> Gleichheit zweier
	   * <code>BusinessObject</code>-Objekte. Die Gleichheit wird in diesem Beispiel auf eine
	   * identische ID beschränkt.
	   * </p>
	   * <p>
	   * <b>ACHTUNG:</b> Die inhaltliche Gleichheit nicht mit dem Vergleich der
	   * <em>Identit�t</em> eines Objekts mit einem anderen verwechseln!!! Dies
	   * w�rde durch den Operator <code>==</code> bestimmt. Bei Unklarheit hierzu
	   * k�nnen Sie nocheinmal in die Definition des Sprachkerns von Java schauen.
	   * Die Methode <code>equals(...)</code> ist f�r jeden Referenzdatentyp
	   * definiert, da sie bereits in der Klasse <code>Object</code> in einfachster
	   * Form realisiert ist. Dort ist sie allerdings auf die simple Bestimmung der
	   * Gleicheit der Java-internen Objekt-ID der verglichenen Objekte beschr�nkt.
	   * In unseren eigenen Klassen k�nnen wir diese Methode �berschreiben und ihr
	   * mehr Intelligenz verleihen.
	   * </p>
	   */
	  public boolean equals(Object o) {
	    /*
	     * Abfragen, ob ein Objekt ungleich NULL ist und ob ein Objekt gecastet
	     * werden kann, sind immer wichtig!
	     */
	    if (o != null && o instanceof BusinessObject) {
	      BusinessObject bo = (BusinessObject) o;
	      try {
	        if (bo.getId() == this.id)
	          return true;
	      }
	      catch (IllegalArgumentException e) {
	        /*
	         * Wenn irgendetwas schief geht, dann geben wir sicherheitshalber false
	         * zur�ck.
	         */
	        return false;
	      }
	    }
	    /*
	     * Wenn bislang keine Gleichheit bestimmt werden konnte, dann m�ssen
	     * schlie�lich false zur�ckgeben.
	     */
	    return false;
	  }
	}
