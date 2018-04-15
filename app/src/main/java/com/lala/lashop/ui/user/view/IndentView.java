package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.bean.IndentBean;

/**
 * Created by JX on 2018/4/15.
 */

public interface IndentView extends BaseView {

    void setData(IndentBean data);

    String getUserId();

    String getOrFlag();
}
