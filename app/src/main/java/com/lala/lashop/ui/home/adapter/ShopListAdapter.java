package com.lala.lashop.ui.home.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.http.ApiPath;
import com.lala.lashop.ui.home.bean.ShopsBean;

import java.util.List;

/**
 * Created by JX on 2018/4/16.
 */

public class ShopListAdapter extends BaseAdapter<ShopsBean> {

    public ShopListAdapter(int layoutResId, @Nullable List<ShopsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ShopsBean item) {
        holder.setText(R.id.search_tv_title, item.getSp_title());
        holder.loadImage(R.id.search_iv, ApiPath.IMG_URL + item.getSp_simg());
        holder.setText(R.id.search_tv_price, "$" + item.getSp_price());
        holder.setText(R.id.search_tv_vip_price, "$" + item.getSp_vprice());
    }
}
