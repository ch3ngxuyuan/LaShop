package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/22.
 */

public class AddressModel extends BaseModel {

    public Observable<HttpResult> selectProvince() {
        p("pid", 1);
        return HttpService.execute(Http.class).address_province(getRequestBody());
    }

}
