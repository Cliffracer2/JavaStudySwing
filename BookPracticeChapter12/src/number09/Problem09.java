package number09;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem09 extends JFrame {
	
	static BlueLabel blueLabel = null;
	static BlueLabel2 blueLabel2 = null;
	//static BlueLabel blueLabel = new BlueLabel();
	
	static boolean changeFlag = true;
	
	public Problem09() {
		this.setTitle("p680 problem09");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = this.getContentPane();
		container.setLayout(new FlowLayout());
		
		changeFlag = true;
		blueLabel = new BlueLabel("Smile any smilers?? :)");
		// 임의로 변경하기
		blueLabel.setBackground(Color.RED);
		blueLabel.setForeground(Color.YELLOW);
		container.add(blueLabel);
		
		changeFlag = false;
		blueLabel2 = new BlueLabel2("Big SMILE :)");
		blueLabel2.setOpaque(true);
		blueLabel2.setFont(new Font("Arial", Font.ITALIC , 50));
		// 임의로 변경하기
		blueLabel2.setBackground(Color.RED);
		blueLabel2.setForeground(Color.MAGENTA);
		container.add(blueLabel2);

		this.setSize(600, 600);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Problem09();
	}

}
