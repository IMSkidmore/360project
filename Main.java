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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.PasswordField;


public class Main extends Application {
	private StackPane root = new StackPane();
	private Stage stage;
	private TextField username = new TextField();
	private PasswordField password = new PasswordField();
	private Scene scene0, scene1, scene2;
	private int choice;
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		
		//Layout for which login screen
		VBox selectTypeLayout = new VBox();
		StackPane stackLayout0 = new StackPane();
		selectTypeLayout.setSpacing(8);
		selectTypeLayout.setPadding(new Insets(10,10,10,10));
		HBox hBoxLayout = new HBox();
		hBoxLayout.setSpacing(8);
		hBoxLayout.setPadding(new Insets(10,10,10,10));
		Button doctorLogin = new Button("Doctor");
		Button nurseLogin = new Button("Nurse");
		Button patientLogin = new Button("Patient");
		hBoxLayout.getChildren().addAll(doctorLogin, nurseLogin, patientLogin);
		selectTypeLayout.getChildren().addAll(new Label("Please select an account type:"), hBoxLayout);
		stackLayout0.getChildren().addAll(selectTypeLayout);
		scene0 = new Scene(stackLayout0, 400,600);
		
		//Button action handler events
		doctorLogin.setOnAction(e -> {choice = 0; 
		primaryStage.setScene(scene1);
		});
		nurseLogin.setOnAction(e -> {choice = 1; 
		primaryStage.setScene(scene1);
		});
		patientLogin.setOnAction(e -> {choice = 2; 
		primaryStage.setScene(scene1);
		});
		
		
		//Layout for login screen
		VBox vBoxLayout1 = new VBox();
		vBoxLayout1.setSpacing(8);
		vBoxLayout1.setPadding(new Insets(10, 10, 10, 10));
		Button login = new Button("Login");
		vBoxLayout1.getChildren().addAll(new Label("Username"), username, new Label("Password"), password, login);
		root.getChildren().addAll(vBoxLayout1);
		scene1 = new Scene(root, 400, 600);
		
		//Event for button login
		login.setOnAction(e -> {if(username.getText().equals("Austin") && password.getText().equals("Piper")) {
			primaryStage.setScene(scene2);
		}else if(username.getText().equals("Austin") == false){
			AlertBox.display("Login Error", "Username is incorrect, check capslock");
		}else {
			AlertBox.display("Login Error", "Password is incorrect, check capslock");
		}
		});
		
		//layout for scene1
		Button logout = new Button("Logout");
		logout.setOnAction(e -> primaryStage.setScene(scene0));
		StackPane stackLayout2= new StackPane() ;
		stackLayout2.getChildren().add(logout);
		scene2 = new Scene(stackLayout2, 600, 300);
		
		primaryStage.setScene(scene0);
		primaryStage.show();
		primaryStage.setTitle("Login");
		primaryStage.setAlwaysOnTop(true);
	}
}
