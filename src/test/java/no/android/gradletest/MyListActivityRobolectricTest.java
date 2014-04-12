package no.android.gradletest;

import android.widget.ListView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class MyListActivityRobolectricTest {

    MyListActivity activity;
    ListView listView;
    @Before
    public void setUp() {
        activity = (MyListActivity) Robolectric.buildActivity(MyListActivity.class).create().get();
        listView = (ListView)activity.findViewById(android.R.id.list);
    }

    @Test
    public void testCreate() {
        assertTrue(listView != null);
    }

    @Test
    public void testListSize() {
        assertEquals(10, listView.getCount());
    }

    @Test
    public void testListContent() {
        assertEquals("Blackberry", listView.getItemAtPosition(3));
    }

}
