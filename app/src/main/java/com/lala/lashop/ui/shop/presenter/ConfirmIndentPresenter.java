package com.lala.lashop.ui.shop.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.http.ApiSubscribers;
import com.lala.lashop.http.HttpResult;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.ui.shop.bean.InvoiceBean;
import com.lala.lashop.ui.shop.model.ConfirmIndentModel;
import com.lala.lashop.ui.shop.view.ConfirmIndentView;
import com.lala.lashop.ui.user.bean.AddressBean;

import java.util.List;

/**
 * Created by JX on 2018/4/13.
 */

public class ConfirmIndentPresenter extends BasePresenter<ConfirmIndentView> {

    private ConfirmIndentModel mModel;

    public ConfirmIndentPresenter() {
        mModel = new ConfirmIndentModel();
    }

    public void getAddress() {
        getView().showLoadingDialog();

        mModel.getAddress(getView().getUserIdId())
                .compose(this.<HttpResult<AddressBean>>compose())
                .subscribe(new ApiSubscribers<HttpResult<AddressBean>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<AddressBean> addressBeanHttpResult) {
                        getView().setAddress(addressBeanHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

    public void getInvoice() {
        getView().showLoadingDialog();

        mModel.invoice_moren(getView().getUserId())
                .compose(this.<HttpResult<List<InvoiceBean>>>compose())
                .subscribe(new ApiSubscribers<HttpResult<List<InvoiceBean>>>(getView()) {
                    @Override
                    public void onSuccess(HttpResult<List<InvoiceBean>> listHttpResult) {
                        getView().setInvoice(listHttpResult.getMess());
                    }

                    @Override
                    public void onError(ApiException e) {

                    }
                });
    }

}
