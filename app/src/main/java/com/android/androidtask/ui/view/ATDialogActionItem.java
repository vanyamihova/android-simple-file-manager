package com.android.androidtask.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.androidtask.R;
import com.android.androidtask.util.ATResourceUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by vanya on 28.05.16.
 */
public class ATDialogActionItem extends FrameLayout implements View.OnClickListener {

    @Nullable @Bind(R.id.action_item_container)LinearLayout layout;
    @Nullable @Bind(R.id.action_item_icon)ImageView icon;
    @Nullable @Bind(R.id.action_item_label)TextView text;

    String labelResource;
    Drawable iconResource;

    public ATDialogActionItem(Context context) {
        super(context);
        init(null);
    }

    public ATDialogActionItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ATDialogActionItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.layout_action_item, this);
        ButterKnife.bind(this);

        if(attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ATActionItem);

            labelResource = typedArray.getString(R.styleable.ATActionItem_at_title);
            iconResource = typedArray.getDrawable(R.styleable.ATActionItem_at_icon);

            typedArray.recycle();
        }

        if (text != null) {
            text.setText(labelResource);
            text.setOnClickListener(this);
        }

        if (icon != null) {
            if (iconResource != null) {
                icon.setVisibility(VISIBLE);
                icon.setImageDrawable(iconResource);
            } else {
                icon.setVisibility(GONE);
            }
            icon.setOnClickListener(this);
        }

        if (layout != null) {
            layout.setOnClickListener(this);
        }
    }

    public void setLabel(String label) {
        if (text != null) {
            text.setText(label);
            invalidate();
        }
    }


    public void setIcon(int resource) {
        if (icon != null) {
            if (resource > 0) {
                icon.setVisibility(VISIBLE);
                icon.setImageDrawable(ATResourceUtils.getDrawableFromResource(resource));
            } else {
                icon.setVisibility(GONE);
            }
            invalidate();
        }
    }

    @Override
    public void onClick(View v) {
        Log.i("TAG", text.getText().toString());
    }

}
