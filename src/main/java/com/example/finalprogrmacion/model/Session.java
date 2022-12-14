package com.example.finalprogrmacion.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class Session {
    private Integer ID;
    private String name;
    private Trainer trainer;
    private String trainerName;
    private HashMap<String, Exercise> exercises;
    private HashMap<String, Member> members;
    private LocalDate day;
    private String time;
    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Trainer getTrainer() {
        return trainer;
    }
    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public HashMap<String, Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(HashMap<String, Exercise> exercises) {
        this.exercises = exercises;
    }

    public HashMap<String, Member> getMembers() {
        return members;
    }

    public void setMembers(HashMap<String, Member> members) {
        this.members = members;
    }
    public LocalDate getDay() {
        return day;
    }
    public void setDay(LocalDate day) {
        this.day = day;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public Session(Integer ID, String name, Trainer trainer, HashMap<String, Exercise> exercises, HashMap<String, Member> members, LocalDate day, String time) {
        this.ID = ID;
        this.name = name;
        this.trainer = trainer;
        this.trainerName = trainer.getName();
        this.exercises = exercises;
        this.members = members;
        this.day = day;
        this.time = time;
    }

    public Session() {}
}
