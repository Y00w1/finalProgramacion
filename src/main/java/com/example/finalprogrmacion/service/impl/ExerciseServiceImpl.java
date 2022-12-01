package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.service.ExerciseService;

import java.util.ArrayList;
import java.util.List;

public class ExerciseServiceImpl implements ExerciseService {

    List<Exercise> exercises = new ArrayList<Exercise>();

    @Override
    public void createExercise(String id, String name, Double calories, Double duration) {
        exercises.add(new Exercise(id, name, calories, duration));
    }
}
