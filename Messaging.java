//Messaging screen, pulls up the screen for anyone interacting with the system to send a message to anyone within the system.

//package com.example.messaging;

//declares all imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
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

public class HelloApplication extends Application {

    //All variables declared to set up text fields then a text area for message so it can be long, then sets up stage
    private TextField recipientTF;
    private TextField subjectTF;
    private TextArea messageTF;
    private Stage stageMessage;

    public void start(Stage primaryStage) {

        //sets up the title for the scene and changes the font and size then orients it correctly
        stageMessage = primaryStage;
        Text sceneTitle1 = new Text("Messaging");
        sceneTitle1.setFont(Font.font("Tacoma", FontWeight.NORMAL, 20));
        HBox welcomeBox1 = new HBox(10);
        welcomeBox1.setAlignment(Pos.TOP_CENTER);
        welcomeBox1.getChildren().add(sceneTitle1);

        //Sets up all the labels and text fields for the recipient,subject, and message
        Label recipientLabel = new Label("Recipient\n");
        recipientTF = new TextField();
        recipientTF.setPromptText("Doctor John Doe");
        recipientTF.setMaxWidth(200);

        Label subjectLabel = new Label("Subject   \n");
        subjectTF = new TextField();
        subjectTF.setPromptText("Reason for message");
        subjectTF.setMaxWidth(200);

        Label messageLabel = new Label("Message\n");
        messageTF = new TextArea();
        messageTF.setPromptText("...");
        messageTF.setPrefWidth(300);
        messageTF.setPrefHeight(500);
        messageTF.setWrapText(true);

        //sets up send and cancel buttons
        Button send = new Button("Send");
        Button cancel = new Button("Cancel");

        VBox sendBox = new VBox();

        HBox recipientBox = new HBox(5);
        HBox subjectBox = new HBox(5);
        HBox messageBox = new HBox(5);

        sendBox.setAlignment((Pos.BOTTOM_RIGHT));
        sendBox.getChildren().add(send);

        recipientBox.getChildren().addAll(recipientLabel, recipientTF);
        subjectBox.getChildren().addAll(subjectLabel, subjectTF);
        messageBox.getChildren().addAll(messageLabel, messageTF);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_LEFT);
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.setVgap(5);
        pane.setHgap(5);

        pane.add(welcomeBox1, 1, 0);
    
        //adds boxes
        pane.add(recipientBox,0,1);
        pane.add(subjectBox,0,2);
        pane.add(messageBox,0,3);
        pane.add(sendBox,1,6);

        //sets color
        pane.setStyle("-fx-background-color: #a2f3f5;");

        //actially builds scene and displays everything
        Scene scene = new Scene(pane, 1000, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Messaging");
        primaryStage.show();

    }
}
