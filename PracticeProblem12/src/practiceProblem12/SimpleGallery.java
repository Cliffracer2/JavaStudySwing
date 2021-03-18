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
		// 화살표 버튼 설정
		this.leftArrowIcon = new ImageIcon("images/Left.png");
		this.rightArrowIcon = new ImageIcon("images/Right.png");
		btnLeft = new JButton(this.leftArrowIcon);
		btnRight = new JButton(this.rightArrowIcon);
		
		// 이미지 파일 읽어오기
		for(int idx = 0; idx < galleryImages.length; idx++) {
			galleryImages[idx] = new ImageIcon("images/re_image" + (idx + 1) + ".jpg");
		}
		
		// 처음 이미지 표시 
		currentImageNumber = 0;
		imageLabel = new JLabel(galleryImages[currentImageNumber]);
	}
	
	public SimpleGallery() {
		this.setTitle("SimpleGallery");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		this.ImageInit();
		buttonListener.buttonListenerHandle(); // 버튼 리스너 처리

		// 화살표 버튼패널에 화살표 버튼 추가
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