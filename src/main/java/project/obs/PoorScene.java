package project.obs;

public class PoorScene {
	
	private String name;
	private boolean hasMediaSource, isCurrentScene;
	
	public PoorScene(String name, boolean hasMediaSource) {
		this.name = name;
		this.hasMediaSource = hasMediaSource;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean hasMediaSource() {
		return hasMediaSource;
	}
	
	public void setHasMediaSource(boolean hasMediaSource) {
		this.hasMediaSource = hasMediaSource;
	}
	
	public boolean isCurrentScene() {
		return isCurrentScene;
	}
	
	public void setAsCurrentScene(boolean isCurrentScene) {
		this.isCurrentScene = isCurrentScene;
	}
	
	@Override
	public String toString() {
		if(hasMediaSource) {
			return "<html>" + name + " : " + "Contains a Media source" + "</html>";
		}
		return "<html>" + name + "</html>";
	}
}
