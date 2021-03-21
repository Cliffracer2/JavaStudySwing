package number06;

//import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem06 extends JFrame {
	
	static ImagePanel imagePanel = new ImagePanel();
	
	static int[] xAxis =  {250, 0, 250, 500};
	static int[] yAxis = {0, 250, 500, 250};
	
	static boolean isDrawLine = true;
	
	public Problem06() {
		if (isDrawLine == true) {
			this.setTitle("p679 problem06 Line");
		}
		else {
			this.setTitle("p679 problem06 Diamond");
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컨텐트 팬을 이미지 패널로 세트
		this.setContentPane(imagePanel);
		
		this.setSize(600, 600);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Problem06();
	}

}
