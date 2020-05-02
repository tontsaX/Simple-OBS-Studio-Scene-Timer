package project;

import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionResponse;

public class Main {

	public static void main(String[] args) {
		OBSRemoteController controller = new OBSRemoteController("ws://localhost:4444", false);

		if (controller.isFailed()) { // Awaits response from OBS
			// Here you can handle a failed connection request
			System.out.println("Yhteyttä ei voitu muodostaa.");
		}
		
		controller.registerConnectCallback(response -> {
			GetVersionResponse version = (GetVersionResponse) response;
			System.out.println(version.getObsStudioVersion());

			// Other requests...
		});
		
		System.out.println("Program finished");
	}

}
