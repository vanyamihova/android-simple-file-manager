package com.android.androidtask.db.model;

import com.android.androidtask.base.ATBaseModel;
import com.android.androidtask.db.ATDatabase;
import com.android.androidtask.db.type.FileType;
import com.android.androidtask.db.type.FileTypeConverter;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Table;

import java.util.Date;

/**
 * Created by vanya on 28.05.16.
 */
@Table(database = ATDatabase.class)
public class ATFileModel extends ATBaseModel {

    @Column
    public String filename;

    @Column
    public boolean isFolder;

    @Column
    public Date modDate;

    @Column(typeConverter = FileTypeConverter.class)
    public FileType fileType;

    @Column
    public boolean isOrange;

    @Column
    public boolean isBlue;

}
