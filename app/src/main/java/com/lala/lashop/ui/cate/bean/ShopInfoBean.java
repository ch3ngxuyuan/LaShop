package com.lala.lashop.ui.cate.bean;

import com.lala.lashop.ui.home.bean.ShopsBean;

import java.util.List;

/**
 * Created by JX on 2018/3/28.
 */

public class ShopInfoBean {

    private ShopsBean shop;
    private List<ShopsBean> shopPhoto;

    public ShopsBean getShop() {
        return shop;
    }

    public void setShop(ShopsBean shop) {
        this.shop = shop;
    }

    public List<ShopsBean> getShopPhoto() {
        return shopPhoto;
    }

    public void setShopPhoto(List<ShopsBean> shopPhoto) {
        this.shopPhoto = shopPhoto;
    }
}
