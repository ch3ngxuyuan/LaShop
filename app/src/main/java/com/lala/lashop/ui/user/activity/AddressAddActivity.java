package com.lala.lashop.ui.user.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.http.Body;

/**
 * 添加地址
 * Created by JX on 2018/3/20.
 */

public class AddressAddActivity extends BaseActivity {

    private static final int SELECT_ADDRESS = 1;

    @BindView(R.id.address_tv_select)
    TextView tvSelect;

    @Override
    public int setContentView() {
        return R.layout.address_add_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("新增收货地址");
    }

    @OnClick({R.id.address_ll_select, R.id.address_tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.address_ll_select:
                startActivityForResult(SelectAddressActivity.class, SELECT_ADDRESS);
                break;
            case R.id.address_tv_save:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_ADDRESS && resultCode == RESULT_OK) {
            tvSelect.setText(data.getStringExtra("address"));
        }
    }
}
