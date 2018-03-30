package com.lala.lashop.ui.home.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.home.bean.BannerBean;
import com.lala.lashop.ui.home.bean.HomeBean;

import java.util.List;

/**
 * Created by JX on 2018/3/19.
 */

public interface HomeView extends BaseView {

    void setBannerData(List<BannerBean> data);

    void setHomeData(HomeBean data);

}
