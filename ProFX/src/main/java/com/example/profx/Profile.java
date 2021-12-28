package com.example.profx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Profile {

    @FXML
    private Button updateB;

    @FXML
    private Button backB;

    @FXML
    private TextField nameF;

    @FXML
    private TextField addressF;

    @FXML
    private TextField phoneF;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void toHome(ActionEvent event) throws IOException {
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
    void updateProfile(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Updated");
        alert.setHeaderText("Your data has been updated successfully !");
        alert.setContentText("You successfully updated");
        if (alert.showAndWait().get() == ButtonType.APPLY.OK) {
            System.out.println("You successfully updated");
        }
    }

}
