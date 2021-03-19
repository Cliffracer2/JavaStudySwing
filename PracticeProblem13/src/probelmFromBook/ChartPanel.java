package probelmFromBook;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChartPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int startAngle = 0;
		
		for (int idx = 0; idx < PIChartEx11.storeValue.length; idx++) {
			g.setColor(PIChartEx11.color[idx]);
			// 텍스트 표시 위치 조정
			if (idx <= 2) {
				g.drawString((PIChartEx11.fruitName[idx] + " " + (PIChartEx11.angleValue[idx] * 100 / 360) + "%"), 90 + (idx * 95), 20);
			}
			else {
				g.drawString((PIChartEx11.fruitName[idx] + " " + (PIChartEx11.angleValue[idx] * 100 / 360) + "%"), 105 + (idx * 100), 20);
			}
		}
		
		for (int idx = 0; idx < PIChartEx11.storeValue.length; idx++) {
			g.setColor(PIChartEx11.color[idx]);
			g.fillArc(130, 70, 300, 300, startAngle, PIChartEx11.angleValue[idx]);
			startAngle = startAngle + PIChartEx11.angleValue[idx];
		}
	}	
}
