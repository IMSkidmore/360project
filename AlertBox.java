//alertbox for any errors - if anything occurs that was unintended / any errors we can call this to display an error

package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	public static void display(String title, String message) {
		Stage window = new Stage();
		//set title
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		//set label and message
		Label issue = new Label();
		issue.setText(message);
		Button exit = new Button("OK");
		exit.setOnAction(e -> window.close());
		//create vbox layout
		VBox layout = new VBox(10);
		layout.getChildren().addAll(issue,exit);
		layout.setAlignment(Pos.CENTER_RIGHT);
		//set scene
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
