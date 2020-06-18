package project.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JViewport;

public class ScenesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int labelHeight, bLabelPadding;
	List<JLabel> sceneLabels;
	
	public ScenesPanel(Dimension preferredSize) {
		setPreferredSize(preferredSize);
	}
	
	public void markCurrentScene(String sceneTxt) {
		if(sceneLabels != null) {
			for(JLabel sceneLabel: sceneLabels) {
				if(sceneLabel.getText().equals(sceneTxt)) {
					sceneLabel.setOpaque(true);
					this.scrollRectToVisible(sceneLabel.getBounds());
				} else {
					sceneLabel.setOpaque(false);
				}
				repaint();
			}
		}
	}

	public void updateSceneLabels(List<String> sceneLabelTxts) {
		createSceneLabels(sceneLabelTxts);
		addSceneLabels();
	}
	
	private void createSceneLabels(List<String> sceneLabelTxts) {
		sceneLabels = new ArrayList<>();
		labelHeight = 70;
		
		for(String sceneLabelTxt: sceneLabelTxts) {
			JLabel sceneLabel = new JLabel();
			sceneLabel.setPreferredSize(new Dimension(getPreferredSize().width, labelHeight));
			sceneLabel.setText(sceneLabelTxt);
			sceneLabel.setBackground(Color.decode("#D6EAF8"));
			sceneLabels.add(sceneLabel);
		}
		
		bLabelPadding = 16;

		setPreferredSize(new Dimension(getPreferredSize().width, (labelHeight + bLabelPadding) * sceneLabels.size()));
	}
	
	private void addSceneLabels() {
		for(JLabel sceneLabel: sceneLabels) {
			add(sceneLabel);
		}
	}
	
}
