package number05;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(Problem05.image, 0, 0, this);
	}
}
