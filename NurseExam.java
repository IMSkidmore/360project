package application;

//declares all imports
import javafx.geometry.Pos;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class NurseExam extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        //Vertical and horizontal boxes for components
        HBox HRandWeightLabelBox = new HBox();
        HBox HRandWeightTFBox = new HBox();
        HBox  tempandBloodPressureLabelBox= new HBox();
        HBox  tempandBloodPressureTFBox= new HBox();
        HBox  heightLabelBox= new HBox();
        HBox  heightTFBox= new HBox();
        HBox addressBox = new HBox();
        HBox addressTAandButton = new HBox();


        //Initializing the labels and tf
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

        Label healthHistoryLabel = new Label("History");
        TextArea healthHistoryTA = new TextArea();
        healthHistoryTA.setPromptText("Enter previous health issues, previously \nprescribed medication,"
        + " history of \nimmunization, etc...");
        healthHistoryTA.setPrefSize(220,300);
        Label space4 = new Label("                                                        ");


        //Creation of the "Submit" button
        Button submit = new Button("Submit");
        submit.setAlignment(Pos.BASELINE_RIGHT);


        //Adding the components to their respective container, and setting the spaces
        HRandWeightLabelBox.getChildren().addAll(heartLabel,weightLabel);
        HRandWeightTFBox.getChildren().addAll(heartTF,space1,weigthTF);
        tempandBloodPressureLabelBox.getChildren().addAll(tempLabel,pressureLabel);
        tempandBloodPressureTFBox.getChildren().addAll(tempTF,space2,pressureTF);//CHECK AGE of Patient before passing, check in button handler
        heightLabelBox.getChildren().addAll(heightLabel,allergyLabel);
        heightTFBox.getChildren().addAll(heightTF,inchTF,space3,allergyTF);
        addressBox.getChildren().add(healthHistoryLabel);
        addressTAandButton.getChildren().addAll(healthHistoryTA,space4,submit);


        //This is the container that will contain all the sub-containers created above
        GridPane pane = new GridPane();
        pane.setVgap(3);

        pane.add(HRandWeightLabelBox,0,0);
        pane.add(HRandWeightTFBox,0,1);
        pane.add(tempandBloodPressureLabelBox,0,2);
        pane.add(tempandBloodPressureTFBox,0,3);
        pane.add(heightLabelBox,0,4);
        pane.add(heightTFBox,0,5);
        pane.add(addressBox,0,6);
        pane.add(addressTAandButton,0,7);

        pane.setStyle("-fx-background-color: #a2f3f5;");


        //Adding the major container created above to the scene and setting the scene up
        Scene scene = new Scene(pane, 550, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Input Patient Vital Information");
        primaryStage.show();
    }

}
/*
 * if(Patient.getAge() < 12){
 * 
 * Alertbox.setasdfasdglasdlkfnasdl;f
 * 
 * pt.setPressure("N/A")//-1;
 * 
 * }
 */
/*TODO
-Change class so it is a working screen in main
-Impliment this code so it updates the patient object
*/
