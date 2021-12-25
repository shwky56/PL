package com.example.course;

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

    @FXML
    private AnchorPane an;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<?, ?> courseDegree;

    @FXML
    private TableColumn<?, ?> courseId;

    @FXML
    private TableColumn<?, ?> courseName;

    @FXML
    private TableColumn<?, ?> examTime;

    @FXML
    private Button instractorB;

    @FXML
    private Button logoutB;

    @FXML
    private Button studentB;

    @FXML
    private TableView<?> table;

    @FXML
    void goToInstracor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Instructor.fxml"));
        root = loader.load();
        Instructor studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goToStudent(ActionEvent event) {

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

}
