package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/4/18.
 */

public class FoundModel extends BaseModel {

    public Observable<HttpResult> user_updatePwd(String phone, String uPwd) {
        p("phone", phone).p("uPwd", uPwd);
        return HttpService.execute(Http.class).user_updatePwd(getRequestBody());
    }

}
