package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.PasswordField;

public class LoginScreenPatient extends StackPane {
	private TextField username = new TextField();
	private PasswordField password = new PasswordField();
	public int choice;
	public LoginScreenPatient(Stage primaryStage, int width, int height) {		
		
		// Layout for login screen
		VBox vBoxLayout1 = new VBox();
		vBoxLayout1.setSpacing(8);
		vBoxLayout1.setPadding(new Insets(10, 10, 10, 10));
		Button login = new Button("Login");
		Button newUser = new Button("New User");
		vBoxLayout1.getChildren().addAll(new Label("Username"), username, new Label("Password"), password, login, newUser);
		this.getChildren().addAll(vBoxLayout1);

		// Event for button login
		EventHandler loginHandle = new ButtonHandler();
		login.setOnAction(loginHandle);
		
		EventHandler newUserHandle = new NewUserHandler();
		newUser.setOnAction(newUserHandle);

	}
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			if (username.getText().equals("Username") && password.getText().equals("Password")) {
				//add change of screen here
			} else if (username.getText().equals("Username") == false) {
				AlertBox.display("Login Error", "Username is incorrect, check capslock");
			} else {
				AlertBox.display("Login Error", "Password is incorrect, check capslock");
			}
		}
	} // end of ButtonHandler
	private class NewUserHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//add Change of screen here
		}
	}
	
}
