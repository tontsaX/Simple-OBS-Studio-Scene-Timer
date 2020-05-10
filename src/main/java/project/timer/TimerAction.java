package project.timer;

import java.awt.event.ActionEvent;

public class TimerAction extends ActionEvent {
	
	private static final long serialVersionUID = 1L;

	public TimerAction(Object source, int id, String command) {
		super(source, id, command);
	}

}
