package com.android.androidtask.manager;

import android.content.Context;

/**
 * Created by vanya on 28.05.16.
 */
public class ATContextManager {

    private static ATContextManager sInstance;

    private Context mApplicationContext;

    public static ATContextManager getInstance() {
        if(sInstance == null) {
            throw new RuntimeException("Before use ATContextManager you should init him");
        }
        return sInstance;
    }

    public static void create(Context context) {
        if(sInstance == null) {
            sInstance = new ATContextManager(context.getApplicationContext());
        }
    }

    private ATContextManager(Context context) {
        this.mApplicationContext = context;
    }

    public Context getContext() {
        return mApplicationContext;
    }

}
