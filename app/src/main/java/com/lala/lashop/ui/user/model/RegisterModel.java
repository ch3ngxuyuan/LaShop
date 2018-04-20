package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.CodeBean;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/21.
 */

public class RegisterModel extends BaseModel {

    public Observable<HttpResult> register(String phone, String pwd) {
        p("phone", phone).p("pwd", pwd).p("reg_from", 3).p("account", phone);
        return HttpService.execute(Http.class).user_register(getRequestBody());
    }

    public Observable<HttpResult<CodeBean>> sms_send(String phone) {
        p("phone", phone);
        return HttpService.execute(Http.class).sms_send(getRequestBody());
    }

}
