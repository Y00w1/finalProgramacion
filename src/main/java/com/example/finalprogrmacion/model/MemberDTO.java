package com.example.finalprogrmacion.model;

public class MemberDTO {
    private String ID;
    private String Name;
    private Double weight;
    private Double height;
    private Integer age;

    public MemberDTO(String ID, String name, Double weight, Double height, Integer age) {
        this.ID = ID;
        this.Name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }
}
