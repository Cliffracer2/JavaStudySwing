package number07;

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

		DrawPanel.xAxis.add(e.getX());
		DrawPanel.yAxis.add(e.getY());
		
//		for (int idx = 0; idx < DrawPanel.xAxis.size(); idx++) {
//			System.out.printf("x: %d, y: %d\n", DrawPanel.xAxis.get(idx), DrawPanel.yAxis.get(idx));
//		}
		
		Problem07.drawPanel.repaint();
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
