package com.example.finalprogrmacion.validator;

import com.example.finalprogrmacion.controller.ModelFactoryController;
import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Trainer;

import java.util.HashMap;

public class ClassVal {
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    //Exercise
    //General
    public Exercise valIDExercise(String ID, HashMap<String,Exercise> exercises) throws notFoundExc{
        if (exercises.get(ID) == null){
            throw new notFoundExc("El id no coincide");
        }else {
            return exercises.get(ID);
        }
    }
    //Session
    public void valIDExerSession(String id, HashMap<String, Exercise> exercises)throws notFoundExc{
        if(exercises.get(id) == null){
            throw new notFoundExc("El id no coincide");
        }
    }

    //Member
    //General
    public Member valIDMember(String ID, HashMap<String, Member> members) throws notFoundExc{
        if(members.get(ID) == null){
            throw new notFoundExc("El id no coincide");
        }else{
            return members.get(ID);
        }
    }
    //Session
    public void valIDMembSession(String id, HashMap<String, Member> members ) throws notFoundExc{
        if(members.get(id) == null){
            throw new notFoundExc("El id no coincide");
        }
    }

    //Trainer
    public Trainer valIDTrainer(String ID, HashMap<String, Trainer> trainers ) throws notFoundExc {
        if(trainers.get(ID) == null){
            throw new notFoundExc("El id no coincide");
        }else {
            return trainers.get(ID);
        }
    }
}
