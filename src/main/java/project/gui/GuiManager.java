package project.gui;

import java.awt.Dimension;

import javax.swing.SwingUtilities;

// t‰‰ luokka p‰ivitt‰‰ swing komponentteja
public class GuiManager implements Runnable {
	
	private static final int APPWIDTH = 500;
	private static final int APPHEIGHT = 316;
	
	private ScenesPanel scenesPanel;
	private TimerPanel timerPanel;
	private boolean running;
	private Thread timeManager;
	
	
	public GuiManager() {
		scenesPanel = new ScenesPanel();
		timerPanel = new TimerPanel();
		
		Dimension panelSize = new Dimension(APPWIDTH / 2, APPHEIGHT);
		scenesPanel.setPreferredSize(panelSize);
		timerPanel.setPreferredSize(panelSize);
		
		App application = new App(scenesPanel, timerPanel);
		new AppWindow("My App", application);
	}
	
	public void startTimer() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				timerPanel.startTimer();
			}	
		});
	}
	
	public void updateScenes() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void run() {

	}
	
	public void start() {
		timeManager = new Thread(this);
		timeManager.start();
	}
	
	public void stop() {
		running = false;
	}
}
