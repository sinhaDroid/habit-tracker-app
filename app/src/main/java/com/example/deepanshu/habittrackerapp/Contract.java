package com.example.deepanshu.habittrackerapp;

import android.provider.BaseColumns;

/**
 * Created by deepanshu on 3/4/17.
 */

class Contract {

    static final String DATABASE_NAME = "habitTracker.db";
    static final int DB_VERSION = 1;

    public Contract() {
    }

    class Entry implements BaseColumns {
        static final String TABLE = "habits";

        static final String COL_HABIT = "habit";
        static final String COL_TIMES = "times";
    }
}
