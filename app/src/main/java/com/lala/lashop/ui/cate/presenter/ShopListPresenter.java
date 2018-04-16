package com.lala.lashop.ui.cate.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.ui.cate.model.ShopListModel;
import com.lala.lashop.ui.cate.view.ShopListView;

/**
 * Created by JX on 2018/4/16.
 */

public class ShopListPresenter extends BasePresenter<ShopListView> {

    private ShopListModel mModel;

    public ShopListPresenter() {
        mModel = new ShopListModel();
    }
}
