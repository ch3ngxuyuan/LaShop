package com.lala.lashop.ui.shop.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.shop.bean.CartBean;
import com.lala.lashop.ui.shop.bean.ConfirmBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/4/4.
 */

public class ShopModel extends BaseModel {

    public Observable<HttpResult<List<CartBean>>> cart_list(String user_id) {
        p("admin_id", user_id);
        return HttpService.execute(Http.class).cart_list(getRequestBody());
    }

    public Observable<HttpResult> cart_delete(String orderid) {
        p("orderid", orderid);
        return HttpService.execute(Http.class).cart_delete(getRequestBody());
    }

    public Observable<HttpResult<ConfirmBean>> shop_jiesuan(String ids, String spids, String counts, String simgs, String prices, String yunfeis) {
        p("ids", ids).p("spids", spids).p("counts", counts).p("simgs", simgs).p("prices", prices).p("yunfeis", yunfeis);
        return HttpService.execute(Http.class).shop_pinjie(getRequestBody());
    }

}
