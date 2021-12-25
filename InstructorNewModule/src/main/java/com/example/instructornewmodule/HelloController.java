package com.example.instructornewmodule;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ImageView BigLogo;

    @FXML
    private ImageView BigLogo1;

    @FXML
    private Pane DashHeader;

    @FXML
    private Pane InstructorInfo;

    @FXML
    private Button SignOutButton;

    @FXML
    private TableColumn<?, ?> StdGrade;

    @FXML
    private TableView<?> Table;

    @FXML
    private TableColumn<?, ?> clswrkGRD;

    @FXML
    private TableColumn<?, ?> coursNAME;

    @FXML
    private TableColumn<?, ?> finalGrade;

    @FXML
    private TextField getAddress;

    @FXML
    private TextField getDepartment;

    @FXML
    private TextField getEmail;

    @FXML
    private TextField getName;

    @FXML
    private TextField getPhone;

    @FXML
    private Label promptMSG;

    @FXML
    private Button pubButton;

    @FXML
    private TableColumn<?, ?> stdID;

    @FXML
    private TableColumn<?, ?> stdNAME;


    Stage stage ;
    public  void signOut(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign out");
        alert.setHeaderText("You're about to Sign out!");
        alert.setContentText("Do you want to Sign out?");

        if(alert.showAndWait().get() == ButtonType.OK){
        stage = (Stage) DashHeader.getScene().getWindow();
        stage.close();}
    }

    public void display(ActionEvent event) {
        promptMSG.setText("Your grades published successfully.");
    }
}


