package com.lala.lashop.ui.cate.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.home.bean.CategoryBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/3/21.
 */

public class CateModel extends BaseModel {

    public Observable<HttpResult<List<CategoryBean>>> getCategory() {
        return HttpService.execute(Http.class).getCategory();
    }

}
