package number07;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem07 extends JFrame {
	
	static DrawPanel drawPanel = new DrawPanel();
	
	public Problem07() {
		this.setTitle("p679 problem07");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		MyMouseListener mouseListener = new MyMouseListener();
		
		container.add(drawPanel);
		container.addMouseListener(mouseListener);
		
		this.setSize(600, 600);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Problem07();
	}

}
