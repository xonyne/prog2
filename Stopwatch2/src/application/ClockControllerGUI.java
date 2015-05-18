package application;

import java.util.Observable;
import java.util.Observer;

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

public class ClockControllerGUI extends Stage implements Observer {
	private Timer timer;
	private Controller controller;
	private Label lblTime;
	private Label lblStatus;
	
	private Button btnStart;
	private Button btnStop;
	private Button btnReset;

	public ClockControllerGUI(Timer timer, Controller controller) {
		this.timer = timer;
		this.controller = controller;
		timer.addObserver(this);
		initializeGUI();
	}

	private void initializeGUI() {
		final String cssDefault = "-fx-border-color: orange;\n"
				+ "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n" + "-fx-font-size: 24px;"
				+ "-fx-border-style: solid;\n";

		lblTime = new Label("Time");
		lblTime.setStyle(cssDefault);
		
		BorderPane borderPane = new BorderPane();
		
		final HBox hBoxTime = new HBox(1);
		hBoxTime.setMaxHeight(Double.MAX_VALUE);
		hBoxTime.setMaxWidth(Double.MAX_VALUE);
		hBoxTime.setAlignment(Pos.CENTER);
		hBoxTime.getChildren().addAll(lblTime);

		btnStart = new Button("Start");
		btnStart.setMaxWidth(Double.MAX_VALUE);
		btnStart.addEventHandler(ActionEvent.ACTION, event -> controller.start());
		
		btnStop = new Button("Stop");
		btnStop.setMaxWidth(Double.MAX_VALUE);
		btnStop.addEventHandler(ActionEvent.ACTION, event -> controller.stop());
		
		btnReset = new Button("Reset");
		btnReset.setMaxWidth(Double.MAX_VALUE);
		btnReset.addEventHandler(ActionEvent.ACTION, event -> controller.reset());
		
		lblStatus = new Label("Status");
		lblStatus.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setAlignment(lblStatus, Pos.BOTTOM_LEFT);

		final HBox hBoxButtons = new HBox(5);
		hBoxButtons.setAlignment(Pos.CENTER);
		hBoxButtons.getChildren().addAll(btnStart, btnStop, btnReset);
		
		final VBox vBoxControlsAndStatus = new VBox(5);
		vBoxControlsAndStatus.setMaxWidth(Double.MAX_VALUE);
		vBoxControlsAndStatus.getChildren().addAll(hBoxButtons, lblStatus);

		borderPane.setCenter(hBoxTime);
		borderPane.setBottom(vBoxControlsAndStatus);
		this.setScene(new Scene(borderPane));
		this.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		Platform.runLater(() -> {
			lblTime.setText(timer.getTimeString());
			btnStart.setDisable(timer.isRunning());
			btnStop.setDisable(!timer.isRunning());
			btnReset.setDisable(timer.isRunning());
			lblStatus.setText(timer.isRunning() ? "Running...":"Stopped.");
		});
	}

}
