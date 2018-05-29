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

}
