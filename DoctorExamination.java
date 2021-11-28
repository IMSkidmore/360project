 package application;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DoctorExamination extends VBox {

    private Stage saved;
    private Stage cancelled;
    private EventHandler savee = new saveHandler();
    private EventHandler cancell = new cancelHandler();
    private RadioButton radioButton0,radioButton1,radioButton2,radioButton3,radioButton4;
    private TextField eye,ears,throat, medi;
    private TextArea history;
    private Patient p;
    public DoctorExamination(Stage stage, Patient input) throws Exception {
    	p = input;
        saved = stage;
        cancelled = stage;

        VBox vBox = new VBox(15);
        vBox.setStyle("-fx-background-color: #a2f3f5;");
        Label top = new Label("Examination for (Insert Name here)");
        top.setAlignment(Pos.CENTER);
        top.setStyle("-fx-font-size: 18px");
        Label reflex = new Label("Reflexes");
        reflex.setStyle("-fx-font-size: 18px");
        radioButton0 = new RadioButton("0");
        radioButton1 = new RadioButton("1");
        radioButton2 = new RadioButton("2");
        radioButton3 = new RadioButton("3");
        radioButton4 = new RadioButton("4");
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(reflex, radioButton0, radioButton1, radioButton2,
                radioButton3, radioButton4);
        Label eyes = new Label("Eye Test:");
        eyes.setStyle("-fx-font-size: 13px");
        eye = new TextField();
        eye.setPromptText("Eye examination results");
        eye.setMaxWidth(250);
        Label ear = new Label("Ear Test:");
        ear.setStyle("-fx-font-size: 13px");
        ears = new TextField();
        ears.setPromptText("Ear examination results");
        ears.setMaxWidth(250);
        throat = new TextField();
        throat.setPromptText("Throat examination results");
        throat.setMaxWidth(250);
        Label throats = new Label("Throat Test:");
        throats.setStyle("-fx-font-size: 13px");
        Label medication = new Label("Prescribe Medication");
        medication.setStyle("-fx-font-size: 13px");
        medi = new TextField();
        medi.setPromptText("Prescription");
        medi.setMaxWidth(250);
        Label summary = new Label("Health History");
        summary.setStyle("-fx-font-size: 13px");
        history = new TextArea();
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

        this.getChildren().addAll(top, hBox, summ, eyes, eye, ear, ears, throats, throat, medication, medi, hBox1);
        stage.setScene(new Scene(vBox, 600, 400));
        stage.show();
        stage.setTitle("Doctor Exam");

    }

    private class saveHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
        	
        	ArrayList<String> examStuff = new ArrayList<String>();
        	examStuff.add(eye.getText());
        	examStuff.add(ears.getText());
        	examStuff.add(throat.getText());
        	examStuff.add(medi.getText());
        	examStuff.add(history.getText());
        	String reflex = null;
            if(radioButton0.isSelected()){
                reflex = "0";
            } else if(radioButton1.isSelected()){
                reflex = "1";
            } else if(radioButton2.isSelected()){
                reflex = "2";
            } else if(radioButton3.isSelected()){
                reflex = "3";
            } else if(radioButton4.isSelected()){
                reflex = "4";
            }

            examStuff.add(reflex);
        	FileManipulator writer = new FileManipulator();
        	try {
				writer.writeFileContentsExam(p.getID(), examStuff);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
