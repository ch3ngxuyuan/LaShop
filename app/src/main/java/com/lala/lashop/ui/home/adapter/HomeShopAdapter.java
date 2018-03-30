package com.lala.lashop.ui.home.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.home.bean.CategoryBean;

import java.util.List;

/**
 * Created by JX on 2018/3/30.
 */

public class HomeShopAdapter extends BaseAdapter<CategoryBean> {

    public HomeShopAdapter(int layoutResId, @Nullable List<CategoryBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, CategoryBean item) {

        holder.setText(R.id.home_shop_tv_title, item.getTitle());

        RecyclerView rv = holder.getView(R.id.home_shop_rv);
        HomeSubShopAdapter homeSubShopAdapter = new HomeSubShopAdapter(R.layout.home_shop_sub_item, item.getShops());
        homeSubShopAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new GridLayoutManager(mContext, 4));
    }
}
