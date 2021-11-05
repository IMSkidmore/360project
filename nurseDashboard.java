import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Nurse extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-color: #a2f3f5;");
        pane.setVgap(20);
        pane.setHgap(20);

        Label welcome = new Label("Welcome 'Nurse Name here'!");
        welcome.setStyle("-fx-font-size: 20px");
        Label checkIn = new Label("Check in patient");
        Label checkInNew = new Label("Check in new patient");
        ComboBox<String> choosePatient = new ComboBox<>();
        choosePatient.setPromptText("Choose Patient");
        ComboBox<String> addNew = new ComboBox<>();
        addNew.setPromptText("Add new Patient");
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(checkIn, choosePatient);
        VBox vBox1 = new VBox(10);
        vBox1.getChildren().addAll(checkInNew, addNew);

        ListView<HBox> listView = new ListView<>();
        HBox hBox = new HBox(10);
        hBox.getChildren().
                addAll(new Label("Patient 1"), new Button("Edit Vitals"), new Button("Notes"));
        HBox hBox1 = new HBox(10);
        hBox1.getChildren().
                addAll(new Label("Patient 2"), new Button("Edit Vitals"), new Button("Notes"));
        HBox hBox2 = new HBox(10);
        hBox2.getChildren().
                addAll(new Label("Patient 3"), new Button("Edit Vitals"), new Button("Notes"));
        listView.getItems().addAll(hBox, hBox1, hBox2);
        pane.add(welcome,0,0);
        pane.add(vBox,0,1);
        pane.add(vBox1,1,1);
        pane.add(listView,0,2);
        stage.setScene(new Scene(pane,600,400));
        stage.show();

        stage.setTitle("Nurse Dashboard");

    }
    public static void main(String[] args) {
        launch(args);
    }
}
