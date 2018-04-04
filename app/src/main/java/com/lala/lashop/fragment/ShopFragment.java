package com.lala.lashop.fragment;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.shop.presenter.ShopPresenter;
import com.lala.lashop.ui.shop.view.ShopView;

/**
 * Created by JX on 2018/3/17.
 */

@CreatePresenter(ShopPresenter.class)
public class ShopFragment extends BaseFragment<ShopView, ShopPresenter> implements ShopView {

    @Override
    public int setContentView() {
        return R.layout.fragment_shop;
    }

    @Override
    public void onCreate() {
        getPresenter().getCartList();
    }
}
