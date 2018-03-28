package com.lala.lashop.ui.cate.activity;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.cate.presenter.ShopInfoPresenter;
import com.lala.lashop.ui.cate.view.ShopInfoView;

/**
 * 商品详情
 * Created by JX on 2018/3/28.
 */

@CreatePresenter(ShopInfoPresenter.class)
public class ShopInfoActivity extends BaseActivity<ShopInfoView, ShopInfoPresenter> implements ShopInfoView {

    public static final String SHOP_ID = "shopid";

    private String shopid; //商品id

    @Override
    public int setContentView() {
        return R.layout.shopinfo_activity;
    }

    @Override
    public void onCreate() {
        shopid = getIntent().getStringExtra(SHOP_ID);

        getPresenter().getShopInfo();
    }

    @Override
    public String getShopId() {
        return shopid;
    }

    @Override
    public String getUserId() {
        return App.getUser() != null ? App.getUser().getUser_id() : "";
    }
}
