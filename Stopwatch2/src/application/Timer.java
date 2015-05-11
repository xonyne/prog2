package application;

import javafx.application.Platform;

public class Timer implements Runnable {

	private double currentTime;
	private double startTime;
	private Stopwatch stopwatch;
	Thread thread;

	public Timer(Stopwatch stopwatch) {	
		currentTime = 0;
		startTime=0;
		this.stopwatch = stopwatch;
		thread = null;
	}

	@Override
	public void run() {
		while (true) {
			currentTime = System.currentTimeMillis() - startTime;
			updateGUI();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				thread = null;
				updateGUI();
				break;
			} finally{
				
			}
		}

	}
	
	private void updateGUI(){
		Platform.runLater(() -> {
			stopwatch.update();
		});
	}

	public void attach(Stopwatch stopwatch) {
		this.stopwatch = stopwatch;
	}

	public String getTimeString() {
		long currentTimeMilli = (long) (currentTime % 1000);
		long currentTimeSec = (long) (currentTime / 1000);
		long currentTimeMin = (long)(currentTime / 1000 / 60);
		return String.valueOf(currentTimeMin) + ":" + String.valueOf(currentTimeSec) + ":" + String.valueOf(currentTimeMilli);
 	}

	public boolean isRunning() {
		return thread != null;
	}

	public void reset() {
		currentTime = 0;
		startTime = 0;
		updateGUI();
	}

	public void start() {
		currentTime = (currentTime == 0 ? startTime = System.currentTimeMillis():currentTime);
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		thread.interrupt();
	}

}
