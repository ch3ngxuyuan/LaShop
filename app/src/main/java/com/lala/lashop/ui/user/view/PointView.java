package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.bean.PointBean;

import java.util.List;

/**
 * Created by JX on 2018/4/13.
 */

public interface PointView extends BaseView {

    void setData(List<PointBean> data);

    String getUserId();

}
