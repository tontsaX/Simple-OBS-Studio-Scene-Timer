package project.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import project.obs.PoorScene;

// t‰‰ luokka p‰ivitt‰‰ swing komponentteja
public class GuiManager {
	
	private static final int APPWIDTH = 500;
	private static final int APPHEIGHT = 316;
	
	private ScenesPanel scenesPanel;
	private TimerPanel timerPanel;
	private App application;
	
	public GuiManager() {
		scenesPanel = new ScenesPanel();
		timerPanel = new TimerPanel();
		
		Dimension panelSize = new Dimension(APPWIDTH / 2, APPHEIGHT);
		scenesPanel.setPreferredSize(panelSize);
		timerPanel.setPreferredSize(panelSize);
		
		application = new App(scenesPanel, timerPanel);
		new AppWindow("Media Source Timer beta", application);
	}
	
	public boolean appReady() {
		return application.appReady();
	}
	
	public void markCurrentScene(String sceneTxt) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				scenesPanel.markCurrentScene(sceneTxt);
			}
		});
	}
	
	public void updateConnectionMessage(String message) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				application.updateConnectionMessage(message);
			}	
		});
	}
	
	public void updateConnectionIndicator(boolean connected) {
		Color connectionIndicator;
		
		if(connected) {
			connectionIndicator = Color.green.darker();
		} else {
			connectionIndicator = Color.red;
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				application.updateConnectionIndicator(connectionIndicator);
			}
		});
	}
	
	public void updateScenes(List<PoorScene> scenes) {
		List<String> sceneLabelTxts = new ArrayList<>();
		
		for(PoorScene scene: scenes) {
			sceneLabelTxts.add(scene.getName());
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				scenesPanel.removeAll();
				scenesPanel.updateSceneLabels(sceneLabelTxts);
				scenesPanel.revalidate();
				scenesPanel.repaint();
			}
		});
	}
	
	public void startTimer() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				timerPanel.startTimer();
			}	
		});
	}
	
	public void stopTimer() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				timerPanel.stopTimer();
			}	
		});
	}
}
