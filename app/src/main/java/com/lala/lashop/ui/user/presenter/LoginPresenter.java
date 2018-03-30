package com.lala.lashop.ui.user.presenter;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.bean.UserBean;
import com.lala.lashop.ui.user.model.LoginModel;
import com.lala.lashop.ui.user.view.LoginView;

/**
 * Created by JX on 2018/3/21.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private LoginModel mModel;

    public LoginPresenter() {
        mModel = new LoginModel();
    }

    public void login() {
        String phone = getView().getPhone();
        String pwd = getView().getPwd();

        if (TextUtils.isEmpty(phone)) {
            getView().toast("账号不能为空");
            return;
        }

        if (TextUtils.isEmpty(pwd)) {
            getView().toast("密码不能为空");
            return;
        }

        getView().showLoadingDialog();

        mModel.login(phone, pwd)
                .compose(this.<HttpResult<UserBean>>compose())
                .subscribe(new ApiSubscribers<HttpResult<UserBean>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<UserBean> userBeanHttpResult) {
                        getView().loginSuccess(userBeanHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }
}
