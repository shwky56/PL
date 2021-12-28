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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentCourse implements Initializable {

    @FXML
    private Label tf1;
    @FXML
    private Button backB;

    @FXML
    private Button updateB;

    @FXML
    private TableView<StudentInfo> table;

    @FXML
    private TableColumn<StudentInfo, String> courseName;

    @FXML
    private TableColumn<StudentInfo, String> courseId;

    @FXML
    private TableColumn<StudentInfo, Integer> CourseDegree;

    @FXML
    private TableColumn<StudentInfo,Integer> examTime;
    @FXML
    private ChoiceBox<String> courseChoice;
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
    ObservableList<StudentInfo>list=FXCollections.observableArrayList();
    @FXML
    void update(ActionEvent event) {
        StudentInfo s1= new StudentInfo(courseChoice.getValue(),courseChoice.getValue(),100,3);
        list.add(s1);
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Updated");
        alert.setHeaderText("Your data has been updated successfully !");
        alert.setContentText("You successfully updated");
        if(alert.showAndWait().get()== ButtonType.APPLY.OK) {
            System.out.println("You successfully updated");
        }
        table.setItems(list);

    }
    private String[] role = {"Math2","Operating System","Algorethim","Simulation"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseChoice.getItems().addAll(role);
        courseChoice.setOnAction(this::getRole);
        courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        CourseDegree.setCellValueFactory(new PropertyValueFactory<>("maxCourseGrade"));
        examTime.setCellValueFactory(new PropertyValueFactory<>("examTime"));
        table.setItems(list);

    }
    public void getRole(ActionEvent actionEvent) {
        String myRole = courseChoice.getValue();
        tf1.setText(myRole);
    }
}
