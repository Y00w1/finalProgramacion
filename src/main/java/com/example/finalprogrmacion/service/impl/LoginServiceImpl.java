package com.example.finalprogrmacion.service.impl;

import com.example.finalprogrmacion.model.Admin;
import com.example.finalprogrmacion.resources.Persistence;
import com.example.finalprogrmacion.service.LoginService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServiceImpl implements LoginService{
    Map<String, Admin> admins = new HashMap<>();

    @Override
    public void loadAdmins(){
        admins.put("2", new Admin("2", "dummy", "last", "mail","123"));
        try {
            admins = Persistence.loadAdmins();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean verifyCredentials(String username, String password) {
        for (Admin admin : admins.values()) {
            if (admin.getName().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
