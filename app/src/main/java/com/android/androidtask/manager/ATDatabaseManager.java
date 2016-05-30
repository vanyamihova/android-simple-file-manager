package com.android.androidtask.manager;

import com.android.androidtask.db.model.ATFileModel;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

/**
 * Created by vanya on 28.05.16.
 */
public class ATDatabaseManager {

    public static ATDatabaseManager sInstance;

    public static ATDatabaseManager getInstance() {
        if(sInstance == null)
            sInstance = new ATDatabaseManager();
        return sInstance;
    }

    public List<ATFileModel> getAllFileModels() {
        return new Select().from(ATFileModel.class).where().queryList();
    }

}
