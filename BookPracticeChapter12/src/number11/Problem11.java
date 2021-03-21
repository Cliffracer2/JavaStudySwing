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
	
	// ���� ��Ʈ�� �׸��� ���� ���� ���� ����ϴ� �޼ҵ�
	public static void calculateAngle() {
		
		int sumOfValue = 0;
		int sumOfAngle = 0;
		
		for (int idx = 0; idx < storeValue.length; idx++) {
			storeValue[idx] = Integer.parseInt(tfFruit[idx].getText());
			sumOfValue += storeValue[idx];			
		}
		
		// �ؽ�Ʈ �ʵ忡�� ���� ���� ������ ��쿡 ������ ����Ѵ�. �������� ������ ������� �ʴ´�.
		if (sumOfValue != 0) {
			for(int idx = 0; idx < storeValue.length; idx++) {
				angleValue[idx] = (int)(((float)storeValue[idx] / (float)sumOfValue) * 360);
				if (idx == (storeValue.length - 1)) {
					// ������ ������ 360���� ���� ������ ���� ������ �� ������ ���� �ִ´�.
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
