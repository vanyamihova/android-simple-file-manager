package com.android.androidtask.db.type;

import com.android.androidtask.R;

/**
 * Created by vanya on 28.05.16.
 */
public enum FileType {
    IMAGE(R.drawable.ic_file_image),
    PDF(R.drawable.ic_file_pdf),
    DOC(R.drawable.ic_file_doc),
    MUSIC(R.drawable.ic_file_music),
    VIDEO(R.drawable.ic_file_video),
    FOLDER(R.drawable.ic_file_folder);

    private final int icon;

    FileType(int icon) {
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public static FileType valueOf(int icon) {
        for(FileType fileType : values()) {
            if (icon == fileType.getIcon()) {
                return fileType;
            }
        }
        return null;
    }

}
