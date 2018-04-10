package com.lala.lashop.ui.shop.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.shop.bean.CartBean;

import java.util.List;

/**
 * Created by JX on 2018/4/4.
 */

public interface ShopView extends BaseView {

    void setData(List<CartBean> data);

    void deleteSuccess();

    String getOrderId();
}
