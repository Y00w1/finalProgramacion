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
    public Exercise valIDExercise(String ID) throws notFoundExc{
        HashMap<String,Exercise> exercises = mfc.getGymService().getExerciseService().getExercises();
        if (exercises.get(ID) == null){
            throw new notFoundExc("El id no coincide");
        }else {
            return exercises.get(ID);
        }
    }
    //Session
    public void calIDExerSession(String id)throws notFoundExc{
        HashMap<String, Exercise> exercises = mfc.getGymService().getSessionService().getExercisesSession();
        if(exercises.get(id) == null){
            throw new notFoundExc("El id no coincide");
        }
    }

    //Member
    //General
    public Member valIDMember(String ID) throws notFoundExc{
        HashMap<String, Member> members = mfc.getGymService().getMemberService().getMembersHashMap();
        if(members.get(ID) == null){
            throw new notFoundExc("El id no coincide");
        }else{
            return members.get(ID);
        }
    }
    //Session
    public void valIDMmembSession(String id) throws notFoundExc{
        HashMap<String, Member> members = mfc.getGymService().getSessionService().getMembersSession();
        if(members.get(id) == null){
            throw new notFoundExc("El id no coincide");
        }
    }

    //Trainer
    public Trainer valIDTrainer(String ID) throws notFoundExc {
        HashMap<String, Trainer> trainers = mfc.getGymService().getTrainerService().getTrainers();
        if(trainers.get(ID) == null){
            throw new notFoundExc("El id no coincide");
        }else {
            return trainers.get(ID);
        }
    }
}
