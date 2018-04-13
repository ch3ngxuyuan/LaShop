package com.lala.lashop.ui.shop.model;

import com.lala.lashop.base.BaseModel;
import com.lala.lashop.http.Http;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.HttpService;
import com.lala.lashop.ui.shop.bean.InvoiceBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by JX on 2018/4/13.
 */

public class InvoiceModel extends BaseModel {

    public Observable<HttpResult<List<InvoiceBean>>> invoice_list(String user_id) {
        p("user_id", user_id);
        return HttpService.execute(Http.class).invoice_list(getRequestBody());
    }

    public Observable<HttpResult> invoice_add(String user_id, String head, String taxnumber, int moren) {
        p("user_id", user_id).p("head", head).p("taxnumber", taxnumber).p("moren", moren);
        return HttpService.execute(Http.class).invoice_add(getRequestBody());
    }
}
