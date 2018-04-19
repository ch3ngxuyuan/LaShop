package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.bean.UserBean;
import com.lala.lashop.ui.user.model.UserModel;
import com.lala.lashop.ui.user.view.UserView;

/**
 * Created by JX on 2018/4/19.
 */

public class UserPresenter extends BasePresenter<UserView> {

    private UserModel mModel;

    public UserPresenter() {
        mModel = new UserModel();
    }

    public void getUserInfo() {
        getView().showLoadingDialog();

        mModel.user_info(getView().getUserId())
                .compose(this.<HttpResult<UserBean>>compose())
                .subscribe(new ApiSubscribers<HttpResult<UserBean>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<UserBean> userBeanHttpResult) {
                        getView().setData(userBeanHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
