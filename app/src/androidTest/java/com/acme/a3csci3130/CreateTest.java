package com.acme.a3csci3130;

import android.content.Context;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Tap;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CreateTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }
    @Test
    public void testCreate() throws Exception {
        SystemClock.sleep(1500);
        onView(withId(R.id.submitButton)).perform(new GeneralClickAction(Tap.SINGLE,GeneralLocation.CENTER,Press.FINGER));
        onView(withId(R.id.name)).perform(new GeneralClickAction(Tap.SINGLE,GeneralLocation.CENTER,Press.FINGER));
        onView(withId(R.id.name)).perform(typeText("Matthew"));
        onView(withId(R.id.number)).perform(new GeneralClickAction(Tap.SINGLE,GeneralLocation.CENTER,Press.FINGER));
        onView(withId(R.id.number)).perform(typeText("111222333"));
        onView(withId(R.id.business)).perform(new GeneralClickAction(Tap.SINGLE,GeneralLocation.CENTER,Press.FINGER));
        onView(withId(R.id.business)).perform(typeText("Distributor"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.province)).perform(new GeneralClickAction(Tap.SINGLE,GeneralLocation.CENTER,Press.FINGER));
        onView(withId(R.id.province)).perform(typeText("NS"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.address)).perform(new GeneralClickAction(Tap.SINGLE,GeneralLocation.CENTER,Press.FINGER));
        onView(withId(R.id.address)).perform(typeText("123 Dixon Court"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.submitButton)).perform(new GeneralClickAction(Tap.SINGLE,GeneralLocation.CENTER,Press.FINGER));
    }


}
