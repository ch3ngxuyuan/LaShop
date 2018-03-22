package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.model.AddressModel;
import com.lala.lashop.ui.user.view.AddressView;

/**
 * Created by JX on 2018/3/22.
 */

public class AddressPresenter extends BasePresenter<AddressView> {

    private AddressModel mModel;

    public AddressPresenter() {
        mModel = new AddressModel();
    }

    public void getAddress() {
        mModel.selectProvince()
                .compose(this.<HttpResult>compose())
                .subscribe(new ApiSubscribers<HttpResult>(getView()) {
                    @Override
                    public void onSuccess(HttpResult httpResult) {

                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });

    }

}
