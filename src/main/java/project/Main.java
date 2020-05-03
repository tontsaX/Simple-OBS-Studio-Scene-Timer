package project;

import net.twasi.obsremotejava.Callback;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.objects.Scene;
import net.twasi.obsremotejava.objects.Source;
import net.twasi.obsremotejava.requests.ResponseBase;
import net.twasi.obsremotejava.requests.GetSceneList.GetSceneListResponse;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionResponse;
import project.obs.OBSController;

public class Main {

	public static void main(String[] args) {

//		OBSRemoteController controller = new OBSRemoteController("ws://localhost:4444", false);
//
//		if (controller.isFailed()) { // Awaits response from OBS
//			// Here you can handle a failed connection request
//			System.out.println("Yhteyttä ei voitu muodostaa.");
//		}
		
		betterStructure();
		
//		controller.registerConnectCallback(new Callback() {
//			@Override
//			public void run(ResponseBase response) {
//				controller.getScenes(innerResponse -> {
//					GetSceneListResponse sceneListResponse = (GetSceneListResponse) innerResponse;
//		            for (Scene scene : sceneListResponse.getScenes()) {
//		            	
//		                System.out.println("Name: " + scene.getName());
//		                for (Source src : scene.getSources()) {
//		                    System.out.println("  " + src.getName() + " Source type: " + src.getType());
//		                    // tyyppi on ffmpeg_source, joka on open source videolähde
//		                    // kuva antaa image_source
//		                }
//		            }
//				});
//			}
//		});
		
//		try {
//            controller.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
		
		// olla oleva lyhennetty lambaksi vielä alempana oleva kutsu
//		controller.registerConnectCallback(response -> {
//			GetVersionResponse version = (GetVersionResponse) response;
//			System.out.println("Obs studio version " + version.getObsStudioVersion());
//			System.out.println("Version response status " + version.getStatus());
//			// Other requests...
//		});
		
//		Callback versionCallback = new VersionCallback();
//		controller.registerConnectCallback(versionCallback);
		
//		controller.getCurrentScene(new Callback() {
//			@Override
//			public void run(ResponseBase response) {
//				GetCurrentSceneResponse currentScene = (GetCurrentSceneResponse)  response;
//				System.out.println("Current scene: " + currentScene.getName());
//			}
//		});
	}
	
	public static void betterStructure() {
		OBSController controller = OBSController.connect("ws://localhost:4444");
		
		controller.listenEvents();
		controller.setCurrentScene("Pichu").printAllScenesAndSources();
	}
}
