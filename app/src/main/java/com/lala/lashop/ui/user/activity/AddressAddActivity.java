package com.lala.lashop.ui.user.activity;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;

/**
 * 添加地址
 * Created by JX on 2018/3/20.
 */

public class AddressAddActivity extends BaseActivity {

    @Override
    public int setContentView() {
        return R.layout.address_add_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("新增收货地址");
    }
}
