package com.android.androidtask.db;

import com.android.androidtask.db.model.ATFileModel;
import com.android.androidtask.db.type.FileType;

import java.util.Date;

/**
 * Created by vanya on 28.05.16.
 */
public class ATDummyData {

    public static ATDummyData sInstance;

    public static ATDummyData getInstance() {
        if(sInstance == null)
            sInstance = new ATDummyData();
        return sInstance;
    }

    public void putDummyDataInDb() {

        ATFileModel data = new ATFileModel();
        data.isFolder = true;
        data.filename = "filename1";
        data.fileType = FileType.FOLDER;
        data.isBlue = false;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = false;
        data.filename = "filename2";
        data.fileType = FileType.DOC;
        data.isBlue = true;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = false;
        data.filename = "filename3";
        data.fileType = FileType.IMAGE;
        data.isBlue = true;
        data.isOrange = true;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = true;
        data.filename = "filename4";
        data.fileType = FileType.FOLDER;
        data.isBlue = false;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = true;
        data.filename = "filename1";
        data.fileType = FileType.FOLDER;
        data.isBlue = false;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = false;
        data.filename = "filename2";
        data.fileType = FileType.DOC;
        data.isBlue = true;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = false;
        data.filename = "filename3";
        data.fileType = FileType.IMAGE;
        data.isBlue = true;
        data.isOrange = true;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = true;
        data.filename = "filename4";
        data.fileType = FileType.FOLDER;
        data.isBlue = false;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = true;
        data.filename = "filename1";
        data.fileType = FileType.FOLDER;
        data.isBlue = false;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = false;
        data.filename = "filename2";
        data.fileType = FileType.DOC;
        data.isBlue = true;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = false;
        data.filename = "filename3";
        data.fileType = FileType.IMAGE;
        data.isBlue = true;
        data.isOrange = true;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = true;
        data.filename = "filename4";
        data.fileType = FileType.FOLDER;
        data.isBlue = false;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = true;
        data.filename = "filename1";
        data.fileType = FileType.FOLDER;
        data.isBlue = false;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = false;
        data.filename = "filename2";
        data.fileType = FileType.DOC;
        data.isBlue = true;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = false;
        data.filename = "filename3";
        data.fileType = FileType.IMAGE;
        data.isBlue = true;
        data.isOrange = true;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

        data = new ATFileModel();
        data.isFolder = true;
        data.filename = "filename4";
        data.fileType = FileType.FOLDER;
        data.isBlue = false;
        data.isOrange = false;
        data.modDate = new Date( System.currentTimeMillis() / 1000L );
        data.saveData();

    }

}
