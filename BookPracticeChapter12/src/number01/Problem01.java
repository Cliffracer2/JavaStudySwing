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
		// ũ��� �̹��� ũ�⿡ �����.
		this.setSize(this.backgroundImageIcon.getIconWidth(), this.backgroundImageIcon.getIconHeight());
		this.setVisible(true);
	}
	
	class ImagePanel extends JPanel {
		
		JButton switchButton = new JButton();

		// �г� �����ڿ� ��ư�� �������� �����ϴ� ����� �߰��Ѵ�.
		public ImagePanel() {
			
			this.switchButton.setText("Hide/Show");
			this.switchButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					// ��ư�� Ŭ���� ������ �̹��� ON/OFF �ϴ� ���
					if (isShowImage == true) {
						backgroundImageIcon = new ImageIcon(); // �̹��� ǥ�� X
						backgroundImage = backgroundImageIcon.getImage();
						isShowImage = false;
					}
					else {
						backgroundImageIcon = new ImageIcon("images/Hmm.gif");
						backgroundImage = backgroundImageIcon.getImage();
						isShowImage = true;
					}
					
					System.out.printf("Button Pushed\n");
					// ��ư�� ������ repaint�� �гο� ���� �׸���.
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
