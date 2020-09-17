package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {

    public FlowPane createFlowPane() {
        FlowPane flow = new FlowPane();

        ObservableList<String> choices = FXCollections.observableArrayList("favorite fruits", "item 1", "item 2", "item 3");
        ChoiceBox<String> choiceBox = new ChoiceBox();
        choiceBox.setValue("items...");
        choiceBox.getItems().addAll(choices);

        choiceBox.getSelectionModel().selectFirst();
        Button submitBtn = new Button("click me!!!");

        /*EventHandler<MouseEvent> handler = new EventHandler<>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("value: " + choiceBox.getValue());
            }
        };
        submitBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        */

        submitBtn.setOnMouseClicked(e -> {
            //choiceBox.setValue("item 1");
            String value = choiceBox.getValue();
            System.out.println("value " + value);
        });

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("option A", "Option B", "Option C");

        flow.getChildren().addAll(choiceBox, submitBtn, comboBox);
        comboBox.getSelectionModel().selectFirst();
        return flow;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/main.fxml") );
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(createFlowPane(), 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
