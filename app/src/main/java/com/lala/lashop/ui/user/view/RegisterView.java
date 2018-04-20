package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;

/**
 * Created by JX on 2018/3/21.
 */

public interface RegisterView extends BaseView {

    void registerSuccess();

    void sendSuccess(String code);

    String getPhone();

    String getPwd();

    String getCode();

    String getSendCode();

}
