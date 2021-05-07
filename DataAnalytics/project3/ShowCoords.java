package project3;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ShowCoords implements MouseListener {
	private JButton label;

	@Override
	public void mouseClicked(MouseEvent e) {
		label.setText("(" + e.getX() + "," + e.getY() + ")");
		System.out.println("(" + e.getX() + "," + e.getY() + ")");

	}
	public ShowCoords(JButton label) {
		this.label = label;
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