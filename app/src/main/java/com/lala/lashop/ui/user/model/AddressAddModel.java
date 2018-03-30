package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;

import io.reactivex.Observable;


/**
 * Created by JX on 2018/3/22.
 */

public class AddressAddModel extends BaseModel {

    public Observable<HttpResult> address_add(String user_id,
                                              String mobile,
                                              String provincialName,
                                              String cityName,
                                              String areaName,
                                              String addressDetail,
                                              int m_id,
                                              String fullName) {
        p("user_id", user_id)
                .p("mobile", mobile)
                .p("provincialName", provincialName)
                .p("cityName", cityName)
                .p("areaName", areaName)
                .p("addressDetail", addressDetail)
                .p("m_id", m_id)
                .p("fullName", fullName);
        return HttpService.execute(Http.class).address_add(getRequestBody());
    }

    public Observable<HttpResult> address_update(String user_id,
                                                 String mobile,
                                                 String provincialName,
                                                 String cityName,
                                                 String areaName,
                                                 String addressDetail,
                                                 int m_id,
                                                 String fullName,
                                                 String addressid) {
        p("user_id", user_id)
                .p("mobile", mobile)
                .p("provincialName", provincialName)
                .p("cityName", cityName)
                .p("areaName", areaName)
                .p("addressDetail", addressDetail)
                .p("m_id", m_id)
                .p("fullName", fullName)
                .p("addressid", addressid);
        return HttpService.execute(Http.class).address_update(getRequestBody());
    }

}
