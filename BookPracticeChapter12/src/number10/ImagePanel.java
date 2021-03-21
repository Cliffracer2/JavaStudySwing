package number10;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class ImagePanel extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// 나누어 그릴 영역 계산
		int[] clipOne = {0, 0, ((this.getWidth() / 2) - 5), ((this.getHeight() / 2) - 5)};
		int[] clipTwo = {((this.getWidth() / 2) + 5), 0, this.getWidth(), ((this.getHeight() / 2) - 5)};
		int[] clipThree = {0, ((this.getHeight() / 2) + 5), ((this.getWidth() / 2) - 5), this.getHeight()};
		int[] clipFour = {((this.getWidth() / 2) + 5), ((this.getHeight() / 2) + 5), this.getWidth(), this.getHeight()};
		
		//g.setClip(clipOne[0], clipOne[1], clipOne[2], clipOne[3]);
		//g.setClip(clipTwo[0], clipTwo[1], clipTwo[2], clipTwo[3]);
		//g.drawImage(Problem10.backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
		
		// 메소드 값 설명: (0, 0)에서 (clipOne[2], clipOne[3])영역 만큼 그리는데, 그리는 영역은 (0, 0)에서 (clipOne[2], clipOne[3]) 크기로 그린다.
		// 2사분면(왼쪽 위)
		g.drawImage(Problem10.backgroundImage, 0, 0, clipOne[2], clipOne[3], 0, 0, clipOne[2], clipOne[3], this);
		// 1사분면(오른쪽 위)
		g.drawImage(Problem10.backgroundImage, clipTwo[0], clipTwo[1], clipTwo[2], clipTwo[3], clipTwo[0], clipTwo[1], clipTwo[2], clipTwo[3], this);
		// 3사분면(왼쪽 아래)
		g.drawImage(Problem10.backgroundImage, clipThree[0], clipThree[1], clipThree[2], clipThree[3], clipThree[0], clipThree[1], clipThree[2], clipThree[3], this);
		// 4사분면(오른쪽 아래)
		g.drawImage(Problem10.backgroundImage, clipFour[0], clipFour[1], clipFour[2], clipFour[3], clipFour[0], clipFour[1], clipFour[2], clipFour[3], this);
	}
}
