package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
    private SimpleStringProperty city,
            firstName,
            lastName,
            gender;
    private SimpleIntegerProperty sn, age;
    private LocalDate dob;

    public Student(int sn, int age, String city, LocalDate dob, String fname, String gender, String lname) {
        this.sn = new SimpleIntegerProperty(sn);
        this.age = new SimpleIntegerProperty(age);
        this.city = new SimpleStringProperty(city);
        this.firstName = new SimpleStringProperty(fname);
        this.lastName = new SimpleStringProperty(lname);
        this.gender = new SimpleStringProperty(gender);
        this.dob = dob;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public int getAge() {
        return age.get();
    }

    public void setFirstName(String fname) {
        this.firstName.set(fname);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setSn(int sn) {
        this.sn.set(sn);
    }

    public Integer getSn() {
        return sn.get();
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


}
