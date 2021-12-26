package com.example.profx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CourseHome {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane an;

    @FXML
    private Button instractorB;

    @FXML
    private Button studentB;

    @FXML
    private Button logoutB;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> courseName;

    @FXML
    private TableColumn<?, ?> courseId;

    @FXML
    private TableColumn<?, ?> courseDegree;

    @FXML
    private TableColumn<?, ?> room;

    @FXML
    private TableColumn<?, ?> instructor;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableColumn<?, ?> startDay;

    @FXML
    private TableColumn<?, ?> endDay;

    @FXML
    private TableColumn<?, ?> numberOfDays;

    @FXML
    private TextField courseNameTF;

    @FXML
    private TextField courseIdTF;

    @FXML
    private TextField instructorTF;

    @FXML
    private TextField priceTF;

    @FXML
    private TextField gradesTF;

    @FXML
    private TextField numberOfDaysTF;

    @FXML
    private TextField startDayTF;

    @FXML
    private TextField roomTF;

    @FXML
    private TextField endDayTF;

    @FXML
    private Button createB;

    @FXML
    private Button deleteB;

    @FXML
    private Button updateB;

    @FXML
    void create(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void goToInstrucor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("instructor.fxml"));
        root = loader.load();
        Instructor studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goToStudent(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentCourseModul.fxml"));
        root = loader.load();
        StudentCourseModul studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logOut(ActionEvent event) {
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout !");
        alert.setContentText("Do you want to save before exiting");
        if(alert.showAndWait().get()== ButtonType.APPLY.OK) {
            stage=(Stage) an.getScene().getWindow();
            System.out.println("You successfully logged out");
            stage.close();
        }
    }

    @FXML
    void update(ActionEvent event) {

    }

}
