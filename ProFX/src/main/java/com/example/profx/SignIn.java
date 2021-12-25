package com.example.profx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.InflaterInputStream;

public class SignIn implements Initializable {

    @FXML
    private ChoiceBox<String > choice;

    @FXML
    private Label l1;

    @FXML
    private PasswordField paaswordF;

    @FXML
    private TextField userF;
    @FXML
    private Label l2;

    @FXML
    private Button logInB;
    private String[] role = {"Admin","Instructor","Student"};
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void logIn(ActionEvent event) throws IOException {
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
    void password(ActionEvent event) {

    }
    @FXML
    void userName(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choice.getItems().addAll(role);
        choice.setOnAction(this::getRole);
    }
    public void getRole(ActionEvent actionEvent) {
        String myRole = choice.getValue();
        l2.setText(myRole);
    }
}
