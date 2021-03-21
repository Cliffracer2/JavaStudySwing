package number06;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (Problem06.isDrawLine == true) {
			// x축 일직선 그리기
			for (int idx = 0; idx < Problem06.imagePanel.getHeight(); idx++) {
				g.drawLine(0, (10 * idx), Problem06.imagePanel.getWidth(), (10 * idx));
			}
			
			// y축 일직선 그리기
			for (int idx = 0; idx < Problem06.imagePanel.getWidth(); idx++) {
				g.drawLine((10 * idx), 0, (10 * idx), Problem06.imagePanel.getHeight());
			}
		}
		else { // 마름모 그리기

			Problem06.xAxis[0] = (getWidth() / 2);
			Problem06.xAxis[1] = 0;
			Problem06.xAxis[2] = (getWidth() / 2);
			Problem06.xAxis[3] = getWidth();
			
			Problem06.yAxis[0] = 0;
			Problem06.yAxis[1] = (getHeight() / 2);
			Problem06.yAxis[2] = getHeight();
			Problem06.yAxis[3] = (getHeight() / 2);
			
			for (int idx = 0; idx < 4; idx++) {
				System.out.printf("x[%d]: %d, y[%d]: %d\n", idx, Problem06.xAxis[idx], idx, Problem06.yAxis[idx]);
			}
			
			for (int idx = 0; idx < 10; idx++) {
				
				Problem06.xAxis[1] = (10 * idx);
				Problem06.xAxis[3] = Problem06.imagePanel.getWidth() - (10 * idx);
				
				Problem06.yAxis[0] = (10 * idx);
				Problem06.yAxis[2] = Problem06.imagePanel.getHeight() - (10 * idx);
				
				g.drawPolygon(Problem06.xAxis, Problem06.yAxis, 4);
			}
		}

	}
}
