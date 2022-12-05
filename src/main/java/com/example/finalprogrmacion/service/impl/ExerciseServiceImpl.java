package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.resources.Persistence;
import com.example.finalprogrmacion.service.ExerciseService;
import com.example.finalprogrmacion.validator.InputException;
import com.example.finalprogrmacion.validator.InputsVal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseServiceImpl implements ExerciseService {
    private final InputsVal inpVal = new InputsVal();
    HashMap<String, Exercise> exercises = new HashMap<>();
//Persistence
    @Override
    public void loadExercises() {
        try{
            exercises = Persistence.loadExercises();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<Exercise> fillObLiExercises() {
        ObservableList<Exercise> exercisesObList = FXCollections.observableArrayList();
        exercisesObList.addAll(exercises.values());
        return exercisesObList;
    }

    //CRUD
    //Create
    @Override
    public void createExercise(String id, String name, String calories, String duration) throws IOException, InputException {
        inpVal.doubleInput(calories);
        inpVal.doubleInput(duration);
        exercises.put(id, new Exercise(id, name, Double.parseDouble(calories), Double.parseDouble(duration)));
    }

    //Edit
    @Override
    public void editExercise(String id, String name, String calories, String duration) throws IOException, InputException {
        inpVal.doubleInput(calories);
        inpVal.doubleInput(duration);
        exercises.replace(id, new Exercise(id, name, Double.parseDouble(calories), Double.parseDouble(duration)));
        Persistence.saveExercises(exercises);
    }

    //Delete
    @Override
    public void deleteExercise(String id) throws IOException {
        exercises.remove(id);
        Persistence.saveExercises(exercises);
    }

    //Sort
    @Override
    public void sortExercise(FilteredList<Member> filteredList, TextField textField) {
        textField.textProperty().addListener((prop, old, text)->{
            filteredList.setPredicate(element ->{
                if (text == null || text.isEmpty()) return true;
                String name = element.getName().toLowerCase();
                return name.contains(text.toLowerCase());
            });
        });
    }
}
