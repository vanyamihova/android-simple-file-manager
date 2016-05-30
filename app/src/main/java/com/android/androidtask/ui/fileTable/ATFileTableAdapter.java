package com.android.androidtask.ui.fileTable;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.androidtask.R;
import com.android.androidtask.base.ATBaseRecyclerViewAdapter;
import com.android.androidtask.base.ATBaseViewHolder;
import com.android.androidtask.db.model.ATFileModel;
import com.android.androidtask.ui.dialog.ATDialog;
import com.android.androidtask.util.ATCalendarUtils;
import com.android.androidtask.util.ATResourceUtils;

import java.util.List;

import butterknife.Bind;

/**
 * Created by vanya on 28.05.16.
 */
public class ATFileTableAdapter extends ATBaseRecyclerViewAdapter<ATFileModel, ATFileTableAdapter.FileModelViewHolder> {

    private ATDialog dialog;

    public ATFileTableAdapter(List<ATFileModel> objects) {
        super(objects);
    }

    @Override
    public boolean setDragDropEnabled() {
        return true;
    }

    @Override
    public int layoutId() {
        return R.layout.card_view_file_item;
    }

    @Override
    public FileModelViewHolder onCreateViewHolder(View view) {
        return new FileModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FileModelViewHolder holder, ATFileModel item) {
        holder.txtTitle.setText(item.filename);
        holder.icon.setImageResource(item.fileType.getIcon());

        if (item.isFolder) {
            holder.containerFolderLabel.setVisibility(View.VISIBLE);
        } else {
            holder.containerFolderLabel.setVisibility(View.GONE);
        }

        if (item.isBlue) {
            holder.lineColorLabelBlue.setVisibility(View.VISIBLE);
        } else {
            holder.lineColorLabelBlue.setVisibility(View.GONE);
        }

        if (item.isOrange) {
            holder.lineColorLabelOrange.setVisibility(View.VISIBLE);
        } else {
            holder.lineColorLabelOrange.setVisibility(View.GONE);
        }

        holder.txtCreateDate.setText(
                String.format(
                        ATResourceUtils.getStringFromResource(R.string.modified),
                        ATCalendarUtils.formatDate(item.modDate.getTime())));
    }


    public class FileModelViewHolder extends ATBaseViewHolder {

        private final String TAG = FileModelViewHolder.class.getSimpleName();

        @Bind(R.id.card_view_file_model_item)CardView cardView;
        @Bind(R.id.line_color_label_orange)View lineColorLabelOrange;
        @Bind(R.id.line_color_label_blue)View lineColorLabelBlue;
        @Bind(R.id.txt_create_date)TextView txtCreateDate;
        @Bind(R.id.txt_title)TextView txtTitle;
        @Bind(R.id.container_folder_label)LinearLayout containerFolderLabel;
        @Bind(R.id.icon)ImageView icon;

        public FileModelViewHolder(View itemView) {
            super(itemView);
            cardView.setOnClickListener(this);
            cardView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ATFileModel fileModel = getItem(getAdapterPosition());

            if (fileModel.isFolder) {
                Intent intent = new Intent(mContext, FileTableActivity.class);
                mContext.startActivity(intent);
            } else {
                Log.i(TAG, "This is a file!");
            }
        }

        @Override
        public boolean onLongClick(View v) {
            dialog = new ATDialog(v.getContext());
            dialog.showDialog();
            return true;
        }

    }

}
