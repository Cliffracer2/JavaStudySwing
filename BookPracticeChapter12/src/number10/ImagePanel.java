package number10;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class ImagePanel extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// ������ �׸� ���� ���
		int[] clipOne = {0, 0, ((this.getWidth() / 2) - 5), ((this.getHeight() / 2) - 5)};
		int[] clipTwo = {((this.getWidth() / 2) + 5), 0, this.getWidth(), ((this.getHeight() / 2) - 5)};
		int[] clipThree = {0, ((this.getHeight() / 2) + 5), ((this.getWidth() / 2) - 5), this.getHeight()};
		int[] clipFour = {((this.getWidth() / 2) + 5), ((this.getHeight() / 2) + 5), this.getWidth(), this.getHeight()};
		
		//g.setClip(clipOne[0], clipOne[1], clipOne[2], clipOne[3]);
		//g.setClip(clipTwo[0], clipTwo[1], clipTwo[2], clipTwo[3]);
		//g.drawImage(Problem10.backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
		
		// �޼ҵ� �� ����: (0, 0)���� (clipOne[2], clipOne[3])���� ��ŭ �׸��µ�, �׸��� ������ (0, 0)���� (clipOne[2], clipOne[3]) ũ��� �׸���.
		// 2��и�(���� ��)
		g.drawImage(Problem10.backgroundImage, 0, 0, clipOne[2], clipOne[3], 0, 0, clipOne[2], clipOne[3], this);
		// 1��и�(������ ��)
		g.drawImage(Problem10.backgroundImage, clipTwo[0], clipTwo[1], clipTwo[2], clipTwo[3], clipTwo[0], clipTwo[1], clipTwo[2], clipTwo[3], this);
		// 3��и�(���� �Ʒ�)
		g.drawImage(Problem10.backgroundImage, clipThree[0], clipThree[1], clipThree[2], clipThree[3], clipThree[0], clipThree[1], clipThree[2], clipThree[3], this);
		// 4��и�(������ �Ʒ�)
		g.drawImage(Problem10.backgroundImage, clipFour[0], clipFour[1], clipFour[2], clipFour[3], clipFour[0], clipFour[1], clipFour[2], clipFour[3], this);
	}
}
