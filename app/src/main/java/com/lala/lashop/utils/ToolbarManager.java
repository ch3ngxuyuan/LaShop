package com.lala.lashop.utils;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lala.lashop.R;


/**
 * Created by JX on 2017/12/12.
 */

public class ToolbarManager {

    private Toolbar mToolbar;
    private ImageView ivBack;
    private TextView tvTitle;
    private TextView tvRight;
    private ImageView ivRight;

    private Activity activity;

    public ToolbarManager(Activity activity) {
        this.activity = activity;
        mToolbar = activity.findViewById(R.id.toolbar);
        initView();
    }

    private void initView() {
        if (mToolbar == null) return;
        ivBack = mToolbar.findViewById(R.id.iv_back);
        tvTitle = mToolbar.findViewById(R.id.tv_title);
        tvRight = mToolbar.findViewById(R.id.tv_right);
        ivRight = mToolbar.findViewById(R.id.iv_right);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    public void setTitle(String title) {
        if (tvTitle == null) return;
        tvTitle.setText(title);
    }

    public void setTitle(int strId) {
        if (tvTitle == null) return;
        tvTitle.setText(activity.getResources().getString(strId));
    }

    public void setBackListener(View.OnClickListener listener) {
        if (ivBack == null) return;
        ivBack.setOnClickListener(listener);
    }

    public void hiddenBack(boolean hidden) {
        ivBack.setVisibility(hidden ? View.GONE : View.VISIBLE);
    }

    public TextView setRightText(String right) {
        if (tvRight == null) return null;
        tvRight.setText(right);
        tvRight.setVisibility(View.VISIBLE);
        return tvRight;
    }

    public TextView setRightText(int right) {
        if (tvRight == null) return null;
        tvRight.setText(activity.getResources().getString(right));
        tvRight.setVisibility(View.VISIBLE);
        return tvRight;
    }

    public ImageView setRightImage(@DrawableRes int right) {
        if (ivRight == null) return null;
        ivRight.setImageResource(right);
        ivRight.setVisibility(View.VISIBLE);
        return ivRight;
    }

}
