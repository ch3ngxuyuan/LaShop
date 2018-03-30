package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.bean.AddressBean;
import com.lala.lashop.ui.user.model.AddressModel;
import com.lala.lashop.ui.user.view.AddressView;

import java.util.List;

/**
 * Created by JX on 2018/3/22.
 */

public class AddressPresenter extends BasePresenter<AddressView> {

    private AddressModel mModel;

    public AddressPresenter() {
        mModel = new AddressModel();
    }

    public void getAddress() {

        getView().showLoadingDialog();

        mModel.address_list(getView().getUserId())
                .compose(this.<HttpResult<List<AddressBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<AddressBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<AddressBean>> httpResult) {
                        getView().setData(httpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });

    }

}
