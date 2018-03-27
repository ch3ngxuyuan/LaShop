package com.lala.lashop.ui.cate.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.home.bean.ChildrenBean;

import java.util.List;

/**
 * Created by JX on 2018/3/27.
 */

public class CateSubAdapter extends BaseAdapter<ChildrenBean> {

    public CateSubAdapter(int layoutResId, @Nullable List<ChildrenBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ChildrenBean item) {
        holder.setText(R.id.cate_tv_name, item.getTitle());
    }
}
