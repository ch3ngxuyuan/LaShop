package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;

/**
 * Created by JX on 2018/4/18.
 */

public interface FoundView extends BaseView {

    void updateSuccess();

    void sendSuccess(String code);

    String getPhone();

    String getNewPwd();

    String getConfirmPwd();

    String getCode();

    String getSendCode();

}
