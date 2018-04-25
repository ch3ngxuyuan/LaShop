package com.lala.lashop.ui.shop.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.http.ApiPath;
import com.lala.lashop.ui.shop.bean.CartBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JX on 2018/4/9.
 */

public class ShopAdapter extends BaseAdapter<CartBean> {

    private List<Boolean> mSelect;

    public ShopAdapter(int layoutResId, @Nullable List<CartBean> data) {
        super(layoutResId, data);
        mSelect = new ArrayList<>();
    }

    public void initSelect() {
        mSelect.clear();
        for (CartBean bean : getData()) {
            mSelect.add(false);
        }
    }

    public boolean isSelectAll() {
        for (Boolean is : mSelect) {
            if (!is) return false;
        }
        return true;
    }

    public void select(int position) {
        mSelect.set(position, !mSelect.get(position));
        notifyDataSetChanged();
    }

    /**
     * 全选
     */
    public void selectAll(boolean isAll) {
        if (isAll) {
            //取消全选
            for (int i = 0; i < mSelect.size(); i++) {
                mSelect.set(i, false);
            }
        } else {
            for (int i = 0; i < mSelect.size(); i++) {
                mSelect.set(i, true);
            }
        }
        notifyDataSetChanged();
    }

    /**
     * 获取选中的数据
     */
    public List<CartBean> getSelectData() {
        List<CartBean> data = new ArrayList<>();
        for (int i = 0; i < mSelect.size(); i++) {
            if (mSelect.get(i)) {
                data.add(getData().get(i));
            }
        }
        return data;
    }

    @Override
    protected void convert(BaseViewHolder holder, CartBean item) {
        holder.loadImage(R.id.shop_iv, ApiPath.IMG_URL + item.getSp_simg());
        holder.setText(R.id.shop_tv_color, item.getGui() + "，" + item.getColor());
        holder.setText(R.id.shop_tv_name, item.getSp_title());
        holder.setText(R.id.shop_tv_price, "$" + item.getSp_price());
        holder.setText(R.id.shop_tv_count, "x" + item.getSp_count());

        holder.setImageResource(R.id.shop_iv_select, mSelect.get(holder.getLayoutPosition()) ? R.drawable.general_icon_select : R.drawable.general_icon_unselect);

        holder.addOnClickListener(R.id.shop_iv_delete);
        holder.addOnClickListener(R.id.shop_tv_count);
        holder.addOnClickListener(R.id.shop_iv_select);
        holder.addOnClickListener(R.id.shop_ll_shop);
    }
}
