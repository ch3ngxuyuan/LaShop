package com.lala.lashop.ui.shop.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.http.ApiPath;
import com.lala.lashop.ui.shop.bean.JieSuanBean;

import java.util.List;

/**
 * Created by JX on 2018/4/13.
 */

public class ConfirmShopAdapter extends BaseAdapter<JieSuanBean> {

    public ConfirmShopAdapter(int layoutResId, @Nullable List<JieSuanBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, JieSuanBean item) {
        holder.loadImage(R.id.shop_iv, ApiPath.IMG_URL + item.getSp_simg());
        holder.setText(R.id.shop_tv_color, item.getGui() + "，" + item.getColor());
        holder.setText(R.id.shop_tv_name, item.getSp_title());
        holder.setText(R.id.shop_tv_price, "$" + item.getSp_price());
        holder.setText(R.id.shop_tv_count, "x" + item.getSp_count());
    }
}
