package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.ProvinceBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/22.
 */

public class SelectAddressModel extends BaseModel {

    public Observable<HttpResult<List<ProvinceBean>>> selectProvince(String pid) {
        p("pid", pid);
        return HttpService.execute(Http.class).address_province(getRequestBody());
    }

}
