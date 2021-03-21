package number03;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem03 extends JFrame {
	
	static ImageIcon imageIcon = new ImageIcon("images/Buung.png");
	
	static JLabel imageLabel = new JLabel();
	
	public Problem03() {
		
		this.setTitle("p677 Problem03");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = this.getContentPane();
		// null로 배치 관리자가 없을경우 컴포넌트 위치 크기를 정해줘야 윈도우 창에 표시가 된다.
		container.setLayout(null);
		
		imageLabel.setIcon(imageIcon);
		imageLabel.setLocation(0, 0);
		imageLabel.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
		
		MyMouseListener mouseListener = new MyMouseListener();
		
		container.add(imageLabel);
		container.addMouseListener(mouseListener);
		container.addMouseMotionListener(mouseListener);
		
		this.setSize(800, 800);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Problem03();
	}

}
