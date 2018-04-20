package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.model.UserDetailModel;
import com.lala.lashop.ui.user.view.UserDetailView;

/**
 * Created by JX on 2018/4/19.
 */

public class UserDetailPresenter extends BasePresenter<UserDetailView> {

    private UserDetailModel mModel;

    public UserDetailPresenter() {
        mModel = new UserDetailModel();
    }

    public void update() {
        getView().showLoadingDialog();

        mModel.user_updateinfo(getView().getUserId(), getView().getName(), getView().getImg(), getView().getSex(), getView().getEmail(), getView().getBirthday())
                .compose(this.<HttpResult>compose())
                .subscribe(new ApiSubscribers<HttpResult>(getView()) {
                    @Override
                    public void onSuccess(HttpResult httpResult) {
                        getView().toast(httpResult.getMess().toString());
                        getView().updateSuccess();
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void uploadImage() {
        getView().showLoadingDialog();

        mModel.upload_image(getView().getHeadFile())
                .compose(this.<HttpResult<String>>compose())
                .subscribe(new ApiSubscribers<HttpResult<String>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<String> stringHttpResult) {
                        getView().uploadSuccess(stringHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }
}
