package application;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Stopwatch extends BorderPane {
	private Timer timer;
	private Label lblTime;
	private Label lblStatus;
	
	private Button btnStart;
	private Button btnStop;
	private Button btnReset;

	public Stopwatch() {
		initializeGUI();
		this.timer = new Timer(this);
		update();
	}

	private void initializeGUI() {
		final String cssDefault = "-fx-border-color: orange;\n"
				+ "-fx-border-insets: 5;\n" + "-fx-border-width: 1;\n" + "-fx-font-size: 24px;"
				+ "-fx-border-style: solid;\n";

		lblTime = new Label("Time");
		lblTime.setStyle(cssDefault);
		
		final HBox hBoxTime = new HBox(1);
		hBoxTime.setMaxHeight(Double.MAX_VALUE);
		hBoxTime.setMaxWidth(Double.MAX_VALUE);
		hBoxTime.setAlignment(Pos.CENTER);
		hBoxTime.getChildren().addAll(lblTime);

		btnStart = new Button("Start");
		btnStart.setMaxWidth(Double.MAX_VALUE);
		btnStart.addEventHandler(ActionEvent.ACTION, event -> timer.start());
		
		btnStop = new Button("Stop");
		btnStop.setMaxWidth(Double.MAX_VALUE);
		btnStop.addEventHandler(ActionEvent.ACTION, event -> timer.stop());
		
		btnReset = new Button("Reset");
		btnReset.setMaxWidth(Double.MAX_VALUE);
		btnReset.addEventHandler(ActionEvent.ACTION, event -> timer.reset());
		
		lblStatus = new Label("Status");
		lblStatus.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setAlignment(lblStatus, Pos.BOTTOM_LEFT);

		final HBox hBoxButtons = new HBox(5);
		hBoxButtons.setAlignment(Pos.CENTER);
		hBoxButtons.getChildren().addAll(btnStart, btnStop, btnReset);
		
		final VBox vBoxControlsAndStatus = new VBox(5);
		vBoxControlsAndStatus.setMaxWidth(Double.MAX_VALUE);
		vBoxControlsAndStatus.getChildren().addAll(hBoxButtons, lblStatus);

		this.setCenter(hBoxTime);
		this.setBottom(vBoxControlsAndStatus);
	}

	public void update() {
		lblTime.setText(timer.getTimeString());
		btnStart.setDisable(timer.isRunning());
		btnStop.setDisable(!timer.isRunning());
		btnReset.setDisable(timer.isRunning());
		lblStatus.setText(timer.isRunning() ? "Running...":"Stopped.");
	}

}
