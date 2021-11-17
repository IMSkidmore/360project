//The screen for the actual exam for the doctor. Provides doctor with all necessary options to save information

//Declares all necessary imports
package application;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DoctorExamination extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        
        //builds label  and sets font size, then creates a new label for reflexes and sets that font size as well.
        //Then builds all the radio buttons for the doctor to put in the reflexes of the patient.
        //Also sets up an area for the doctor to input other physical tests.
        VBox vBox = new VBox(15);
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
        Label other = new Label("(Other physcial tests)");
        other.setStyle("-fx-font-size: 16px");
        Button cancel = new Button("Cancel");
        Button save = new Button("Save");

        HBox hBox1 = new HBox(30);
        hBox1.getChildren().addAll(cancel, save);
        hBox1.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(top,hBox,other,hBox1);
        stage.setScene(new Scene(vBox,600,400));
        stage.show();

    }

}
