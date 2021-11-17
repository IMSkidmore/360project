//this is the login screen for the patients, access the usernames and passwords stored in LoginPatients.txt rather than
//employees login text file

package application;

import java.io.BufferedReader;
import java.io.File;
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

public class LoginScreenPatient extends StackPane {
    private TextField username = new TextField();
    private PasswordField password = new PasswordField();
    public int choice;
    private Stage stageLogin;
    private Stage mainStage;

    public LoginScreenPatient(Stage primaryStage, int width, int height) {

        // Layout for login screen
        mainStage = primaryStage;
        stageLogin = primaryStage;
        VBox vBoxLayout1 = new VBox();
        vBoxLayout1.setSpacing(8);
        vBoxLayout1.setPadding(new Insets(10, 10, 10, 10));
        Button login = new Button("Login");
        Button newUser = new Button("New User");
        Button cancel = new Button("Cancel");
        vBoxLayout1.getChildren().addAll(new Label("Username"), username, new Label("Password"), password, login, newUser, cancel);
        this.getChildren().addAll(vBoxLayout1);

        // Event for button login
        EventHandler loginHandle = new ButtonHandler();
        login.setOnAction(loginHandle);

        EventHandler newUserHandle = new NewUserHandler();
        newUser.setOnAction(newUserHandle);

        EventHandler cancelled = new cancelHandler();
        cancel.setOnAction(cancelled);

    }
    private class ButtonHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            try {
                Scanner scanner = new Scanner(new FileReader("src/application/LoginPatients.txt"));
                String line;

                while (scanner.hasNext()) {
                    line = scanner.nextLine();
                    String[] tokens=line.split(",");

                    if (username.getText().equals(tokens[0]) && password.getText().equals(tokens[1])) {
                        //add switch content here
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
            AlertBox.display("Login Error", "Username is incorrect, check capslock");
        }
    } // end of ButtonHandler
    private class NewUserHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event) {
            patientEditInformation pei = new patientEditInformation();
            pei.start(stageLogin);
        }
    }

    private class cancelHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {

            Main cancelDash = new Main();

            try {
                cancelDash.start(mainStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
