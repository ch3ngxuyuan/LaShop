package com.lala.lashop.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.http.ApiPath;
import com.lala.lashop.ui.home.ShopListActivity;
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
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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

    @OnClick({R.id.iv_0, R.id.iv_1, R.id.iv_2, R.id.iv_3, R.id.iv_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_0:
                toShopList(0);
                break;
            case R.id.iv_1:
                toShopList(1);
                break;
            case R.id.iv_2:
                toShopList(2);
                break;
            case R.id.iv_3:
                toShopList(3);
                break;
            case R.id.iv_4:
                toShopList(4);
                break;
        }
    }

    private void toShopList(int type) {
        Bundle bundle = new Bundle();
        bundle.putInt(ShopListActivity.TYPE, type);
        startActivity(ShopListActivity.class, bundle);
    }

}
