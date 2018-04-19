package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.UserBean;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/4/19.
 */

public class UserModel extends BaseModel {

    public Observable<HttpResult<UserBean>> user_info(String id) {
        p("id", id);
        return HttpService.execute(Http.class).user_info(getRequestBody());
    }

}
