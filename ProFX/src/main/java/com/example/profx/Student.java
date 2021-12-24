package com.example.profx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Student implements Initializable {

    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button profile;

    @FXML
    private Button course;

    @FXML
    private Button logOutB;
    //go to profile
    @FXML
    void goToProfile(ActionEvent event) {

    }
    //go to course

    private Stage stageB;
    private Scene sceneB;
    private Parent rootB;
    @FXML
    void gotToCourse(ActionEvent event) throws IOException {
       /* FXMLLoader loader = new FXMLLoader(getClass().getResource("course.fxml"));
        rootB = loader.load();
        Student studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stageB = (Stage) ((Node)event.getSource()).getScene().getWindow();
        sceneB = new Scene(rootB);
        stageB.setScene(sceneB);
        stageB.show();*/
    }
    //Table
    @FXML
    private TableView<StudentInfo> table;

    @FXML
    private TableColumn<StudentInfo, String> courseName;

    @FXML
    private TableColumn<StudentInfo, String> courseId;

    @FXML
    private TableColumn<StudentInfo, Integer> yourCourseGrade;
    @FXML
    private TableColumn<StudentInfo, Integer> maxCourseGrade;

    @FXML
    private TableColumn<StudentInfo, Integer> examTime;
    ObservableList<StudentInfo>list = FXCollections.observableArrayList(
            new StudentInfo("Math","MT",97,100,3),
            new StudentInfo("Operation Research","OR",92,100,2),
            new StudentInfo("Informaton System","IS",95,100,2),
            new StudentInfo("Internet Tchnology","IT",94,100,2),
            new StudentInfo("Programing Language","PL",95,100,2)

    );

    Stage stage;
    @FXML
    void logOut(ActionEvent event) {
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout !");
        alert.setContentText("Do you want to save before exiting");
        if(alert.showAndWait().get()== ButtonType.APPLY.OK) {
            stage=(Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully logged out");
            stage.close();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseName.setCellValueFactory(new PropertyValueFactory<StudentInfo,String>("courseName"));
        courseId.setCellValueFactory(new PropertyValueFactory<StudentInfo,String>("courseId"));
        yourCourseGrade.setCellValueFactory(new PropertyValueFactory<StudentInfo,Integer>("yourCourseGrade"));
        maxCourseGrade.setCellValueFactory(new PropertyValueFactory<StudentInfo,Integer>("maxCourseGrade"));
        examTime.setCellValueFactory(new PropertyValueFactory<StudentInfo,Integer>("examTime"));

        table.setItems(list);
    }

    public void goToCousre(ActionEvent actionEvent) {
    }
}