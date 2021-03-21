package number09;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BlueLabel2 extends JLabel {

	public BlueLabel2(String text) {
		super(text);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		System.out.printf("2 enter here\n");
		
		super.setBackground(Color.BLUE);
		return;
	}
}