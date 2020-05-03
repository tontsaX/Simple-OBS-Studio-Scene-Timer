package project.gui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import project.timer.Stopwatch;

public class TimerPanel extends JPanel {
	
	private JLabel timerTxt;
	private Stopwatch timer;

	public TimerPanel() {
		super(new FlowLayout());
		timerTxt = new JLabel("00:00");
		
		add(timerTxt);
	}
	
	
}
