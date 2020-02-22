package Ddg;

import java.awt.*;
import java.util.*;

public class Mole {
	Rectangle m_rect;
	Random m_rand;
	int m_cx;
	int m_cy;
	
	public Mole(int cx, int cy) {
		m_rect = new Rectangle(10,10,50,50);
		m_rand = new Random();
		m_cx = cx;
		m_cy = cy;
	}
	public void myPaint(Graphics g) {
		g.drawRect(m_rect.x, m_rect.y, m_rect.width, m_rect.height);
	}
	public void moveNext() {
		m_rect.x = m_rand.nextInt(m_cx);
		m_rect.y = m_rand.nextInt(m_cy);
	}
	public int checkScore(int x, int y) {
		int score = 0;
		if(true == m_rect.contains(x,y)) {
			score = 1000;
		}
		return score;
	}
}
