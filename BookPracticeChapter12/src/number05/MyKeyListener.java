package number05;

import java.awt.event.*;
import javax.swing.*;

public class MyKeyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// key code numpad 쪽 '+' 버튼: 107
		// key code numpad 쪽 '-' 버튼: 109
		System.out.printf("get Key Code: %d\n", e.getKeyCode());
		
		double scaleSizeXAxis = 0;
		double scaleSizeYAxis = 0;
		
		if ((e.getKeyCode() == KeyEvent.VK_PLUS) || (e.getKeyCode() == 107)) {
			System.out.printf("+ Key Pressed: %d\n", e.getKeyCode());
			// +를 누를때마다 10% 크기 증가. 동작은 numpad 키값만 제대로 읽어옴 +키가 shift를 눌러서 입력해야하는데 이게 안먹음.
			// 일반 키로는 = 키값만 읽어들인다.
			scaleSizeXAxis = (Problem05.imageIcon.getIconWidth() * 1.1);
			scaleSizeYAxis = (Problem05.imageIcon.getIconHeight() * 1.1);
			// Problem05.image에 스케일이 변한 사이즈 이미지를 저장하고 이 이미지를 다시 Problem05.imageIcon에 저장시켜서 최종적으로 크기를 변경한다.
			Problem05.image = Problem05.image.getScaledInstance((int)scaleSizeXAxis, (int)scaleSizeYAxis, java.awt.Image.SCALE_DEFAULT);
			Problem05.imageIcon = new ImageIcon(Problem05.image);
			
		}
		else  if ((e.getKeyCode() == KeyEvent.VK_MINUS) || (e.getKeyCode() == 109)) {
			System.out.printf("- Key Pressed: %d\n", e.getKeyCode());
			// -를 누를때마다 10% 크기 증가. 일반, numpad -키 둘 다 정상 동작
			scaleSizeXAxis = (Problem05.imageIcon.getIconWidth() * 0.9);
			scaleSizeYAxis = (Problem05.imageIcon.getIconHeight() * 0.9);
			Problem05.image = Problem05.image.getScaledInstance((int)scaleSizeXAxis, (int)scaleSizeYAxis, java.awt.Image.SCALE_DEFAULT);
			Problem05.imageIcon = new ImageIcon(Problem05.image);
		}
		else {
			// nothing
		}
		
		Problem05.imagePanel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
