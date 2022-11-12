package com.example.finalprogrmacion.model;

public class MemberDTO {
    private String Name;
    private Double weight;
    private Double height;
    private Integer months;

    public MemberDTO(String name, Double weight, Double height, Integer months) {
        Name = name;
        this.weight = weight;
        this.height = height;
        this.months = months;
    }
}
