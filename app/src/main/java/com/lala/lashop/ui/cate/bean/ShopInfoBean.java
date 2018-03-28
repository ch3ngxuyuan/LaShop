package com.lala.lashop.ui.cate.bean;

import com.lala.lashop.ui.home.bean.ShopsBean;

import java.util.List;

/**
 * Created by JX on 2018/3/28.
 */

public class ShopInfoBean {

    private ShopsBean shop;
    private List<ShopsBean> shopPhoto;
    private List<ColorsBean> colors;
    private List<GuisBean> guis;

    public List<GuisBean> getGuis() {
        return guis;
    }

    public void setGuis(List<GuisBean> guis) {
        this.guis = guis;
    }

    public List<ColorsBean> getColors() {
        return colors;
    }

    public void setColors(List<ColorsBean> colors) {
        this.colors = colors;
    }

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
