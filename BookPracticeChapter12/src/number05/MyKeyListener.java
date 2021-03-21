package number05;

import java.awt.event.*;
import javax.swing.*;

public class MyKeyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// key code numpad �� '+' ��ư: 107
		// key code numpad �� '-' ��ư: 109
		System.out.printf("get Key Code: %d\n", e.getKeyCode());
		
		double scaleSizeXAxis = 0;
		double scaleSizeYAxis = 0;
		
		if ((e.getKeyCode() == KeyEvent.VK_PLUS) || (e.getKeyCode() == 107)) {
			System.out.printf("+ Key Pressed: %d\n", e.getKeyCode());
			// +�� ���������� 10% ũ�� ����. ������ numpad Ű���� ����� �о�� +Ű�� shift�� ������ �Է��ؾ��ϴµ� �̰� �ȸ���.
			// �Ϲ� Ű�δ� = Ű���� �о���δ�.
			scaleSizeXAxis = (Problem05.imageIcon.getIconWidth() * 1.1);
			scaleSizeYAxis = (Problem05.imageIcon.getIconHeight() * 1.1);
			// Problem05.image�� �������� ���� ������ �̹����� �����ϰ� �� �̹����� �ٽ� Problem05.imageIcon�� ������Ѽ� ���������� ũ�⸦ �����Ѵ�.
			Problem05.image = Problem05.image.getScaledInstance((int)scaleSizeXAxis, (int)scaleSizeYAxis, java.awt.Image.SCALE_DEFAULT);
			Problem05.imageIcon = new ImageIcon(Problem05.image);
			
		}
		else  if ((e.getKeyCode() == KeyEvent.VK_MINUS) || (e.getKeyCode() == 109)) {
			System.out.printf("- Key Pressed: %d\n", e.getKeyCode());
			// -�� ���������� 10% ũ�� ����. �Ϲ�, numpad -Ű �� �� ���� ����
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
