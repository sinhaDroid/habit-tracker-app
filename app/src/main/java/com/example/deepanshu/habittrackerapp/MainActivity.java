package com.example.deepanshu.habittrackerapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper helper = new DBHelper(this);

        helper.insert("BreakFast", 9);
        helper.insert("Lunch", 13);
        helper.insert("Snacks", 18);
        helper.insert("Dinner", 22);


        Cursor cursor = helper.readHabits();

        while (cursor.moveToNext()) {
            Log.v(TAG, "Daily Schedule: \n" + " Food - " + cursor.getString(0) + " Time - " + cursor.getInt(1));
        }
    }
}
