package com.lala.lashop.ui.user.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.user.bean.PathBean;
import com.lala.lashop.ui.user.model.PathModel;
import com.lala.lashop.ui.user.view.PathView;
import com.lala.lashop.utils.L;

import java.util.List;

/**
 * Created by JX on 2018/4/18.
 */

public class PathPresenter extends BasePresenter<PathView> {

    private PathModel mModel;

    public PathPresenter() {
        mModel = new PathModel();
    }

    public void getData() {
        getView().showLoadingDialog();

        L.e("获取足迹列表---------");

        mModel.path_list(getView().getUserIdId())
                .compose(this.<HttpResult<List<PathBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<PathBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<PathBean>> listHttpResult) {
                        getView().setData(listHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
