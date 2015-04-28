package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.FlowPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			final BorderPane root = new BorderPane();
			

final String cssDefault = "-fx-border-color: blue;\n"
                + "-fx-border-insets: 5;\n"
                + "-fx-border-width: 3;\n"
                + "-fx-border-style: dashed;\n";
		
			Label lblTime = new Label("Time");
			lblTime.setMaxWidth(Double.MAX_VALUE);
			lblTime.setStyle(cssDefault);
			BorderPane.setAlignment(lblTime, Pos.CENTER);
			
			Label lblStatus = new Label("Time");
			lblStatus.setMaxWidth(Double.MAX_VALUE);
			BorderPane.setAlignment(lblStatus, Pos.BOTTOM_LEFT);
			
			Button btnStart = new Button("Start");
			Button btnStop = new Button("Stop");
			Button btnReset = new Button("Reset");	
			
			btnStart.setMaxWidth(Double.MAX_VALUE);
			btnStop.setMaxWidth(Double.MAX_VALUE);
			btnReset.setMaxWidth(Double.MAX_VALUE);
			
			root.setTop(lblTime);
			root.setLeft(btnStart);
			root.setCenter(btnStop);
			root.setRight(btnReset);
			root.setBottom(lblStatus);
			
			
			// Show GUI
			Scene scene = new Scene(root);
			primaryStage.setTitle("My App");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
