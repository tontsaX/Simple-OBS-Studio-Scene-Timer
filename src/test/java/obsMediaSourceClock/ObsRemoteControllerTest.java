package obsMediaSourceClock;

import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

import net.twasi.obsremotejava.Callback;
import net.twasi.obsremotejava.OBSRemoteController;
import net.twasi.obsremotejava.events.responses.ScenesChangedResponse;
import net.twasi.obsremotejava.events.responses.SwitchScenesResponse;
import net.twasi.obsremotejava.events.responses.TransitionBeginResponse;
import net.twasi.obsremotejava.events.responses.TransitionEndResponse;
import net.twasi.obsremotejava.requests.ResponseBase;
import net.twasi.obsremotejava.requests.GetVersion.GetVersionResponse;

public class ObsRemoteControllerTest {
    /**
     * - Set these two values before running these tests
     * - Make sure your OBS is running and available for connection
     */
    private final String obsAddress = "ws://localhost:4444";
    private final String obsPassword = null;

    @Test
    void test() {
        final OBSRemoteController controller = new OBSRemoteController(obsAddress, false);

        if (controller.isFailed()) {
            System.out.println("UPS DAS GET NET H�LFEEE!");
        }

        controller.registerDisconnectCallback(new Callback() {
            @Override
            public void run(ResponseBase response) {
                System.out.println("Disconnected");
            }
        });

        controller.registerConnectCallback(new Callback() {
            @Override
            public void run(ResponseBase response) {
                GetVersionResponse version = (GetVersionResponse) response;
                System.out.println("Connected!");
                System.out.println(version.getObsStudioVersion());

                controller.registerReplayStartedCallback(res -> {
                    System.out.println("Replay started");
                });

                controller.registerReplayStartingCallback(res -> {
                    System.out.println("Replay starting");
                });

                controller.registerReplayStoppedCallback(res -> {
                    System.out.println("Replay stopped");
                });

                controller.registerReplayStoppingCallback(res -> {
                    System.out.println("Replay stopping");
                });

                controller.startReplayBuffer(res -> {
                    System.out.println("Should start replay buffer");
                });

                controller.saveReplayBuffer(res -> {
                    System.out.println("Should save replay buffer");
                });

                controller.stopReplayBuffer(res -> {
                    System.out.println("Should stop replay buffer");
                });
                
                System.out.println(Thread.currentThread().getName());

                /* controller.getScenes(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetSceneListResponse res = (GetSceneListResponse) response;
                        for (Scene scene : res.getScenes()) {
                            System.out.println("Name: " + scene.getName());
                            for (Source src : scene.getSources()) {
                                System.out.println("  " + src.getName());
                            }
                        }
                    }
                }); */

                /* controller.setCurrentTransition("�berbllenden", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Change transition: " + response.getStatus());
                    }
                }); */

                /* controller.setCurrentScene("Szene", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Change scene:" + response.getStatus());
                    }
                }); */

                /* controller.changeSceneWithTransition("EineCooleSzene", "�berblenden", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.print("Change completed.");
                    }
                }); */

                /* controller.setSourceVisibility("EineCooleSzene", "Bildschirmaufnahme", true, new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        if (response.getStatus().equals("ok")) {
                            System.out.println("Visibility changed.");
                        } else {
                            System.out.print("Error while changing visibility: " + response.getError());
                        }
                    }
                }); */

                /* controller.getTransitionList(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetTransitionListResponse res = (GetTransitionListResponse) response;
                        System.out.println("Current transition: " + res.getCurrentTransition());
                        System.out.println("All transitions:");
                        for(GetTransitionListResponse.Transition t : res.getTransitions()) {
                            System.out.println("  - " + t.getName());
                        }
                    }
                }); */

                /* controller.transitionToProgram("�berblenden", 0, new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Transition OK");
                    }
                }); */

                /* controller.getSourceSettings("Streaminput", new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetSourceSettingsResponse res = (GetSourceSettingsResponse) response;
                        System.out.println(res.getSourceName());
                        System.out.println(res.getSourceSettings());
                    }
                }); */

                /* Map<String, Object> settings = new HashMap<>();
                settings.put("input", "https://sadfasdf.net");
                controller.setSourceSettings("Medienquelle", settings, new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Source settings changed.");
                    }
                }); */

                /* controller.getStreamingStatus(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetStreamingStatusResponse res = (GetStreamingStatusResponse) response;
                        System.out.println("isStreaming: " + res.isStreaming());
                        System.out.println("Streaming since: " + res.getStreamTimecode());
                        System.out.println("isRecording: " + res.isRecording());
                        System.out.println("Recording since: " + res.getRecTimecode());
                    }
                }); */

                /* controller.startStreaming(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Streaming started: " + response.getStatus());
                    }
                }); */

                /* controller.stopStreaming(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        System.out.println("Streaming stopped: " + response.getStatus());
                    }
                }); */

                /* controller.listProfiles(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        ListProfilesResponse res = (ListProfilesResponse) response;
                        res.getProfiles().forEach(profile -> System.out.println(profile.getName()));
                    }
                }); */

                /* controller.getCurrentProfile(new Callback() {
                    @Override
                    public void run(ResponseBase response) {
                        GetCurrentProfileResponse res = (GetCurrentProfileResponse) response;
                        System.out.println(res.getProfileName());
                    }
                }); */

                /* controller.setCurrentProfile("Unbenannt", res -> {
                    System.out.println(res.getStatus());
                }); */

                /* controller.getCurrentScene(res -> {
                    System.out.println(((GetCurrentSceneResponse) res).getName());
                }); */

                /* controller.getVolume("Streaminput", res -> {
                    GetVolumeResponse resp = (GetVolumeResponse) res;
                    System.out.println(resp.isMuted());
                    System.out.println(resp.getVolume());
                }); */

                /* controller.setVolume("Streaminput", 0.01, res -> {
                    System.out.println("Done");
                }); */

                /* controller.setMute("Streaminput", true, res -> {
                    System.out.println("Done");
                }); */

                /* controller.getPreviewScene(res -> {
                    GetPreviewSceneResponse resp = (GetPreviewSceneResponse)res;
                    System.out.println(resp);
                }); */

                /* controller.setPreviewScene("Twasi Starting Soon", res -> {
                    System.out.println("Done");
                }); */

                /* controller.getTransitionDuration(res -> {
                    GetTransitionDurationResponse resp = (GetTransitionDurationResponse) res;
                    System.out.println(resp.getTransitionDuration());
                }); */

                /* controller.setTransitionDuration(1077, res -> {
                    System.out.println("Done");
                }); */

                /* controller.getStudioModeEnabled(res -> {
                    GetStudioModeEnabledResponse resp = (GetStudioModeEnabledResponse) res;
                    System.out.println("Studio mode is " + (resp.isEnabled() ? "enabled" : "disabled") + ".");
                }); */

                /* controller.setStudioModeEnabled(false, res -> {
                    System.out.println("Done");
                }); */


                controller.registerSwitchScenesCallback(res -> {
                    SwitchScenesResponse switchScenesResponse = (SwitchScenesResponse) res;
                    System.out.println("Switched to scene: " + switchScenesResponse.getSceneName());
                });

                // laukeaa kun skene-listaa muuttaa, ei reagoi muutoksiin sources listassa
                controller.registerScenesChangedCallback(res -> {
                    //ScenesChangedResponse scenesChangedResponse = (ScenesChangedResponse) res;
                    System.out.println("Scenes changed");
                });
                

                controller.registerTransitionBeginCallback(res -> {
                    TransitionBeginResponse transitionBeginResponse = (TransitionBeginResponse) res;
                    System.out.println("Transition started from scene: '" + transitionBeginResponse.getFromScene() + "' to scene: '" + transitionBeginResponse.getToScene() + "'");
                });

                controller.registerTransitionEndCallback(res -> {
                    TransitionEndResponse transitionEndResponse = (TransitionEndResponse) res;
                    System.out.println("Transition ended with scene: " + transitionEndResponse.getToScene());
                });
            }
        });

        try {
            controller.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
