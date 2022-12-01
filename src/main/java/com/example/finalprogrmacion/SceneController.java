package com.example.finalprogrmacion;

import com.example.finalprogrmacion.controller.ModelFactoryController;
import com.example.finalprogrmacion.service.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController implements SceneService {
    private Stage stage;
    private Scene scene;
    private Parent root;

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    public void switchScene(ActionEvent e, String resource) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(resource)));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root, 1030, 620);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToLandingScene(ActionEvent e) throws IOException {
        switchScene(e,"Landing.fxml");
    }
    public void switchToExerciseScene(ActionEvent e) throws IOException {
        switchScene(e,"Exercise.fxml");
    }
    public void switchToMemberScene(ActionEvent e) throws IOException {
        switchScene(e,"Member.fxml");
    }
    public void switchToSessionScene(ActionEvent e) throws IOException {
        switchScene(e,"Session.fxml");
    }
    public void switchToTrainerScene(ActionEvent e) throws IOException {
        switchScene(e,"Trainer.fxml");
    }

}