package application;

public class Controller {
	
	Timer timer;
	
	public Controller(Timer timer) {
		this.timer=timer;
	}

	public void reset() {
		timer.reset();
	}

	public void stop() {
		timer.stop();
	}

	public void start() {
		timer.start();
	}

}
