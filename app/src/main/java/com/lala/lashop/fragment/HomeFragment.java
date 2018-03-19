package com.lala.lashop.fragment;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.home.presenter.HomePresenter;
import com.lala.lashop.ui.home.view.HomeView;

/**
 * Created by JX on 2018/3/17.
 */

@CreatePresenter(HomePresenter.class)
public class HomeFragment extends BaseFragment<HomeView, HomePresenter> implements HomeView {

    @Override
    public int setContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate() {
        getPresenter().getBanner();
    }
}
