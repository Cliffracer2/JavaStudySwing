package number01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Problem01 extends JFrame {
	
	ImagePanel imagePanel = new ImagePanel();
	ImageIcon backgroundImageIcon = new ImageIcon("images/Hmm.gif");
	Image backgroundImage = backgroundImageIcon.getImage();
	
	boolean isShowImage = true;
	
	public Problem01() {
		
		this.setTitle("p676 problem01");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(imagePanel);

		System.out.printf("size %d x %d\n", this.backgroundImageIcon.getIconWidth(), this.backgroundImageIcon.getIconHeight());
		// 크기는 이미지 크기에 맞춘다.
		this.setSize(this.backgroundImageIcon.getIconWidth(), this.backgroundImageIcon.getIconHeight());
		this.setVisible(true);
	}
	
	class ImagePanel extends JPanel {
		
		JButton switchButton = new JButton();

		// 패널 생성자에 버튼을 눌렀을때 수행하는 기능을 추가한다.
		public ImagePanel() {
			
			this.switchButton.setText("Hide/Show");
			this.switchButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					// 버튼을 클릭할 때마다 이미지 ON/OFF 하는 기능
					if (isShowImage == true) {
						backgroundImageIcon = new ImageIcon(); // 이미지 표시 X
						backgroundImage = backgroundImageIcon.getImage();
						isShowImage = false;
					}
					else {
						backgroundImageIcon = new ImageIcon("images/Hmm.gif");
						backgroundImage = backgroundImageIcon.getImage();
						isShowImage = true;
					}
					
					System.out.printf("Button Pushed\n");
					// 버튼을 누르고 repaint로 패널에 새로 그린다.
					imagePanel.repaint();
				}
				
			});
			
			this.add(switchButton);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(backgroundImage, 0, 0, this);
		}
	}
	
	public static void main(String[] args) {
		new Problem01();
	}
}
