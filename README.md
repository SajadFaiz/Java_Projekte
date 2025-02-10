# P1_Ziffernfolge

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

# Ergebnis auf der Konsole

![image](https://github.com/user-attachments/assets/e9f168da-2a3b-4bd9-a3f0-84c20bc7978c)

![image](https://github.com/user-attachments/assets/a0472768-fc39-4e17-a43e-dec03d9f408e)

![image](https://github.com/user-attachments/assets/55d17701-7974-4a84-9550-c805e8e2832a)

# P2_ZiffernfolgeMitGUI

Es handelt sich wieder  um das Spiel Ziffernfolge mit 
folgenden weiteren Elemente:

**(1)** Das Ergebnis eines Spieldurchgangs (Name des Spielers, Zeit, Länge 
der Reihe) wird in einer Ergebnisliste auf der Festplatte gespeichert.  

**(2)** Die Ergebnisliste wird am Ende eines jeden Spieldurchgangs vollständig 
angezeigt (sortiert nach der Länge der Reihe, absteigend). 

**(3)** Ein Spieler kann mehrere Spieldurchgänge hintereinander ohne 
Programmneustart durchführen. 

Im Vergleich zur P1 werden folgende Dinge zusätzlich 
geübt: 

**(1)** Graphische GUI. 

**(2)** Implementierung eines vorgegebenen OO-Entwurfs (UML, 
Klassendiagramm, Zustandsdiagramm). 

**(3)** Dokumentation mit Javadoc. 

**(4)** Testen der Klassen möglichst mit JUnit mindestens in C0-Qualität. 

**(5)** Rollen (Planungs-, Code-, Qualitätsmanager). 

**(6)** Programmieren von Zustandsautomaten (Zustand-Entwurfsmuster). 

**(7)** Verwenden des Iterator-Entwurfsmusters. 

**(8)** Implementieren von einigen Standard-Algorithmen (Sortierung, 
Verschlüsselung, Zufallszahlen, Komprimierungen). 

# Ergebnis auf der Konsole

![image](https://github.com/user-attachments/assets/f7b89f12-0386-4710-9be8-9659958ad045)

![image](https://github.com/user-attachments/assets/477ccc45-3836-4929-87f6-75e0fbf4776d)


# Ergebnisse Sortiert

![image](https://github.com/user-attachments/assets/247530c3-7ab5-46c3-9428-4acf86e115b2)

