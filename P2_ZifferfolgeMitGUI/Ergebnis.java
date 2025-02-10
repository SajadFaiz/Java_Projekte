package ziffernfolge;

/**
 * Klasse fuer das Ergebnis
 * @author Adam Bobusch
 * @version 07.06.2020
 */

/**
 * Diese Klasse stellt die grundlegenden Funktionen 
 * fuer das gespielte Ergebnis dar
 */

public class Ergebnis implements Comparable<Ergebnis>{
	
	public String spielerName;
	public long spielZeit;
	public int laengeReihe; 
	

	
	
	/**
	 * Methode fuer den Vergleich
	 * @param ergebnis
	 * @return int
	 * - wenn Objekt kleiner als uebergebenese Objekt, dann return -1
	 * - wenn Objekt gleiche Laenge hat wie das uebergebene Objekt return 0
	 * - wenn Objekt groesser als uebergeben Objekt, dann return 1
	 * - wenn uebergebenes Objekt null enthaehlt return 2
	 */
	public int compareTo(Ergebnis ergebnis) {
		if (ergebnis != null) {
			if (ergebnis.laengeReihe == this.laengeReihe) {
				if (ergebnis.spielZeit < this.spielZeit){
					return -1;
				}
				else if (ergebnis.spielZeit > this.spielZeit){
					return 1;
				}
				return 0;
			}
			else if (ergebnis.laengeReihe > this.laengeReihe) {
				return 1;
			}
			else {
				return -1;
			}
		}	
		return 2;
	}

}
