package practiceProblem12;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleGallery extends JFrame {
	
	EventHandler buttonListener = new EventHandler();
	
	static JLabel imageLabel = null;
	
	JPanel ArrowPanel = null;
	
	ImageIcon leftArrowIcon = null;
	ImageIcon rightArrowIcon = null;
	static ImageIcon[] galleryImages = new ImageIcon [4];

	static JButton btnLeft = null;
	static JButton btnRight = null;
	
	static int currentImageNumber;
	
	public void ImageInit () {
		// ȭ��ǥ ��ư ����
		this.leftArrowIcon = new ImageIcon("images/Left.png");
		this.rightArrowIcon = new ImageIcon("images/Right.png");
		btnLeft = new JButton(this.leftArrowIcon);
		btnRight = new JButton(this.rightArrowIcon);
		
		// �̹��� ���� �о����
		for(int idx = 0; idx < galleryImages.length; idx++) {
			galleryImages[idx] = new ImageIcon("images/re_image" + (idx + 1) + ".jpg");
		}
		
		// ó�� �̹��� ǥ�� 
		currentImageNumber = 0;
		imageLabel = new JLabel(galleryImages[currentImageNumber]);
	}
	
	public SimpleGallery() {
		this.setTitle("SimpleGallery");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		this.ImageInit();
		buttonListener.buttonListenerHandle(); // ��ư ������ ó��

		// ȭ��ǥ ��ư�гο� ȭ��ǥ ��ư �߰�
		this.ArrowPanel = new JPanel();
		this.ArrowPanel.add(btnLeft);
		this.ArrowPanel.add(btnRight);
		container.add(imageLabel, BorderLayout.CENTER);
		container.add(this.ArrowPanel, BorderLayout.SOUTH);
		
		this.setSize(600, 600);
		this.setVisible(true);
	}
	
	public static void main(String [] args) {
		new SimpleGallery();
	}
} 