package number09;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class BlueLabel extends JLabel {

	public BlueLabel(String text) {
		super(text);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		System.out.printf("1 enter here\n");
		
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.BOLD , 11));
		
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		super.paintComponent(g);
	}
}
