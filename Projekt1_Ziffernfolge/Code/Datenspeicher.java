package spiel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Diese Klasse ist fuer das Speichern und Laden von Ergebnislisten zustandig.
 * Sie behandelt verschiedene Fehlerfalle wie ungultige Eingaben oder fehlerhafte Dateien.
 * Ziel ist es, robuste Methoden bereitzustellen, die sowohl im Normalfall als auch bei Ausnahmen zuverlassig arbeiten.
 */
public class Datenspeicher {

    /**
     * Speichert die Ergebnisse aus der Ergebnisliste in einer Datei.
     * Verwendet das Semikolon als Trennzeichen und stellt sicher, dass Semikolons in den Namen korrekt behandelt werden.
     *
     * @param ergebnisListe Die Liste mit den Ergebnissen, die gespeichert werden soll.
     * @param dateiName Der Name der Datei, in die gespeichert werden soll.
     * @throws IllegalArgumentException Wenn der Dateiname null oder leer ist.
     * @throws RuntimeException Wenn ein Fehler beim Schreiben auftritt (z. B. keine Schreibrechte).
     */
    public void speichern(Ergebnisliste ergebnisListe, String dateiName) {
        if (dateiName == null || dateiName.isEmpty()) {
            throw new IllegalArgumentException("Dateiname darf nicht null oder leer sein.");
        }

        try (FileWriter fw = new FileWriter(dateiName, false)) {
            for (int i = ergebnisListe.size() - 1; i >= 0; i--) {
                Ergebnis ergebnis = ergebnisListe.get(i);
                // Ersetze Semikolons in den Namen durch ein alternatives Trennzeichen
                String spielerName = ergebnis.getName().replace(";", "|;");
                fw.write(spielerName + ";" + ergebnis.getSpielZeit() + ";" + ergebnis.getLaengeDerReihe() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Speichern der Ergebnisliste: " + e.getMessage(), e);
        }
    }

    /**
     * L�dt die Ergebnisse aus einer Datei und gibt sie als Ergebnisliste zuruck.
     * 
     * @param dateiName Der Name der Datei, aus der geladen werden soll.
     * @return Eine Ergebnisliste mit den geladenen Ergebnissen.
     * @throws IllegalArgumentException Wenn der Dateiname null oder leer ist.
     * @throws RuntimeException Wenn ein Fehler beim Lesen der Datei auftritt
     * oder die Daten in der Datei nicht korrekt formatiert sind.
     */
    public Ergebnisliste laden(String dateiName) {
        if (dateiName == null || dateiName.isEmpty()) {
            throw new IllegalArgumentException("Dateiname darf nicht null oder leer sein.");
        }

        Ergebnisliste ergebnisListe = new Ergebnisliste();
        try (BufferedReader br = new BufferedReader(new FileReader(dateiName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Ung�ltiges Datenformat: " + line);
                }

                // R�ckverwandlung des Namens
                String spielerName = parts[0].replace("|;", ";");
                long spielZeit = Long.parseLong(parts[1]);
                int laengeDerReihe = Integer.parseInt(parts[2]);
                
                Ergebnis ergebnis = new Ergebnis(spielerName, spielZeit, laengeDerReihe);
                ergebnisListe.add(ergebnis);
            }
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Laden der Ergebnisliste: " + e.getMessage(), e);
        }
        return ergebnisListe;
    }
}

