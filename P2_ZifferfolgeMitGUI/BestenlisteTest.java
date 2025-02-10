package ziffernfolge;

/*Test der Bestenliste.
 *An der Vorgabe der Benutzeroberfl�che Lasse wird eine Oberfl�che erstellt.
 *Nach dem die Oberfl�che erstellt wurde, startet die Methode Test_Methode.
 *Die Klassen Ergebnis, Ergebnisliste und Steuerung enthalten Testimplementierungen.
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BestenlisteTest extends JFrame {

	private JPanel contentPane;

	private Bestenliste bestenliste = new Bestenliste();
	private Steuerung steuerung = new Steuerung(null, bestenliste);
	
	public void Test_Methoden() {
		bestenliste.sichtbar(true);
		bestenliste.neues_Ergebnis(10, 12.01);
		bestenliste.aktiviere_Namenseingabe();

	}

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BestenlisteTest frame = new BestenlisteTest();
					frame.setVisible(true);
					frame.steuerung.Spiel_gestartet();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BestenlisteTest() {
		setTitle("Ziffernfolge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 210, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Bestenliste");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bestenliste.Name_eingegeben();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBounds(42, 232, 90, 23);
		bestenliste.setBounds(10, 10, 170, 300);
		contentPane.add(bestenliste);
		bestenliste.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Neues Spiel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bestenliste.neues_Spiel();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.setBounds(42, 266, 90, 23);
		bestenliste.add(btnNewButton_1);

	}
}
