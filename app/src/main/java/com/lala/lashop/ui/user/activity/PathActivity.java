package com.lala.lashop.ui.user.activity;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;

/**
 * 我的足迹
 * Created by JX on 2018/4/15.
 */

public class PathActivity extends BaseActivity {

    @Override
    public int setContentView() {
        return R.layout.path_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("我的足迹");
    }
}
