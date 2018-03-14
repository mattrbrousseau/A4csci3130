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

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

/**
 * This is the third test that should be run. It starts at the main activity
 * and clicks on the first entry in the database, which should be the same that
 * was used previously. It then changes the name and submits the changes.
 *
 * useAppContext checks to see if the right package is being used
 * testCreate creates the test
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class UpdateTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }
    /**
    * run test
    */
    @Test
    public void testRetrieve() throws Exception {
        SystemClock.sleep(1500);
        onView(withId(R.id.listView));
        onData(anything()).inAdapterView(allOf(withId(R.id.listView),isCompletelyDisplayed())).atPosition(0).perform(click());
        onView(withId(R.id.name)).perform(replaceText("notMatthew"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.updateButton)).perform(new GeneralClickAction(Tap.SINGLE,GeneralLocation.CENTER,Press.FINGER));

    }
}
