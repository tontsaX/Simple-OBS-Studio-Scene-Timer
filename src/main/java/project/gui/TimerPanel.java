package project.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		timerLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 45));
		
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setVerticalAlignment(JLabel.CENTER);

		add(timerLabel, BorderLayout.CENTER);
	}
	
	public void setTimeLabel(String timeTxt) {
		timerLabel.setText(timeTxt);
	}
	
	public void startTimer() {
		timeUpdater = new Timer(1000, this);
		timeUpdater.start();
		actionPerformed(new ActionEvent(this, 1, "dummy"));
	}
	
	public void stopTimer() {
		if(timeUpdater != null) {
			timeUpdater.stop();
			elapsedSeconds = 0;
			minutes = 0;
			seconds = 0;
		}
		timerLabel.setText("00:00");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(seconds < 10) {
		 setTimeLabel(minutes + ":0" + seconds);
		} else {
			setTimeLabel(minutes + ":" + seconds);
		}
		
		elapsedSeconds++;
		seconds = elapsedSeconds % 60;
		minutes = elapsedSeconds / 60;
		
	}
}
