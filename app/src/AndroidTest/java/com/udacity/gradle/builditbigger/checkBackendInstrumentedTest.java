package com.udacity.gradle.builditbigger;


import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.jokedisplayandroidlibrary.ApplicationConstants;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
/**
 * Created by Akshay on 13-11-2017. This test checks if the backend returns non null joke String value
 * This is checked from the extras in the intent 
 */
@RunWith(AndroidJUnit4.class)
public class checkBackendInstrumentedTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void clickTellJoke_ReturnsNonEmptyString() {
        onView((withId(R.id.tell_joke)))
                .perform(click());
        intended(hasExtras
                (hasEntry
                        (equalTo(ApplicationConstants.INTENT_JOKE_KEY), notNullValue())));
    }
}
