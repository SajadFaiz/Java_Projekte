package ziffernfolge;

import java.io.*;

public class Datenspeicher {
	
	private String cryptKey = "abcde12345";
	private String line = null;
	private int noOfLines = 0;
	
	
	private String getfile() {
		
		File filename = new File("Ergebnisliste.txt");
		try {
			if (filename.createNewFile() == true) {
				
				BufferedWriter writer = null;
				writer = new BufferedWriter(new FileWriter(filename.getPath(), true));
				writer.close();
				}
			else {
				try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
					while (reader.readLine() != null) {
			            noOfLines++;
			        }		
				}
			}
		} 
		catch (Exception e) {
			System.out.println("Problem beim Erstellen der Datei Ergebnisliste!!");
			}
		return filename.getPath();
	}
	
	public Liste lade()  {
		try {
			FileReader readfile = new FileReader(getfile());
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(readfile);
			Liste liste = new VerketteteListe();
			StringBuffer buffer = new StringBuffer();
			Kryptomethode decrypt = new Vigenere(cryptKey);
			Komprimierung compTest = new RunLength();
			
			if (noOfLines == 0) {
				System.out.println("Datei Ergebnisliste.txt ist leer!");
				}
			else {
				System.out.println("Datei Ergebnisliste.txt ist nicht leer!");
				Ergebnis[] ergebnis = new Ergebnis[noOfLines];
				int cnt = 0;
				while((line = bufferedReader.readLine()) != null) {
					buffer = new StringBuffer();
					buffer.append(line);
					decrypt.entschluesseln(buffer);
					line = compTest.expandieren(buffer.toString());
					if (line.contains("|")) {
						String[] lineSplit = line.split("\\|",3);
						ergebnis[cnt] = new Ergebnis();
						ergebnis[cnt].laengeReihe = Integer.parseInt(lineSplit[0]);
						ergebnis[cnt].spielZeit = Long.parseLong(lineSplit[1]);
						ergebnis[cnt].spielerName = lineSplit[2];
						liste.setze_an_Ende(ergebnis[cnt]);
					}
					else {
					    throw new IllegalArgumentException("Trenner | in Zeile: " + line + " existiert nicht!!");
					}
					cnt++;
				}
			}
			bufferedReader.close();
			return liste;
		}
		catch (FileNotFoundException e) {
			System.out.println("Datei Ergebnisliste.txt nicht gefunden!!");
			return null;
			}
		catch (IOException e) {
			System.out.println("Datei Ergebnisliste.txt hat ein Problem!!");
			return null;
			}
	}
	
	public void speichere(Liste liste)  {
		
		Liste.Iterator iterator = liste.erzeuge_Iterator();
		String ergebnisString = "";		
		Ergebnis line = new Ergebnis();
		Komprimierung compTest = new RunLength();
		Kryptomethode encrypt = new Vigenere(cryptKey);
		
		StringBuffer buffer;
		BufferedWriter writer = null;
		
		try {
			File writefile = new File ("Ergebnisliste.txt");
			writefile.delete();
			writer = new BufferedWriter(new FileWriter(getfile(), true));
			for (; iterator.nach_ende() != true;) {
				line = (Ergebnis) iterator.element();
				ergebnisString =  line.laengeReihe + "|" + line.spielZeit + "|" + line.spielerName;				
				ergebnisString = compTest.komprimieren(ergebnisString);				
				buffer = new StringBuffer(ergebnisString);		
				
				encrypt.verschluesseln(buffer);				
				writer.write(buffer.toString());
							
				writer.newLine();
				writer.flush();
				iterator.weiter();				
			}
			writer.close();
		}catch (IOException e) {
			System.out.println("Problem beim Schreiben der Datei Ergebnisliste.txt");
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				System.out.println("Problem beim Schliessen der Datei Ergebnisliste.txt");
			}
		}
		
	}
	
}



