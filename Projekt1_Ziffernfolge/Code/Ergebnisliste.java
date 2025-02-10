package spiel;

import java.util.LinkedList;

public class Ergebnisliste {
    private LinkedList<Ergebnis> liste = new LinkedList<>();

    public int size() {
        return liste.size();
    }

    public Ergebnis get(int index) {
        return liste.get(index);
    }

    public void setze_an_Anfang(Ergebnis ergebnis) {
        liste.addFirst(ergebnis);
    }

    public void zeigeErgebnisliste() {
        System.out.println("Bestenliste:");
        for (Ergebnis e : liste) {
            System.out.println("Spieler: " + e.getName() + ", Zeit: " + e.getSpielZeit() + "s, Länge: " + e.getLaengeDerReihe());
        }
    }

    public void add(Ergebnis ergebnis) {
        liste.add(ergebnis);
    }
}
