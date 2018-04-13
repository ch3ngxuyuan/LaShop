package com.lala.lashop.ui.cate.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.cate.bean.ShopInfoBean;
import com.lala.lashop.ui.shop.bean.ConfirmBean;

/**
 * Created by JX on 2018/3/21.
 */

public interface ShopInfoView extends BaseView {

    void setData(ShopInfoBean data);

    void jieSuanSuccess(ConfirmBean data);

    String getShopId();

    String getUserId();

    String getUserIdId();

    String getCount();

    String getColor();

    String getGui();

    String getYunFei();

}
