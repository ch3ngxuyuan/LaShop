package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.bean.UserBean;

/**
 * Created by JX on 2018/4/19.
 */

public interface UserView extends BaseView {

    void setData(UserBean data);

    String getUserId();

}
