package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.Trainer;
import com.example.finalprogrmacion.service.TrainerService;

import java.util.ArrayList;
import java.util.List;

public class TrainerServiceImpl implements TrainerService {
    List<Trainer> trainers = new ArrayList<Trainer>();

    @Override
    public void createTrainer(String ID, String name, String lastName, String email, String password, Integer months, Double salary) {
        trainers.add(new Trainer(ID, name, lastName, email, password, months, salary));
    }
}
