package number04;

import java.awt.event.*;

class MyMouseListener implements MouseListener, MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		ImagePanel.getXAxis = e.getX();
		ImagePanel.getYAxis = e.getY();
		Problem04.imagePanel.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ImagePanel.getXAxis = e.getX();
		ImagePanel.getYAxis = e.getY();
		Problem04.imagePanel.repaint();
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
