package com.lala.lashop.ui.home.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.home.bean.HomeBean;
import com.lala.lashop.ui.home.model.ShopListModel;
import com.lala.lashop.ui.home.view.ShopListView;

/**
 * Created by JX on 2018/4/16.
 */

public class ShopListPresenter extends BasePresenter<ShopListView> {

    private ShopListModel mModel;

    public ShopListPresenter() {
        mModel = new ShopListModel();
    }

    public void getHomeData() {
        getView().showLoadingDialog();

        mModel.getHomeData()
                .compose(this.<HttpResult<HomeBean>>compose())
                .subscribe(new ApiSubscribers<HttpResult<HomeBean>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<HomeBean> homeBeanHttpResult) {
                        getView().setData(homeBeanHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }
}
