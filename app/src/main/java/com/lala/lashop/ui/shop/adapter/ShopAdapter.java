package com.lala.lashop.ui.shop.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.shop.bean.ShopBean;

import java.util.List;

/**
 * Created by JX on 2018/4/9.
 */

public class ShopAdapter extends BaseAdapter<ShopBean> {

    public ShopAdapter(int layoutResId, @Nullable List<ShopBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ShopBean item) {

    }
}
