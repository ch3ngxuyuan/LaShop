package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.bean.IndentBean;
import com.lala.lashop.ui.user.model.IndentModel;
import com.lala.lashop.ui.user.view.IndentView;

/**
 * Created by JX on 2018/4/15.
 */

public class IndentPresenter extends BasePresenter<IndentView> {

    private IndentModel mModel;

    public IndentPresenter() {
        mModel = new IndentModel();
    }

    public void getData() {
        getView().showLoadingDialog();

        mModel.getData(getView().getUserId(), getView().getOrFlag(), "")
                .compose(this.<HttpResult<IndentBean>>compose())
                .subscribe(new ApiSubscribers<HttpResult<IndentBean>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<IndentBean> httpResult) {
                        getView().setData(httpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
