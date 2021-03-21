package number08;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem08 extends JFrame {
	
	static DrawPanel drawPanel = new DrawPanel();
	
	static boolean isFirstRelease = true;
	
	public Problem08() {
		this.setTitle("p680 problem08");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = this.getContentPane();
		MyMouseListener mouseListener = new MyMouseListener();
		container.add(drawPanel);
		container.addMouseListener(mouseListener);
		
		this.setSize(800, 800);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Problem08();
	}

}
