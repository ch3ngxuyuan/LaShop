package com.lala.lashop.ui.cate.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.home.bean.CategoryBean;

import java.util.List;

/**
 * Created by JX on 2018/3/27.
 */

public class CateAdapter extends BaseAdapter<CategoryBean> {

    private CateSubAdapter subAdapter;

    public CateAdapter(int layoutResId, @Nullable List<CategoryBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, CategoryBean item) {
        holder.setText(R.id.cate_tv, item.getTitle());

        RecyclerView rvSub = holder.getView(R.id.cate_rv_sub);

        rvSub.setLayoutManager(new LinearLayoutManager(mContext));
        subAdapter = new CateSubAdapter(R.layout.cate_rv_sub_item, item.getChildren());
        rvSub.setAdapter(subAdapter);

    }
}
