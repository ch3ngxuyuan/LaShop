package com.lala.lashop.ui.shop;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.ui.shop.adapter.InvoiceAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 确认订单
 * Created by JX on 2018/4/11.
 */

public class ConfirmIndentActivity extends BaseActivity {

    @BindView(R.id.rv_shop)
    RecyclerView rvShop;
    @BindView(R.id.iv_point)
    ImageView ivPoint;
    @BindView(R.id.iv_you)
    ImageView ivYou;
    @BindView(R.id.iv_fa)
    ImageView ivFa;

    @Override
    public int setContentView() {
        return R.layout.confirm_indent_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("确认订单");
    }

    @OnClick({R.id.tv_address_update, R.id.tv_point_update, R.id.iv_point, R.id.iv_you, R.id.iv_fa, R.id.tv_fa_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_address_update:
                break;
            case R.id.tv_point_update:
                break;
            case R.id.iv_point:
                break;
            case R.id.iv_you:
                break;
            case R.id.iv_fa:
                break;
            case R.id.tv_fa_update: //发票
                startActivity(InvoiceActivity.class);
                break;
        }
    }
}
