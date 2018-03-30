package com.lala.lashop.ui.user.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.bean.AddressBean;
import com.lala.lashop.ui.user.presenter.AddressAddPresenter;
import com.lala.lashop.ui.user.view.AddressAddView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 添加地址
 * Created by JX on 2018/3/20.
 */

@CreatePresenter(AddressAddPresenter.class)
public class AddressAddActivity extends BaseActivity<AddressAddView, AddressAddPresenter> implements AddressAddView {

    private static final int SELECT_ADDRESS = 1;
    public static final String ADDRESS_UPDATE = "address_update";
    public static final String ADDRESSBEAN = "addressBean";

    @BindView(R.id.address_tv_select)
    TextView tvSelect;
    @BindView(R.id.address_et_name)
    EditText addressEtName;
    @BindView(R.id.address_et_mobile)
    EditText addressEtMobile;
    @BindView(R.id.address_et_detail)
    EditText addressEtDetail;
    @BindView(R.id.address_switch)
    Switch aSwitch;

    private AddressBean addressBean;
    private boolean isUpdate = false; //是否为更新

    private String province;
    private String city;
    private String area;

    @Override
    public int setContentView() {
        return R.layout.address_add_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("新增收货地址");
        isUpdate = getIntent().getBooleanExtra(ADDRESS_UPDATE, false);

        if (isUpdate) {
            initView();
        }
    }

    private void initView() {
        addressBean = getIntent().getParcelableExtra(ADDRESSBEAN);
        addressEtName.setText(addressBean.getFullName());
        addressEtMobile.setText(addressBean.getMobile());
        addressEtDetail.setText(addressBean.getAddressDetail());
        province = addressBean.getProv();
        city = addressBean.getCity();
        area = addressBean.getArea();

        tvSelect.setText(province + city + area);

        if (addressBean.getM_id() == "1") {
            aSwitch.setChecked(true);
        }
    }

    @OnClick({R.id.address_ll_select, R.id.address_tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.address_ll_select:
                startActivityForResult(SelectAddressActivity.class, SELECT_ADDRESS);
                break;
            case R.id.address_tv_save:
                if (isUpdate) {
                    getPresenter().update();
                } else {
                    getPresenter().add();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_ADDRESS && resultCode == RESULT_OK) {
            province = data.getStringExtra("province");
            city = data.getStringExtra("city");
            area = data.getStringExtra("area");
            tvSelect.setText(province + city + area);
        }
    }

    @Override
    public void addSuccess() {
        toast("添加成功");
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void updateSuccess() {
        toast("更新成功");
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public String getUserId() {
        return App.getUser().getUser_id();
    }

    @Override
    public String getMobile() {
        return addressEtMobile.getText().toString();
    }

    @Override
    public String getProvcine() {
        return province;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getArea() {
        return area;
    }

    @Override
    public String getDetail() {
        return addressEtDetail.getText().toString();
    }

    @Override
    public int getDefault() {
        return aSwitch.isChecked() ? 1 : 0;
    }

    @Override
    public String getName() {
        return addressEtName.getText().toString();
    }

    @Override
    public String getAddressId() {
        return addressBean.getId();
    }
}
