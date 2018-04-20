package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;

import java.io.File;

/**
 * Created by JX on 2018/4/19.
 */

public interface UserDetailView extends BaseView {

    void updateSuccess();

    void uploadSuccess(String headName);

    String getUserId();

    String getName();

    String getImg();

    String getSex();

    String getEmail();

    String getBirthday();

    File getHeadFile();

}
