package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.bean.PointBean;
import com.lala.lashop.ui.user.model.PointModel;
import com.lala.lashop.ui.user.view.PointView;
import com.lala.lashop.utils.ArrayUtil;

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
//                        if (ArrayUtil.isEmpty(listHttpResult.getMess())) {
////                            getView().toast("暂无数据");
//                        }else {
                            getView().setData(listHttpResult.getMess());
//                        }
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void getCurrentCredit() {
        getView().showLoadingDialog();
        mModel.credit_user(getView().getUserId())
                .compose(this.<HttpResult<String>>compose())
                .subscribe(new ApiSubscribers<HttpResult<String>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<String> httpResult) {
                        getView().setCurrentCredit(httpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
