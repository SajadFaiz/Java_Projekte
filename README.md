# ZiffernfolgeSpiel

Dieses Java-Programm ist ein einfaches Konsolenspiel, bei dem die Spieler sich eine zufällig generierte Ziffernfolge merken und korrekt wiederholen müssen. Ziel des Spiels ist es, die längste mögliche Ziffernfolge fehlerfrei einzugeben. Das Programm speichert die besten Ergebnisse in einer Datei und zeigt eine Bestenliste an.

# Funktionen

**Zufällige Ziffernfolgen:** Das Spiel generiert zufällige Ziffernfolgen, die sich der Spieler merken muss.

**Ergebnisverwaltung:** Ergebnisse werden gespeichert, geladen und angezeigt.

**Bestenliste:** Die besten Ergebnisse werden automatisch gespeichert und nach jeder Runde angezeigt.

**Fehlerbehandlung:** Robuste Fehlerprüfung für Dateizugriffe und Benutzereingaben.

# Dateistruktur

**Datenspeicher.java:** Verantwortlich für das Speichern und Laden der Ergebnisse.

**Ergebnis.java:** Enthält die Struktur für ein Spielergebnis.

**Ergebnisliste.java:** Verwaltung und Anzeige der Ergebnisliste.

**Spielkonsole.java:** Die Hauptklasse, die das Spiel steuert.

**Ziffernreihe.java:** Implementiert die Logik für die zufällige Ziffernfolge.

# Spielanleitung

**Spielstart:** Nach dem Start wirst du aufgefordert, deinen Namen einzugeben.

**Ziffernfolge merken:** Eine Ziffernfolge wird angezeigt und nach kurzer Zeit ausgeblendet.

**Wiedereingabe:** Gib die Ziffernfolge korrekt ein, um das Spiel fortzusetzen.

**Fehler:** Bei einem Fehler wird das Spiel beendet und dein Ergebnis gespeichert.

**Bestenliste:** Nach jeder Runde wird die Bestenliste angezeigt.

**Spiel wiederholen:** Drücke 'a', um das Spiel zu wiederholen, oder eine andere Taste, um zu beenden.

# Dateispeicherung

Die Ergebnisse werden in der Datei ergebnisliste.txt im selben Verzeichnis gespeichert. Die Datei wird bei jedem Beenden des Spiels automatisch aktualisiert.
