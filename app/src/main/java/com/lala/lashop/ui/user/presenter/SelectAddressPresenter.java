package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.bean.ProvinceBean;
import com.lala.lashop.ui.user.model.AddressModel;
import com.lala.lashop.ui.user.model.SelectAddressModel;
import com.lala.lashop.ui.user.view.AddressView;
import com.lala.lashop.ui.user.view.SelectAddressView;

import java.util.List;

/**
 * Created by JX on 2018/3/22.
 */

public class SelectAddressPresenter extends BasePresenter<SelectAddressView> {

    private SelectAddressModel mModel;

    public SelectAddressPresenter() {
        mModel = new SelectAddressModel();
    }

    public void getProvince() {
        getView().showLoadingDialog();

        mModel.selectProvince(getView().getPid())
                .compose(this.<HttpResult<List<ProvinceBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<ProvinceBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<ProvinceBean>> listHttpResult) {
                        getView().setData(listHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
