package com.example.finalprogrmacion.controller;

import com.example.finalprogrmacion.service.impl.GymServiceImpl;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ModelFactoryController {
    GymServiceImpl gymService;
    private static class SingletonHolder{
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance(){
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController(){
        gymService = new GymServiceImpl();
    }

    //Functions

    //Scenes buttons
    //Exercise
    public void switchToExerciseScene(ActionEvent event) throws IOException {
        gymService.getSceneService().switchToExerciseScene(event);
    }
    //Member
    public void switchToMemberScene(ActionEvent event) throws IOException {
        gymService.getSceneService().switchToMemberScene(event);
    }
    //Trainer
    public void switchToTrainerScene(ActionEvent event) throws IOException {
        gymService.getSceneService().switchToTrainerScene(event);
    }
    //Session
    public void switchToSessionScene(ActionEvent event) throws IOException {
        gymService.getSceneService().switchToSessionScene(event);
    }

}
