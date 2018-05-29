package com.example.rhianna.password_validator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class ValidatorTest {

    Validator validator;
    String pass = "";
    boolean[] rulesPassed = new boolean[5];

    @Before
    public void setUp(){
        validator = new Validator();
    }

    @Test
    public void isNotWordPassword(){
        pass = "notTheWordPassword";
        assertEquals(validator.validate(pass), 3);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[0], true);
    }

    @Test
    public void isNotPasswordFail(){
        pass = "password";
        assertEquals(validator.validate(pass), 2);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[0], false);
    }

    @Test
    public void isNotPasswordFailCaseDifferences(){
        pass = "PassWOrd";
        assertEquals(validator.validate(pass), 2);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[0], false);
    }

    @Test
    public void atLeast8CharLong(){
        pass = "OverEightCharacters";
        assertEquals(validator.validate(pass), 3);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[1], true);
    }

    @Test
    public void exactly8CharLong(){
        pass = "12345678";
        assertEquals(validator.validate(pass), 4);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[1], true);
    }

    @Test
    public void lessThan8CharLong(){
        pass = "aaa";
        assertEquals(validator.validate(pass), 2);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[1], false);
    }

    @Test
    public void contains1SpecialCharacter(){
        pass = "!";
        assertEquals(validator.validate(pass), 3);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[2], true);

        pass = "@";
        assertEquals(validator.validate(pass), 3);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[2], true);

        pass = "#";
        assertEquals(validator.validate(pass), 3);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[2], true);

        pass = "$";
        assertEquals(validator.validate(pass), 3);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[2], true);
    }

    @Test
    public void containsNoSpecialCharacters(){
        pass="noSpecialCharsHere";
        assertEquals(validator.validate(pass), 3);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[2], false);
    }

    @Test
    public void moreThan20CharsFails(){
        pass = "ThisPasswordIsSuperDuperLong";
        assertEquals(validator.validate(pass), 2);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[3], false);
    }

    @Test
    public void exactly20CharsPasses(){
        pass = "IsExactlyTwentyChars";
        assertEquals(validator.validate(pass), 3);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[3], true);
    }

    @Test
    public void atLeastOneNumber(){
        pass = "1abc";
        assertEquals(validator.validate(pass), 3);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[4], true);
    }

    @Test
    public void failsWhenNoNumber(){
        pass = "abc";
        assertEquals(validator.validate(pass), 2);
        rulesPassed = validator.getRulesPassed();
        assertEquals(rulesPassed[4], false);
    }

    @Test
    public void passesAllRules(){
        pass = "ef@m73rk402";
        assertEquals(validator.validate(pass), 5);
        rulesPassed = validator.getRulesPassed();

        assertEquals(rulesPassed[0], true);
        assertEquals(rulesPassed[1], true);
        assertEquals(rulesPassed[2], true);
        assertEquals(rulesPassed[3], true);
        assertEquals(rulesPassed[4], true);
    }
}
