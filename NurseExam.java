//patient vitals screen for nurse/doctor

package com.example.demo1;

import javafx.scene.control.TextInputDialog;
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

public class nurseExam extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        //Vertical and horizontal boxes for components
        HBox HRandWeightLabelBox = new HBox();
        HBox HRandWeightTFBox = new HBox();
        HBox  tempandBloodPressureLabelBox= new HBox();
        HBox  tempandBloodPressureTFBox= new HBox();
        HBox  HeightLabelBox= new HBox();
        HBox  HeightTFBox= new HBox();


        //Initializing the labels
        Label heartLabel = new Label("Heart Rate");
        TextField heartTF = new TextField();
        heartTF.setPromptText("BPM");
        heartTF.setMaxWidth(150);

        Label weightLabel = new Label("                                                                                         Weight");
        TextField weigthTF = new TextField();
        weigthTF.setPromptText("Lbs");
        weigthTF.setMaxWidth(150);
        Label space1 = new Label("                                                             ");

        Label tempLabel = new Label("Temperature                                                                                      ");
        TextField tempTF = new TextField();
        tempTF.setPromptText("F");
        tempTF.setMaxWidth(150);

        Label pressureLabel = new Label("Blood Pressure");
        TextField pressureTF= new TextField();
        pressureTF.setPromptText("mmHg");
        pressureTF.setMaxWidth(150);
        Label space2 = new Label("                                                             ");

        Label heightLabel = new Label("Height                                                                                               ");
        TextField heightTF = new TextField();
        heightTF.setPromptText("FT");
        heightTF.setMaxWidth(75);
        TextField inchTF = new TextField();
        inchTF.setPromptText("Inches");
        inchTF.setMaxWidth(75);

        Label allergyLabel = new Label("Allergy");
        TextField allergyTF = new TextField();
        allergyTF.setPromptText("Latex,Penicillin,etc.");
        allergyTF.setMaxWidth(150);
        Label space3 = new Label("                                                            ");


        //Creation of the "Submit" button
        Button b = new Button("Submit");


        //Adding the components to their respective container, and setting the spaces
        HRandWeightLabelBox.getChildren().addAll(heartLabel,weightLabel);
        HRandWeightTFBox.getChildren().addAll(heartTF,space1,weigthTF);
        tempandBloodPressureLabelBox.getChildren().addAll(tempLabel,pressureLabel);
        tempandBloodPressureTFBox.getChildren().addAll(tempTF,space2,pressureTF);
        HeightLabelBox.getChildren().addAll(heightLabel,allergyLabel);
        HeightTFBox.getChildren().addAll(heightTF,inchTF,space3,allergyTF);


        //This is the container that will contain all the sub-containers created above
        GridPane pane = new GridPane();
        pane.setVgap(3);

        pane.add(HRandWeightLabelBox,0,0);
        pane.add(HRandWeightTFBox,0,1);
        pane.add(tempandBloodPressureLabelBox,0,2);
        pane.add(tempandBloodPressureTFBox,0,3);
        pane.add(HeightLabelBox,0,4);
        pane.add(HeightTFBox,0,5);

        pane.setStyle("-fx-background-color: #a2f3f5;");

        //Adding the major container created above to the scene and setting the scene up
        Scene scene = new Scene(pane, 550, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Input Patient Vital Information");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

