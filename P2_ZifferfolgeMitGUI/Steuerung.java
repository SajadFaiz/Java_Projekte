package ziffernfolge;


/**
 * Test Steuerung
 * 
 */

public class Steuerung {
	private Bestenliste bestenliste;
	private Spielkonsole spielkonsole;
	private Start start = new Start();
	private Praesentation_Ziffernfolge praesentation_ziffernfolge = new Praesentation_Ziffernfolge();
	private Memorieren_Ziffernfolge memorieren_ziffernfolge = new Memorieren_Ziffernfolge();
	private Eingabe_Name name_eingeben = new Eingabe_Name();
	private Anzeige_Bestenliste anzeige_bestenliste = new Anzeige_Bestenliste();
	// aktueller Zustand der Spielkonsole.
	private Zustand zustand = start;

	/**
	 * Konstruktor fuer Steuerung Erzeugt eine Steuerung fuer eine Spielkonsole. und
	 * Bestenliste
	 * 
	 * @param spielkonsole Spielkonsole, welche gesteuert werden soll.
	 */
	public Steuerung(Spielkonsole spielkonsole, Bestenliste bestenliste) {
		this.spielkonsole = spielkonsole;
		this.bestenliste = bestenliste;
		bestenliste.sichtbar(false);
	}

	/**
	 * Ereignis. Teilt der Steuerung mit, dass das Spiel gestartet worden ist.
	 */
	public void Spiel_gestartet() {
		zustand.spiel_gestartet();
	}

	/**
	 * Ereignis. Teilt der Steuerung mit, dass die Praesentation der Ziffernfolge
	 * beendet worden ist.
	 */
	public void praesentation_Ziffernfolge_beendet() {
		zustand.praesentation_Ziffernfolge_beendet();
	}

	/**
	 * Ereignis. Teilt der Steuerung mit, dass der Spieler eine Ziffer ausgewaehlt
	 * hat
	 * 
	 * @param ziffer
	 */
	public void ziffer_ausgewaehlt(Ziffer ziffer) {
		zustand.Ziffer_ausgewaehlt(ziffer);
	}

	/**
	 * Startereignis fuer neues Spiel.
	 */
	public void neues_Spiel() {
		zustand.neues_Spiel();
	}

	/**
	 * Name Eingabeereignis
	 */
	public void Name_eingegeben() {
		zustand.name_eingegeben();
	}

//abstrakte Zustandsklasse mit Standardverhalten
	public abstract class Zustand {
		public void spiel_gestartet() {

		}

		public void praesentation_Ziffernfolge_beendet() {

		}

		public void Ziffer_ausgewaehlt(Ziffer ziffer) {

		}

		public void neues_Spiel() {

		}

		public void name_eingegeben() {

		}

		public void entry() {

		}

		public void exit() {

		}

		// Umschalten auf neuen Zustand
		public void naechster_Zustand(Zustand neuer_zustand) {
			exit();
			zustand = neuer_zustand;
			neuer_zustand.entry();
		}
	}

	// Zustand Start
	class Start extends Zustand {
		/**
		 * Die Anwendung wurde gestartet, nächster Zustand ist Praesentation
		 * Ziffernfolge.
		 */
		public void spiel_gestartet() {
			naechster_Zustand(praesentation_ziffernfolge);
			
		}
	}

	// Zustand Praesentation_Ziffernfolge
	class Praesentation_Ziffernfolge extends Zustand {
		/**
		 * Die Präsentation der Ziffernfolge wird gestarten.
		 */
		public void entry() {
			spielkonsole.starte_Praesentation_Ziffernfolge();
		}

		/**
		 * Das Ereignis praesentation_Ziffernfolge_beendet ist eingetreten. Der nächste
		 * Zustand ist Memorieren Ziffernfolge.
		 */
		public void praesentation_Ziffernfolge_beendet() {
			naechster_Zustand(memorieren_ziffernfolge);
		}
	}

	// Zustand Memorieren_Ziffernfolge
	class Memorieren_Ziffernfolge extends Zustand {
		/**
		 * Die ausgewählte Ziffer wird überprüft. Ereignis ziffer_ausgewählt ist
		 * eingetreten. I: Wenn die Ziffer korrekt ist und alle anderen Ziffern
		 * memoriert sind leuchtet die Ziffer grün auf und der nächste Zustand ist
		 * Praesentation Ziffernfolge. II: Wenn die Ziffer korrekt ist, aber noch nicht
		 * alle anderen Ziffern memoriert sind, leuchtet die Ziffer grün auf. Die
		 * nächste Sollziffer wird ausgewählt und der nächste Zustand ist Memorieren
		 * Ziffernfolge. III:Wenn die Ziffer nicht korrekt ist, leuchtet die Ziffer rot
		 * auf und der nächste Zustand ist Name eingegeben.
		 * 
		 * @param ziffer Die ausgewählte Ziffer
		 */
		public void Ziffer_ausgewaehlt(Ziffer ziffer) {
			if(spielkonsole.ausgewaehlte_Ziffer_korrekt(ziffer) && spielkonsole.alle_Ziffern_memoriert()) {
				ziffer.leuchte_gruen_auf();
				naechster_Zustand(praesentation_ziffernfolge);
				return;
			}
			if(spielkonsole.ausgewaehlte_Ziffer_korrekt(ziffer) && !spielkonsole.alle_Ziffern_memoriert()) {
				ziffer.leuchte_gruen_auf();
				spielkonsole.naechste_Sollziffer();
				naechster_Zustand(memorieren_ziffernfolge);
				return;
			}
			if (!spielkonsole.ausgewaehlte_Ziffer_korrekt(ziffer)) {
				ziffer.leuchte_rot_auf();
				naechster_Zustand(name_eingeben);
				return;
			}
		}
	}

	// Zustand Anzeige_Bestenliste
	class Anzeige_Bestenliste extends Zustand {
		/**
		 * Die Bestenliste wird angezeigt.
		 */
		public void entry() {
			bestenliste.zeige_Liste_an();
		}

		/**
		 * Das Ereignis neues Spiel ist eingetreten. Die Zifferfolge wird gelöscht und
		 * eine neue wird erstellt. Die Spielkonsole wird sichtbar und die Bestenliste
		 * unsichtbar. Der nächste Zustand ist Praesentation Ziffernfolge.
		 */
		public void exit() {
			bestenliste.sichtbar(false);
			spielkonsole.sichtbar(true);
			spielkonsole.beginne_neue_Ziffernfolge();
		}
		/**
		 * Das Ereignis neues Spiel ist eingetreten.
		 */
		public void neues_Spiel() {
			naechster_Zustand(praesentation_ziffernfolge);			
		}
	}

	// Zustand Eingabe_Name
	class Eingabe_Name extends Zustand {
		/**
		 * Das Ereignis neues Spiel ist eingetreten. Die Zifferfolge wird gelöscht und
		 * eine neue wird erstellt. Die Spielkonsole wird sichtbar und die Bestenliste
		 * unsichtbar. Der nächster Zustand ist Praesentation Ziffernfolge.
		 */
		public void neues_Spiel() {
			bestenliste.sichtbar(false);
			spielkonsole.sichtbar(true);
			spielkonsole.beginne_neue_Ziffernfolge();
			naechster_Zustand(praesentation_ziffernfolge);
		}

		/**
		 * Die Spielkonsole wird unsichtbar und die Bestenliste sichtbar. Die
		 * Namenseingabe wird aktiviert. Die Spielzeit und Listenlänge wird von der
		 * Spielkonsole an die Bestenliste, über die Methode 'neues_Ergebnis',
		 * übergeben.
		 */
		public void entry() {
			spielkonsole.sichtbar(false);
			bestenliste.sichtbar(true);
			bestenliste.aktiviere_Namenseingabe();
			bestenliste.neues_Ergebnis(spielkonsole.Laenge_Ziffernfolge(), spielkonsole.Spielzeit());
		}

		/**
		 * Das Ereignis Name_eingegeben ist eingetreten. Der nächste Zustand ist
		 * Anzeige Bestenliste.
		 */
		public void name_eingegeben() {
			naechster_Zustand(anzeige_bestenliste);
		}
	}

}