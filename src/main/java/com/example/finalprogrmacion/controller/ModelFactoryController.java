package com.example.finalprogrmacion.controller;

import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.service.impl.GymServiceImpl;
import com.example.finalprogrmacion.validator.InputException;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

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
    //Landing
    public void switchToLandingScene(ActionEvent event) throws IOException {
        gymService.getSceneService().switchToLandingScene(event);
    }
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

    //Login
    public void loadAdmins(){
        gymService.getLoginService().loadAdmins();
    }
    public Boolean verifyCredentials(String username, String password){
        return gymService.getLoginService().verifyCredentials(username, password);
    }

    //Members
    public void createMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age) throws IOException, InputException {
        gymService.getMemberService().addMember(ID, name, lastName, email, password, weight, height, age);
    }
    public void loadMembers(){
        gymService.getMemberService().loadMembers();
    }
    public void searchMember(FilteredList<Member> filteredlist, TextField textField){
        gymService.getMemberService().sortByName(filteredlist, textField);
    }
    //Filling the observableList
    public ObservableList<Member> fillObLiMembers(){
        return gymService.getMemberService().fillObLiMembers();
    }
    //Delete
    public void deleteMember(String ID) throws IOException {
        gymService.getMemberService().deleteMember(ID);
    }

}
