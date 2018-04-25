package com.lala.lashop.ui.cate.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.home.bean.CategoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JX on 2018/3/27.
 */

public class CateAdapter extends BaseAdapter<CategoryBean> {

    private CateSubAdapter subAdapter;

    private int parentPosition = -1;
    private int childPosition = -1;

    private List<Boolean> openStatusList;

    public CateAdapter(int layoutResId, @Nullable List<CategoryBean> data) {
        super(layoutResId, data);
        openStatusList = new ArrayList<>();
    }

    public void initStatus(int size) {
        for (int i = 0; i < size; i++) {
            openStatusList.add(false);
        }
    }

    @Override
    protected void convert(final BaseViewHolder holder, CategoryBean item) {
        holder.setText(R.id.cate_tv, item.getTitle());

        holder.addOnClickListener(R.id.cate_tv);

        RecyclerView rvSub = holder.getView(R.id.cate_rv_sub);

        if (openStatusList.get(holder.getLayoutPosition())) {
            rvSub.setVisibility(View.VISIBLE);
        } else {
            rvSub.setVisibility(View.GONE);
        }

        rvSub.setLayoutManager(new LinearLayoutManager(mContext));
        subAdapter = new CateSubAdapter(R.layout.cate_rv_sub_item, item.getChildren());
        subAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(view, holder.getLayoutPosition(), position);
                    parentPosition = holder.getLayoutPosition();
                    childPosition = position;
                    notifyDataSetChanged();
                }
            }
        });
        rvSub.setAdapter(subAdapter);

        if (parentPosition == holder.getLayoutPosition()) {
            subAdapter.setSelectPosition(childPosition);
        } else {
            subAdapter.setSelectPosition(-1);
        }
    }

    private OnAdapterItemClickListener onItemClickListener;

    public void setOnAdapterItemClickListener(OnAdapterItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnAdapterItemClickListener {
        void onItemClick(View view, int parent, int position);
    }

    public void changeStatus(int position) {
        openStatusList.set(position, !openStatusList.get(position));
        notifyItemChanged(position);
    }

}
