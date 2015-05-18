package application;

public class ClockController {
	
	Timer timer;
	
	public ClockController(Timer timer) {
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
