package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class TableController {
    @FXML private TableView table;

    @FXML private void onMouseClicked(MouseEvent e) {
        Button btn = (Button)e.getSource();
        Scene scene = btn.getScene();

        try {
            Parent main = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
            scene.setRoot(main);
        } catch (IOException x) {
            System.out.println("error loading main ui: "+ x.getMessage());
        }
    }


}
