package application;

import javafx.application.Platform;

public class Timer implements Runnable {

	private double time;
	private Stopwatch stopwatch;
	Thread thread;

	public Timer() {
		thread = new Thread(this);
	}

	@Override
	public void run() {
		while (true) {
			if (thread.isInterrupted()) {
				break;
			}
			time++;
			Platform.runLater(() -> {
				stopwatch.update();
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

	public double getTime() {
		return time;
	}

	public String getTimeString() {
		return null;
	}

	public boolean isRunning() {
		return false;
	}

	public void reset() {
		this.time = 0;
	}

	public void start() {
		thread.start();
	}

	public void stop() {
		thread.interrupt();
	}

}
