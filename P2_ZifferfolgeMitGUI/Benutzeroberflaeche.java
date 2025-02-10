package ziffernfolge;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Benutzeroberflaeche extends JFrame
{

  private JPanel contentPane;
  private Spielkonsole spielkonsole=new Spielkonsole();
  private Bestenliste bestenliste = new Bestenliste(); 
  private Steuerung steuerung = new Steuerung(spielkonsole, bestenliste);
  
  
  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          Benutzeroberflaeche frame = new Benutzeroberflaeche();
          frame.setVisible(true);
          frame.steuerung.Spiel_gestartet();
        } catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public Benutzeroberflaeche()
  {
    setTitle("Ziffernfolge");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,350,448);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    spielkonsole.setBounds(10, 10, 170, 170);
    contentPane.add(spielkonsole);
    
    
    JButton btnBestenliste = new JButton("Bestenliste");
    btnBestenliste.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		bestenliste.Name_eingegeben();
    		//bestenliste.sichtbar(true);
    	}
    });
    btnBestenliste.setBounds(178, 357, 117, 29);
    bestenliste.setBounds(10, 10, 334, 410);
    contentPane.add(bestenliste);
    bestenliste.add(btnBestenliste);

    
    JButton btnNeuesSpiel = new JButton("Neues Spiel");
    btnNeuesSpiel.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		bestenliste.neues_Spiel();
    	}
    });
    btnNeuesSpiel.setBounds(23, 357, 117, 29);
    bestenliste.add(btnNeuesSpiel);
    
    
    spielkonsole.melde_an(steuerung);
    bestenliste.melde_an(steuerung);
  
  }
  
}
