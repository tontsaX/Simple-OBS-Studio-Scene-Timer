package project.gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import project.obs.PoorScene;

// t‰‰ luokka p‰ivitt‰‰ swing komponentteja
public class GuiManager implements Runnable {
	
	private static final int APPWIDTH = 500;
	private static final int APPHEIGHT = 316;
	
	private ScenesPanel scenesPanel;
	private TimerPanel timerPanel;
	private Thread timeManager;
	private boolean running;
	
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
	
	public void updateScenes(List<PoorScene> scenes) {
		List<String> sceneLabelTxts = new ArrayList<>();
		
		for(PoorScene scene: scenes) {
			sceneLabelTxts.add(scene.toString());
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				scenesPanel.updateSceneLabels(sceneLabelTxts);
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
