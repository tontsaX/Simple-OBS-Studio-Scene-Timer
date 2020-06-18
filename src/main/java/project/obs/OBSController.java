package project.obs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.events.responses.SwitchScenesResponse;
import net.twasi.obsremotejava.objects.Scene;
import net.twasi.obsremotejava.objects.Source;
import net.twasi.obsremotejava.requests.GetCurrentScene.GetCurrentSceneResponse;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import project.gui.GuiManager;

public class OBSController {
	
	private OBSRemoteController connection;
	private GuiManager guiManager;
	private List<PoorScene> scenes;
	private Map<String, Boolean> sceneMap;
	
	public OBSController() {
		
	}
	
	public OBSController(GuiManager guiManager) {
		this.guiManager = guiManager;
		this.scenes = new ArrayList<>();
		this.sceneMap = new HashMap<>();
	}
	
	public void connect(String address, String password) {
		if(password == null) {
			connection = new OBSRemoteController(address, false);
		} else {
			connection = new OBSRemoteController(address, false, password);
		}
		
		while (connection.isFailed()) { // Awaits response from OBS
			guiManager.updateConnectionMessage("Connection failed");
			
			try {
				Thread.sleep(2000);
				guiManager.updateConnectionMessage("Connecting");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			connection = new OBSRemoteController(address, false);
			
			if(!connection.isFailed()) {
				guiManager.updateConnectionIndicator(true);
				guiManager.updateConnectionMessage("Connected");
			}
		}
		
		guiManager.updateConnectionIndicator(true);
		guiManager.updateConnectionMessage("Connected");
	}
	
	public void setEventListeners() {
		connection.registerSwitchScenesCallback(res -> {
			guiManager.stopTimer();
			
            String currentScene = ((SwitchScenesResponse) res).getSceneName();
            guiManager.markCurrentScene(currentScene);
            
            if(sceneMap.get(currentScene)) {
            	guiManager.startTimer();
            }
        });
		
		connection.registerScenesChangedCallback(res -> {
			scenes = new ArrayList<>();
			sceneMap = new HashMap<>();
			setScenesOnGui().getCurrentSceneMarked();
		});
	}

	public void execute() {
		try {
            connection.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public OBSController setScenesOnGui() {
		connection.getScenes(innerResponse -> {
			GetSceneListResponse sceneListResponse = (GetSceneListResponse) innerResponse;
			String sceneName;
            for(Scene scene: sceneListResponse.getScenes()) {
            	sceneName = scene.getName();
            	if(hasMediaSource(scene)) {
        			scenes.add(new PoorScene(sceneName, true));
        			sceneMap.put(sceneName, true);
        		} else {
        			scenes.add(new PoorScene(sceneName, false));
        			sceneMap.put(sceneName, false);
        		}
            }
            
            guiManager.updateScenes(scenes);
        });
		
		return this;
	}
	
	private boolean hasMediaSource(Scene scene) {
		for(Source source: scene.getSources()) {
			System.out.println(source.getType());
			if(source.getType().equals("ffmpeg_source")) {
				return true;
			}
		}
		return false;
	}
	
	public void getCurrentSceneMarked() {
		connection.getCurrentScene(res -> {
			GetCurrentSceneResponse currentScene = (GetCurrentSceneResponse) res;
			guiManager.stopTimer();
			String sceneName = currentScene.getName();
            guiManager.markCurrentScene(sceneName);
            guiManager.startTimer();
            if(!sceneMap.get(sceneName)) {
            	guiManager.stopTimer();
            }
        });
	}
	
}
