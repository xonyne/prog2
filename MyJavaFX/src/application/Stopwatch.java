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
		this.timer = new Timer();
		initializeGUI();
	}

	private void initializeGUI() {
		final String cssDefault = "-fx-border-color: black;\n"
				+ "-fx-border-insets: 5;\n" + "-fx-border-width: 3;\n"
				+ "-fx-border-style: solid;\n";

		lblTime = new Label("Time");
		lblTime.setMaxWidth(Double.MAX_VALUE);
		lblTime.setMaxHeight(Double.MAX_VALUE);
		lblTime.setStyle(cssDefault);

		btnStart = new Button("Start");
		btnStart.setMaxWidth(Double.MAX_VALUE);
		btnStart.addEventHandler(ActionEvent.ACTION, event -> timer.start());
		
		btnStop = new Button("Stop");
		btnStop.setMaxWidth(Double.MAX_VALUE);
		btnStart.addEventHandler(ActionEvent.ACTION, event -> timer.stop());
		
		btnReset = new Button("Reset");
		btnReset.setMaxWidth(Double.MAX_VALUE);
		btnStart.addEventHandler(ActionEvent.ACTION, event -> timer.reset());
		
		lblStatus = new Label("Status");
		lblStatus.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setAlignment(lblStatus, Pos.BOTTOM_LEFT);

		final HBox hBox = new HBox(5);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(btnStart, btnStop, btnReset);
		
		final VBox vBox = new VBox(5);
		vBox.setMaxWidth(Double.MAX_VALUE);
		vBox.getChildren().addAll(hBox, lblStatus);

		this.setCenter(lblTime);
		this.setBottom(vBox);
	}

	public void update() {
		lblTime.setText(timer.getTimeString());
	}

}
