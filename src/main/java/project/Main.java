package project;

import java.util.ArrayList;
import java.util.List;

import project.gui.GuiManager;
import project.obs.OBSController;
import project.obs.PoorScene;

public class Main {
	
	//public static GuiManager manager = new GuiManager();

	public static void main(String[] args) throws InterruptedException {
		GuiManager guiManager = new GuiManager();
		OBSController controller = new OBSController(guiManager);
		controller.connect("ws://localhost:4444");
		
//		GuiManager manager = new GuiManager();
		
//		List<PoorScene> scenes = new ArrayList<>();
//		scenes.add(new PoorScene("Charmander Meowth", true));
//		scenes.add(new PoorScene("Meowth", false));
//		scenes.add(new PoorScene("Pichu", true));
//		manager.updateScenes(scenes);
//		
//		currentSceneTest("Charmander Meowth");
//		
//		Thread.sleep(5000);
//		
//		manager.stopTimer();
//		
//		currentSceneTest("Pichu");
	}
	
//	public static void currentSceneTest(String txt) {
//		manager.markCurrentScene(txt);
//		manager.startTimer();
//	}
	
	public static void betterStructure() {
		OBSController controller = new OBSController(new GuiManager());
		
		controller.connect("ws://localhost:4444");
		controller.listenEvents();
		controller.setCurrentScene("Pichu").printAllScenesAndSources();
	}
}
