package ziffernfolge;

import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.text.BadLocationException;

/**BestenlisteZeile fuer das Spiel "Ziffernfolge". 
 * Es besteht aus einem Textfeld, wobei die Position variable ist.
 */
@SuppressWarnings("serial")
public class BestenlisteZeile extends JPanel{
	
	private int platz=0;
	JTextField textfield;
	
	/**Erzeugt eine BestenlisteZeile.
	 * Das Text-Feld f�r die Ergebnisausgabe wird eingestellt.
	 * Die Position wird �ber den Konstrukter bei der Erstellung angegeben.
	 *  
	 * @param pane Die Bestenliste wird dem Text-Feld bekannt gemacht
	 * @param position Die Position des Feldes auf der Benutzeroberfl�che von 0 - 9.
	 */
	public BestenlisteZeile(JTextField pane, int position) {
		textfield=pane;
		textfield.setEditable(false);
		textfield.setBounds(1, (position*23)+1, 300, 23);
		platz=position+1;
	}
	
	/**Zeigt das ausgewaehlte Ergebnis in einer Zeile auf der Benutzeroberflaeche an. 
	 * @param ergebnis das ausgewaehlte Ergebnis
	 * @throws BadLocationException 
	 */
	public void zeige_an(Ergebnis ergebnis)  {		
		String zeile_in = platz +". "+ ""+ergebnis.spielerName +" Fl: " +
        		ergebnis.laengeReihe +" Sz:"+ergebnis.spielZeit+"\n";        
        textfield.setText(zeile_in); 
	}
}
