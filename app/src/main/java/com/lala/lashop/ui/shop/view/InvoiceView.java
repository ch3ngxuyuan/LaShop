package com.lala.lashop.ui.shop.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.shop.bean.InvoiceBean;

import java.util.List;

/**
 * Created by JX on 2018/4/13.
 */

public interface InvoiceView extends BaseView {

    void setListData(List<InvoiceBean> data);

    void addSuccess();

    String getUserId();

    String getHead();

    String getTaxnumber();

    int getMoren();
}
