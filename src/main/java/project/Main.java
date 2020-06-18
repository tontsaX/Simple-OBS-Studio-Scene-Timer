package project;

import project.gui.GuiManager;
import project.obs.OBSController;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		GuiManager guiManager = new GuiManager();
		OBSController controller = new OBSController(guiManager);
		controller.connect("ws://localhost:4444", null);
		controller.setEventListeners();
		controller.setScenesOnGui().getCurrentSceneMarked();
	}
	
}
