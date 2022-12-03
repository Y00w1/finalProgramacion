package com.example.finalprogrmacion.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Session {
    private String name;
    private Trainer trainer;
    private List<Exercise> exercises;
    private List<Member> members;
    private LocalDate day;
    private LocalTime time;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
    public LocalDate getDay() {
        return day;
    }
    public void setDay(LocalDate day) {
        this.day = day;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Session(String name, Trainer trainer, List<Exercise> exercises, List<Member> members, LocalDate day, LocalTime time) {
        this.name = name;
        this.trainer = trainer;
        this.exercises = exercises;
        this.members = members;
        this.day = day;
        this.time = time;
    }

    public Session() {}
}
