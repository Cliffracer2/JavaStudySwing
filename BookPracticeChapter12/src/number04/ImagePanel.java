package number04;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
	
	static int getXAxis = 0;
	static int getYAxis = 0;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(Problem04.image, getXAxis, getYAxis, this);
	}
	

}
