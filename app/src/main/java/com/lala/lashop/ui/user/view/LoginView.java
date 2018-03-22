package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.bean.UserBean;

/**
 * Created by JX on 2018/3/21.
 */

public interface LoginView extends BaseView {

    String getPhone();

    String getPwd();

    void loginSuccess(UserBean user);

}
