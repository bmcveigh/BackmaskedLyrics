import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Reverses a string, particularly designed for music lyrics.
 *
 * @author Brian McVeigh
 *
 */

public class Backmask extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea input;
	private JTextArea output;
	private JButton submit;

	public Backmask() 
	{
		setSize(500, 600);
		setBackground(Color.green);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		input = new JTextArea(20, 30);
		input.setEditable(true);
		JScrollPane scrollpane1 = new JScrollPane(input);
		add(scrollpane1);

		output = new JTextArea(20, 30);
		output.setEditable(true);
		JScrollPane scrollpane2 = new JScrollPane(output);
		add(scrollpane2);

		submit = new JButton("Submit");
		add(submit);
		ButtonListener listener = new ButtonListener();
		submit.addActionListener(listener);

	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int choice = JOptionPane.showConfirmDialog(null, "Do you want to reverse each word?");

			String originalText = input.getText();
			String backmaskedString = "";
			
			if (choice == JOptionPane.NO_OPTION){
				
				char[] letters = originalText.toCharArray();
				for (int i = letters.length - 1; i >= 0; i--) {
					backmaskedString += letters[i];
				}
			} else if (choice == JOptionPane.YES_OPTION) {
				String[] words = originalText.split(" ");
				for (int i = 0; i < words.length; i++){
					char[] letters = words[i].toCharArray();
					for (int j = letters.length - 1; j >= 0; j--) {
						backmaskedString += letters[j];
					}
					backmaskedString += " ";
				}
			}
			output.setText(backmaskedString);
		}

	}
}

