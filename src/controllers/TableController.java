package controllers;

import application.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.DBClass;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class TableController {
    @FXML
    private TableView<Student> table;

    @FXML
    private TableColumn<Student, String> firstName,
            lastName,
            city,
            gender;
    @FXML
    private TableColumn<Student, Integer> age, sn;
    @FXML
    private TableColumn<Student, Date> dob;

    ObservableList<Student> students = FXCollections.observableArrayList();

    public void initialize() {
        Label lbl = new Label("no records available in the database");
        table.setPlaceholder(lbl);
        showRecords();
        System.out.println("initialize");
    }


    private void showRecords() {
        DBClass dbClass = new DBClass();
        //dbClass.createConnection();
        ResultSet rs = null;
        try {
            rs = dbClass.queryDB();

            while(rs.next()) {
                int sn = rs.getInt(1);
                int age = rs.getInt("Age");
                String city = rs.getString("City");
                LocalDate dob =  rs.getDate("DOB").toLocalDate();
                String fname = rs.getString("First_Name");
                String lname = rs.getString("Last_Name");
                String gender = rs.getString("Gender");

                //System.out.println(String.format("sn -> %3d| age -> %3d| city -> %8s| dob -> %10s| fname -> %7s| lname -> %7s| gender -> %6s", sn, age, city, dob, fname, lname, gender ));
                    students.add(new Student(sn, age, city, dob, fname, gender, lname));
            }

            //link table columns
            linkTable();
            table.setItems(students);
            //int age, String city, LocalDate dob, String fname, String gender, String lname
        } catch (SQLException e) {
            System.out.println("error getting students: " + e.getMessage());
        }
    }


    private void linkTable() {
        //link table to Student
        firstName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("firstName")
        );
        lastName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("lastName")
        );
        city.setCellValueFactory(
                new PropertyValueFactory<Student, String>("city")
        );
        age.setCellValueFactory(
                new PropertyValueFactory<Student, Integer>("age")
        );
        dob.setCellValueFactory(
                new PropertyValueFactory<Student, Date>("dob")
        );
        gender.setCellValueFactory(
                new PropertyValueFactory<Student, String>("gender")
        );
        sn.setCellValueFactory(
                new PropertyValueFactory<Student, Integer>("sn")
        );
    }


    @FXML
    private void onMouseClicked(MouseEvent e) {
        Button btn = (Button) e.getSource();
        Scene scene = btn.getScene();

        try {
            Parent main = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
            scene.setRoot(main);
        } catch (IOException x) {
            System.out.println("error loading main ui: " + x.getMessage());
        }
    }
}
