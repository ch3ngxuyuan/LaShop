package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.bean.DiscountBean;

import java.util.List;

/**
 * Created by JX on 2018/4/14.
 */

public interface DiscountView extends BaseView {

    void setData(List<DiscountBean> data);

    String getUserId();

}
