package com.lala.lashop.ui.shop.presenter;

import android.text.TextUtils;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.shop.bean.InvoiceBean;
import com.lala.lashop.ui.shop.model.InvoiceModel;
import com.lala.lashop.ui.shop.view.InvoiceView;

import java.util.List;

/**
 * Created by JX on 2018/4/13.
 */

public class InvoicePresenter extends BasePresenter<InvoiceView> {

    private InvoiceModel mModel;

    public InvoicePresenter() {
        mModel = new InvoiceModel();
    }

    public void getList() {
        getView().showLoadingDialog();

        mModel.invoice_list(getView().getUserId())
                .compose(this.<HttpResult<List<InvoiceBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<InvoiceBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<InvoiceBean>> listHttpResult) {
                        getView().setListData(listHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void addInvoice() {
        String name = getView().getHead();
        String number = getView().getTaxnumber();

        if (TextUtils.isEmpty(name)) {
            getView().toast("发票抬头不能为空");
            return;
        }

        if (TextUtils.isEmpty(number)) {
            getView().toast("税号不能为空");
            return;
        }

        getView().showLoadingDialog();

        mModel.invoice_add(getView().getUserId(), getView().getHead(), getView().getTaxnumber(), getView().getMoren())
                .compose(this.<HttpResult>compose())
                .subscribe(new ApiSubscribers<HttpResult>(getView()) {
                    @Override
                    public void onSuccess(HttpResult httpResult) {
                        getView().addSuccess();
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
