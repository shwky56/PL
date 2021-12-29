package com.example.profx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MedoZ extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("adminHome.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("MedoZ");
        stage.setScene(scene);
        Image icon = new Image("images.png") ;
        stage.getIcons().add(icon);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}