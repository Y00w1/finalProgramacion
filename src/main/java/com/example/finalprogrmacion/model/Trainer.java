package com.example.finalprogrmacion.model;

public class Trainer extends User{
    private Integer months;
    private Double salary;

    public Trainer(String ID, String name, String lastName, String email, String password, Integer months, Double salary) {
        super(ID, name, lastName, email, password);
        this.months = months;
        this.salary = salary;
    }
}
