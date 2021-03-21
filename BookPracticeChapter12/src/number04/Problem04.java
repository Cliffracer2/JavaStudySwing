package number04;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem04 extends JFrame {
	
	static ImagePanel imagePanel = new ImagePanel();
	
	static ImageIcon imageIcon = new ImageIcon("images/Buung.png");
	
	//static JLabel imageLabel = new JLabel();
	
	static Image image = imageIcon.getImage();
	
	static int getImageWidth = 0;
	static int getImageHeight = 0;

	public Problem04() {
		
		this.setTitle("p678 Problem04");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = this.getContentPane();
		//imageLabel.setIcon(imageIcon);
		
		MyMouseListener mouseListener = new MyMouseListener();
		
		container.add(imagePanel);
		container.addMouseListener(mouseListener);
		container.addMouseMotionListener(mouseListener);
		
		this.setSize(800, 800);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Problem04();
	}

}
