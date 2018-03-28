package com.lala.lashop.ui.cate.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.home.bean.ShopsBean;

import java.util.List;

/**
 * Created by JX on 2018/3/21.
 */

public interface SearchView extends BaseView {

    void setData(List<ShopsBean> data);

    String getSmallId();

}
