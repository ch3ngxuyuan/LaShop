package com.lala.lashop.ui.user.activity;

import android.view.View;
import android.widget.EditText;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.presenter.RegisterPresenter;
import com.lala.lashop.ui.user.view.RegisterView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册
 * Created by JX on 2018/3/19.
 */

@CreatePresenter(RegisterPresenter.class)
public class RegisterActivity extends BaseActivity<RegisterView, RegisterPresenter> implements RegisterView {

    @BindView(R.id.register_et_phone)
    EditText registerEtPhone;
    @BindView(R.id.register_et_pass)
    EditText registerEtPass;
    @BindView(R.id.register_et_code)
    EditText registerEtCode;

    @Override
    public int setContentView() {
        return R.layout.register_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("注册");
    }

    @Override
    public String getPhone() {
        return registerEtPhone.getText().toString();
    }

    @Override
    public String getPwd() {
        return registerEtPass.getText().toString();
    }

    @Override
    public void registerSuccess() {
        toast("注册成功");
        finish();
    }

    @OnClick({R.id.register_tv_send, R.id.register_tv_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_tv_send:
                break;
            case R.id.register_tv_complete:
                getPresenter().register();
                break;
        }
    }
}
