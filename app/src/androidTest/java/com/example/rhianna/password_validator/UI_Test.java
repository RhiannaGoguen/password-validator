package com.example.rhianna.password_validator;

import android.support.test.runner.AndroidJUnit4;

import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class UI_Test {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

        //Test 1: See that the default text in the output box is correct.
        @Test
        public void checkDefaultText(){

            onView(withId(R.id.output)).check(matches(withText("This will be where your password strength is outputted.")));
        }

        //Test 2: Want to write good password, click button, and receive feedback
        //saying the password is "Strong"
        @Test
        public void goodPassword(){
        onView(withId(R.id.input))
                .perform(typeText("123goodPassword@!"), closeSoftKeyboard());
        onView(withId(R.id.validatePassButton)).perform(click());

        onView(withId(R.id.output)).check(matches(withText("Strong")));
    }

    //Test 3: Want to write a bad password, failing 1 rule, click button,
        //and receive feedback saying the password is "Almost Strong Enough"
    @Test
    public void failOneRule(){
        onView(withId(R.id.input))
                .perform(typeText("123goodPassword"), closeSoftKeyboard());
        onView(withId(R.id.validatePassButton)).perform(click());

        onView(withId(R.id.output)).check(matches(withText("Almost Strong Enough")));

    }

    //Test 4: Want to write a bad password, failing 2 rules, click button,
        //and receive feedback saying the password is "Weak"
    @Test
    public void failTwoRules(){
        onView(withId(R.id.input))
                .perform(typeText("goodPassword"), closeSoftKeyboard());
        onView(withId(R.id.validatePassButton)).perform(click());

        onView(withId(R.id.output)).check(matches(withText("Weak")));
    }

    //Test 5: Want to write a bad password, failing 3 or more rules, click button,
        //and receive feedback saying the password is "Very Weak"
    @Test
    public void failThreeOrMoreRules(){
        onView(withId(R.id.input))
                .perform(typeText("abc"), closeSoftKeyboard());
        onView(withId(R.id.validatePassButton)).perform(click());

        onView(withId(R.id.output)).check(matches(withText("Very Weak")));
    }

    //Test 6: Want to click button with no input in the box, see that
    @Test
    public void noInput(){
        onView(withId(R.id.validatePassButton)).perform(click());

        onView(withId(R.id.output)).check(matches(withText("Please enter a password into the box below.")));
    }

}
