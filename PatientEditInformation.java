//package com.example.demo1;

//declares imports
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
import javafx.scene.control.ComboBox;
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

public class PatientEditInformation extends Application {

	//Sets up variables for the textfields which the patient would need to edit
    private TextField nameTF, emailTF, DOBTF, phoneNumTF;
    private TextField pharmacyNameTF, pharmacyAddressTF, pharmacyPhoneNumTF;
    private TextField insuranceNameTF, insuranceGroupNumTF, insurancePhoneNumTF;
    private TextField emergencyPhoneTF;
    private ComboBox<String> gender;
    private Stage stageEdit;
    
    public void start(Stage primaryStage) {

        //Sets text at top of screens
	    //Builds stage and gives welcome text as title, then changes font and size and sets up the welcome box
    	stageEdit = primaryStage;
        Text sceneTitle1 = new Text("Welcome");
        sceneTitle1.setFont(Font.font("Tacoma", FontWeight.NORMAL, 20));
        HBox welcomeBox1 = new HBox(10);
        welcomeBox1.setAlignment(Pos.TOP_CENTER);
        welcomeBox1.getChildren().add(sceneTitle1);

        //Initialize labels, textfields, prompts, and size for contact info
        Label contactLabel = new Label("Contact Information");

	    //Builds labels and sets size and prompt text, also sets up text fields
        Label name = new Label("               Name:");
        nameTF = new TextField();
        nameTF.setPromptText("John Doe");
        nameTF.setMaxWidth(200);

        Label DOB = new Label("    Date of Birth:");
        DOBTF = new TextField();
        DOBTF.setPromptText("3/12/2000");
        DOBTF.setMaxWidth(200);

        Label email = new Label("                Email:");
        emailTF = new TextField();
        emailTF.setPromptText("xxxxxxx@gmail.com");
        emailTF.setMaxWidth(200);

        Label phoneNum = new Label("Phone Number:");
        phoneNumTF = new TextField();
        phoneNumTF.setPromptText("(XXX)-XXX-XXXX");
        phoneNumTF.setMaxWidth(200);
        

        //setup of Emergency Info
        Label emergPhoneNum = new Label("Emergency Phone Number:");
        emergencyPhoneTF = new TextField();
        emergencyPhoneTF.setPromptText("(XXX)-XXX-XXXX");
        emergencyPhoneTF.setMaxWidth(200);

        //Gender
        gender = new ComboBox<String>();
        gender.setPromptText("Gender");
        gender.getItems().addAll("Male","Female");
        
        //Initialize labels, textfields, prompts, and size for Pharmacy info
        Label pharmacyLabel = new Label("Pharmacy Information");

        Label pharmacyName = new Label("               Name:");
        pharmacyNameTF = new TextField();
        pharmacyNameTF.setPromptText("CVS Pharmacy");
        pharmacyNameTF.setMaxWidth(200);

        Label pharmacyAddress = new Label("            Address:");
        pharmacyAddressTF = new TextField();
        pharmacyAddressTF.setPromptText("1234 Address Lane, Phoenix, AZ");
        pharmacyAddressTF.setMaxWidth(200);

        Label pharmacyPhoneNum = new Label("Phone Number:");
        pharmacyPhoneNumTF = new TextField();
        pharmacyPhoneNumTF.setPromptText("(XXX)-XXX-XXXX");
        pharmacyPhoneNumTF.setMaxWidth(200);


        //Initialize labels, textfields, prompts, and size for insurance info
        Label insuranceInformation = new Label("Insurance Information");

        Label insuranceName = new Label("               Name:");
        insuranceNameTF = new TextField();
        insuranceNameTF.setPromptText("UMR");
        insuranceNameTF.setMaxWidth(200);

        Label insuranceGroupNum = new Label("Group Number:");
        insuranceGroupNumTF = new TextField();
        insuranceGroupNumTF.setPromptText("XXXXXXXX");
        insuranceGroupNumTF.setMaxWidth(200);

        Label insurancePhoneNum = new Label("Phone Number:");
        insurancePhoneNumTF = new TextField();
        insurancePhoneNumTF.setPromptText("(XXX)-XXX-XXXX");
        insurancePhoneNumTF.setMaxWidth(200);

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
        TableColumn firstNameCol = new TableColumn();
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
        HBox emergencyPhoneBox = new HBox(5);
        HBox genderBox = new HBox(5);
        
        HBox pharmNameBox = new HBox(5);
        HBox pharmAddressBox = new HBox(5);
        HBox pharmPhoneBox = new HBox(5);

        HBox insuranceNameBox = new HBox(5);
        HBox insuranceGroupBox = new HBox(5);
        HBox insurancePhoneBox = new HBox(5);

        //adding to button boxes
        saveBox.setAlignment(Pos.BOTTOM_RIGHT);
        saveBox.getChildren().add(saveChanges);
        cancelBox.setAlignment(Pos.BOTTOM_CENTER);
        cancelBox.getChildren().add(cancel);

        //adding to contact info boxes
        nameBox.getChildren().addAll(name, nameTF);
        DOBBox.getChildren().addAll(DOB, DOBTF);
        emailBox.getChildren().addAll(email, emailTF);
        phoneBox.getChildren().addAll(phoneNum, phoneNumTF);
        emergencyPhoneBox.getChildren().addAll(emergPhoneNum, emergencyPhoneTF);
        genderBox.getChildren().addAll(gender);
        
        pharmNameBox.getChildren().addAll(pharmacyName, pharmacyNameTF);
        pharmAddressBox.getChildren().addAll(pharmacyAddress,pharmacyAddressTF);
        pharmPhoneBox.getChildren().addAll(pharmacyPhoneNum,pharmacyPhoneNumTF);

        insuranceNameBox.getChildren().addAll(insuranceName, insuranceNameTF);
        insuranceGroupBox.getChildren().addAll(insuranceGroupNum,insuranceGroupNumTF);
        insurancePhoneBox.getChildren().addAll(insurancePhoneNum,insurancePhoneNumTF);

        //setup of containers
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_LEFT);
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.setVgap(5);
        pane.setHgap(5);

        //adding everything to the GridPane
        pane.add(welcomeBox1, 1, 0);

        //everything in column 0 (all patient info)
        pane.add(contactLabel, 0, 1);
        pane.add(nameBox, 0, 2);
        pane.add(DOBBox, 0, 3);
        pane.add(emailBox, 0, 4);
        pane.add(phoneBox, 0, 5);
        pane.add(emergencyPhoneBox, 0, 6);
        pane.add(genderBox,0,7);
        pane.add(tableView, 0, 8);

        //everything in column 1 (all pharmacy info)
        pane.add(pharmacyLabel,1,1);
        pane.add(pharmNameBox,1,2);
        pane.add(pharmAddressBox,1,3);
        pane.add(pharmPhoneBox,1,4);

        //everything in column 2 (all insurance info)
        pane.add(insuranceInformation,2,1);
        pane.add(insuranceNameBox,2,2);
        pane.add(insuranceGroupBox,2,3);
        pane.add(insurancePhoneBox,2,4);

        pane.add(cancelBox, 1, 6);
        pane.add(saveBox, 2, 6);

        //sets color of screen
        pane.setStyle("-fx-background-color: #a2f3f5;");

        //EventHandler for saveChanges Button
        EventHandler addInfoHandle = new addInformationHandler();
        saveChanges.setOnAction(addInfoHandle);
        
        //EventHandler for cancel Button
        EventHandler cancelHandle = new cancelHandler();
        cancel.setOnAction(cancelHandle);
        
        //Adding containers to scene
        Scene scene = new Scene(pane, 1000, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Edit Patient Information");
        primaryStage.show();
    }

    private class addInformationHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            Patient newPatient = new Patient(nameTF.getText(),phoneNumTF.getText(),emailTF.getText(),emergencyPhoneTF.getText(),DOBTF.getText(),gender.getValue(),pharmacyNameTF.getText(),pharmacyAddressTF.getText(),pharmacyPhoneNumTF.getText(),insuranceNameTF.getText(), insuranceGroupNumTF.getText(),insurancePhoneNumTF.getText());            
            FileManipulator fm = new FileManipulator();
            try {
				fm.writeFileContentsPatientInfo(newPatient.addPatientInfo());
				AlertBox.display("Success", "Your account was created");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Main mn = new Main();
            try {
				mn.start(stageEdit);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    private class cancelHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            Main mn = new Main();
            try {
				mn.start(stageEdit);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
    }
}
