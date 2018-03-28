package com.lala.lashop.ui.cate.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.home.bean.ShopsBean;

import java.util.List;

/**
 * Created by JX on 2018/3/28.
 */

public class SearchAdapter extends BaseAdapter<ShopsBean> {

    public SearchAdapter(int layoutResId, @Nullable List<ShopsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ShopsBean item) {
        holder.setText(R.id.search_tv_title, item.getSp_title());
    }
}
