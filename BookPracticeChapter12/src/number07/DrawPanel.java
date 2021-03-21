package number07;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
	
	static ArrayList<Integer> xAxis = new ArrayList<Integer>();
	static ArrayList<Integer> yAxis = new ArrayList<Integer>();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int[] drawXAxis = new int[xAxis.size()];
		int[] drawYAxis = new int[yAxis.size()];
		
		System.out.printf("\nsize %d\n", xAxis.size());
		
		for (int idx = 0; idx < xAxis.size(); idx++) {
			drawXAxis[idx] = xAxis.get(idx);
			drawYAxis[idx] = yAxis.get(idx);
			System.out.printf("2 x: %d, y: %d\n", drawXAxis[idx], drawYAxis[idx]);
		}
		
		g.drawPolygon(drawXAxis, drawYAxis, xAxis.size());
	}

}
