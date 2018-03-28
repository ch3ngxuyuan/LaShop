package com.lala.lashop.ui.cate.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.cate.model.CateModel;
import com.lala.lashop.ui.cate.view.CateView;
import com.lala.lashop.ui.home.bean.CategoryBean;

import java.util.List;

/**
 * Created by JX on 2018/3/21.
 */

public class CatePresenter extends BasePresenter<CateView> {

    private CateModel mModel;

    public CatePresenter() {
        mModel = new CateModel();
    }

    public void getCategory() {

        getView().showLoadingDialog();

        mModel.getCategory()
                .compose(this.<HttpResult<List<CategoryBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<CategoryBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<CategoryBean>> listHttpResult) {
                        getView().setData(listHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
