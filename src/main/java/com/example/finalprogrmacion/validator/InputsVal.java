package com.example.finalprogrmacion.validator;

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


}
