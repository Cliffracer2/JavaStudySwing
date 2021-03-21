package number08;

import java.awt.event.*;

class MyMouseListener implements MouseListener, MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DrawPanel.xAxisStart.add(e.getX());
		DrawPanel.yAxisStart.add(e.getY());
		
		for (int idx = 0; idx < DrawPanel.xAxisStart.size(); idx++) {
			System.out.printf("mousePressed x: %d, y: %d\n", DrawPanel.xAxisStart.get(idx), DrawPanel.yAxisStart.get(idx));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		DrawPanel.xAxisEnd.add(e.getX());
		DrawPanel.yAxisEnd.add(e.getY());
		
		for (int idx = 0; idx < DrawPanel.xAxisEnd.size(); idx++) {
			System.out.printf("mouseReleased x: %d, y: %d\n", DrawPanel.xAxisEnd.get(idx), DrawPanel.yAxisEnd.get(idx));
		}
		
		Problem08.drawPanel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
