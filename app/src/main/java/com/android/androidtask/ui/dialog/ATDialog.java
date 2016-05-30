package com.android.androidtask.ui.dialog;

import android.content.Context;
import android.widget.LinearLayout;

import com.android.androidtask.R;
import com.android.androidtask.base.ATBaseDialog;
import com.android.androidtask.util.ATResourceUtils;
import com.android.androidtask.ui.view.ATDialogActionItem;

import butterknife.Bind;

/**
 * Created by vanya on 28.05.16.
 */
public class ATDialog extends ATBaseDialog {

    @Bind(R.id.dialog_fixed_list_content)LinearLayout layout;

    public ATDialog(Context context) {
        super(context);
        initView();
    }

    @Override
    protected LayoutResId setLayoutResId(LayoutResId layoutResId) {
        return LayoutResId.DIALOG_LIST_OPTIONS;
    }

    @Override
    protected void setTitle(String title) {
        super.setTitle(ATResourceUtils.getStringFromResource(R.string.actions));
    }

    private void initView() {
        createNewItem(R.string.set_as_favourite, R.drawable.ic_star);
        createNewItem(R.string.get_permalink, R.drawable.ic_link);
        createNewItem(R.string.delete, R.drawable.ic_delete);
    }

    private void createNewItem(int labelResource, int iconResource) {
        ATDialogActionItem item = new ATDialogActionItem(mContext);
        item.setLabel(ATResourceUtils.getStringFromResource(labelResource));
        item.setIcon(iconResource);
        layout.addView(item);
    }

}
