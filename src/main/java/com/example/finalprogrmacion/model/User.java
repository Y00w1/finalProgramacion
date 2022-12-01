package com.example.finalprogrmacion.model;

public class User {
    private String ID;
    private String name;
    private String lastName;
    private String Email;
    private String Password;

    public User() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(String ID, String name, String lastName, String email, String password) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        Email = email;
        Password = password;
    }
}
