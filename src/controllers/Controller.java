package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField firstName,
            lastName,
            city;

    @FXML private Slider age;
    @FXML private DatePicker dob;


    public void initialize() {

    }

    @FXML
    public void onMouseClicked(MouseEvent e) {
        Button btn = (Button)e.getSource();
        String btnText = btn.getText().strip().toLowerCase();
        Scene scene = btn.getScene();
        try {
            Parent recordsUI = FXMLLoader.load(getClass().getResource("/view/records.fxml"));
            switch(btnText) {
                case "records":
                    scene.setRoot(recordsUI);
                    break;
            }

        } catch(IOException x) {
            System.out.println("error getting records ui: "+ x.getMessage());
        }

        System.out.println("event fired");
    }

}
