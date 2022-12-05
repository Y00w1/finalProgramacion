package com.example.finalprogrmacion.validator;

import java.util.ArrayList;

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

    //Empty inputs
    //member
    public void emptyMember(String ID, String name, String lastName, String email, String password, String weight, String height, String age) throws InputException{
        if(ID.isEmpty() || name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || weight.isEmpty() || height.isEmpty() || age.isEmpty()){
            throw new InputException("No pueden quedar campos vacios");
        }
    }
    //Exercise
    public void emptyExercise(String id, String name, String calories, String duration) throws InputException{
        if(id.isEmpty() || name.isEmpty() || calories.isEmpty() || duration.isEmpty()){
            throw new InputException("No pueden quedar campos vacios");
        }
    }

}
