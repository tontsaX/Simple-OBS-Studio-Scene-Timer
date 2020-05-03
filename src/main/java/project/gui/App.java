package project.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

public class App extends JPanel {
	
	public App( JPanel scenesPanel, JPanel timerPanel) {
		super(new BorderLayout());
//		setPreferredSize(new Dimension(500, 316));
		
//		Dimension innerPanelSize = new Dimension(getWidth()/2, getHeight());
//		scenesPanel.setPreferredSize(innerPanelSize);
//		timerPanel.setPreferredSize(innerPanelSize);
		
		add(scenesPanel, BorderLayout.LINE_START);
		add(timerPanel, BorderLayout.LINE_END);
	}
}
