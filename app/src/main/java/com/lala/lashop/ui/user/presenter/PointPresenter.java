package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.bean.PointBean;
import com.lala.lashop.ui.user.model.PointModel;
import com.lala.lashop.ui.user.view.PointView;

import java.util.List;

/**
 * Created by JX on 2018/4/13.
 */

public class PointPresenter extends BasePresenter<PointView> {

    private PointModel mModel;

    public PointPresenter() {
        mModel = new PointModel();
    }

    public void getCreditData() {
        getView().showLoadingDialog();

        mModel.getCreditList(getView().getUserId())
                .compose(this.<HttpResult<List<PointBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<PointBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<PointBean>> listHttpResult) {
                        getView().setData(listHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
