package com.lala.lashop.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.http.ApiPath;
import com.lala.lashop.ui.home.adapter.HomeShopAdapter;
import com.lala.lashop.ui.home.bean.BannerBean;
import com.lala.lashop.ui.home.bean.CategoryBean;
import com.lala.lashop.ui.home.bean.HomeBean;
import com.lala.lashop.ui.home.presenter.HomePresenter;
import com.lala.lashop.ui.home.view.HomeView;
import com.lala.lashop.utils.BannerImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by JX on 2018/3/17.
 */

@CreatePresenter(HomePresenter.class)
public class HomeFragment extends BaseFragment<HomeView, HomePresenter> implements HomeView {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.home_rv)
    RecyclerView rv;

    private HomeShopAdapter homeShopAdapter;

    @Override
    public int setContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate() {
        homeShopAdapter = new HomeShopAdapter(R.layout.home_shop_rv_item, new ArrayList<CategoryBean>());
        homeShopAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setNestedScrollingEnabled(false);

        getPresenter().getBanner();
        getPresenter().getHomeData();
    }

    @Override
    public void setBannerData(List<BannerBean> data) {
        List<String> images = new ArrayList<>();
        for (BannerBean bean : data) {
            images.add(ApiPath.IMG_URL + bean.getImg());
        }
        banner.setImageLoader(new BannerImageLoader());
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setImages(images);
        banner.start();
    }

    @Override
    public void setHomeData(HomeBean data) {
        homeShopAdapter.setNewData(data.getCategory());
    }
}
