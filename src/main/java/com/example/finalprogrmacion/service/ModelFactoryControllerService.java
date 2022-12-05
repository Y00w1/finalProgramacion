package com.example.finalprogrmacion.service;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Trainer;
import com.example.finalprogrmacion.validator.InputException;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public interface ModelFactoryControllerService {
    //Scenes
    void switchToLandingScene(ActionEvent event) throws IOException;
    void switchToExerciseScene(ActionEvent event) throws IOException;
    void switchToMemberScene(ActionEvent event) throws IOException;
    void switchToTrainerScene(ActionEvent event) throws IOException;
    void switchToSessionScene(ActionEvent event) throws IOException;
    //Admins
    void loadAdmins();
    Boolean verifyCredentials(String username, String password);

    //Members
    void createMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age) throws IOException, InputException;
    void deleteMember(String ID) throws IOException;
    void editMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age) throws InputException, IOException;
    void loadMembers();
    void searchMember(FilteredList<Member> filteredList, TextField textField);
    ObservableList<Member> fillObLiMembers();

    //Exercises
    ObservableList<Exercise> fillObLiExercises();
    void loadExercises();
    void createExercise(String id, String name, String calories, String duration) throws InputException, IOException;
    void editExercise(String id, String name, String calories, String duration) throws InputException, IOException;
    void deleteExercise(String id) throws IOException;
    void sortExercise(FilteredList<Exercise> filteredList, TextField textField);

    //Trainer
    ObservableList<Trainer> fillObLiTrainers();
    void loadTrainers();
    void createTrainer(String ID, String name, String lastName, String email, String password, String months, String salary)throws  InputException, IOException;
    void editTrainer(String ID, String name, String lastName, String email, String password, String months, String salary)throws InputException, IOException;
    void deleteTrainer(String ID) throws IOException;
    void sortTrainer(FilteredList<Trainer> filteredList, TextField textField);
}
