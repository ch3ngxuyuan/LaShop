package com.lala.lashop.ui.user.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.user.bean.PointBean;

import java.util.List;

/**
 * Created by JX on 2018/3/20.
 */

public class PointAdapter extends BaseAdapter<PointBean> {

    public PointAdapter(int layoutResId, @Nullable List<PointBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, PointBean item) {

    }
}
