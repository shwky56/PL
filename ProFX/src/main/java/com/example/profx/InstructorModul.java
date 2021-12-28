package com.example.profx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InstructorModul {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane ankholy;


    @FXML
    private Pane DashHeader;

    @FXML
    private Button SignOutButton;

    @FXML
    private ImageView BigLogo1;

    @FXML
    private TableView<?> Table;

    @FXML
    private TableColumn<?, ?> stdNAME;

    @FXML
    private TableColumn<?, ?> stdID;

    @FXML
    private TableColumn<?, ?> coursNAME;

    @FXML
    private TableColumn<?, ?> StdGrade;

    @FXML
    private TableColumn<?, ?> clswrkGRD;

    @FXML
    private TableColumn<?, ?> finalGrade;

    @FXML
    private Pane InstructorInfo;

    @FXML
    private TextField getName;

    @FXML
    private TextField getDepartment;

    @FXML
    private TextField getEmail;

    @FXML
    private TextField getPhone;

    @FXML
    private TextField getAddress;

    @FXML
    private ImageView BigLogo;

    @FXML
    private Button pubButton;

    @FXML
    private Label promptMSG;

    @FXML
    void display(ActionEvent event) {

    }

    @FXML
    void signOut(ActionEvent event) {
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout !");
        alert.setContentText("Do you want to save before exiting");
        if(alert.showAndWait().get()== ButtonType.APPLY.OK) {
            stage=(Stage) ankholy.getScene().getWindow();
            System.out.println("You successfully logged out");
            stage.close();
        }

    }

}