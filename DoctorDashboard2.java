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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
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
            Button message = new Button("Message");
            message.setOnAction(msgHandle);
            hBox.setPadding(new Insets(10));
            hBox.getChildren().addAll(name,dob,examination,message);
            listView.getItems().add(hBox);

        }

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #a2f3f5;");
        Label top = new Label("Welcome, Dr.(Insert Name here)");
        top.setAlignment(Pos.CENTER);
        top.setStyle("-fx-font-size: 20px");
        root.setTop(top);

        TabPane tabPane = new TabPane();
        Tab checkIn = new Tab("Patients", listView);
        Tab patients = new Tab("Patient History");
        tabPane.getTabs().add(checkIn);
        tabPane.getTabs().add(patients);

        root.setCenter(tabPane);
        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Doctor Dashboard");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    private class examHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {


            Examination newExam = new Examination();
            try {
                newExam.start(examScreen);
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

}