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

public class StudentCourse {


    @FXML
    private Button backB;

    @FXML
    private Button updateB;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> courseName;

    @FXML
    private TableColumn<?, ?> courseId;

    @FXML
    private TableColumn<?, ?> CourseDegree;

    @FXML
    private TableColumn<?, ?> examTime;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student.fxml"));
        root = loader.load();
        Student studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void update(ActionEvent event) {
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Updated");
        alert.setHeaderText("Your data has been updated successfully !");
        alert.setContentText("You successfully updated");
        if(alert.showAndWait().get()== ButtonType.APPLY.OK) {
            System.out.println("You successfully updated");
        }

    }

}
