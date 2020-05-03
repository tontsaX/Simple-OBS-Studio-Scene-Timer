package project.obs;

import net.twasi.obsremotejava.Callback;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.events.responses.SwitchScenesResponse;
import net.twasi.obsremotejava.objects.Scene;
import net.twasi.obsremotejava.objects.Source;
import net.twasi.obsremotejava.requests.ResponseBase;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import net.twasi.obsremotejava.requests.GetSourceSettings.GetSourceSettingsResponse;
import project.gui.GuiManager;

public class OBSController {
	
	private OBSRemoteController connection;
	private GuiManager guiManager;
	
	public OBSController(GuiManager guiManager) {
		this.guiManager = guiManager;
	}
	
	public void connect(String address) {
		connection = new OBSRemoteController(address, false);
		if (connection.isFailed()) { // Awaits response from OBS
			// Here you can handle a failed connection request
			System.out.println("Yhteyttä ei voitu muodostaa.");
		}
	}
	
	public void listenEvents() {
		connection.registerSwitchScenesCallback(res -> {
            SwitchScenesResponse switchScenesResponse = (SwitchScenesResponse) res;
            System.out.println("Switched to scene: " + switchScenesResponse.getSceneName());
        });
		
		execute();
	}

	public void execute() {
		try {
			System.out.println("execute");
            connection.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public OBSController setCurrentScene(String sceneName) {
		connection.setCurrentScene(sceneName, new Callback() {
            @Override
            public void run(ResponseBase response) {
                System.out.println("Change scene:" + response.getStatus());
            }
        });
		return this;
	}
	
	public OBSController inspectCurrentScene() {
		return this;
	}
	
	public void printAllScenesAndSources() {
		connection.getScenes(innerResponse -> {
			GetSceneListResponse sceneListResponse = (GetSceneListResponse) innerResponse;
            for (Scene scene : sceneListResponse.getScenes()) {
            	
                System.out.println("Name: " + scene.getName());
                for (Source src : scene.getSources()) {
                	if(src.getType().equals("ffmpeg_source")) {
	                	String sourceName = src.getName();
	                    System.out.println("  " + sourceName + " Source type: " + src.getType());
                	}
                    // tyyppi on ffmpeg_source, joka on open source videolähde
                    // kuva antaa image_source
                }
            }
            
            connection.getSourceSettings("Meowth 2 gif", sourceResponse -> {
            	GetSourceSettingsResponse settings = (GetSourceSettingsResponse) sourceResponse;
            	System.out.println(settings.getSourceSettings().get("restart_on_activate"));
            });
		});
	}
	
}
