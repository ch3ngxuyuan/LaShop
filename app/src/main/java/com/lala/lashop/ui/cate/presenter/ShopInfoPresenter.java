package com.lala.lashop.ui.cate.presenter;

import android.text.TextUtils;

import com.lala.lashop.Constant;
import com.lala.lashop.app.App;
import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.cate.bean.ShopInfoBean;
import com.lala.lashop.ui.cate.model.ShopInfoModel;
import com.lala.lashop.ui.cate.view.ShopInfoView;
import com.lala.lashop.ui.shop.bean.ConfirmBean;
import com.lala.lashop.utils.L;
import com.lala.lashop.utils.RxBus;

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
                        collCheck();
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void collCheck() {
        if (TextUtils.isEmpty(getView().getUserId())) return;

        mModel.collCheck(getView().getShopId(), getView().getUserId())
                .compose(this.<HttpResult<Integer>>compose())
                .subscribe(new ApiSubscribers<HttpResult<Integer>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<Integer> httpResult) {
                        getView().checkCollSuccess(httpResult.getMess());
                    }

                    @Override
                    public boolean getDisplay() {
                        return false;
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void addCart(final boolean isJiesuan) {
        if (TextUtils.isEmpty(getView().getCount())) {
            getView().toast("数量不能为空");
            return;
        }

        getView().showLoadingDialog();

        mModel.addCart(getView().getShopId(), getView().getUserIdId(), getView().getCount(), getView().getColor(), getView().getGui(), getView().getYunFei())
                .compose(this.<HttpResult>compose())
                .subscribe(new ApiSubscribers<HttpResult>(getView()) {
                    @Override
                    public void onSuccess(HttpResult httpResult) {
                        if (isJiesuan) {
                            jiesuan();
                        } else {
                            RxBus.getInstance().post(Constant.CART);
                            getView().toast(httpResult.getMess().toString());
                        }
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void jiesuan() {
        getView().showLoadingDialog();

        mModel.jiesuan(getView().getShopId(), getView().getUserIdId(), getView().getColor(), getView().getGui())
                .compose(this.<HttpResult<ConfirmBean>>compose())
                .subscribe(new ApiSubscribers<HttpResult<ConfirmBean>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<ConfirmBean> httpResult) {
                        getView().jieSuanSuccess(httpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void addPath() {
        if (App.getUser() == null) return;

        L.e("添加足迹----------");

        mModel.path_add(getView().getUserIdId(), getView().getShopId())
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
