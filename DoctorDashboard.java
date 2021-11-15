package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DoctorDashboard extends Application {
	@Override
    public void start(Stage stage){
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #a2f3f5;");
        Label top = new Label("Welcome, Dr.(Insert Name here)");
        top.setAlignment(Pos.CENTER);
        top.setStyle("-fx-font-size: 20px");
        root.setTop(top);

        HBox hBox = new HBox(15);
        Label name = new Label("Patient Name");
        Label dob = new Label("Date of birth: (mm/dd/yyyy)");
        Button examination = new Button("New Examination");
        Button records = new Button("View Records");
        Button message = new Button("Message");

        hBox.setPadding(new Insets(10));
        examination.setPrefHeight(80);
        records.setPrefHeight(80);
        message.setPrefHeight(80);
        hBox.getChildren().addAll(name,dob,examination,records,message);
	    
	//Creates the grid pane for the patient history tab
        GridPane PH_Table = new GridPane();
        PH_Table.setBorder(new Border(new BorderStroke[2]));
	
	//Gets the data of the patients
	FileManipulator FM = new FileManipulator();
        
        ArrayList<Patient> data = null;
		try {
			data = FM.readFilePatientInfo();
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
	
	//Scroll pane in case of larger tables
        ScrollPane PH_Scroll = new ScrollPane(PH_Table);
        PH_Scroll.setPadding(new Insets(10));
		
	

        TabPane tabPane = new TabPane();
        Tab checkIn = new Tab("Check In Patients",hBox);
        Tab patients = new Tab("Patients");
	Tab patientHistory = new Tab("Patient History", PH_Scroll);
        tabPane.getTabs().add(checkIn);
        tabPane.getTabs().add(patients);

        root.setCenter(tabPane);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

}
