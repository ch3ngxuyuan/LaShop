package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.bean.DiscountBean;
import com.lala.lashop.ui.user.model.DiscountModel;
import com.lala.lashop.ui.user.view.DiscountView;

import java.util.List;

/**
 * Created by JX on 2018/4/14.
 */

public class DiscountPresenter extends BasePresenter<DiscountView> {

    private DiscountModel mModel;

    public DiscountPresenter() {
        mModel = new DiscountModel();
    }

    public void getDisCountData() {
        getView().showLoadingDialog();

        mModel.discount_list(getView().getUserId())
                .compose(this.<HttpResult<List<DiscountBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<DiscountBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<DiscountBean>> listHttpResult) {
                        getView().setData(listHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
