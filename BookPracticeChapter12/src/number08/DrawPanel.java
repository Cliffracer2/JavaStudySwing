package number08;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
	
	static ArrayList<Integer> xAxisStart = new ArrayList<Integer>();
	static ArrayList<Integer> yAxisStart = new ArrayList<Integer>();
	static ArrayList<Integer> xAxisEnd = new ArrayList<Integer>();
	static ArrayList<Integer> yAxisEnd = new ArrayList<Integer>();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int[] drawXAxis = new int[xAxisStart.size()];
		int[] drawYAxis = new int[yAxisStart.size()];
		int[] drawWidth = new int[xAxisEnd.size()];
		int[] drawHeight = new int[yAxisEnd.size()];
		
		System.out.printf("\nsize %d\n", xAxisStart.size());
		
		for (int idx = 0; idx < xAxisStart.size(); idx++) {
			drawXAxis[idx] = xAxisStart.get(idx);
			drawYAxis[idx] = yAxisStart.get(idx);
			
			drawWidth[idx] = xAxisEnd.get(idx);
			drawHeight[idx] = xAxisEnd.get(idx);
			
			// ũ���� ���� ���� ���ϱ� ���� �׻� ����� ���� ������� �ڵ�
			// ��, ���� ���� Ÿ���� �ƴ� ������� ����� ���� ���� ���� �ִ´�.
			if (drawXAxis[idx] > drawWidth[idx]) {
				drawWidth[idx] = drawXAxis[idx] - drawWidth[idx];
				drawHeight[idx] = drawWidth[idx];
			}
			else {
				drawWidth[idx] = drawWidth[idx] - drawXAxis[idx];
				drawHeight[idx] = drawWidth[idx];
			}
			
			System.out.printf("x: %d, y: %d\n", drawXAxis[idx], drawYAxis[idx]);
			System.out.printf("w: %d, h: %d\n", drawWidth[idx], drawHeight[idx]);
			g.setColor(Color.MAGENTA);
			g.drawOval(drawXAxis[idx], drawYAxis[idx], drawWidth[idx], drawHeight[idx]);
		}
	}

}
