package number10;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem10 extends JFrame {
	
	static ImagePanel imagePanel = new ImagePanel();
	static ImageIcon backgroundImageIcon = new ImageIcon("images/pepewithjoker.gif");
	static Image backgroundImage = backgroundImageIcon.getImage();
	
	public Problem10() {
		this.setTitle("p681 problem10");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = this.getContentPane();
		container.add(imagePanel);
		
		System.out.printf("size %d x %d\n", backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight());
		// 크기는 이미지 크기에 맞춘다.
		this.setSize(backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight());
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Problem10();
	}

}
