package com.example.finalprogrmacion.model;

public class Trainer extends User{
    private Integer months;
    private Double salary;
    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Trainer(String ID, String name, String lastName, String email, String password, Integer months, Double salary) {
        super(ID, name, lastName, email, password);
        this.months = months;
        this.salary = salary;
    }
    public Trainer() {}
}
