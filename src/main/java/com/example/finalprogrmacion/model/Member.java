package com.example.finalprogrmacion.model;

public class Member extends User{
    private Double weight;
    private Double height;
    private Integer months;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Member(String ID, String name, String lastName, String email, String password, Double weight, Double height, Integer months) {
        super(ID, name, lastName, email, password);
        this.weight = weight;
        this.height = height;
        this.months = months;
    }
}
