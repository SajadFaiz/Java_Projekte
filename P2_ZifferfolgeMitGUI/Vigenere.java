package ziffernfolge;
/** abstrakter Datentyp: Verschl�sseler (und Entschl�sseler) f�r beliebige Zeichenketten. 
   */
public class Vigenere implements Kryptomethode{ 
	
  private char[] key = ("12345abcde").toCharArray();	
	
	
  // Konstruktor f�r Implementierungen:
  /** Ein Verschl�sseler und ein Entschl�sseler werden bereitgestellt. */ 
  //public VIGENERE() {
	  
  //}
	
  // Konstruktor f�r Implementierungen:
  /** Ein Verschl�sseler und ein Entschl�sseler werden mit zugeh�rigem
      Schl�sselwort bereitgestellt. 
      @param schluesselwort: eine beliebige Zeichenkette */ 
  public Vigenere(String schluesselwort) {
	  this.Schluessel(schluesselwort);
  }

  /** Der Schluessel fuer das Ver- und Entschluesseln wird bereitgestellt.
      @param wert Wert des Schluessels: eine beliebige Zeichenkette.*/
  public void Schluessel(String wert) {
	  if (wert!="") {
		  key = wert.toCharArray();
	  }
	  System.out.println("Cryptkey = "+wert);
  }
  
  /** Der Text wird verschluesselt. Wenn kein Schluessel bereitgestellt ist, 
      oder f�r den Text ein Null-Zeiger uebergeben wird, wird nicht 
      verschluesselt. Der verschl�sselte Text wird im Parameter text zur 
      Verf�gung gestellt.
      @param text der zu verschluesselnde Text.*/
  public void verschluesseln(StringBuffer text) {
	  if (text != null) {
		  //System.out.println("Verschluesselung start ...");
		  for (int i = 0; i < text.length(); i++) {
			int offset = (text.toString().charAt(i) + key[i % key.length]) % 128;
			text.replace(i, i+1, String.valueOf((char) offset));
		  }
	  }		
  }

  /** Der Text wird entschluesselt. Wenn kein Schluessel bereitgestellt ist, 
      oder f�r den Text ein Null-Zeiger uebergeben wird, wird nicht 
      entschluesselt. Der entschl�sselte Text wird im Parameter text zur 
      Verf�gung gestellt.
      @param text der zu entschluesselnde Text.*/
  public void entschluesseln(StringBuffer text){
	  if (text!= null) {
		  //System.out.println("Entschluesselung start ...");
		  for (int i = 0; i < text.length(); i++) {
				int offset = (text.toString().charAt(i) + (key[i % key.length] * -1) +128) % 128;
				text.replace(i, i+1, String.valueOf((char) offset));
		  }
	  }
  }
}