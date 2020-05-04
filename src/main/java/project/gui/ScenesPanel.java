package project.gui;

import java.awt.Color;
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
	
	public void markCurrentScene(String sceneTxt) {
		System.out.println("About to check labels content");
		if(sceneLabels != null) {
			for(JLabel sceneLabel: sceneLabels) {
				if(sceneLabel.isOpaque()) {
					sceneLabel.setBackground(getForeground());
					sceneLabel.setOpaque(false);
				}
				else if(sceneLabel.getText().equals(sceneTxt)) {
					sceneLabel.setBackground(Color.decode("#D6EAF8"));
					sceneLabel.setOpaque(true);
					break;
				}
			}
		}
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
			sceneLabel.setHorizontalAlignment(JLabel.LEADING);
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
