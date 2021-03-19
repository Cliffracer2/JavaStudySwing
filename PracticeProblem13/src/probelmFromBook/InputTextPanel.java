package probelmFromBook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class InputTextPanel extends JPanel {
	public InputTextPanel() {
		this.setBackground(Color.GRAY);
		
		for (int idx = 0; idx < PIChartEx11.tfFruit.length; idx++) {
			PIChartEx11.tfFruit[idx] = new JTextField("0", 5);
			PIChartEx11.tfFruit[idx].addActionListener(new MyActionListener());
			add(new JLabel(PIChartEx11.fruitName[idx]));
			add(PIChartEx11.tfFruit[idx]);
		}
	}
	
	private class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) { // <Enter> Å° Ã³¸®
			JTextField textField = (JTextField)e.getSource();
			try {
				Integer.parseInt(textField.getText());
			}
			catch(NumberFormatException ex) {
				textField.setText("0");
				return;
			}
			PIChartEx11.calculateAngle();
			PIChartEx11.chartPanel.repaint();
		}
	}
}
