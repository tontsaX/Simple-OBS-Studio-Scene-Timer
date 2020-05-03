package project.gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class AppWindow extends JFrame {

	public AppWindow(String title) {
		setTitle(title);
		setPreferredSize(new Dimension(500, 316));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(App.getApplication());
		setVisible(true);
	}
}
