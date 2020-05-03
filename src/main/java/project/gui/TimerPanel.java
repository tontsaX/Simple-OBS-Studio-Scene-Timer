package project.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel timerLabel;
	private Timer timeUpdater;

	private long minutes, seconds, elapsedSeconds;
	
	public TimerPanel() {
		super(new BorderLayout());
		
		timerLabel = new JLabel("00:00");
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setVerticalAlignment(JLabel.CENTER);

		add(timerLabel, BorderLayout.CENTER);
	}
	
	public void setTimeLabel(String timeTxt) {
		timerLabel.setText(timeTxt);
	}
	
	public void startTimer() {
		minutes = 0;
		seconds = 0;
		
		timeUpdater = new Timer(1000, this);
		timeUpdater.start();
		actionPerformed(new ActionEvent(this, 1, "dummy"));
	}
	
	public void stopTimer() {
		timeUpdater.stop();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		setTimeLabel(minutes + ":" + seconds);
		seconds++;
		elapsedSeconds = seconds;
		minutes = elapsedSeconds / 60;
		
		if(elapsedSeconds % 60 == 0) {
			seconds = 0;
		}
		
	}
}
