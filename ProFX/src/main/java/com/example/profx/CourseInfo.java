package com.example.profx;

import javafx.beans.property.*;

public class CourseInfo {
    private StringProperty courseName = new SimpleStringProperty(this,"courseName","");
    public String getCourseName() {
        return courseName.get();
    }
    public StringProperty courseNameProperty() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }

    private StringProperty courseId = new SimpleStringProperty(this,"courseId","");

    public String getCourseId() {
        return courseId.get();
    }

    public StringProperty courseIdProperty() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId.set(courseId);
    }

    public StringProperty courseDegree = new SimpleStringProperty(this,"CourseDegree","");

    public String getCourseDegree() {
        return courseDegree.get();
    }

    public StringProperty courseDegreeProperty() {
        return courseDegree;
    }

    public void setCourseDegree(String courseDegree) {
        this.courseDegree.set(courseDegree);
    }

    public StringProperty room = new SimpleStringProperty(this,"Room","");

    public String getRoom() {
        return room.get();
    }

    public StringProperty roomProperty() {
        return room;
    }

    public void setRoom(String room) {
        this.room.set(room);
    }

    private StringProperty instructor = new SimpleStringProperty(this,"Instructor","");

    public String getInstructor() {
        return instructor.get();
    }

    public StringProperty instructorProperty() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor.set(instructor);
    }

    private StringProperty price = new SimpleStringProperty(this,"Price","");

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    private StringProperty startDay = new SimpleStringProperty(this,"startDay","");

    public String getStartDay() {
        return startDay.get();
    }

    public StringProperty startDayProperty() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay.set(startDay);
    }

    private StringProperty endDay = new SimpleStringProperty(this,"endDay","");

    public String getEndDay() {
        return endDay.get();
    }

    public StringProperty endDayProperty() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay.set(endDay);
    }

    private StringProperty numberOfDays = new SimpleStringProperty(this,"NumberOfDays","");

    public String getNumberOfDays() {
        return numberOfDays.get();
    }

    public StringProperty numberOfDaysProperty() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays.set(numberOfDays);
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "courseName=" + courseName +
                ", courseId=" + courseId +
                ", courseDegree=" + courseDegree +
                ", room=" + room +
                ", instructor=" + instructor +
                ", price=" + price +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", numberOfDays=" + numberOfDays +
                '}';
    }
}

