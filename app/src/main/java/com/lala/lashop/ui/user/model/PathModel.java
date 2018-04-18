package com.lala.lashop.ui.user.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.user.bean.PathBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/4/18.
 */

public class PathModel extends BaseModel {

    public Observable<HttpResult<List<PathBean>>> path_list(String uid) {
        p("uid", uid);
        return HttpService.execute(Http.class).path_list(getRequestBody());
    }

}
