package number05;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem05 extends JFrame {
	
	static ImagePanel imagePanel = new ImagePanel();
	
	static ImageIcon imageIcon = new ImageIcon("images/SignalOwl.gif");
	
	static Image image = imageIcon.getImage();
	
	public Problem05() {
		this.setTitle("p678 problem05");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = this.getContentPane();
		//container.setLayout(null);
		
		MyKeyListener keyListener = new MyKeyListener();
		
		container.add(imagePanel);
		container.addKeyListener(keyListener);
		container.setFocusable(true);
		container.requestFocus();
		
		this.setSize(800, 800);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Problem05();
	}

}
