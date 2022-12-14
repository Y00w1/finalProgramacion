package com.example.finalprogrmacion.validator;

import com.example.finalprogrmacion.model.Exercise;
import com.example.finalprogrmacion.model.Member;
import com.example.finalprogrmacion.model.Session;
import com.example.finalprogrmacion.model.Trainer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class InputsVal {

    //Inputs that only allow positive Integer
    public void intInput(String str)throws InputException {
        try{
            Integer i;
            i = Integer.parseInt(str);
            if (i<=0){
                throw new InputException("No se admiten valores negativos");
            }
        }catch(NumberFormatException e){
            throw new InputException("Campo inválido, sólo se aceptan números");
        }
    }

    //Inputs that only allow Double
    public void doubleInput(String str) throws InputException{
        try{
            Double i;
            i = Double.parseDouble(str);
            if(i<=0){
                throw new InputException("No se admiten valores negativos");
            }
        }catch(NumberFormatException e){
            throw new InputException("Campo inválido, sólo se aceptan números");
        }
    }

    //Email inputs
    public void emailInput(String str) throws InputException{
        if(!str.contains("@")){
            throw new InputException("Correo electrónico inválido");
        }
    }

    //Empty inputs & Password validation
    public void txtEmpty(String str) throws InputException{
        if(str.isEmpty()){
            throw new InputException("El campo no puede estar vacio");
        }
    }
    //Session
    public void emptySession(String name, String trainerID, LocalDate date, String timeStart, String timeEnd)throws InputException{
        if(name.isEmpty() || trainerID.isEmpty() || date == null || timeStart.isEmpty() || timeEnd.isEmpty() ){
            throw new InputException("No pueden quedar campos vacios");
        }
    }
    //TIME
    public String validTime(String timeStart, String timeEnd) throws InputException {
        if( (Double.parseDouble(timeEnd) - Double.parseDouble(timeStart))<0 ){
            throw new InputException("El tiempo es inválido");
        }else{
            return timeStart+" - "+timeEnd;
        }
    }
    //Not repeat time
    public void uniqueTime(String time, LocalDate date, HashMap<Integer, Session> sessions) throws InputException{
        for(Session session : sessions.values()){
            if( session.getTime().equals(time) && session.getDay().equals(date) ){
                throw new InputException("La fecha no se puede repetir");
            }
        }
    }

    //member
    public void emptyMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age) throws InputException{
        if(ID.isEmpty() || name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || weight.isEmpty() || height.isEmpty() || age.isEmpty()){
            throw new InputException("No pueden quedar campos vacios");
        }
    }
    public void memberPassword(String password, String ID, HashMap<String, Member> mapMembers) throws InputException{
        Member member = mapMembers.get(ID);
        if(!member.getPassword().equals(password)){
            throw new InputException("La contraseña no se puede modificar");
        }
    }

    //Exercise
    public void emptyExercise(String id, String name, String calories, String duration) throws InputException{
        if(id.isEmpty() || name.isEmpty() || calories.isEmpty() || duration.isEmpty()){
            throw new InputException("No pueden quedar campos vacios");
        }
    }

    //Trainer
    public void emptyTrainer(String ID, String name, String lastName, String email, String password, String months, String salary) throws InputException{
        if(ID.isEmpty() || name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || months.isEmpty() || salary.isEmpty()){
            throw new InputException("No pueden quedar campos vacios");
        }
    }
    public void trainerPassword(String ID, String password, HashMap<String, Trainer> mapTrainers) throws InputException{
        Trainer trainer = mapTrainers.get(ID);
        if(!trainer.getPassword().equals(password)){
            throw new InputException("La contraseña no se puede modificar");
        }
    }


}
