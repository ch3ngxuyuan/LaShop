package com.lala.lashop.ui.user.view;

import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.bean.AddressBean;
import com.lala.lashop.ui.user.bean.ProvinceBean;

import java.util.List;

/**
 * Created by JX on 2018/3/21.
 */

public interface SelectAddressView extends BaseView {

    void setData(List<ProvinceBean> data);

    String getPid();
}
