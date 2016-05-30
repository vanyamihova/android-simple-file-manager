package com.android.androidtask.ui.fileTable;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;

import com.android.androidtask.R;
import com.android.androidtask.base.ATBaseActivity;
import com.android.androidtask.base.helperrecyclerview.ATSimpleItemTouchHelperCallback;
import com.android.androidtask.db.model.ATFileModel;
import com.android.androidtask.manager.ATDatabaseManager;
import com.android.androidtask.util.ATListUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FileTableActivity extends ATBaseActivity  {

    @Bind(R.id.recycler_view)RecyclerView recyclerView;
    @Bind(R.id.empty_state)TextView emptyState;

    private ATFileTableAdapter mAdapter;
    private List<ATFileModel> mFileModelList;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out);

        setContentView(R.layout.activity_file_table);
        ButterKnife.bind(this);

        // Get data from database
        initData();

        // check data's status
        if (!ATListUtils.isEmpty(mFileModelList)) {
            hideEmptyState();
            initAdapter();
            initRecyclerView();
        } else {
            showEmptyState();
        }

    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }

    private void initAdapter() {
        mAdapter = new ATFileTableAdapter(mFileModelList);

        if (mAdapter.isDragDropEnabled()) {
            ItemTouchHelper.Callback callback = new ATSimpleItemTouchHelperCallback(mAdapter);
            mItemTouchHelper = new ItemTouchHelper(callback);
            mItemTouchHelper.attachToRecyclerView(recyclerView);
        }
    }

    private void initData() {
        mFileModelList = ATDatabaseManager.getInstance().getAllFileModels();
    }

    private void showEmptyState() {
        emptyState.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    private void hideEmptyState() {
        emptyState.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }



}
