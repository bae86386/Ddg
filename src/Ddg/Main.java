package Ddg;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	View m_view;
	
	public Main() {
		m_view = new View();
		add(m_view);
		setTitle("µÎ´õÁö");
		setSize(View.W_CX +15, View.W_CY+40);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Main theApp= new Main();
	}
}
