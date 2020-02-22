package Ddg;

import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;

public class View extends JPanel implements ActionListener, MouseListener{

	public static final int W_CX = 400;
	public static final int W_CY = 500;
	Mole m_mole,m_mole2;
	Timer m_moleTimer;
	int m_score;
	int m_playTime;
	Timer m_playTimer;
	
	public View() {
		m_mole = new Mole(W_CX,W_CY);
		m_mole2 = new Mole(W_CX,W_CY);
		m_moleTimer = new Timer(800, this);
		m_moleTimer.restart();
		m_score = 0;
		addMouseListener(this);
		m_playTime = 15;
		m_playTimer = new Timer(1000,this);
		m_playTimer.start();
	}
	public void paint(Graphics g) {
		paintComponent(g);
		g.drawRect(2, 2, W_CX,W_CY);
		m_mole.myPaint(g);
		m_mole2.myPaint(g);
		g.drawString("Score:" + m_score , 20, 20);
		g.drawString("Time:" + m_playTime , 20, 40);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == m_moleTimer) {
			m_mole.moveNext();
			m_mole2.moveNext();
			repaint();
		}else if(e.getSource() == m_playTimer) {
			m_playTime--;
			repaint();
			if(m_playTime <= 0) {
				m_playTimer.stop();
				m_moleTimer.stop();
				JOptionPane.showMessageDialog(this,"Game Over!",
						"information", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		int score;
		if(m_playTime <=0 ) {
			return;
		}
		score = m_mole.checkScore(e.getX(), e.getY());
		score = m_mole2.checkScore(e.getX(), e.getY());
		if(0< score) {
			m_score += score;
			m_mole.moveNext();
			m_mole2.moveNext();
			repaint();
		}
	}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}
