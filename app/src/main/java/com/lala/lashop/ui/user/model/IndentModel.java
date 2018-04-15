package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.IndentBean;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/4/15.
 */

public class IndentModel extends BaseModel {

    public Observable<HttpResult<IndentBean>> getData(String user_id, String or_flag, String orid) {
        p("user_id", user_id).p("or_flag", or_flag).p("orid", orid);
        return HttpService.execute(Http.class).indent_list(getRequestBody());
    }

}
