package com.example.rhianna.password_validator;

public class Validator {

    public Validator(){}

    public static int validate(String pass){
        int rulesPassed = 0;

        //Rule 1: The password is not the word "password".
        if(!pass.equalsIgnoreCase("password"))
            rulesPassed++;

        //Rule 2: The password is at least 8 characters long.
        if(pass.length()>=8){
            rulesPassed++;
        }

        //Rule 3: The password contains at least one of these special characters !, @, # or $.

        //Rule 4: The password is not longer than 20 characters.

        //Rule 5: The password contains at least 1 number.

        return rulesPassed;
    }

}
