package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;

/**
 * Created by JX on 2018/3/30.
 */

public interface AddressAddView extends BaseView {

    void addSuccess();

    void updateSuccess();

    String getUserId();

    String getMobile();

    String getProvcine();

    String getCity();

    String getArea();

    String getDetail();

    int getDefault();

    String getName();

    String getAddressId();

}
