package com.android.androidtask.base.helperrecyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * Created by vanya on 28.05.16.
 */
public interface ATItemTouchHelperListener {
    void onItemSwipe(RecyclerView.ViewHolder viewHolder, int i);
}
