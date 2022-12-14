package com.example.finalprogrmacion.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LandingController{
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    //Scenes
    @FXML
    void switchToExerciseScene(ActionEvent event)throws IOException {
        mfc.switchToExerciseScene(event);
    }
    @FXML
    void switchToMemberScene(ActionEvent e) throws IOException{
        mfc.switchToMemberScene(e);
    }
    @FXML
    void switchToTrainerScene(ActionEvent e) throws IOException {
        mfc.switchToTrainerScene(e);
    }
    @FXML
    void switchToSessionScene(ActionEvent e) throws IOException{
        mfc.switchToSessionScene(e);
    }
}
