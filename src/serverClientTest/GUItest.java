package serverClientTest;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUItest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -337835093808669329L;
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	JLabel label = new JLabel("Testar bara");
	
	GUItest(){
		
		List<JButton> buttons = buttonsList();
		setLayout(new GridLayout());
		panelUp.add(label);
		add(panelUp);
		panelDown.setLayout(new GridLayout(2, 1));
		for (JButton b : buttons) {
			panelDown.add(b);
		}
		add(panelDown);
		setLocation(700, 300);
		setSize(700, 400);
		setVisible(true);
		
	}
	
	private List<JButton> buttonsList() {
		
		List<JButton> buttons = new ArrayList<>();
		
		buttons.add(new JButton("Tryck här"));
		buttons.add(new JButton("Tryck här"));
		buttons.add(new JButton("Tryck här"));
		buttons.add(new JButton("Tryck här"));
		
		return buttons;
	}
}
