package com.ucsal.braodireito;

import android.content.Context;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.ucsal.braodireito.Dice.DiceActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.ucsal.braodireito", appContext.getPackageName());
    }
    @Rule
    public ActivityScenarioRule<DiceActivity> activityRule =
            new ActivityScenarioRule<>(DiceActivity.class);

    @Test
    public void turmasDevemEstarVisiveis() {
        Espresso.onView(ViewMatchers.withId(R.id.btnHistory))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}