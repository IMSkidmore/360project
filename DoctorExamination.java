import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DoctorExamination extends Application {

    private Stage saved;
    private Stage cancelled;
    private EventHandler savee = new saveHandler();
    private EventHandler cancell = new cancelHandler();

    public void start(Stage stage) throws Exception {

        saved = stage;
        cancelled = stage;

        VBox vBox = new VBox(15);
        vBox.setStyle("-fx-background-color: #a2f3f5;");
        Label top = new Label("Examination for (Insert Name here)");
        top.setAlignment(Pos.CENTER);
        top.setStyle("-fx-font-size: 18px");
        Label reflex = new Label("Reflexes");
        reflex.setStyle("-fx-font-size: 18px");
        RadioButton radioButton0 = new RadioButton("0");
        RadioButton radioButton1 = new RadioButton("1");
        RadioButton radioButton2 = new RadioButton("2");
        RadioButton radioButton3 = new RadioButton("3");
        RadioButton radioButton4 = new RadioButton("4");
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(reflex, radioButton0, radioButton1, radioButton2,
                radioButton3, radioButton4);
        Label eyes = new Label("Eye Test:");
        eyes.setStyle("-fx-font-size: 13px");
        TextField eye = new TextField();
        eye.setPromptText("Eye examination results");
        eye.setMaxWidth(250);
        Label ear = new Label("Ear Test:");
        ear.setStyle("-fx-font-size: 13px");
        TextField ears = new TextField();
        ears.setPromptText("Ear examination results");
        ears.setMaxWidth(250);
        TextField throat = new TextField();
        throat.setPromptText("Throat examination results");
        throat.setMaxWidth(250);
        Label throats = new Label("Throat Test:");
        throats.setStyle("-fx-font-size: 13px");
        Label medication = new Label("Prescribe Medication");
        medication.setStyle("-fx-font-size: 13px");
        TextField medi = new TextField();
        medi.setPromptText("Prescription");
        medi.setMaxWidth(250);
        Label summary = new Label("Health History");
        summary.setStyle("-fx-font-size: 13px");
        TextArea history = new TextArea();
        history.setPromptText("Enter Health History");
        Button cancel = new Button("Cancel");
        cancel.setOnAction(cancell);
        Button save = new Button("Save");
        save.setOnAction(savee);

        HBox hBox1 = new HBox(30);
        hBox1.getChildren().addAll(cancel, save);
        hBox1.setAlignment(Pos.CENTER);
        HBox summ = new HBox(30);
        summ.getChildren().addAll(summary, history);

        vBox.getChildren().addAll(top, hBox, summ, eyes, eye, ear, ears, throats, throat, medication, medi, hBox1);
        stage.setScene(new Scene(vBox, 600, 400));
        stage.show();
        stage.setTitle("Doctor Exam");

    }

    public static void main(String[] args) {
        launch(args);
    }

    private class saveHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {

            DoctorDashboard saveDash = new DoctorDashboard();
            try {
                saveDash.start(saved);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class cancelHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {

            DoctorDashboard cancelDash = new DoctorDashboard();
            try {
                cancelDash.start(cancelled);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
