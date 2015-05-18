package application;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsoleGUI implements Observer {
	private Timer timer;
	private Controller controller;
	private boolean lastTimerStatus;
	private double lastTimerTime;

	public ConsoleGUI(Timer timer, Controller controller) {
		this.timer = timer;
		lastTimerStatus=timer.isRunning();
		lastTimerTime=0d;
		this.controller = controller;
		timer.addObserver(this);
		initializeGUI();
	}

	private void initializeGUI() {
		System.out.println("Clock Controller (start|stop|reset|exit):");

		new Thread(new Runnable(){
			@Override
			public void run() {
				String operation;
				Scanner scan = new Scanner(System.in);
				do {
					operation = scan.nextLine();

					switch (operation.toLowerCase()) {
					case "start":
						if (timer.isRunning()) {
							System.out.println("Timer already started.");
						} else {
							controller.start();
						}
						break;
					case "stop":
						if (!timer.isRunning()) {
							System.out.println("Timer already stopped.");
						} else {
							controller.stop();
						}
						break;
					case "reset":
						if (timer.isRunning()) {
							System.out.println("Reset not possible while timer is running.");
						} else {
							controller.reset();							
						} 
						break;
					case "exit":
						System.exit(0);;
					default:
						System.out.println("Operation unknown.");
					}

				} while (!operation.toLowerCase().equals("exit"));
				scan.close();
				
			}
		}).start();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (timer.getTime() < this.lastTimerTime) {
			System.out.println("Reset.");
		}
		if (timer.isRunning() != this.lastTimerStatus) {
			System.out.println(timer.isRunning() ? "Started. Timer is running...":"Stopped.");
		}
		this.lastTimerStatus = timer.isRunning();
		this.lastTimerTime = timer.getTime();
	}
}
