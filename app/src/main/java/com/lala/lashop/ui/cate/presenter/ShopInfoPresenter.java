package com.lala.lashop.ui.cate.presenter;

import android.text.TextUtils;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.cate.bean.ShopInfoBean;
import com.lala.lashop.ui.cate.model.ShopInfoModel;
import com.lala.lashop.ui.cate.view.ShopInfoView;

/**
 * Created by JX on 2018/3/21.
 */

public class ShopInfoPresenter extends BasePresenter<ShopInfoView> {

    private ShopInfoModel mModel;

    public ShopInfoPresenter() {
        mModel = new ShopInfoModel();
    }

    public void getShopInfo() {

        getView().showLoadingDialog();

        mModel.getShopInfo(getView().getShopId(), getView().getUserId())
                .compose(this.<HttpResult<ShopInfoBean>>compose())
                .subscribe(new ApiSubscribers<HttpResult<ShopInfoBean>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<ShopInfoBean> httpResult) {
                        getView().setData(httpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void collAdd() {
        getView().showLoadingDialog();

        mModel.collAdd(getView().getShopId(), getView().getUserId())
                .compose(this.<HttpResult>compose())
                .subscribe(new ApiSubscribers<HttpResult>(getView()) {
                    @Override
                    public void onSuccess(HttpResult httpResult) {
                        getView().toast(httpResult.getMess().toString());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void collCheck() {
        if (TextUtils.isEmpty(getView().getUserId())) return;

        mModel.collCheck(getView().getShopId(), getView().getUserId())
                .compose(this.<HttpResult>compose())
                .subscribe(new ApiSubscribers<HttpResult>(getView()) {
                    @Override
                    public void onSuccess(HttpResult httpResult) {
                        getView().toast(httpResult.getMess().toString());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void addCart() {
        if (TextUtils.isEmpty(getView().getCount())) {
            getView().toast("数量不能为空");
            return;
        }

        mModel.addCart(getView().getShopId(), getView().getUserId(), getView().getCount(), getView().getColor(), getView().getGui(), getView().getYunFei())
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
