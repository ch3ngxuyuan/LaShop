package com.lala.lashop.ui.user.activity;

import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.ui.user.bean.UserBean;

import butterknife.BindView;

/**
 * 用户资料
 * Created by JX on 2018/3/22.
 */

public class UserDetailActivity extends BaseActivity {

    @BindView(R.id.user_tv_name)
    TextView userTvName;
    @BindView(R.id.tv_phone)
    TextView tvName;

    private UserBean user;

    @Override
    public int setContentView() {
        return R.layout.user_detail_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("");

        initView();
    }

    private void initView() {
        user = App.getUser();

        userTvName.setText(user.getU_phone());
        tvName.setText(user.getU_phone());
    }

}
