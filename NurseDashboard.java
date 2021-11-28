package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class NurseDashboard extends Application {

    private Stage stageLogin;
    private ArrayList<Patient> array;
    private ComboBox<String> choosePatient;
    private ListView<HBox> listView;
    private  EventHandler editVHandle;
    private Label name;
    private Patient p;
    private ArrayList<String> indexList;
    private Stage mainStage;

    public void start(Stage primaryStage) throws IOException {
        
        //Logout Button and Handler
        Button logout = new Button("Logout");
        EventHandler logoutt = new cancelHandler();
        logout.setOnAction(logoutt);
        
        //file manipulator object
        FileManipulator fm = new FileManipulator();
        array = fm.readFilePatientInfo();
        indexList = new ArrayList<String>();

        stageLogin = primaryStage;
        mainstage = primaryStage;
        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-color: #a2f3f5;");
        pane.setVgap(20);
        pane.setHgap(20);

        Label welcome = new Label("Welcome!");
        welcome.setStyle("-fx-font-size: 20px");
        Label checkIn = new Label("Check in patient");
        Label checkInNew = new Label("Check in new patient");
        Label checkInExisting = new Label("Check in Chosen Patient");

        //Combo Box code
        choosePatient = new ComboBox<>();
        choosePatient.setPromptText("Choose Patient");

        for (Patient p: array)
        {
            choosePatient.getItems().add(p.getName());
        }

        Button addNew = new Button();
        addNew.setText("Add New Patient");

        Button submitPatient = new Button();
        submitPatient.setText("Check-in Patient");
        EventHandler createNewUser = new CreateNewUser();
        EventHandler submitExistingPatient = new existingPatient();

        submitPatient.setOnAction(submitExistingPatient);
        addNew.setOnAction(createNewUser);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(checkIn, choosePatient);
        VBox vBox1 = new VBox(10);
        vBox1.getChildren().addAll(checkInNew, addNew);
        VBox vbox2 = new VBox(10);
        vbox2.getChildren().addAll(checkInExisting,submitPatient);


        listView = new ListView<>();
        editVHandle = new editVitalsBtn();

        pane.add(welcome,0,0);
        pane.add(vBox,0,1);
        pane.add(vbox2,1,1);
        pane.add(vBox1,2,1);
        pane.add(listView,0,2);
        pane.add(logout,1,2);

        stageLogin.setScene(new Scene(pane,600,400));
        stageLogin.show();
        stageLogin.setTitle("Nurse Dashboard");


        //EventHandler for check in new patient
      

    }//Add Create New Patient button. Replace check in patient Combo box with a button to add whats in the Patient combo box to the table view

    private class CreateNewUser implements EventHandler<ActionEvent> {
       public void handle(ActionEvent e)
       {
        PatientEditInformation pei = new PatientEditInformation();
        pei.start(stageLogin);
       }
    }

    private class existingPatient implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
        	Patient p = null;
            if (!choosePatient.getSelectionModel().isEmpty()) {
                p = Parser.findPatient(choosePatient.getValue(), array);
            }

            HBox hBox = new HBox(10);
            name = new Label(p.getName());
            indexList.add(p.getName());
            Button editButton = new Button("Edit Vitals");
            editButton.setOnAction(editVHandle);
       
            hBox.setPadding(new Insets(10));
            editButton.setId(p.getName());
            hBox.getChildren().addAll(name, editButton);
            listView.getItems().add(hBox);
        }
    }

    private class editVitalsBtn implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
        	Button butt = (Button) e.getTarget();
        	Patient p = null;
            p = Parser.findPatient(butt.getId(), array);
             
            VitalsInfo v = new VitalsInfo(stageLogin, p);
            Scene sceneVitals = new Scene(v);
            try {
                stageLogin.setScene(sceneVitals);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
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
