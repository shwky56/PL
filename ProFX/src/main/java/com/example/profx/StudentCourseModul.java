package com.example.profx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentCourseModul {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button backB;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("courseHome.fxml"));
        root = loader.load();
        CourseHome studentCont= loader.getController();
        //Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}

