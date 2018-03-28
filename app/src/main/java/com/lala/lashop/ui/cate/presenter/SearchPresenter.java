package com.lala.lashop.ui.cate.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.cate.model.SearchModel;
import com.lala.lashop.ui.cate.view.SearchView;
import com.lala.lashop.ui.home.bean.ShopsBean;

import java.util.List;

/**
 * Created by JX on 2018/3/21.
 */

public class SearchPresenter extends BasePresenter<SearchView> {

    private SearchModel mModel;

    public SearchPresenter() {
        mModel = new SearchModel();
    }

    public void search() {

        mModel.search(1, getView().getSmallId())
                .compose(this.<HttpResult<List<ShopsBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<ShopsBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<ShopsBean>> listHttpResult) {
                        getView().setData(listHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
