package ziffernfolge;

import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Bestenliste extends JPanel {
	

	private Steuerung steuerung;
	private Ergebnis ergebnis;
	private BestenlisteZeile[] zeilen = new BestenlisteZeile[10];
	private Ergebnisliste ergebnisliste = new Ergebnisliste();
	private String spielerName;
	
	private JTextField textField;
	private JTextField[] textListe = new JTextField[10];

	/**
	 * Create the panel.
	 */
	/**
	 * Konstruktor Bereitstellung der Bestenliste mit 10 Zeilen innerhalb eines
	 * Texfeldes
	 */
	public Bestenliste() {
		setName("Bestenliste");
		setLayout(null);
		textField = new JTextField();
		textField.setBounds(6, 76, 324, 45);
		add(textField);
		textField.setEditable(false);
		this.add(textField);
		textField.setColumns(10);
		for (int i = 0; i < 10; i++) {
			textListe[i] = new JTextField();
			this.add(textListe[i]);
			textListe[i].setVisible(false);
			zeilen[i] = new BestenlisteZeile(textListe[i], i);
		}
	}

	/**
	 * Hier wird der namen eingegeben
	 */
	public void Name_eingegeben() {
		spielerName = textField.getText();
		steuerung.Name_eingegeben();
	}

	/**
	 * Hier wird ein neues Spiel gestartet
	 */
	public void neues_Spiel() {
		steuerung.neues_Spiel();
		for(int i =0;i<10;i++) {
			textListe[i].setVisible(false);
		}
	}

	/**
	 * Hier wird ein neues Ergebnis erstellt.
	 * 
	 * @param folgenlaenge Anzahl der richtigen gefundenen Ziffern
	 * @param spielzeit    Dauer des Ziffernspiels
	 */
	public void neues_Ergebnis(int laengeReihe, double spielZeit) {
		//System.out.println(spielZeit);
		//System.out.println(laengeReihe);
		ergebnis = new Ergebnis();
		ergebnis.spielZeit = (long) spielZeit;
		ergebnis.laengeReihe = laengeReihe;
	}

	/**
	 * Hier die Namenseingabe aktiviert
	 */
	public void aktiviere_Namenseingabe() {
		//System.out.println("aktiviere_Namenseingabe");
		textField.setEditable(true);
		textField.setVisible(true);
		textField.setText("Bitte den Namen eingeben");
	}

	/**
	 * Hier wird die Bestelliste angezeigt
	 * @throws IOException 
	 */
	public void zeige_Liste_an() {
		ergebnisliste = new Ergebnisliste();
		ergebnis.spielerName = spielerName;
		ergebnisliste.speichere(ergebnis);
		ergebnisliste.start();
		for (int i = 0; i < 10; i++) {
			if (!ergebnisliste.ende()) {
				zeilen[i].zeige_an(ergebnisliste.aktuelles_Element());
				textListe[i].setVisible(true);
				ergebnisliste.weiter();
			}
		}
		textField.setEditable(false);
		textField.setVisible(false);
	}

	/**
	 * Hier wird entschieden, ob die Bestenliste sichtbar ist oder nicht
	 * 
	 * @param wert als boolean Werte "true" oder "false"
	 */
	public void sichtbar(boolean wert) {
		setVisible(wert);
	}
	
	public void melde_an(Steuerung steuerung) {
		this.steuerung = steuerung;
	}
}
