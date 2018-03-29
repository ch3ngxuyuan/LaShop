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

import java.util.List;

/**
 * Created by JX on 2018/3/27.
 */

public class CateAdapter extends BaseAdapter<CategoryBean> {

    private CateSubAdapter subAdapter;

    private int parentPosition = -1;
    private int childPosition = -1;

    public CateAdapter(int layoutResId, @Nullable List<CategoryBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, CategoryBean item) {
        holder.setText(R.id.cate_tv, item.getTitle());

        RecyclerView rvSub = holder.getView(R.id.cate_rv_sub);

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

}
