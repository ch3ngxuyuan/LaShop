package com.lala.lashop.fragment;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.base.mvp.CreatePresenter;
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

    @Override
    public int setContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onCreate() {
        getPresenter().getBanner();

        initBanner();
    }

    private void initBanner() {
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.image);
        images.add(R.drawable.image);
        images.add(R.drawable.image);
        images.add(R.drawable.image);
        banner.setImages(images);
        banner.setImageLoader(new BannerImageLoader());
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();
    }
}
