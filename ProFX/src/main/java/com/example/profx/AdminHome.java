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

public class AdminHome implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane adminAncher;
    @FXML
    private Button addStudentB;

    @FXML
    private Button addInstructorB;

    @FXML
    private Button addCourseB;

    @FXML
    private Button logOutB;

    @FXML
    private TableView<AdminHomeInfo> table;

    @FXML
    private TableColumn<AdminHomeInfo, String> name;

    @FXML
    private TableColumn<AdminHomeInfo, String> id;

    @FXML
    void addCourse(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("courseHome.fxml"));
        root = loader.load();
        CourseHome studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void addInstructor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addInstructor.fxml"));
        root = loader.load();
        AddInstructor studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void addStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addStudent.fxml"));
        root = loader.load();
        AddStudent studentCont= loader.getController();
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
            stage=(Stage) adminAncher.getScene().getWindow();
            System.out.println("You successfully logged out");
            stage.close();
        }

    }
    ObservableList<AdminHomeInfo>list= FXCollections.observableArrayList(
            new AdminHomeInfo("                                 Ahmed Mohamed Fathy",       "                                    202000075"),
            new AdminHomeInfo("                                 Mohamed Hassan Abd-Elhay",  "                                    202000743"),
            new AdminHomeInfo("                                 Mahmoud Ezzat Abdul-naby",  "                                    202000851"),
            new AdminHomeInfo("                                 Mahmoud Mohamed Fawzy",     "                                    202000858"),
            new AdminHomeInfo("                                 Shwky Mohamed Abd_Elrahman","                                    202000455")
    );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<AdminHomeInfo,String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<AdminHomeInfo,String>("id"));
        table.setItems(list);


    }
}


