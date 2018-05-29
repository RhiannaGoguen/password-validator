package com.example.rhianna.password_validator;

public class Validator {

    boolean rule1, rule2, rule3, rule4, rule5 = false;

    public Validator(){}

    public  int validate(String pass){
        int rulesPassed = 0;

        //Rule 1: The password is not the word "password".
        if(!pass.equalsIgnoreCase("password")) {
            rulesPassed++;
            rule1=true;
        }

        //Rule 2: The password is at least 8 characters long.
        if(pass.length()>=8){
            rulesPassed++;
            rule2=true;
        }

        //Rule 3: The password contains at least one of these special characters !, @, # or $.
        if(pass.contains("!") || pass.contains("@") || pass.contains("#") || pass.contains("$")){
            rulesPassed++;
            rule3=true;
        }

        //Rule 4: The password is not longer than 20 characters.
        if(pass.length()<=20){
            rulesPassed++;
            rule4=true;
        }

        //Rule 5: The password contains at least 1 number.
        if(pass.contains("1") ||
                pass.contains("2") ||
                pass.contains("3") ||
                pass.contains("4") ||
                pass.contains("5") ||
                pass.contains("6") ||
                pass.contains("7") ||
                pass.contains("8") ||
                pass.contains("9") ||
                pass.contains("0")){
            rulesPassed++;
            rule5=true;
        }

        return rulesPassed;
    }

    public boolean[] getRulesPassed(){
        boolean[] result = {rule1, rule2, rule3, rule4, rule5};
        return result;
    }

}
