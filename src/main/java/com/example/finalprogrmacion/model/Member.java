package com.example.finalprogrmacion.model;

public class Member extends User{
    private Double weight;
    private Double height;
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Member(String ID, String name, String lastName, String email, String password, Double weight, Double height, Integer age) {
        super(ID, name, lastName, email, password);
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public Member() {
    }
}
