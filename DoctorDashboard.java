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
    public void start(Stage stage) throws Exception {
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

        TabPane tabPane = new TabPane();
        Tab checkIn = new Tab("Check In Patients",hBox);
        Tab patients = new Tab("Patients");
        tabPane.getTabs().add(checkIn);
        tabPane.getTabs().add(patients);

        root.setCenter(tabPane);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
