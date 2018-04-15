package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.PointBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/4/13.
 */

public class PointModel extends BaseModel {

    public Observable<HttpResult<List<PointBean>>> getCreditList(String user_id) {
        p("user_id", user_id);
        return HttpService.execute(Http.class).credit_list(getRequestBody());
    }

    public Observable<HttpResult<String>> credit_user(String user_id) {
        p("user_id", user_id);
        return HttpService.execute(Http.class).credit_user(getRequestBody());
    }

}
