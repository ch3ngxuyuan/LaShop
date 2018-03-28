package com.lala.lashop.ui.cate.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.cate.bean.ShopInfoBean;
import com.lala.lashop.ui.cate.model.ShopInfoModel;
import com.lala.lashop.ui.cate.view.ShopInfoView;
import com.lala.lashop.ui.home.bean.ShopsBean;

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

}
