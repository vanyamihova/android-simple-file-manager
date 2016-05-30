package com.android.androidtask.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by vanya on 28.05.16.
 */
@Database(name = ATDatabase.NAME, version = ATDatabase.VERSION)
public class ATDatabase {
    public static final String NAME = "android_task_database";
    public static final int VERSION = 1;
}
