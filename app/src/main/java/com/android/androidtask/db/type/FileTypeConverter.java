package com.android.androidtask.db.type;

import com.raizlabs.android.dbflow.converter.TypeConverter;

/**
 * Created by vanya on 28.05.16.
 */
@com.raizlabs.android.dbflow.annotation.TypeConverter
public class FileTypeConverter
        extends TypeConverter<Integer, FileType> {

    @Override public Integer getDBValue(FileType fileType) {
        return fileType.getIcon();
    }

    @Override public FileType getModelValue(Integer icon) {
        return FileType.valueOf(icon);
    }
}
