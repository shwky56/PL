package com.example.profx;

import javafx.beans.property.*;

public class AddStudentInfo {
    private StringProperty firstName = new SimpleStringProperty(this,"firstName","");
    public String getFirstName() {
        return firstName.get();
    }
    public StringProperty firstNameProperty() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    private StringProperty lastName = new SimpleStringProperty(this,"lastName","");
    public String getLastName() {
        return lastName.get();
    }
    public StringProperty lastNameProperty() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public IntegerProperty age = new SimpleIntegerProperty(this,"Age",0);
    public int getAge() {
        return age.get();
    }
    public IntegerProperty ageProperty() {
        return age;
    }
    public void setAge(int age) {
        this.age.set(age);
    }

    public DoubleProperty gpa = new SimpleDoubleProperty(this,"GPA",0.0);
    public double getGpa() {
        return gpa.get();
    }
    public DoubleProperty gpaProperty() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa.set(gpa);
    }

    private StringProperty course = new SimpleStringProperty(this,"Course","");
    public String getCourse() {
        return course.get();
    }
    public StringProperty courseProperty() {
        return course;
    }
    public void setCourse(String course) {
        this.course.set(course);
    }

    private StringProperty gender = new SimpleStringProperty(this,"Gender","");
    public String getGender() {
        return gender.get();
    }
    public StringProperty genderProperty() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender.set(gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", age=" + age +
                ", gpa=" + gpa +
                ", course=" + course +
                ", gender=" + gender +
                '}';
    }
}

