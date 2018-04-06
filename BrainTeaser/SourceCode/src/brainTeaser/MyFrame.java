package brainTeaser;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	public MyFrame() {
		super("Gra logiczna - Pijacka czkawka");
			
		JPanel panel = new MyPanel();
		
		panel.setBackground(new Color(210, 180, 140));
		
		instruction();
		getContentPane().add(panel);
		pack();
		setLocation((int)getSize().getWidth()-100, (int)getSize().getHeight()-262);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	public void instruction() {
		final String text = "Za chwilę uruchomi się gra logiczna \"Pijacka czkawka\".\n"  
				+ "Podążaj przez planszę aż do punktu wyjścia znajdującego się po prawej stronie. \n"
				+ "Możesz się poruszać po kolorowych punktach wyłącznie w porządku:\n"
				+ "czerwony, niebieski, czerwony, niebieski, czerwony itd. \n"
				+ "Powodzenia :)";	
		JOptionPane.showMessageDialog(null,
			    text,
			    "Instrukcja gry",
			    JOptionPane.PLAIN_MESSAGE);
		
	}
}


