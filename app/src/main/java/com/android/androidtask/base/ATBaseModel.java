package com.android.androidtask.base;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

/**
 * Created by vanya on 28.05.16.
 */
public abstract class ATBaseModel extends BaseModel implements Serializable {

    @PrimaryKey(autoincrement = true)
    public long id;

    public void saveData() {
        if(id > 0) {
            update();
        } else {
            save();
        }
    }

}
