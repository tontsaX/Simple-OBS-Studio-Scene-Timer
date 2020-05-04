package project.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScenesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	List<JLabel> sceneLabels;
	
	public ScenesPanel() {
		super(new GridLayout(0,1));
		setBorder(BorderFactory.createTitledBorder("Scenes"));
	}
	
	public void markCurrentScene(String sceneTxt) {
		if(sceneLabels != null) {
			for(JLabel sceneLabel: sceneLabels) {
//				if(sceneLabel.isOpaque()) {
//					// outo juttu, mutta taustaväri tarvitsee vaihtaa ennen kuin se muuttuu näkymättömäksi
//					sceneLabel.setBackground(getForeground());
//					sceneLabel.setOpaque(false);
//				}
//				else if(sceneLabel.getText().equals(sceneTxt)) {
//					sceneLabel.setBackground(Color.decode("#D6EAF8"));
//					sceneLabel.setOpaque(true);
//					break;
//				}
				if(sceneLabel.getText().equals(sceneTxt)) {
//					sceneLabel.setBackground(Color.decode("#D6EAF8"));
					sceneLabel.setOpaque(true);
				} else {
//					sceneLabel.setBackground(getForeground());
					sceneLabel.setOpaque(false);
				}
				repaint();
			}
		}
	}

	public void updateSceneLabels(List<String> sceneLabelTxts) {
		setLayout(new GridLayout(sceneLabelTxts.size(), 1));
		createSceneLabels(sceneLabelTxts);
		addSceneLabels();
	}
	
	private void createSceneLabels(List<String> sceneLabelTxts) {
		sceneLabels = new ArrayList<>(); // tyhjä
		for(String sceneLabelTxt: sceneLabelTxts) {
			JLabel sceneLabel = new JLabel();
			sceneLabel.setText(sceneLabelTxt);
			sceneLabel.setBackground(Color.decode("#D6EAF8"));
			sceneLabels.add(sceneLabel);
		}
	}
	
	private void addSceneLabels() {
		for(JLabel sceneLabel: sceneLabels) {
			add(sceneLabel);
		}
	}
	
}
