package number02;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class ImagePanel extends JPanel {
	
	static int getXAxis = 0;
	static int getYAxis = 0;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
			
		g.drawImage(Problem02.backgroundImage, 0, 0, this);
		g.setColor(Color.BLUE);
		g.fillArc(getXAxis, getYAxis, 20, 20, 0, 360);
	}
}
