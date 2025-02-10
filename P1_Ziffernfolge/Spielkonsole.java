package spiel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Spielkonsole {
    private Ziffernreihe ziffernfolge = new Ziffernreihe();  // Ziffernreihe-Objekt zur Speicherung der Ziffernfolge
    private BufferedReader leser = new BufferedReader(new InputStreamReader(System.in));
    private Ergebnisliste ergebnisListe = new Ergebnisliste();
    private static final int MAX_ZIFFERN = 5;  // Maximale Anzahl an Ziffern in der Folge

    public Spielkonsole() throws InterruptedException, IOException {
        while (true) {
            System.out.println("Bitte den Namen eingeben: ");
            Scanner scanner = new Scanner(System.in);
            String spielerName = scanner.nextLine();
            long start = System.nanoTime();

            ziffernfolge = new Ziffernreihe();  // Starte eine neue Ziffernfolge
            ziffernfolge.fuegeNeueZifferHinzu();


            int korrekteLaenge = 0;  // Variable zur Speicherung der korrekt eingegebenen Länge

            while (true) {
                praesentiereZiffernfolge();  // Ziffernfolge anzeigen und sofort ausblenden

                // Überprüfe, ob die Eingabe des Spielers korrekt ist
                if (!empfangene_Ziffernfolge_korrekt()) {
                    System.out.println("Eingabe war falsch. Spiel wird beendet.");
                    break;
                }

                // Wenn die Eingabe korrekt war, aktualisiere die Länge
                korrekteLaenge = ziffernfolge.laenge();

                // Erstelle ein Ergebnisobjekt mit der korrekten Länge
                int spielZeit = (int) ((System.nanoTime() - start) / 1000000000);
                Ergebnis ergebnis = new Ergebnis(spielerName, spielZeit, korrekteLaenge);

                // Speichere das Ergebnis nur, wenn es das längste Ergebnis ist
                if (ergebnisListe.size() == 0 || ergebnis.getLaengeDerReihe() > ergebnisListe.get(0).getLaengeDerReihe()) {
                    ergebnisListe = new Ergebnisliste();
                    ergebnisListe.setze_an_Anfang(ergebnis);
                }

                // Wenn die maximale Länge erreicht ist, Spiel beenden
                if (korrekteLaenge == MAX_ZIFFERN) {
                    System.out.println("Herzlichen Glückwunsch! Sie haben die maximale Ziffernfolge erreicht.");
                    break;
                }

                // Füge die nächste Ziffer zur Ziffernreihe hinzu
                ziffernfolge.fuegeNeueZifferHinzu();
            }

            // Prüfen, ob kein einziges Ergebnis korrekt war
            if (korrekteLaenge == 0) {
                int spielZeit = (int) ((System.nanoTime() - start) / 1000000000);
                Ergebnis ergebnis = new Ergebnis(spielerName, spielZeit, 0);  // Speichere 0 als Länge
                ergebnisListe.setze_an_Anfang(ergebnis);
            }

            // Bestenliste anzeigen nach jedem Durchgang
            ergebnisListe.zeigeErgebnisliste();

            System.out.println("Dr�cken Sie 'a', um das Spiel zu wiederholen, oder eine andere Taste zum Beenden.");
            String eingabe = scanner.nextLine();

            if (!eingabe.equals("a")) {
                // Speicher das Ergebnis vor Beenden des Spiels
                Datenspeicher datenspeicher = new Datenspeicher();
                String dateiName = "ergebnisliste.txt"; // Dateiname als String
                datenspeicher.speichern(ergebnisListe, dateiName);
                System.out.println("Spiel wurde beendet.");
                break;
            }

        }
    }

    // Zeigt die aktuelle Ziffernfolge an
    void praesentiereZiffernfolge() throws InterruptedException {
        loescheBildschirm();
        System.out.print("Folge: ");
        for (int i = 0; i < ziffernfolge.laenge(); i++) {
            System.out.print(ziffernfolge.aktuelle_Ziffer(i) + " "); // Gib jede Ziffer aus
            Thread.sleep(1000);
        }
        System.out.println();
        loescheBildschirm();
    }


    // Überprüft, ob der Spieler die Ziffernfolge korrekt wiederholt hat
    boolean empfangene_Ziffernfolge_korrekt() throws IOException {
        System.out.print("Geben Sie die Ziffernfolge ein (mit Leerzeichen zwischen Ziffern): ");
        String[] eingabe = leser.readLine().split(" ");

        if (eingabe.length != ziffernfolge.laenge()) {
            return false;
        }

        for (int i = 0; i < ziffernfolge.laenge(); i++) {
            int ziffer_ist = Integer.parseInt(eingabe[i]);
            if (ziffer_ist != ziffernfolge.aktuelle_Ziffer(i)) {
                return false;
            }
        }
        return true;
    }

    void beendeSpiel() {
        System.out.println("Ende der Runde");
    }

    private void loescheBildschirm() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        new Spielkonsole();
    }
}



