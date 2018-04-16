package com.lala.lashop.ui.home.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.home.bean.HomeBean;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/4/16.
 */

public class ShopListModel extends BaseModel {

    public Observable<HttpResult<HomeBean>> getHomeData() {
        return HttpService.execute(Http.class).getHome();
    }

}
