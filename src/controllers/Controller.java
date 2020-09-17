package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class Controller {
    @FXML private ChoiceBox choiceBox;


    public void initialize() {
    choiceBox.getItems().addAll("item 1", "item 2", "item 3");
        System.out.println();
    }


}
