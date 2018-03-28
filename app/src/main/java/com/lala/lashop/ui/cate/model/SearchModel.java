package com.lala.lashop.ui.cate.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.home.bean.ShopsBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/21.
 */

public class SearchModel extends BaseModel {

    public Observable<HttpResult<List<ShopsBean>>> search(int page, String sp_classification) {
        p("page", page).p("sp_classification", sp_classification);
        return HttpService.execute(Http.class).cate_search(getRequestBody());
    }

}
