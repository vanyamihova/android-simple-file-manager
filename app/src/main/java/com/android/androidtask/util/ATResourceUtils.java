package com.android.androidtask.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.android.androidtask.manager.ATContextManager;

/**
 * Created by vanya on 28.05.16.
 */
public class ATResourceUtils {

    public static String getStringFromResource(int resourceId) {
        Context context = ATContextManager.getInstance().getContext();
        return context.getString(resourceId);
    }

    public static Drawable getDrawableFromResource(int resourceId) {
        Context context = ATContextManager.getInstance().getContext();
        return context.getResources().getDrawable(resourceId);
    }

}
