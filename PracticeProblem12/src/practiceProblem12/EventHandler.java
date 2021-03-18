package practiceProblem12;

import java.awt.event.*;

public class EventHandler {
	
	public void buttonListenerHandle () {
		// ���� ȭ��ǥ ��ư Ŭ���ϸ� ���� �̹����� �̵��ϴ� ������
		SimpleGallery.btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleGallery.currentImageNumber -= 1; // ���� �̹���
				
				if (SimpleGallery.currentImageNumber < 0) {
					SimpleGallery.currentImageNumber = (SimpleGallery.galleryImages.length - 1); // ó�� �̹������� ����ȭ��ǥ�� ������ ������ �̹����� �����´�.
				}
				SimpleGallery.imageLabel.setIcon(SimpleGallery.galleryImages[SimpleGallery.currentImageNumber]);
			}
		});
		
		// ������ ȭ��ǥ ��ư Ŭ���ϸ� ���� �̹����� �̵��ϴ� ������
		SimpleGallery.btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleGallery.currentImageNumber += 1; // ���� �̹���
				
				if (SimpleGallery.currentImageNumber >= SimpleGallery.galleryImages.length) {
					SimpleGallery.currentImageNumber = 0; // ������ �̹������� ������ȭ��ǥ�� ������ ó�� �̹����� �����´�.
				}
				SimpleGallery.imageLabel.setIcon(SimpleGallery.galleryImages[SimpleGallery.currentImageNumber]);
			}
		});
	}

}
