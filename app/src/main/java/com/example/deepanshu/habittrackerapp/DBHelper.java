package com.example.deepanshu.habittrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by deepanshu on 3/4/17.
 */

class DBHelper extends SQLiteOpenHelper {

    DBHelper(Context context) {
        super(context, Contract.DATABASE_NAME, null, Contract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS " +
                        Contract.Entry.TABLE +
                        " (" +
                        Contract.Entry.COL_HABIT +
                        " VARCHAR, " +
                        Contract.Entry.COL_TIMES +
                        " INT(3))"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contract.Entry.TABLE);
        onCreate(db);
    }

    void insert(String habit, int times) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contract.Entry.COL_HABIT, habit);
        values.put(Contract.Entry.COL_TIMES, times);

        db.insert(Contract.Entry.TABLE, null, values);
    }

    Cursor readHabits() {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                Contract.Entry.COL_HABIT,
                Contract.Entry.COL_TIMES
        };

        return db.query(Contract.Entry.TABLE, projection, null, null, null, null, null);
    }
}
