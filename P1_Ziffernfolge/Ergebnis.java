package spiel;

public class Ergebnis {
    private String spielerName;
    private long spielZeit; 
    private int laengeDerReihe;

    public Ergebnis(String spielerName, long spielZeit, int laengeDerReihe) {
        this.spielerName = spielerName;
        this.spielZeit = spielZeit;
        this.laengeDerReihe = laengeDerReihe;
    }

    public String getName() {
        return spielerName;
    }

    public long getSpielZeit() {
        return spielZeit;
    }

    public int getLaengeDerReihe() {
        return laengeDerReihe;
    }
}

