package com.lala.lashop.ui.shop.presenter;

import com.lala.lashop.app.App;
import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.shop.bean.CartBean;
import com.lala.lashop.ui.shop.model.ShopModel;
import com.lala.lashop.ui.shop.view.ShopView;

import java.util.List;

/**
 * Created by JX on 2018/4/4.
 */

public class ShopPresenter extends BasePresenter<ShopView> {

    private ShopModel mModel;

    public ShopPresenter() {
        mModel = new ShopModel();
    }

    public void getCartList() {
        if (getView() == null) return;
        if (App.getUser() == null) {
            getView().toast("未登录");
            return;
        }

        getView().showLoadingView();

        mModel.cart_list(App.getUser().getUser_id())
                .compose(this.<HttpResult<List<CartBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<CartBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<CartBean>> httpResult) {
                        getView().setData(httpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void delete() {
        getView().showLoadingDialog();

        mModel.cart_delete(getView().getOrderId())
                .compose(this.<HttpResult>compose())
                .subscribe(new ApiSubscribers<HttpResult>(getView()) {
                    @Override
                    public void onSuccess(HttpResult httpResult) {
                        getView().deleteSuccess();
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }
}
