//This is the login screen, provides the user the chance to sign in with username and password

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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

public class LoginScreen extends StackPane {
	private TextField username = new TextField();
	private PasswordField password = new PasswordField();
	public int choice;
	private Stage stageLogin;
	public LoginScreen(Stage primaryStage, int width, int height) {		
		
		// Layout for login screen
		stageLogin = primaryStage;
		VBox vBoxLayout1 = new VBox();
		vBoxLayout1.setSpacing(8);
		vBoxLayout1.setPadding(new Insets(10, 10, 10, 10));
		Button login = new Button("Login");
		Button newUser = new Button("New User");
		vBoxLayout1.getChildren().addAll(new Label("Username"), username, new Label("Password"), password, login);
		this.getChildren().addAll(vBoxLayout1);

		// Event for button login
		EventHandler loginHandle = new ButtonHandler();
		login.setOnAction(loginHandle);

	}
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			try {
				Scanner scanner = new Scanner(new FileReader("src/application/LoginEmployees.txt"));
				String line;

	            while (scanner.hasNext()) {
	            	line = scanner.nextLine();
	            	String[] tokens=line.split(",");
	      
	            	if (username.getText().equals(tokens[0]) && password.getText().equals(tokens[1])) {
	            		if(tokens[2].equals("0")) {
	            			DoctorDashboard doctorDash = new DoctorDashboard();
	            			doctorDash.start(stageLogin);
	            		}else {
	            			NurseDashboard nurseDash = new NurseDashboard();
	            			nurseDash.start(stageLogin);
	            		}
	            	} else if (username.getText().equals(tokens[0])) {
	    				AlertBox.display("Login Error", "Password is incorrect, check capslock");
	    		} else if (!username.getText().equals(tokens[0]) && !password.getText().equals(tokens[1])){
	    				AlertBox.display("Login Error", "No such account found");
	    		}
	            }
	            scanner.close();
	        } catch (IOException e) {
	            AlertBox.display("File not found", "Check file location");
	        }
			
		}
	} // end of ButtonHandler

}
