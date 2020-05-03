package project.gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class App extends JPanel {
	
	private JPanel scenesPanel, timerPanel;
	
	private App() {
		super(new FlowLayout());
		scenesPanel = new ScenesPanel();
		timerPanel = new TimerPanel();
		
		add(scenesPanel);
		add(timerPanel);
	}
	
	public static JPanel getApplication() {
		return new App();
	}
}
