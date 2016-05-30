package com.android.androidtask.util;

import java.util.List;

/**
 * Created by vanya on 28.05.16.
 */
public class ATListUtils {

    public static boolean isEmpty(List list) {
        if(list != null && list.size() > 0)
            return false;
        return true;
    }

}
