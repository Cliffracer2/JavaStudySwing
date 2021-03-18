package practiceProblem12;

import java.awt.event.*;

public class EventHandler {
	
	public void buttonListenerHandle () {
		// 왼쪽 화살표 버튼 클릭하면 이전 이미지로 이동하는 리스너
		SimpleGallery.btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleGallery.currentImageNumber -= 1; // 이전 이미지
				
				if (SimpleGallery.currentImageNumber < 0) {
					SimpleGallery.currentImageNumber = (SimpleGallery.galleryImages.length - 1); // 처음 이미지에서 왼쪽화살표를 누르면 마지막 이미지를 가져온다.
				}
				SimpleGallery.imageLabel.setIcon(SimpleGallery.galleryImages[SimpleGallery.currentImageNumber]);
			}
		});
		
		// 오른쪽 화살표 버튼 클릭하면 다음 이미지로 이동하는 리스너
		SimpleGallery.btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleGallery.currentImageNumber += 1; // 다음 이미지
				
				if (SimpleGallery.currentImageNumber >= SimpleGallery.galleryImages.length) {
					SimpleGallery.currentImageNumber = 0; // 마지막 이미지에서 오른쪽화살표를 누르면 처음 이미지를 가져온다.
				}
				SimpleGallery.imageLabel.setIcon(SimpleGallery.galleryImages[SimpleGallery.currentImageNumber]);
			}
		});
	}

}
