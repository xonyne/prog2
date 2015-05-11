package application;

import javafx.application.Platform;

public class Timer implements Runnable {

	private double currentTime;
	private double startTime;
	private Stopwatch stopwatch;
	Thread thread;

	public Timer(Stopwatch stopwatch) {	
		this.stopwatch = stopwatch;
		reset();
	}

	@Override
	public void run() {
		while (true) {
			if (thread.isInterrupted()) {
				break;
			}
			currentTime = System.currentTimeMillis() - startTime;
			Platform.runLater(() -> {
				stopwatch.update(this.getTimeString());
			});
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				thread.interrupt();
			}
		}

	}

	public void attach(Stopwatch stopwatch) {
		this.stopwatch = stopwatch;
	}

//	public double getTime() {
//		return time;
//	}

	public String getTimeString() {
		long currentTimeMilli = (long) (currentTime % 1000);
		long currentTimeSec = (long) (currentTime / 1000);
		long currentTimeMin = (long)(currentTime / 1000 / 60);
		return String.valueOf(currentTimeMin) + ":" + String.valueOf(currentTimeSec) + ":" + String.valueOf(currentTimeMilli);
 	}

	public boolean isRunning() {
		return !this.thread.isInterrupted();
	}

	public void reset() {
		startTime = System.currentTimeMillis();
		stopwatch.update(this.getTimeString());
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		thread.interrupt();
	}

}
