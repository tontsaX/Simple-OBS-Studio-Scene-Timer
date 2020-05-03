package project.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ScenesPanel extends JPanel {

	List<JLabel> scenes;
	
	public ScenesPanel() {
		super(new BorderLayout());
		//setBorder(BorderFactory.createLineBorder(Color.black));
		setBorder(BorderFactory.createTitledBorder("Scenes"));
	}
}
