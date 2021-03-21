package number02;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem02 extends JFrame {
	
	static ImagePanel imagePanel = new ImagePanel();
	//static DrawPanel drawPanel = new DrawPanel();
	static ImageIcon backgroundImageIcon = new ImageIcon("images/Hmm.gif");
	static Image backgroundImage = backgroundImageIcon.getImage();
	
	public Problem02() {
		
		this.setTitle("p677 problem02");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.setContentPane(imagePanel);
		Container container = this.getContentPane();
		container.add(imagePanel);
		//container.add(drawPanel);
		MyMouseListener mouseListner = new MyMouseListener();
		container.addMouseListener(mouseListner);
		container.addMouseMotionListener(mouseListner);

		System.out.printf("size %d x %d\n", backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight());
		// 크기는 이미지 크기에 맞춘다.
		this.setSize(backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight());
		this.setVisible(true);
	}
		
	public static void main(String[] args) {
		new Problem02();
	}
}
