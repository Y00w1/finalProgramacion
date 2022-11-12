package com.example.finalprogrmacion.controller;

import com.example.finalprogrmacion.service.impl.GymServiceImpl;

public class ModelFactoryController {
    GymServiceImpl gymService;
    private static class SingletonHolder{
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance(){
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController(){
        gymService = new GymServiceImpl();
    }
}
