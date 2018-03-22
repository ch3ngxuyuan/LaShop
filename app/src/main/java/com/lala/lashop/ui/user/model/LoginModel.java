package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.UserBean;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/21.
 */

public class LoginModel extends BaseModel {

    public Observable<HttpResult<UserBean>> login(String phone, String pwd) {
        p("phone", phone).p("pwd", pwd);
        return HttpService.execute(Http.class).user_login(getRequestBody());
    }

}
