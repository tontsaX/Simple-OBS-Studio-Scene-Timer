package project.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public AppWindow(String title, JPanel contents) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(contents);
		pack();
		setAlwaysOnTop(true);
		setVisible(true);
	}
}
