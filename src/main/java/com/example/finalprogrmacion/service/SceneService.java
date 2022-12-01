package com.example.finalprogrmacion.service;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface SceneService {
    void switchScene(ActionEvent e, String resource) throws IOException;
    public void switchToLandingScene(ActionEvent e) throws IOException;
    void switchToExerciseScene(ActionEvent event)throws IOException;
    public void switchToMemberScene(ActionEvent e) throws IOException;
    public void switchToSessionScene(ActionEvent e) throws IOException;
    public void switchToTrainerScene(ActionEvent e) throws IOException;
}
