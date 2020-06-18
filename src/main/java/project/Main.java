package project;

import project.gui.GuiManager;
import project.obs.OBSController;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		GuiManager guiManager = new GuiManager();
		OBSController controller = new OBSController(guiManager);
		
		if(args.length != 0) {
			controller.connect("ws://localhost:4444", args[0]).doStuff();
		} else {
			controller.connect("ws://localhost:4444", null).doStuff();
		}
		
	}
	
}
