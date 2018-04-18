package com.lala.lashop.ui.user.activity;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.bean.PathBean;
import com.lala.lashop.ui.user.presenter.PathPresenter;
import com.lala.lashop.ui.user.view.PathView;

import java.util.List;

/**
 * 我的足迹
 * Created by JX on 2018/4/15.
 */

@CreatePresenter(PathPresenter.class)
public class PathActivity extends BaseActivity<PathView, PathPresenter> implements PathView {

    @Override
    public int setContentView() {
        return R.layout.path_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("我的足迹");

        getPresenter().getData();
    }

    @Override
    public void setData(List<PathBean> data) {

    }

    @Override
    public String getUserIdId() {
        return App.getUser() == null ? "" : App.getUser().getId();
    }
}
