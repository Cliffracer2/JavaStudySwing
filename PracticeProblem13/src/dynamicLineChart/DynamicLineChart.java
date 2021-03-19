package dynamicLineChart;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class DynamicLineChart extends JFrame {
	
	static final int DEFAULT_HEIGHT = 20;
	static final int H_GAP = 100;
	
	private MyPanel panel = new MyPanel();
	
	static int[] salesAccount = new int[4];
	
	public DynamicLineChart() {
		this.setTitle("분기별 매출");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(panel);
		
		this.setSize(900, 800);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// y축 선
			g.setColor(Color.BLACK);
			g.drawLine(H_GAP, 600, 100, 20);
			// x축 선
			g.setColor(Color.BLACK);
			g.drawLine(H_GAP, 600, 700, 600);
			
			// y축 텍스트
			g.drawString("y축", 70, 20);
			for (int idx = 0; idx < 5; idx++) {
				if (idx == 0) {
					g.drawString("0억", 70, 600);
				}
				else {
					g.drawString((idx + "00억"), 55, (600 - (H_GAP * idx)));
				}
			}
			
			// x축 텍스트
			g.drawString("x축", 700, 620);
			for (int idx = 1; idx <= 4; idx++) {
				g.drawString((idx + "/4분기"), (90 + (H_GAP * idx)), 620);
			}
			
			// 그래프 그리기
			int basicYAxis = 600;
			int tempSalesAccount = 0;
			// 각 분기별 점선으로된 구분선 그리기 설정
			Graphics2D g2=(Graphics2D)g;
			float[] dash = {3, 1f};
			
			// 실선
			for (int idx = 0; idx < 4; idx++) {
				g.setColor(Color.RED);
				
				if (idx > 0) {
					tempSalesAccount = salesAccount[idx] - salesAccount[idx - 1];
				}
				else {
					tempSalesAccount = salesAccount[idx];
				}
				//System.out.printf("subSalesAccount %d, basicYAxis %d, salesAccount[%d] %d\n", tempSalesAccount, basicYAxis, idx, salesAccount[idx]);
				//System.out.printf("100, %d, %d, %d\n", basicYAxis, (100 + H_GAP * (idx + 1)), (basicYAxis - tempSalesAccount));
				g.drawLine((100 + (H_GAP * idx)), basicYAxis, (100 + H_GAP * (idx + 1)), (basicYAxis - tempSalesAccount));
				basicYAxis = basicYAxis - tempSalesAccount;
			}
			
			// 점선
			basicYAxis = 600;
			for (int idx = 0; idx < 4; idx++) {
				
				if (idx > 0) {
					tempSalesAccount = salesAccount[idx] - salesAccount[idx - 1];
				}
				else {
					tempSalesAccount = salesAccount[idx];
				}
				
				// 점선으로 분기별 구분 선 그리기
				g2.setColor(Color.BLUE);
				g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, dash, 0));
				g2.drawLine((100 + (H_GAP * (idx + 1))), 600, (100 + (H_GAP * (idx + 1))), (basicYAxis - tempSalesAccount));
				g.drawString((salesAccount[idx] + "억"), (80 + (H_GAP * (idx + 1))), (basicYAxis - tempSalesAccount) - 30);
				basicYAxis = basicYAxis - tempSalesAccount;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		salesAccount[0] = 200;
		salesAccount[1] = 150;
		salesAccount[2] = 220;
		salesAccount[3] = 300;
		
		new DynamicLineChart();
	}

}
