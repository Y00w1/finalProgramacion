package com.example.finalprogrmacion.model;

import java.util.List;

public class Session {
    private Trainer trainer;
    private List<Exercise> exercises;
    private List<Member> members;

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

    public Session(Trainer trainer, List<Exercise> exercises, List<Member> members) {
        this.trainer = trainer;
        this.exercises = exercises;
        this.members = members;
    }
}
