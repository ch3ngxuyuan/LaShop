package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.AddressBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/22.
 */

public class AddressModel extends BaseModel {

    public Observable<HttpResult<List<AddressBean>>> address_list(String user_id) {
        p("user_id", user_id);
        return HttpService.execute(Http.class).address_list(getRequestBody());
    }

}
