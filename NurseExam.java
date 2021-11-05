//patient vitals screen for nurse/doctor

package vitalsinformation;

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

public class vitalsinfo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        //Vertical and horizontal boxes for components
        VBox root = new VBox();
        VBox root2 = new VBox();
        HBox root4 = new HBox();


        //Initializing the labels
        Label heartLabel = new Label("Heart Rate");
        Label weightLabel = new Label("Weight");
        Label tempLabel = new Label("Temperature");
        Label pressureLabel = new Label("Blood Pressure");
        Label heightLabel = new Label("Height");

        //Initializing the textfields and setting their prompt text and sizes
        TextField tf1 = new TextField();
        tf1.setPromptText("BPM");
        tf1.setMaxWidth(150);
        TextField tf2 = new TextField();
        tf2.setPromptText("Lbs");
        tf2.setMaxWidth(150);
        TextField tf3 = new TextField();
        tf3.setPromptText("F");
        tf3.setMaxWidth(150);
        TextField tf4 = new TextField();
        tf4.setPromptText("mmHg");
        tf4.setMaxWidth(150);
        TextField tf5 = new TextField();
        tf5.setPromptText("FT");
        tf5.setMaxWidth(100);
        TextField tf6 = new TextField();
        tf6.setPromptText("Inches");
        tf6.setMaxWidth(100);


        //Creation of the "Submit" button
        Button b = new Button("Submit");



        //Adding the components to their respective container, and setting the spaces
        root.getChildren().addAll(heartLabel,tf1,tempLabel,tf3,heightLabel,tf5,tf6);
        root.setSpacing(10);
        root2.getChildren().addAll(weightLabel,tf2,pressureLabel,tf4,b);
        root2.setSpacing(10);
        root4.getChildren().addAll(tf5,tf6);
        root4.setSpacing(5);




        //This is the container that will contain all the sub-containers created above
        GridPane root3 = new GridPane();
        root3.setHgap(150);
        root3.addColumn(0, root);
        root3.addColumn(1, root2);
        root3.addRow(1, root4);
        root3.setStyle("-fx-background-color: #a2f3f5;");

        //Adding the major container created above to the scene and setting the scene up
        Scene scene = new Scene(root3, 550, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Input Patient Vital Information");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

