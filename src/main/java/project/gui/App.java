package project.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class App extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ConnectionBox connectionBox;
	private boolean appReady;
	
	public App(JPanel scenesPanel, JPanel timerPanel) {
		super(new BorderLayout());
		
		connectionBox = new ConnectionBox();
		
		add(connectionBox, BorderLayout.PAGE_START);
		add(scenesPanel, BorderLayout.LINE_START);
		add(timerPanel, BorderLayout.LINE_END);
	}
	
	public void updateConnectionIndicator(Color color) {
		connectionBox.setConnectionBoxColor(color);
		connectionBox.repaint();
	}
	
	public void updateConnectionMessage(String message) {
		connectionBox.setConnectionTxt(message);
		connectionBox.repaint();
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		appReady = true;
	}
	
	public boolean appReady() {
		return appReady;
	}
	
	class ConnectionBox extends JLabel {

		private static final long serialVersionUID = 1L;
		
		private Color boxColor;
		private String connectionTxt;
		
		protected ConnectionBox() {
			setPreferredSize(new Dimension(500, 20));
			boxColor = Color.red;
			connectionTxt = "Connecting";
		}
		
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(boxColor);
			g.fillRect(2, 5, 10, 10);
			
			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.PLAIN, 10));
			g.drawString(connectionTxt, 16, 14);
		}
		
		public void setConnectionBoxColor(Color color) {
			boxColor = color;
		}
		
		public void setConnectionTxt(String txt) {
			connectionTxt = txt;
		}
	}


}
