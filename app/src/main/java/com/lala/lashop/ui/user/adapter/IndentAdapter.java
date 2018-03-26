package com.lala.lashop.ui.user.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.user.bean.IndentBean;

import java.util.List;

/**
 * Created by JX on 2018/3/26.
 */

public class IndentAdapter extends BaseAdapter<IndentBean> {

    public IndentAdapter(int layoutResId, @Nullable List<IndentBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, IndentBean item) {

    }
}
