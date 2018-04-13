package com.lala.lashop.ui.shop.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.shop.bean.CartBean;
import com.lala.lashop.ui.shop.bean.ConfirmBean;

import java.util.List;

/**
 * Created by JX on 2018/4/4.
 */

public interface ShopView extends BaseView {

    void setData(List<CartBean> data);

    void deleteSuccess();

    void jiesuanSuccess(ConfirmBean data);

    String getOrderId();

    String getIds();

    String getSpids();

    String getCounts();

    String getSimgs();

    String getPrices();

    String getYunfeis();
}
