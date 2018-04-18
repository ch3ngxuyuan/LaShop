package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.bean.PathBean;

import java.util.List;

/**
 * Created by JX on 2018/4/18.
 */

public interface PathView extends BaseView {

    void setData(List<PathBean> data);

    String getUserIdId();

}
