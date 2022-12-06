package com.example.finalprogrmacion.service;

import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Trainer;
import com.example.finalprogrmacion.validator.InputException;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;

public interface TrainerService {
    HashMap<String, Trainer> getTrainers();
    void loadTrainers();
    ObservableList<Trainer> fillObLiTrainers();
    void createTrainer(String ID, String name, String lastName, String email, String password, String months, String salary)throws InputException, IOException;
    void editTrainer(String ID, String name, String lastName, String email, String password, String months, String salary)throws InputException, IOException;
    void deleteTrainer(String ID) throws IOException;
    void sortTrainer(FilteredList<Trainer> filteredList, TextField textField);
}
