package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.bean.CollBean;
import com.lala.lashop.ui.user.model.CollModel;
import com.lala.lashop.ui.user.view.CollView;

import java.util.List;

/**
 * Created by JX on 2018/3/22.
 */

public class CollPresenter extends BasePresenter<CollView> {

    private CollModel mModel;

    public CollPresenter() {
        mModel = new CollModel();
    }

    public void getColl() {
        getView().showLoadingDialog();

        mModel.collList(getView().getUserId())
                .compose(this.<HttpResult<List<CollBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<CollBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<CollBean>> httpResult) {
                        getView().setData(httpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void deleteColl() {
        getView().showLoadingDialog();

        mModel.collDelete(getView().getCollectId(), getView().getUserId())
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
