package com.lala.lashop.ui.user.presenter;

import android.text.TextUtils;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.model.AddressAddModel;
import com.lala.lashop.ui.user.view.AddressAddView;

/**
 * Created by JX on 2018/3/22.
 */

public class AddressAddPresenter extends BasePresenter<AddressAddView> {

    private AddressAddModel mModel;

    public AddressAddPresenter() {
        mModel = new AddressAddModel();
    }

    public void add() {
        String mobile = getView().getMobile();
        String province = getView().getProvcine();
        String city = getView().getCity();
        String area = getView().getArea();
        String detail = getView().getDetail();
        int isDefault = getView().getDefault();
        String name = getView().getName();

        if (TextUtils.isEmpty(name)) {
            getView().toast("收货人为空");
            return;
        }

        if (TextUtils.isEmpty(mobile)) {
            getView().toast("手机号码为空");
            return;
        }

        if (TextUtils.isEmpty(province)) {
            getView().toast("省份为空");
            return;
        }

        if (TextUtils.isEmpty(city)) {
            getView().toast("市为空");
            return;
        }

        if (TextUtils.isEmpty(area)) {
            getView().toast("区为空");
            return;
        }

        if (TextUtils.isEmpty(detail)) {
            getView().toast("详细地址为空");
            return;
        }

        getView().showLoadingDialog();

        mModel.address_add(getView().getUserId(), mobile, province, city, area, detail, isDefault, name)
                .compose(this.<HttpResult>compose())
                .subscribe(new ApiSubscribers<HttpResult>(getView()) {
                    @Override
                    public void onSuccess(HttpResult httpResult) {
                        getView().addSuccess();
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });

    }

    public void update() {
        String mobile = getView().getMobile();
        String province = getView().getProvcine();
        String city = getView().getCity();
        String area = getView().getArea();
        String detail = getView().getDetail();
        int isDefault = getView().getDefault();
        String name = getView().getName();

        if (TextUtils.isEmpty(name)) {
            getView().toast("收货人为空");
            return;
        }

        if (TextUtils.isEmpty(mobile)) {
            getView().toast("手机号码为空");
            return;
        }

        if (TextUtils.isEmpty(province)) {
            getView().toast("省份为空");
            return;
        }

        if (TextUtils.isEmpty(city)) {
            getView().toast("市为空");
            return;
        }

        if (TextUtils.isEmpty(area)) {
            getView().toast("区为空");
            return;
        }

        if (TextUtils.isEmpty(detail)) {
            getView().toast("详细地址为空");
            return;
        }

        getView().showLoadingDialog();

        mModel.address_update(getView().getUserId(), mobile, province, city, area, detail, isDefault, name, getView().getAddressId())
                .compose(this.<HttpResult>compose())
                .subscribe(new ApiSubscribers<HttpResult>(getView()) {
                    @Override
                    public void onSuccess(HttpResult httpResult) {
                        getView().updateSuccess();
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
