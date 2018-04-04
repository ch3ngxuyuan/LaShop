package com.lala.lashop.ui.shop.presenter;

import com.lala.lashop.app.App;
import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.shop.model.ShopModel;
import com.lala.lashop.ui.shop.view.ShopView;

/**
 * Created by JX on 2018/4/4.
 */

public class ShopPresenter extends BasePresenter<ShopView> {

    private ShopModel mModel;

    public ShopPresenter() {
        mModel = new ShopModel();
    }

    public void getCartList() {
        if (App.getUser() == null) {
            getView().toast("未登录");
            return;
        }

        getView().showLoadingView();

        mModel.cart_list(App.getUser().getUser_id())
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
