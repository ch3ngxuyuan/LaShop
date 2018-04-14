package com.lala.lashop.ui.shop.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.AddressBean;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/4/13.
 */

public class ConfirmIndentModel extends BaseModel {

    public Observable<HttpResult<AddressBean>> getAddress(String userid) {
        p("userid", userid);
        return HttpService.execute(Http.class).shop_address(getRequestBody());
    }

    public Observable<HttpResult> shop_topayorder(String user_id, String shop_id, String aid, String distribution, String total, String orderids) {
        p("user_id", user_id)
                .p("shop_id", shop_id)
                .p("aid", aid)
                .p("distribution", distribution)
                .p("total", total)
                .p("orderids", orderids);
        return HttpService.execute(Http.class).shop_topayorder(getRequestBody());
    }

}
