package com.example.createaccount;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class newUser extends Application {

    public void start(Stage primaryStage) {
        //layout for newUser


        //initialize labels
        Label firstName = new Label("First Name:");
        Label lastName = new Label("Last Name:");
        Label DOB = new Label("Date of Birth:");

        //initialize tf, prompts, and size of tf
        TextField tf1 = new TextField();
        tf1.setPromptText("John");
        tf1.setMaxWidth(100);

        TextField tf2 = new TextField();
        tf2.setPromptText("Doe");
        tf2.setMaxWidth(100);

        TextField tf3 = new TextField();
        tf3.setPromptText("6/26/2000");
        tf3.setMaxWidth(100);
        //end of layout


        //add sub-containers to container
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(10);
        Text sceneTitle= new Text("Please Enter the Following Information");
        sceneTitle.setFont(Font.font("Tacoma", FontWeight.NORMAL, 20));
        pane.add(sceneTitle,0,0,2,1);
        pane.setPadding(new Insets(10,10,10,10));

        pane.add(firstName,0,1);
        pane.add(tf1,1,1);

        pane.add(lastName, 2,1);
        pane.add(tf2,3,1);

        pane.add(DOB,0,3);
        pane.add(tf3,1,3);


        //create Cancel button and put on gridpane
        Button cancel = new Button("Cancel");
        HBox cancelBox = new HBox(10);
        cancelBox.setAlignment(Pos.BOTTOM_LEFT);
        cancelBox.getChildren().add(cancel);
        pane.add(cancelBox,1,4);

        Button create = new Button("Create");
        HBox createBox = new HBox(10);
        createBox.setAlignment(Pos.BOTTOM_LEFT);
        createBox.getChildren().add(create);
        pane.add(createBox,2,4);

        pane.setStyle("-fx-background-color: #a2f3f5;");


        //Adding the major container created above to the scene and setting the scene up
        Scene scene = new Scene(pane, 550, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Create Account");
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);}
}