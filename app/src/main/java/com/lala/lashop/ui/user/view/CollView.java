package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.bean.CollBean;

import java.util.List;

/**
 * Created by JX on 2018/3/21.
 */

public interface CollView extends BaseView {

    void setData(List<CollBean> data);

    String getUserId();

}
