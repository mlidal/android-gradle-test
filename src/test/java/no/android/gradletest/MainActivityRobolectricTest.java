package no.android.gradletest;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import no.android.gradletest.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Robolectric.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class MainActivityRobolectricTest {

    MainActivity activity;
    TextView textView;
    Button textChangeButton;
    Button newActivityButton;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        textView = (TextView)activity.findViewById(R.id.textview);
        textChangeButton = (Button)activity.findViewById(R.id.button);
        newActivityButton = (Button)activity.findViewById(R.id.button2);
    }

    @Test
    public void testCreate() throws Exception {
        assertTrue(activity != null);
        assertEquals(activity.getString(R.string.hello), textView.getText());
    }

    @Test
    public void testTextChange() throws Exception {
        textChangeButton.performClick();
        assertEquals(activity.getString(R.string.newText), textView.getText());
    }

    @Test
    public void testNewActivity() throws Exception {
        newActivityButton.performClick();
        ShadowActivity shadow = shadowOf(activity);
        Intent nextActivity = shadow.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(nextActivity);
        assertEquals(MyListActivity.class.getName(), shadowIntent.getComponent().getClassName());
    }
}
