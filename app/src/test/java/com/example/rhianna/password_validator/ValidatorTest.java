package com.example.rhianna.password_validator;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.*;

public class ValidatorTest {

    static Validator validator;
    String pass = "";

    @BeforeClass
    public static void setUp(){
        validator = new Validator();
    }

    @Test
    public void isNotPasswordPass(){
        pass = "notTheWordPassword";
        assertEquals(validator.validate(pass), 2);
    }

    @Test
    public void isNotPasswordFail(){
        pass = "password";
        assertEquals(validator.validate(pass), 1);
    }

    @Test
    public void isNotPasswordFailCaseDifferences(){
        pass = "PassWOrd";
        assertEquals(validator.validate(pass), 1);
    }

    @Test
    public void atLeast8CharLong(){
        pass = "OverEightCharacters";
        assertEquals(validator.validate(pass), 2);
    }

    @Test
    public void exactly8CharLong(){
        pass = "12345678";
        assertEquals(validator.validate(pass), 2);
    }

    @Test
    public void lessThan8CharLong(){
        pass = "aaa";
        assertEquals(validator.validate(pass), 1);
    }

    @Test
    public void contains1SpecialCharacter(){
        pass = "!";
        assertEquals(validator.validate(pass), 3);
    }

    @Test
    public void moreThan20CharsFails(){
        pass = "ThisPasswordIsSuperDuperLong";
        assertEquals(validator.validate(pass), 2);
    }

    @Test
    public void atLeastOneNumber(){
        pass = "1abc";
        assertEquals(validator.validate(pass), 2);
    }

    @Test
    public void passesAllRules(){
        pass = "ef@m73rk402";
        assertEquals(validator.validate(pass), 5);
    }
}
