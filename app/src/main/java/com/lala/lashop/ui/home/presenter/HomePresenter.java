package com.lala.lashop.ui.home.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.home.bean.BannerBean;
import com.lala.lashop.ui.home.model.HomeModel;
import com.lala.lashop.ui.home.view.HomeView;

import java.util.List;

/**
 * Created by JX on 2018/3/19.
 */

public class HomePresenter extends BasePresenter<HomeView> {

    private HomeModel mModel;

    public HomePresenter() {
        mModel = new HomeModel();
    }

    public void getBanner() {
        mModel.getBanner()
                .compose(this.<HttpResult<List<BannerBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<BannerBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<BannerBean>> listHttpResult) {

                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });

    }
}
