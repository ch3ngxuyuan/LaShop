package com.lala.lashop.ui.cate.model;

import android.text.TextUtils;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/28.
 */

public class ShopInfoModel extends BaseModel {

    public Observable<HttpResult> getShopInfo(String shopid, String userid) {
        p("shopid", shopid);
        if (!TextUtils.isEmpty(userid)) {
            p("userid", userid);
        }
        return HttpService.execute(Http.class).shops_info(getRequestBody());
    }

}
