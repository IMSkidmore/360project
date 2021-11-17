//doctor dashboard is the doctors home screen, gives them options to move throughout the system to complete
//their various work tasks.

package application;

//Brings in all necessary imports to properly run the dashboard
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class DoctorDashboard extends Application {

	//declares variables patientlist and primStage which is the primary stage for display purposes.
    private ArrayList<Patient> patientlistt;
    private Stage primStage;

    public void start(Stage stage) throws Exception {

	    // sets up new filemanipulator builds arraylists to track information
        FileManipulator fm = new FileManipulator();
        patientlistt = fm.readFilePatientInfo();
        ArrayList<String> patientlist = new ArrayList<String>();
        ArrayList<String> dobs = new ArrayList<String>();
        ListView<HBox> listView = new ListView<>();
        
	//For loop to build patients
        for (Patient p : patientlistt){

            HBox hBox = new HBox(10);
            Label name = new Label(p.getName());
            Label dob = new Label("Date of birth: " + p.getDob());
            Button examination = new Button("New Examination");
            Button message = new Button("Message");
            hBox.setPadding(new Insets(10));
            hBox.getChildren().addAll(name,dob,examination,message);
            listView.getItems().add(hBox);

        }
        
        //Creates the grid pane for the patient history tab
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
        	tempBTN.setOnAction(new EventHandler<ActionEvent>() {
        	    @Override public void handle(ActionEvent e) {
        	    	Button numberButton = (Button) e.getTarget();
        	        int index = Integer.parseInt(numberButton.getId());
        	        System.out.println(index);
        	    }
        	});
        	
        	//Adds the data to the grid pane
        	PH_Table.add(new Text(data.get(i).name), 0, i + 1);
        	
        	PH_Table.add(new Text("    " + data.get(i).dob), 1, i + 1);
        	PH_Table.add(tempBTN, 2, i + 1);
        }
        
        //Scroll pane in case of larger tables
        ScrollPane PH_Scroll = new ScrollPane(PH_Table);
        PH_Scroll.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #a2f3f5;");
        Label top = new Label("Welcome, Dr.(Insert Name here)");
        top.setAlignment(Pos.CENTER);
        top.setStyle("-fx-font-size: 20px");
        root.setTop(top);

        TabPane tabPane = new TabPane();
        Tab checkIn = new Tab("Patients", listView);
        Tab patients = new Tab("Patient History");
        Tab patientHistory = new Tab("Patient History", PH_Scroll);
        tabPane.getTabs().add(checkIn);
        tabPane.getTabs().add(patientHistory);

        root.setCenter(tabPane);
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Doctor Dashboard");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
