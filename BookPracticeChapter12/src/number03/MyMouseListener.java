package number03;

import java.awt.event.*;

class MyMouseListener implements MouseListener, MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		Problem03.imageLabel.setLocation(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Problem03.imageLabel.setLocation(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
