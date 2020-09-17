package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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

        System.out.println("event fired");
    }

}
