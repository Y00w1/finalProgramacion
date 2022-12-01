package com.example.finalprogrmacion.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


import javafx.event.ActionEvent;

import java.io.IOException;

public class LandingController {

    @FXML
    private Button btnExercises;

    @FXML
    private Button btnMembers;

    @FXML
    private Button btnSessions;

    @FXML
    private Button btnTrainers;

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
