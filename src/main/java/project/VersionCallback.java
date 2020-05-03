package project;

import net.twasi.obsremotejava.Callback;
import net.twasi.obsremotejava.requests.ResponseBase;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionResponse;

public class VersionCallback implements Callback {

	@Override
	public void run(ResponseBase response) {
		GetVersionResponse version = (GetVersionResponse) response;
		System.out.println("Obs studio version " + version.getObsStudioVersion());
		System.out.println("Version response status " + version.getStatus());
	}

}
