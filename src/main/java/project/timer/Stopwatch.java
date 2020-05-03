package project.timer;

public class Stopwatch implements Runnable {

	private boolean running;
	private volatile String time;
	private Thread stopwatch;
	
	@Override
	public void run() {
		running = true;
		
		while(running) {
			
		}
		
		System.out.println("Watch stopped");
	}
	
	public void start() {
		stopwatch = new Thread(this);
		stopwatch.start();
	}
	
	public void stop() {
		running = false;
	}

}
