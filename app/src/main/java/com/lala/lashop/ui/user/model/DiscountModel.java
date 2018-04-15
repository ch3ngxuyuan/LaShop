package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.DiscountBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/4/14.
 */

public class DiscountModel extends BaseModel {

    public Observable<HttpResult<List<DiscountBean>>> discount_list(String uid) {
        p("uid", uid);
        return HttpService.execute(Http.class).discount_list(getRequestBody());
    }

    public Observable<HttpResult> discount_delete(String cid) {
        p("cid", cid);
        return HttpService.execute(Http.class).discount_delete(getRequestBody());
    }

}
