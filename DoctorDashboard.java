package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class DoctorDashboard extends Application {

    private ArrayList<Patient> patientlistt;
    private Stage examScreen;
    private Stage msgScreen;
    private EventHandler msgHandle = new messageHandler();
    private EventHandler examHandle = new examHandler();

    public void start(Stage stage) throws Exception {

        examScreen = stage;
        msgScreen = stage;

        FileManipulator fm = new FileManipulator();
        patientlistt = fm.readFilePatientInfo();
        ArrayList<String> patientlist = new ArrayList<String>();
        ArrayList<String> dobs = new ArrayList<String>();
        ListView<HBox> listView = new ListView<>();

        for (Patient p : patientlistt){

            HBox hBox = new HBox(10);
            Label name = new Label(p.getName());
            Label dob = new Label("Date of birth: " + p.getDob());
            Button examination = new Button("New Examination");
            examination.setOnAction(examHandle);
            examination.setId(p.getName());
            Button message = new Button("Message");
            message.setOnAction(msgHandle);
            hBox.setPadding(new Insets(10));
            hBox.getChildren().addAll(name,dob,examination,message);
            listView.getItems().add(hBox);

        }
        //================================================
        GridPane PH_Table = new GridPane();
        PH_Table.setBorder(new Border(new BorderStroke[2]));
        

        
        ArrayList<Patient> data = null;
		try {
			data = fm.readFilePatientInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PH_Table.add(new Text("Patient Name    "), 0, 0);
		PH_Table.add(new Text("    Date of Birth    "), 1, 0);
 
		//Populates the history buttons in the chart
        for(int i = 0; i < data.size(); i++)
        {
        	Button tempBTN = new Button("History");
        	tempBTN.setId(String.valueOf(i));
        	EventHandler historyHandle = new HistoryHandler();
        	tempBTN.setOnAction(historyHandle);
        	
        	//Adds the data to the grid pane
        	PH_Table.add(new Text(data.get(i).name), 0, i + 1);
        	
        	PH_Table.add(new Text("    " + data.get(i).dob), 1, i + 1);
        	PH_Table.add(tempBTN, 2, i + 1);
        }
        
        //Scroll pane in case of larger tables
        ScrollPane PH_Scroll = new ScrollPane(PH_Table);
        PH_Scroll.setPadding(new Insets(10));
        //===============================================
        
        Button cancel = new Button("Cancel");
        EventHandler cancelHandle = new CancelHandler();
        cancel.setOnAction(cancelHandle);

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #a2f3f5;");
        Label top = new Label("Welcome, Doctor                                                                      ");
        HBox topBox = new HBox();
        topBox.getChildren().addAll(top, cancel);
        top.setAlignment(Pos.TOP_RIGHT);
        top.setStyle("-fx-font-size: 20px");
        root.setTop(topBox);

        TabPane tabPane = new TabPane();
        Tab checkIn = new Tab("Patients", listView);
        Tab patients = new Tab("Patient History", PH_Scroll);
        tabPane.getTabs().add(checkIn);
        tabPane.getTabs().add(patients);

        root.setCenter(tabPane);
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Doctor Dashboard");
        stage.show();
    }


    private class examHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {

        	Button butty = (Button) event.getTarget();
        	Patient p = Parser.findPatient(butty.getId(), patientlistt);
            DoctorExamination newExam = null;
			try {
				newExam = new DoctorExamination(examScreen, p);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            Scene sc = new Scene(newExam);
            try {
            	examScreen.setScene(sc);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class messageHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {


            Messaging newMsg = new Messaging();

            try {
                newMsg.start(msgScreen);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private class CancelHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            Main mn = new Main();
            try {
				mn.start(examScreen);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
    }
    private class HistoryHandler implements EventHandler<ActionEvent>
    {
		public void handle(ActionEvent event) 
		{
			Button numberButton = (Button) event.getTarget();
	        int index = Integer.parseInt(numberButton.getId());
	        System.out.println("Selected history for patient at index " + index);
	        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	        //Add the stage opener for the history viewer here
	        //The index of the selected patient is the index variable
	        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			
		}
    	
    }

}
