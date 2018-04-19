package com.lala.lashop.ui.user.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.user.bean.PathBean;
import com.lala.lashop.utils.L;

import java.util.List;

/**
 * Created by JX on 2018/4/19.
 */

public class PathAdapter extends BaseAdapter<List<PathBean>> {

    private List<String> times;

    public PathAdapter(int layoutResId, @Nullable List<List<PathBean>> data) {
        super(layoutResId, data);
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    @Override
    protected void convert(BaseViewHolder holder, List<PathBean> item) {
        holder.setText(R.id.tv_time, times.get(holder.getLayoutPosition()));

        L.e("size = " + item.size());

        RecyclerView rv = holder.getView(R.id.path_item_rv);
        PathItemAdapter pathItemAdapter = new PathItemAdapter(R.layout.path_rv_sub_item, item);
        pathItemAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

    }
}
