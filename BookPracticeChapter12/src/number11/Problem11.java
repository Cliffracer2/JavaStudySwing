package number11;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem11 extends JFrame {
	
	public static int [] storeValue = new int[4];
	public static int [] angleValue = new int[4];
	
	public static Color [] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE};
	public static String [] fruitName = {"Apple", "Cherry", "Strawberry", "Prune"};
	
	public static JTextField [] tfFruit = new JTextField [4];
	public static ChartPanel chartPanel = new ChartPanel();
	
	public Problem11() {
		this.setTitle("P681 problem11");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		container.add(new InputTextPanel(), BorderLayout.NORTH);
		container.add(chartPanel, BorderLayout.CENTER);
		
		this.setSize(600, 500);
		this.setVisible(true);
	}
	
	// 파이 차트에 그리기 위한 각도 값을 계산하는 메소드
	public static void calculateAngle() {
		
		int sumOfValue = 0;
		int sumOfAngle = 0;
		
		for (int idx = 0; idx < storeValue.length; idx++) {
			storeValue[idx] = Integer.parseInt(tfFruit[idx].getText());
			sumOfValue += storeValue[idx];			
		}
		
		// 텍스트 필드에서 받은 값이 존재할 경우에 각도를 계산한다. 존재하지 않으면 계산하지 않는다.
		if (sumOfValue != 0) {
			for(int idx = 0; idx < storeValue.length; idx++) {
				angleValue[idx] = (int)(((float)storeValue[idx] / (float)sumOfValue) * 360);
				if (idx == (storeValue.length - 1)) {
					// 마지막 각도는 360도에 이전 값들을 더한 각도를 뺀 나머지 값을 넣는다.
					angleValue[idx] = 360 - sumOfAngle;
				}
				else {
					sumOfAngle += angleValue[idx];
				}
			}
		}
	}

	public static void main(String [] args) {
		new Problem11();
		
		calculateAngle();
		chartPanel.repaint();
	}
} 
