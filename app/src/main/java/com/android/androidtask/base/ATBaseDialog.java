package com.android.androidtask.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.androidtask.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by vanya on 28.05.16.
 */
public abstract class ATBaseDialog {

    protected Context mContext;

    protected static Dialog dialog;

    @Nullable
    @Bind(R.id.txt_dialog_title)
    TextView txtTitle;

    public ATBaseDialog(Context context) {
        this.mContext = context;
        loadDialog();
    }

    private void loadDialog() {
        setDialog();
        setTitle(null);

        setAdditionalSource();
    }


    private void setDialog() {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();

        dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setDialogView();
        dialog.getWindow().setLayout(metrics.widthPixels - 20, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
    }

    private void setDialogView() {
        dialog.setContentView(setLayoutResId(null).getType());
        ButterKnife.bind(this, dialog);
    }

    public void showDialog() {
        if (!((Activity) mContext).isFinishing()) {
            dialog.show();
        }
    }

    public void hideDialog() {
        dialog.dismiss();
    }

    /////////////////////
    // DIALOG TITLE
    /////////////////////
    protected void setTitle(String title) {
        if(txtTitle != null) {
            if (!TextUtils.isEmpty(title)) {
                txtTitle.setVisibility(View.VISIBLE);
                txtTitle.setText(title);
            } else {
                txtTitle.setVisibility(View.GONE);
            }
        }
    }



    /////////////////////
    // COMMON METHODS
    /////////////////////
    protected void setAdditionalSource() {}

    protected LayoutResId setLayoutResId(LayoutResId layoutResId) {
        return layoutResId;
    }

    public enum LayoutResId {
        DIALOG_LIST_OPTIONS(R.layout.dialog_list_options);

        LayoutResId(int type) { this.type = type; }
        private int type;
        private int getType() {return type;}
    }
}
