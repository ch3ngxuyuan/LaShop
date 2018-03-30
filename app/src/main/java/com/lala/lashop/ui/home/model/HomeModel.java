package com.lala.lashop.ui.home.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.home.bean.BannerBean;
import com.lala.lashop.ui.home.bean.HomeBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/19.
 */

public class HomeModel extends BaseModel {

    public Observable<HttpResult<List<BannerBean>>> getBanner() {
        return HttpService.execute(Http.class).getBanner();
    }

    public Observable<HttpResult<HomeBean>> getHomeData() {
        return HttpService.execute(Http.class).getHome();
    }

}
