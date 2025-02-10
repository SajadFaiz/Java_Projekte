package spiel;

import java.util.Random;

/**
 * Diese Klasse implementiert eine verkettete Liste zur Speicherung von Ziffern.
 */
public class Ziffernreihe {
    private Knoten kopf = new Knoten();
    private Knoten ende = new Knoten();
    private Knoten aktuellerKnoten = kopf;
    private int size = 0;  // Grosse der Ziffernreihe
    private Random random = new Random();  // Zufallszahlengenerator

    public Ziffernreihe() {
        kopf.nachfolger = ende;
        ende.nachfolger = null;
    }

    public int laenge() {
        return size;
    }

    public int aktuelle_Ziffer(int index) {
        Knoten temp = kopf.nachfolger;
        while (index > 0 && temp != ende) {
            temp = temp.nachfolger;
            index--;
        }
        return temp != null ? temp.value : -1;
    }

    public void fuegeNeueZifferHinzu() {
        Random rand = new Random();
        int neueZiffer = rand.nextInt(10); // Zufallszahl zwischen 0 und 9
        add(neueZiffer); // F�ge die neue Ziffer zur Liste hinzu
    }


    private void add(int ziffer) {
        aktuellerKnoten.nachfolger = new Knoten();
        aktuellerKnoten = aktuellerKnoten.nachfolger;
        aktuellerKnoten.value = ziffer;
        aktuellerKnoten.nachfolger = ende;
        size++;
    }

    private class Knoten {
        int value;
        Knoten nachfolger;
    }
}

