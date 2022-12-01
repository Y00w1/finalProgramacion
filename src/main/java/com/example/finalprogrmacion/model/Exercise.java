package com.example.finalprogrmacion.model;

public class Exercise {
    private String id;
    private String name;
    private Double calories;
    private Double duration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Exercise(String id, String name, Double calories, Double duration) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.duration = duration;
    }
}
