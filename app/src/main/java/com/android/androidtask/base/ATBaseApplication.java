package com.android.androidtask.base;

import android.app.Application;

import com.android.androidtask.db.ATDummyData;
import com.android.androidtask.manager.ATContextManager;
import com.android.androidtask.manager.ATDatabaseManager;
import com.android.androidtask.util.ATListUtils;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by vanya on 28.05.16.
 */
public class ATBaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ATContextManager.create(this);
        FlowManager.init(new FlowConfig.Builder(this)
                .openDatabasesOnInit(true).build());

        // Create after database initialization
        ATDummyData.getInstance().putDummyDataInDb();
    }

}
