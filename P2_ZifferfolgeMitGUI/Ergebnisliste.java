package ziffernfolge;

import java.io.IOException;

public class Ergebnisliste {
	
	private Datenspeicher datenspeicher = new Datenspeicher();
	private Liste liste = new VerketteteListe();
	private Sortierung sort = new BubbleSort();
	private Liste.Iterator iterator = liste.erzeuge_Iterator();
	
	public Ergebnisliste() {
		this.liste = datenspeicher.lade();	
	}

	
	/**
	 * Hier wird das Objekt ergebnis 
	 * in die Ergebnisliste gespeichert
	 * @param ergebnis
	 * @throws IOException 
	 */
	public void speichere(Ergebnis ergebnis) {
		liste.setze_an_Ende(ergebnis);
		datenspeicher.speichere(liste);
		
	}
	
	/**
	 * Ein Ergebnis wird an den Anfang der Liste gesetzt
	 */
	public void start() {
		iterator=liste.erzeuge_Iterator();
		iterator.anfang();
		sort.setze_absteigend();
		
		sort.sortiere(liste);
		iterator=liste.erzeuge_Iterator();
		
		iterator.anfang();
	}
	
	/**
	 * Nachfolger des aktuellen Ergbnisses wird das
	 * aktuelle Ergebnis
	 */
	public void weiter() {
		iterator.weiter();
	}
	
	/**
	 * Wenn die Ende Liste erreicht
	 * @return boolean True
	 */
	public boolean ende() {
		return iterator.nach_ende();
	}
	/**
	 * Gibt das aktuelle Element aus der Liste
	 * als Objekt Ergebnis zurueck
	 * @return Ergebnis
	 */
		public Ergebnis aktuelles_Element() {
			Ergebnis ergebnis = new Ergebnis();
			try {			
				ergebnis = (Ergebnis) iterator.element();
				return ergebnis;			
			} catch (Exception e) {
				System.out.println("Liste ist leer");	
				return null;
			}		
		}
	
    
}
 
