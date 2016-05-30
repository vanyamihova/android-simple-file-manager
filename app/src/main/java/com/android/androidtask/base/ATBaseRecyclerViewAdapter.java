package com.android.androidtask.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.androidtask.base.helperrecyclerview.ATItemTouchHelperListener;
import com.android.androidtask.ui.dialog.ATDialog;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vanya on 28.05.16.
 */
public abstract class ATBaseRecyclerViewAdapter<T, VH extends ATBaseViewHolder> extends RecyclerView.Adapter<VH> implements ATItemTouchHelperListener {

    public List<T> mObjects;
    protected Context mContext;
    boolean isDragDropEnabled = true;

    public ATBaseRecyclerViewAdapter(List<T> objects) {
        this.mObjects = objects;
        this.isDragDropEnabled = setDragDropEnabled();
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater
                .from(mContext)
                .inflate(layoutId(), parent, false);

        return onCreateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        onBindViewHolder(holder, getItem(position));
    }

    public abstract int layoutId();
    public abstract VH onCreateViewHolder(View view);
    public abstract void onBindViewHolder(VH holder, T item);
    public abstract boolean setDragDropEnabled();


    @Override
    public void onItemSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        if(isDragDropEnabled) {
            ATDialog dialog = new ATDialog(mContext);
            dialog.showDialog();
            notifyDataSetChanged();
        }
    }

    public boolean isDragDropEnabled() {
        return this.isDragDropEnabled;
    }


    public void setNewList(List<T> object) {
        mObjects = object;
        notifyDataSetChanged();
    }


    /**
     * Adds the specified object at the start of the array.
     *
     * @param object The object to add at the start of the array.
     */
    public void addFirst(final T object) {
        mObjects.add(0, object);
        notifyItemInserted(0);
    }


    /**
     * Adds the specified object at the end of the array.
     *
     * @param object The object to add at the end of the array.
     */
    public void addLast(final T object) {
        mObjects.add(object);
        notifyItemInserted(getItemCount() - 1);
    }

    /**
     * Remove all elements from the list.
     */
    public void clear() {
        final int size = getItemCount();
        mObjects.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }

    public T getItem(final int position) {
        return mObjects.get(position);
    }

    public List<T> getAllItems() {
        return mObjects;
    }

    public long getItemId(final int position) {
        return position;
    }

    /**
     * Returns the position of the specified item in the array.
     *
     * @param item The item to retrieve the position of.
     * @return The position of the specified item.
     */
    public int getPosition(final T item) {
        return mObjects.indexOf(item);
    }

    /**
     * Inserts the specified object at the specified index in the array.
     *
     * @param object The object to insert into the array.
     * @param index  The index at which the object must be inserted.
     */
    public void insert(final T object, int index) {
        mObjects.add(index, object);
        notifyItemInserted(index);

    }

    /**
     * Removes the specified object from the array.
     *
     * @param object The object to remove.
     */
    public void remove(T object) {
        final int position = getPosition(object);
        mObjects.remove(object);
        notifyItemRemoved(position);
    }

    /**
     * Sorts the content of this adapter using the specified comparator.
     *
     * @param comparator The comparator used to sort the objects contained in this adapter.
     */
    public void sort(Comparator<? super T> comparator) {
        Collections.sort(mObjects, comparator);
        notifyItemRangeChanged(0, getItemCount());
    }
}
