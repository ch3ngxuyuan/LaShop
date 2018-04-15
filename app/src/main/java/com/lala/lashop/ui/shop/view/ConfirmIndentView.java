package com.lala.lashop.ui.shop.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.shop.bean.InvoiceBean;
import com.lala.lashop.ui.user.bean.AddressBean;

import java.util.List;

/**
 * Created by JX on 2018/4/13.
 */

public interface ConfirmIndentView extends BaseView {

    void setAddress(AddressBean data);

    void setInvoice(List<InvoiceBean> data);

    String getUserId();

    String getUserIdId();

}
