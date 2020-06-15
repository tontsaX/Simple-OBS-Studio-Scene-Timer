package project.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import project.obs.PoorScene;

public class GuiManager {
	
	private static final int APPWIDTH = 500;
	private static final int APPHEIGHT = 316;
	
	private ScenesPanel scenesPanel;
	private JScrollPane scrollPane;
	private TimerPanel timerPanel;
	private App application;
	
	public GuiManager() {
		Dimension panelSize = new Dimension(APPWIDTH / 2, APPHEIGHT);
		scenesPanel = new ScenesPanel(panelSize);
		timerPanel = new TimerPanel();
		
//		scenesPanel.setPreferredSize(panelSize);
		timerPanel.setPreferredSize(panelSize);
		
		scrollPane = new JScrollPane(scenesPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(panelSize);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Scenes"));
		application = new App(scrollPane, timerPanel);
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
//				scrollPane.revalidate();
//				scenesPanel.repaint();
				
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
