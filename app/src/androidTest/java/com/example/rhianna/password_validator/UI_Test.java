package com.example.rhianna.password_validator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static junit.framework.Assert.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class UI_Test {

    //Test 1: Want to write good password, click button, and receive feedback
        //saying the password is "Strong"
    @Test
    public void goodPassword(){
        fail();
    }

    //Test 2: Want to write a bad password, failing 1 rule, click button,
        //and receive feedback saying the password is "Almost Strong Enough"
    @Test
    public void failOneRule(){
        fail();
    }

    //Test 3: Want to write a bad password, failing 2 rules, click button,
        //and receive feedback saying the password is "Slightly Weak"
    @Test
    public void failTwoRules(){
        fail();
    }

    //Test 4 Want to write a bad password, failing 3 rules, click button,
        //and receive feedback saying the password is "Weak"
    @Test
    public void failThreeRules(){
        fail();
    }

    //Test 5: Want to write a bad password, failing 4 rules, click button,
        //and receive feedback saying the password is "Very Weak"
    @Test
    public void failFourRules(){
        fail();
    }

    //Test 6: Want to write a bad password, failing 5 rules, click button,
        //and receive feedback saying the password is "Extremely Weak"
    @Test
    public void failAllRules(){
        fail();
    }

}
