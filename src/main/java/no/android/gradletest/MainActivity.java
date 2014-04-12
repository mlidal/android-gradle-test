package no.android.gradletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import no.android.gradletest.R;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void changeText(View v) {
        TextView tv = (TextView)findViewById(R.id.textview);
        tv.setText(R.string.newText);
    }

    public void nextActivity(View v) {
        Intent intent = new Intent(getApplicationContext(), MyListActivity.class);
        startActivity(intent);
    }
}
