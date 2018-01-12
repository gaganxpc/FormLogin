package com.example.android.formlogin;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by Agan on 10/20/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void checkViewDisplayed(){
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.btnCancel)).check(matches(isDisplayed()));
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()));
        onView(withId(R.id.editPass)).check(matches(isDisplayed()));
        onView(withId(R.id.editUser)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView2)).check(matches(isDisplayed()));
    }

    // Skema Form Validasi
   @Test
    public void chechErrorMessageIsDisplayedForEmptyData(){
        activityTestRule.launchActivity(new Intent());

       onView(withId(R.id.btnLogin)).check(matches(isDisplayed())).perform(click());
       onView(withId(R.id.btnCancel)).check(matches(isDisplayed())).perform(click());

    }

    @Test
    public void checkSuccesLogin(){
        activityTestRule.launchActivity(new Intent());
        onView(withId(R.id.editUser)).perform(typeText("arul"), closeSoftKeyboard());
        onView(withId(R.id.editPass)).perform(typeText("admin"), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed())).perform(click());
    }

}