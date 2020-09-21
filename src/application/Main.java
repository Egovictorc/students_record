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
import model.DBClass;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Main extends Application {

    public void connectDb() throws SQLException {
        //Test database connection
        //instantiate the database class
        DBClass dbClass = new DBClass();
        //connect to database
        DBClass.createConnection();
    /*    ResultSet rs = null;
        try {
            rs = dbClass.queryDB();
        } catch (SQLException e) {
            System.out.println("error querying db: " + e.getMessage());
        }
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
    */
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("NIIT Java Project");
        primaryStage.show();

        // call method to connect database connection
        connectDb();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
