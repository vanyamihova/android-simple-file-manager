package com.android.androidtask.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vanya on 28.05.16.
 */
public abstract class ATBaseActivity extends AppCompatActivity {

    protected static final String TAG = ATBaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
