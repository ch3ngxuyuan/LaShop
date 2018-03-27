package com.lala.lashop.ui.user.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.user.bean.ApplyBean;

import java.util.List;

/**
 * Created by JX on 2018/3/27.
 */

public class ApplyAdapter extends BaseAdapter<ApplyBean> {

    public ApplyAdapter(int layoutResId, @Nullable List<ApplyBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ApplyBean item) {

    }
}
