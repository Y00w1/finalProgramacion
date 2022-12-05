package com.example.finalprogrmacion.service;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.validator.InputException;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

import java.io.IOException;

public interface ExerciseService {
    void loadExercises();
    ObservableList<Exercise> fillObLiExercises();
    void createExercise(String id, String name, String calories, String duration)throws IOException, InputException;
    void editExercise(String id, String name, String calories, String duration)throws IOException, InputException;
    void deleteExercise(String id)throws IOException;
    void sortExercise(FilteredList<Member> filteredList, TextField textField);
}
