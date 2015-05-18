package application;

import java.util.Observable;

public class Timer extends Observable implements Runnable {

	private double currentTime;
	private double startTime;
	Thread thread;

	public Timer() {	
		currentTime = 0;
		startTime=0;
		thread = null;
	}

	@Override
	public void run() {
		while (true) {
			currentTime = System.currentTimeMillis() - startTime;
			changed();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				thread = null;
				changed();
				break;
			} finally{
				
			}
		}

	}
	
	public double getTime(){
		return this.currentTime;
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
		changed();
	}

	public void start() {
		currentTime = (currentTime == 0 ? startTime = System.currentTimeMillis():currentTime);
		thread = new Thread(this);
		thread.start();
		changed();
	}

	public void stop() {
		thread.interrupt();
		changed();
	}
	
	private void changed() {
		setChanged();
		notifyObservers();
	}

}
