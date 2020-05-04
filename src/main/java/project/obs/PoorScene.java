package project.obs;

public class PoorScene {
	
	private String name;
	private boolean hasMediaSource;
	
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
	
	@Override
	public String toString() {
		if(hasMediaSource) {
			return "<html>" + name + " : " + "Contains a Media source" + "</html>";
		}
		return "<html>" + name + "</html>";
	}
}
