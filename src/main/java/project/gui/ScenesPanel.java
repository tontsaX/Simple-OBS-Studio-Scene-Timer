package project.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScenesPanel extends JPanel {

	List<JLabel> sceneLabels;
	
	public ScenesPanel() {
		super(new GridLayout(0,1));
		setBorder(BorderFactory.createTitledBorder("Scenes"));
	}

	public void updateSceneLabels(List<String> sceneLabelTxts) {
		createSceneLabels(sceneLabelTxts);
		addSceneLabels();
	}
	
	private void createSceneLabels(List<String> sceneLabelTxts) {
		sceneLabels = new ArrayList<>();
		for(String sceneLabelTxt: sceneLabelTxts) {
			JLabel sceneLabel = new JLabel();
			sceneLabel.setText(sceneLabelTxt);
			sceneLabel.setVerticalAlignment(JLabel.CENTER);
			sceneLabels.add(sceneLabel);
		}
	}
	
	private void addSceneLabels() {
		for(JLabel sceneLabel: sceneLabels) {
			add(sceneLabel);
		}
	}
	
	private void updateSceneList(List<String> sceneLabelTxts) {
	}
}
