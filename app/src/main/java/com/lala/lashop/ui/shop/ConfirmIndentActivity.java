package com.lala.lashop.ui.shop;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.ui.shop.adapter.ConfirmShopAdapter;
import com.lala.lashop.ui.shop.bean.ConfirmBean;
import com.lala.lashop.ui.shop.bean.JieSuanBean;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 确认订单
 * Created by JX on 2018/4/11.
 */

public class ConfirmIndentActivity extends BaseActivity {

    public static final String JIESUAN_LIST = "jiesuan_list";
    public static final String CONFIRM = "confirm";

    @BindView(R.id.rv_shop)
    RecyclerView rvShop;
    @BindView(R.id.iv_point)
    ImageView ivPoint;
    @BindView(R.id.iv_you)
    ImageView ivYou;
    @BindView(R.id.iv_fa)
    ImageView ivFa;
    @BindView(R.id.tv_price)
    TextView tvPrice;

    private List<JieSuanBean> mJieSuanData;
    private ConfirmBean mConfirmBean;

    private ConfirmShopAdapter confirmShopAdapter;

    @Override
    public int setContentView() {
        return R.layout.confirm_indent_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("确认订单");

        mJieSuanData = getIntent().getParcelableArrayListExtra(JIESUAN_LIST);
        mConfirmBean = getIntent().getParcelableExtra(CONFIRM);

        initView();

        confirmShopAdapter = new ConfirmShopAdapter(R.layout.confirm_shop_rv_item, mJieSuanData);
        confirmShopAdapter.bindToRecyclerView(rvShop);
        rvShop.setLayoutManager(new LinearLayoutManager(this));
        rvShop.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    private void initView() {
        tvPrice.setText("合计金额：￥" + mConfirmBean.getTotal());
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