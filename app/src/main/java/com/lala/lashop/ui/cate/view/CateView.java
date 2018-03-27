package com.lala.lashop.ui.cate.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.home.bean.CategoryBean;

import java.util.List;

/**
 * Created by JX on 2018/3/21.
 */

public interface CateView extends BaseView {

    void setData(List<CategoryBean> data);

}
