package com.lala.lashop.ui.shop;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.shop.adapter.ConfirmShopAdapter;
import com.lala.lashop.ui.shop.bean.ConfirmBean;
import com.lala.lashop.ui.shop.bean.JieSuanBean;
import com.lala.lashop.ui.shop.presenter.ConfirmIndentPresenter;
import com.lala.lashop.ui.shop.view.ConfirmIndentView;
import com.lala.lashop.ui.user.activity.AddressActivity;
import com.lala.lashop.ui.user.bean.AddressBean;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 确认订单
 * Created by JX on 2018/4/11.
 */

@CreatePresenter(ConfirmIndentPresenter.class)
public class ConfirmIndentActivity extends BaseActivity<ConfirmIndentView, ConfirmIndentPresenter> implements ConfirmIndentView {

    public static final String JIESUAN_LIST = "jiesuan_list";
    public static final String CONFIRM = "confirm";
    public static final String ADDRESSBEAN = "addressBean";

    private static final int UPDATE_ADDRESS = 111;

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
    @BindView(R.id.tv_address_name)
    TextView tvAddressName;
    @BindView(R.id.tv_address_phone)
    TextView tvAddressPhone;
    @BindView(R.id.tv_address_detail)
    TextView tvAddressDetail;

    private List<JieSuanBean> mJieSuanData;
    private ConfirmBean mConfirmBean;

    private ConfirmShopAdapter confirmShopAdapter;

    private AddressBean addressBean;

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

        getPresenter().getAddress();
    }

    private void initView() {
        tvPrice.setText("合计金额：￥" + mConfirmBean.getTotal());
    }

    @OnClick({R.id.tv_address_update, R.id.tv_point_update, R.id.iv_point, R.id.iv_you, R.id.iv_fa, R.id.tv_fa_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_address_update:
                Intent intent = new Intent(this, AddressActivity.class);
                intent.putExtra(AddressActivity.SELECT_ADDRESS, true);
                startActivityForResult(intent, UPDATE_ADDRESS);
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

    @Override
    public void setAddress(AddressBean data) {
        setAddressView(data);
    }

    private void setAddressView(AddressBean data) {
        addressBean = data;
        tvAddressName.setText("收货人：" + addressBean.getFullName());
        tvAddressPhone.setText(addressBean.getMobile());
        tvAddressDetail.setText("收货地址：" + addressBean.getProvincialName()
                + addressBean.getCityName()
                + addressBean.getAreaName()
                + addressBean.getAddressDetail());
    }

    @Override
    public String getUserId() {
        return App.getUser() == null ? "" : App.getUser().getId();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UPDATE_ADDRESS && resultCode == RESULT_OK) {
            AddressBean addressBean = data.getParcelableExtra(ADDRESSBEAN);
            setAddressView(addressBean);
        }
    }
}