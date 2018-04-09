package com.lala.lashop.ui.cate.model;

import android.text.TextUtils;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.cate.bean.ShopInfoBean;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/28.
 */

public class ShopInfoModel extends BaseModel {

    public Observable<HttpResult<ShopInfoBean>> getShopInfo(String shopid, String userid) {
        p("shopid", shopid);
        if (!TextUtils.isEmpty(userid)) {
            p("user", userid);
        }
        return HttpService.execute(Http.class).shops_info(getRequestBody());
    }

    public Observable<HttpResult> collAdd(String shopid, String user_id) {
        p("shopid", shopid).p("user_id", user_id);
        return HttpService.execute(Http.class).coll_add(getRequestBody());
    }

    public Observable<HttpResult> collCheck(String shopid, String user_id) {
        p("shopid", shopid).p("user_id", user_id);
        return HttpService.execute(Http.class).coll_check(getRequestBody());
    }

    public Observable<HttpResult> addCart(String shopid,
                                          String user_id,
                                          String sp_count,
                                          String color,
                                          String guis,
                                          String youfei) {
        p("shopid", shopid).p("userid", user_id).p("sp_count", sp_count)
                .p("color", color).p("guis", guis).p("youfei", youfei);
        return HttpService.execute(Http.class).cart_add(getRequestBody());
    }

}
