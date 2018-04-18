package com.lala.lashop.ui.cate.model;

import android.text.TextUtils;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.cate.bean.ShopInfoBean;
import com.lala.lashop.ui.shop.bean.ConfirmBean;

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

    public Observable<HttpResult<Integer>> collCheck(String shopid, String user_id) {
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
                .p("color", color).p("gui", guis).p("youfei", youfei);
        return HttpService.execute(Http.class).cart_add(getRequestBody());
    }

    public Observable<HttpResult<ConfirmBean>> jiesuan(String shopid, String userid, String color, String gui) {
        p("shopid", shopid).p("userid", userid).p("color", color).p("gui", gui);
        return HttpService.execute(Http.class).shop_jiesuan(getRequestBody());
    }

    public Observable<HttpResult> path_add(String uid, String shopid) {
        p("uid", uid).p("shopid", shopid);
        return HttpService.execute(Http.class).path_add(getRequestBody());
    }

}
