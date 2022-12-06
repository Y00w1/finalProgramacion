package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Trainer;
import com.example.finalprogrmacion.resources.Persistence;
import com.example.finalprogrmacion.service.TrainerService;
import com.example.finalprogrmacion.validator.InputException;
import com.example.finalprogrmacion.validator.InputsVal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrainerServiceImpl implements TrainerService {
    private final InputsVal inpVal = new InputsVal();
    HashMap<String, Trainer> trainers = new HashMap<>();

    public HashMap<String, Trainer> getTrainers() {
        return trainers;
    }

    //Persistence
    @Override
    public void loadTrainers() {
        try{
            trainers = Persistence.loadTrainers();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public ObservableList<Trainer> fillObLiTrainers(){
        ObservableList<Trainer> trainersObList = FXCollections.observableArrayList();
        trainersObList.addAll(trainers.values());
        return trainersObList;
    }

    @Override
    public void createTrainer(String ID, String name, String lastName, String email, String password, String months, String salary) throws InputException, IOException {
        inpVal.intInput(months);
        inpVal.doubleInput(salary);
        inpVal.emptyTrainer(ID, name, lastName, email, password, months, salary);
        trainers.put(ID, new Trainer( ID, name, lastName, email, password, Integer.parseInt(months), Double.parseDouble(salary) ));
        Persistence.saveTrainers(trainers);
    }

    @Override
    public void editTrainer(String ID, String name, String lastName, String email, String password, String months, String salary) throws InputException, IOException {
        inpVal.intInput(months);
        inpVal.doubleInput(salary);
        try{
            inpVal.emptyTrainer(ID, name, lastName, email, password, months, salary);
        }catch (InputException e){
            JOptionPane.showMessageDialog(null, "No pueden quedar campos vacios", "Error", JOptionPane.WARNING_MESSAGE);
        }
        try{
            inpVal.trainerPassword(ID, password, trainers);
        }catch(InputException e){
            JOptionPane.showMessageDialog(null, "La contraseña no se puede modificar", "Error", JOptionPane.WARNING_MESSAGE);
        }

        trainers.replace(ID, new Trainer( ID, name, lastName, email, password, Integer.parseInt(months), Double.parseDouble(salary)));
        Persistence.saveTrainers(trainers);
    }

    @Override
    public void deleteTrainer(String ID) throws IOException {
        trainers.remove(ID);
        Persistence.saveTrainers(trainers);
    }

    @Override
    public void sortTrainer(FilteredList<Trainer> filteredList, TextField textField) {
        textField.textProperty().addListener((prop, old, text)->{
            filteredList.setPredicate(element ->{
                if (text == null || text.isEmpty()) return true;
                String name = element.getName().toLowerCase();
                return name.contains(text.toLowerCase());
            });
        });
    }
}
