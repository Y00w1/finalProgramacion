package com.example.finalprogrmacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GymApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GymApplication.class.getResource("LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1030, 620);
        stage.setTitle("Gimnasio los vigas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}