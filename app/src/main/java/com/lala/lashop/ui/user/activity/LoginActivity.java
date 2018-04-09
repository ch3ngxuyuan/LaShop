package com.lala.lashop.ui.user.activity;

import android.view.View;
import android.widget.EditText;

import com.lala.lashop.Constant;
import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.bean.UserBean;
import com.lala.lashop.ui.user.presenter.LoginPresenter;
import com.lala.lashop.ui.user.view.LoginView;
import com.lala.lashop.utils.RxBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by JX on 2018/3/19.
 */

@CreatePresenter(LoginPresenter.class)
public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    @BindView(R.id.login_et_pass)
    EditText loginEtPass;
    @BindView(R.id.login_et_phone)
    EditText loginEtPhone;

    @Override
    public int setContentView() {
        return R.layout.login_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("登录");
    }

    @OnClick({R.id.login_tv_register, R.id.login_tv_forget, R.id.login_tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_tv_register:
                startActivity(RegisterActivity.class);
                break;
            case R.id.login_tv_forget:
                startActivity(FoundActivity.class);
                break;
            case R.id.login_tv_login:
                getPresenter().login();
                break;
        }
    }

    @Override
    public String getPhone() {
        return loginEtPhone.getText().toString();
    }

    @Override
    public String getPwd() {
        return loginEtPass.getText().toString();
    }

    @Override
    public void loginSuccess(UserBean user) {
        toast("登录成功");
        App.cacheUser(user);
        RxBus.getInstance().post(Constant.LOGIN);
        finish();
    }
}
