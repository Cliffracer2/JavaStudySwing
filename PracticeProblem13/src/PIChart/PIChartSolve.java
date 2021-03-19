package PIChart;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PIChartSolve extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	static int[] salesAccount = new int[4];
	static final int BASIC_CIRCLE_RADIUS = 550;
	
	// 매출 비율 계산하여 각 매출 비율값을 리턴한다.
	public float[] calculateRate() {
		int sumOfSales = 0;
		float[] rateValue = new float[salesAccount.length];
		
		for (int idx = 0; idx < salesAccount.length; idx++) {
			sumOfSales += salesAccount[idx];
		}
		
		for (int idx = 0; idx < salesAccount.length; idx++) {
			rateValue[idx] = (float)salesAccount[idx] / sumOfSales;
			System.out.printf("rateValue %f\n", rateValue[idx]);
		}
		
		return rateValue;
	}
	
	// 비율값을 바탕으로 각도 계산
	public int[] calculateAngle(float[] rateValue) {
		int[] eachRateStore = new int[salesAccount.length];
		
		for (int idx = 0; idx < salesAccount.length; idx++) {
			eachRateStore[idx] = (int)(rateValue[idx] * 360);
			System.out.printf("eachRateStore %d\n", eachRateStore[idx]);
		}
		
		return eachRateStore;
	}
	
	public PIChartSolve() {
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
			
			float[] rateStore = new float[salesAccount.length];
			int[] angleValue = new int[salesAccount.length];
			
			rateStore = calculateRate();
			
			for (int idx = 0; idx < rateStore.length; idx++) {
				System.out.printf("rateStore %f\n", rateStore[idx]);
			}
			
			angleValue = calculateAngle(rateStore);
			// 폰트 설정
			Font myFont = new Font ("고딕", 1, 25);
			g.setFont(myFont);
			
			int startAngle = 0;
			// PI차트
			g.setColor(Color.BLUE);
			startAngle = startAngle + angleValue[0];
			g.fillArc(150, 100, BASIC_CIRCLE_RADIUS, BASIC_CIRCLE_RADIUS, 0, startAngle);
			g.setColor(Color.BLACK);
			g.drawString("1/4분기", 520, 200);
			g.drawString(salesAccount[0] + "억", 520, 230);
			
			g.setColor(Color.YELLOW);
			g.fillArc(150, 100, BASIC_CIRCLE_RADIUS, BASIC_CIRCLE_RADIUS, startAngle, angleValue[1]);
			startAngle = startAngle + angleValue[1];
			g.setColor(Color.BLACK);
			g.drawString("2/4분기", 310, 170);
			g.drawString(salesAccount[1] + "억", 310, 200);
			
			g.setColor(Color.GREEN);
			g.fillArc(150, 100, BASIC_CIRCLE_RADIUS, BASIC_CIRCLE_RADIUS, startAngle, angleValue[2]);
			startAngle = startAngle + angleValue[2];
			g.setColor(Color.BLACK);
			g.drawString("3/4분기", 160, 370);
			g.drawString(salesAccount[2] + "억", 160, 400);
			
			g.setColor(Color.RED);
			g.fillArc(150, 100, BASIC_CIRCLE_RADIUS, BASIC_CIRCLE_RADIUS, startAngle, (360 - startAngle));
			g.setColor(Color.BLACK);
			g.drawString("4/4분기", 480, 550);
			g.drawString(salesAccount[3] + "억", 480, 580);
			
			// 중간 공백 흰원
			g.setColor(Color.WHITE);
			g.fillArc(275, 225, 300, 300, 0, 360);
		}
	}
	
	public static void main(String[] args) {
		
		salesAccount[0] = 200;
		salesAccount[1] = 150;
		salesAccount[2] = 220;
		salesAccount[3] = 300;
		
		new PIChartSolve();
	}

}
