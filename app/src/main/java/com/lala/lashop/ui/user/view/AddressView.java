package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.bean.AddressBean;

import java.util.List;

/**
 * Created by JX on 2018/3/21.
 */

public interface AddressView extends BaseView {

    void setData(List<AddressBean> data);

    void deleteSuccess();

    String getUserId();
}
