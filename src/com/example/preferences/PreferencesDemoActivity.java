package com.example.preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class PreferencesDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // ==============================================
        // Getting the app's shared preferences.
        // ==============================================
        SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // ==============================================
        // Getting the value for the run counter.
        // ==============================================
        int counter = app_preferences.getInt("counter", 1);
        
        // ==============================================
        // Updating the TextView with the counter.
        // ==============================================
        TextView textview = (TextView) findViewById(R.id.text);
        textview.setText("This app has been started " + counter + " times.");
        
        // ==============================================
        // Incrementing and committing the counter.
        // ==============================================
        SharedPreferences.Editor editor = app_preferences.edit();
        editor.putInt("counter", ++counter);
        editor.commit();
    }
}