package com.lala.lashop.ui.user.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.http.ApiPath;
import com.lala.lashop.ui.user.bean.IndentBean;
import com.lala.lashop.ui.user.bean.IndentItemBean;

import java.util.List;

/**
 * Created by JX on 2018/3/26.
 */

public class IndentAdapter extends BaseAdapter<IndentItemBean> {

    public IndentAdapter(int layoutResId, @Nullable List<IndentItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, IndentItemBean item) {
        holder.loadImage(R.id.iv_image, ApiPath.IMG_URL + item.getSp_simg());
        holder.setText(R.id.tv_color, item.getGui() + "，" + item.getColor());
        holder.setText(R.id.tv_title, item.getSp_title());
        holder.setText(R.id.tv_price, "￥" + item.getSp_price());

        holder.setGone(R.id.tv_pay, false);
        holder.setGone(R.id.tv_path, false);
        holder.setGone(R.id.tv_confirm, false);
        holder.setGone(R.id.tv_complete, false);
        holder.setGone(R.id.tv_shou, false);

        if (item.getOr_flag().equals("0")) {
            holder.setGone(R.id.tv_pay, true);
        }else if (item.getOr_flag().equals("1,2")) {
            holder.setGone(R.id.tv_path, true);
            holder.setGone(R.id.tv_confirm, true);
        }else {
            holder.setGone(R.id.tv_complete, true);
        }
    }
}
