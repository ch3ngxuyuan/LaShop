package com.lala.lashop.ui.user.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.user.bean.CollBean;
import com.lala.lashop.utils.L;
import com.lala.lashop.utils.Tos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JX on 2018/3/20.
 */

public class CollAdapter extends BaseAdapter<CollBean> {

    public boolean deleteFlag = false;
    private List<Boolean> mSelectList;

    public CollAdapter(int layoutResId, @Nullable List<CollBean> data) {
        super(layoutResId, data);
        mSelectList = new ArrayList<>();
        for (CollBean bean : data) {
            mSelectList.add(false);
        }
    }

    @Override
    protected void convert(final BaseViewHolder holder, CollBean item) {
        holder.setVisible(R.id.coll_iv_delete, deleteFlag);
        holder.setImageResource(R.id.coll_iv_delete, mSelectList.get(holder.getLayoutPosition())
                ? R.drawable.general_icon_select
                : R.drawable.general_icon_unselect);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //选中
                if (deleteFlag) {
                    mSelectList.set(holder.getLayoutPosition(), !mSelectList.get(holder.getLayoutPosition()));
                    L.e("mSelectList = " + mSelectList.get(holder.getLayoutPosition()));
                    notifyItemChanged(holder.getLayoutPosition());
                } else {
                    Tos.toast(mContext, "跳转详情");
                }
            }
        });
    }

    public void openDelete(boolean flag) {
        deleteFlag = flag;
        notifyDataSetChanged();
    }
}
