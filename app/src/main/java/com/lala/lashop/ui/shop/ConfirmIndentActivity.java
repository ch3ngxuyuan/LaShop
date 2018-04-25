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
import com.lala.lashop.ui.shop.bean.InvoiceBean;
import com.lala.lashop.ui.shop.bean.JieSuanBean;
import com.lala.lashop.ui.shop.presenter.ConfirmIndentPresenter;
import com.lala.lashop.ui.shop.view.ConfirmIndentView;
import com.lala.lashop.ui.user.activity.AddressActivity;
import com.lala.lashop.ui.user.bean.AddressBean;
import com.lala.lashop.utils.ArrayUtil;

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
    public static final String INVOICEBEAN = "invoiceBean";
    public static final String ISBUYNOW = "is_buynow";

    private static final int UPDATE_ADDRESS = 111;
    private static final int UPDATE_INVOICE = 222;

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
    @BindView(R.id.tv_invoice_name)
    TextView tvInvoiceName;
    @BindView(R.id.tv_invoice_number)
    TextView tvInvoiceNumber;
    @BindView(R.id.tv_yunfei)
    TextView tvYunfei;

    private List<JieSuanBean> mJieSuanData;
    private ConfirmBean mConfirmBean;
    private boolean isBuyNow = false; //是否为购物详情立即购买

    private boolean isPoint = true; //是否使用积分
    private boolean isDiscount = true; //是否使用优惠券
    private boolean isInvoice = true; //是否使用发票

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
        isBuyNow = getIntent().getBooleanExtra(ISBUYNOW, false);

        if (isBuyNow) {
            if (!ArrayUtil.isEmpty(mJieSuanData) && mConfirmBean.getOrder() != null) {
                mJieSuanData.get(0).setSp_count(mConfirmBean.getOrder().getSp_count());
            }
        }

        tvPrice.setText("￥" + mConfirmBean.getTotal());
        if (Double.parseDouble(mConfirmBean.getYunfei()) != 0) {
            tvYunfei.setText("邮费：￥" + mConfirmBean.getYunfei());
        }

        confirmShopAdapter = new ConfirmShopAdapter(R.layout.confirm_shop_rv_item, mJieSuanData);
        confirmShopAdapter.bindToRecyclerView(rvShop);
        rvShop.setLayoutManager(new LinearLayoutManager(this));
        rvShop.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        getPresenter().getAddress();
        getPresenter().getInvoice();
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
                clickPoint();
                break;
            case R.id.iv_you:
                clickDiscount();
                break;
            case R.id.iv_fa:
                clickInvoice();
                break;
            case R.id.tv_fa_update: //发票
                startActivityForResult(InvoiceActivity.class, UPDATE_INVOICE);
                break;
        }
    }

    @Override
    public void setAddress(AddressBean data) {
        setAddressView(data);
    }

    @Override
    public void setInvoice(List<InvoiceBean> data) {
        if (!ArrayUtil.isEmpty(data)) {
            setInvoiceView(data.get(0));
        }else {

        }
    }

    private void setInvoiceView(InvoiceBean data) {
        tvInvoiceName.setText(data.getHead());
        tvInvoiceNumber.setText(data.getTaxnumber());
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
    public String getUserIdId() {
        return App.getUser() == null ? "" : App.getUser().getId();
    }

    @Override
    public String getUserId() {
        return App.getUser() == null ? "" : App.getUser().getUser_id();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UPDATE_ADDRESS && resultCode == RESULT_OK) {
            AddressBean addressBean = data.getParcelableExtra(ADDRESSBEAN);
            setAddressView(addressBean);
        } else if (requestCode == UPDATE_INVOICE && resultCode == RESULT_OK) {
            if (data == null) {
                getPresenter().getInvoice();
            } else {
                InvoiceBean invoiceBean = data.getParcelableExtra(INVOICEBEAN);
                setInvoiceView(invoiceBean);
            }
        }
    }

    //点击积分开关
    private void clickPoint() {
        isPoint = !isPoint;
        ivPoint.setImageResource(isPoint ? R.drawable.kai : R.drawable.guan);
    }

    //点击优惠券开关
    private void clickDiscount() {
        isDiscount = !isDiscount;
        ivYou.setImageResource(isDiscount ? R.drawable.kai : R.drawable.guan);
    }

    //点击发票开关
    private void clickInvoice() {
        isInvoice = !isInvoice;
        ivFa.setImageResource(isInvoice ? R.drawable.kai : R.drawable.guan);
    }
}