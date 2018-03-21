package com.lala.lashop.ui.user.presenter;

import android.text.TextUtils;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.model.LoginModel;
import com.lala.lashop.ui.user.model.RegisterModel;
import com.lala.lashop.ui.user.view.LoginView;
import com.lala.lashop.ui.user.view.RegisterView;

/**
 * Created by JX on 2018/3/21.
 */

public class RegisterPresenter extends BasePresenter<RegisterView> {

    private RegisterModel mModel;

    public RegisterPresenter() {
        mModel = new RegisterModel();
    }

    public void register() {
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

        mModel.register(phone, pwd)
                .compose(this.<HttpResult>compose())
                .subscribe(new ApiSubscribers<HttpResult>(getView()) {
                    @Override
                    public void onSuccess(HttpResult httpResult) {
                        getView().registerSuccess();
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });

    }
}
