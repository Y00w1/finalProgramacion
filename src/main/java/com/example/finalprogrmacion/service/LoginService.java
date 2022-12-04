package com.example.finalprogrmacion.service;

public interface LoginService {
    public void loadAdmins();
    Boolean verifyCredentials(String username, String password);
}
