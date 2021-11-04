package application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class patientEditInformation extends Application {

	private TextField nameTF,emailTF,DOBTF,phoneNumTF;
    public void start(Stage primaryStage) {

        //Sets text at top of screen
        Text sceneTitle1 = new Text("Welcome \"Patient Name\"");
        sceneTitle1.setFont(Font.font("Tacoma", FontWeight.NORMAL, 20));
        HBox welcomeBox1 = new HBox(10);
        welcomeBox1.setAlignment(Pos.CENTER_LEFT);
        welcomeBox1.getChildren().add(sceneTitle1);

        //Initialize labels, textfields, prompts, and size
        Label contactLabel = new Label("Contact Information");

        Label name = new Label("Name:               ");
        nameTF = new TextField();
        nameTF.setPromptText("John Doe");
        nameTF.setMaxWidth(200);

        Label DOB = new Label("Date of Birth:    ");
        DOBTF = new TextField();
        DOBTF.setPromptText("3/12/2000");
        DOBTF.setMaxWidth(200);

        Label email = new Label("Email:                ");
        emailTF = new TextField();
        emailTF.setPromptText("xxxxxxx@gmail.com");
        emailTF.setMaxWidth(200);

        Label phoneNum = new Label("Phone Number:");
        phoneNumTF = new TextField();
        phoneNumTF.setPromptText("(XXX)-XXX-XXXX");
        phoneNumTF.setMaxWidth(200);

        //setup of Buttons
        Button saveChanges = new Button("Save Changes");
        Button cancel = new Button("Cancel");

        //setup of Visits Table
        TableView tableView = new TableView();
        Label headerLabel = new Label("Visit(s)");
        VBox headerGraphic = new VBox();
        headerGraphic.setAlignment(Pos.CENTER);
        headerGraphic.getChildren().add(headerLabel);

        //add following after patient is implemented/created
        //         <Patient,String>                               <>
        TableColumn                 firstNameCol = new TableColumn  ();
        firstNameCol.setGraphic(headerGraphic);

        tableView.getColumns().add(firstNameCol);

        //adding elements to their respective Boxes
        
        //Button Boxes
        VBox cancelBox = new VBox();
        VBox saveBox = new VBox();

        //Contact info boxes
        HBox nameBox = new HBox(5);
        HBox DOBBox = new HBox(5);
        HBox emailBox = new HBox(5);
        HBox phoneBox = new HBox(5);

        //adding to button boxes
        saveBox.setAlignment(Pos.BOTTOM_RIGHT);
        saveBox.getChildren().add(saveChanges);
        cancelBox.setAlignment(Pos.BOTTOM_CENTER);
        cancelBox.getChildren().add(cancel);
        
        //adding to contact info boxes
        nameBox.getChildren().addAll(name,nameTF);
        DOBBox.getChildren().addAll(DOB,DOBTF);
        emailBox.getChildren().addAll(email,emailTF);
        phoneBox.getChildren().addAll(phoneNum,phoneNumTF);

        //setup of containers
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_LEFT);
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.setVgap(5);
        pane.setHgap(5);

        //adding everything to the GridPane
        pane.add(welcomeBox1, 0,0);

        pane.add(contactLabel, 0, 1);
        pane.add(nameBox, 0, 2);
        pane.add(DOBBox,0,3);
        pane.add(emailBox,0,4);
        pane.add(phoneBox,0,5);
        pane.add(tableView,0,6);
        pane.add(cancelBox,1,6);
        pane.add(saveBox,2,6);

        //sets color of screen
        pane.setStyle("-fx-background-color: #a2f3f5;");

        //EventHandler for saveChanges Button
		EventHandler addInfoHandle = new addInformationHandler();
		saveChanges.setOnAction(addInfoHandle);
		
        //Adding containers to scene
        Scene scene = new Scene(pane, 550, 275);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Create Account");
        primaryStage.show();
    }
    private class addInformationHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			//Patient newPatient = new Patient(nameTF.getText(),DOBTF.getText(),emailTF.getText(),phoneNumTF.getText());
		
		}
	}
}
