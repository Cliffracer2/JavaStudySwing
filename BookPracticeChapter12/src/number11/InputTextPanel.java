package number11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class InputTextPanel extends JPanel {
	public InputTextPanel() {
		this.setBackground(Color.GRAY);
		
		for (int idx = 0; idx < Problem11.tfFruit.length; idx++) {
			Problem11.tfFruit[idx] = new JTextField("0", 5);
			Problem11.tfFruit[idx].addActionListener(new MyActionListener());
			add(new JLabel(Problem11.fruitName[idx]));
			add(Problem11.tfFruit[idx]);
		}
	}
	
	private class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField textField = (JTextField)e.getSource();
			try {
				Integer.parseInt(textField.getText());
			}
			catch(NumberFormatException ex) {
				textField.setText("0");
				return;
			}
			Problem11.calculateAngle();
			Problem11.chartPanel.repaint();
		}
	}
}
