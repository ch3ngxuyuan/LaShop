package com.lala.lashop.ui.user.activity;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;

/**
 * 忘记密码
 * Created by JX on 2018/3/19.
 */

public class FoundActivity extends BaseActivity {

    @Override
    public int setContentView() {
        return R.layout.found_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("忘记密码");
    }
}
