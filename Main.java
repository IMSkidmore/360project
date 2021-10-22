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

public class Main extends Application {
	private Stage stage;
	private Scene scene0, scene1, scene2;
	private int choice;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		// Layout for which login screen
		VBox selectTypeLayout = new VBox();
		StackPane stackLayout0 = new StackPane();
		selectTypeLayout.setSpacing(8);
		selectTypeLayout.setPadding(new Insets(10, 10, 10, 10));
		Button doctorLogin = new Button("Doctor");
		Button nurseLogin = new Button("Nurse");
		Button patientLogin = new Button("Patient");
		selectTypeLayout.getChildren().addAll(new Label("What would you like to login as:"), doctorLogin, nurseLogin,
				patientLogin);
		stackLayout0.getChildren().addAll(selectTypeLayout);
		scene0 = new Scene(stackLayout0, 400, 600);

		// LoginScreen setup
		LoginScreen loginScreen = new LoginScreen(primaryStage, 400, 600);
		scene1 = new Scene(loginScreen, 400, 600);

		
		// Button action handler events
		doctorLogin.setOnAction(e -> {
			choice = 0;
			primaryStage.setScene(scene1);
		});
		nurseLogin.setOnAction(e -> {
			choice = 1;
			primaryStage.setScene(scene1);
		});
		patientLogin.setOnAction(e -> {
			loginScreen.choice = 2;
			primaryStage.setScene(scene1);
		});

		
		
		
		// layout for scene1
		Button logout = new Button("Logout");
		logout.setOnAction(e -> primaryStage.setScene(scene0));
		StackPane stackLayout2 = new StackPane();
		stackLayout2.getChildren().add(logout);
		scene2 = new Scene(stackLayout2, 600, 300);

		primaryStage.setScene(scene0);
		primaryStage.show();
		primaryStage.setTitle("Login");
		primaryStage.setAlwaysOnTop(false);
	}
}
