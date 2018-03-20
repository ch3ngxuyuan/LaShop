package com.lala.lashop.ui.user.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.user.bean.DiscountBean;

import java.util.List;

/**
 * Created by JX on 2018/3/20.
 */

public class DiscountAdapter extends BaseAdapter<DiscountBean> {

    public DiscountAdapter(int layoutResId, @Nullable List<DiscountBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, DiscountBean item) {

    }
}
