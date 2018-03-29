package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.CollBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/29.
 */

public class CollModel extends BaseModel {

    public Observable<HttpResult<List<CollBean>>> collList(String user_id) {
        p("user_id", user_id);
        return HttpService.execute(Http.class).coll_list(getRequestBody());
    }

}
