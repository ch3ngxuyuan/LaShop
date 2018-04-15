package com.lala.lashop.ui.user.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.cate.ShopInfoActivity;
import com.lala.lashop.ui.user.bean.DiscountBean;
import com.lala.lashop.utils.L;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JX on 2018/3/20.
 */

public class DiscountAdapter extends BaseAdapter<DiscountBean> {

    private boolean isEdit = false;
    private boolean isSelectAll = false; //是否全选
    private List<Boolean> mSelectList;

    public DiscountAdapter(int layoutResId, @Nullable List<DiscountBean> data) {
        super(layoutResId, data);
        mSelectList = new ArrayList<>();
        initSelectFlag(data.size());
    }

    public void initSelectFlag(int size) {
        mSelectList.clear();
        for (int i = 0; i < size; i++) {
            mSelectList.add(false);
        }
    }

    @Override
    protected void convert(final BaseViewHolder holder, final DiscountBean item) {
        holder.setGone(R.id.iv_select, isEdit ? true : false);

        holder.setImageResource(R.id.iv_select, mSelectList.get(holder.getLayoutPosition())
                ? R.drawable.general_icon_select
                : R.drawable.general_icon_unselect);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //选中
                if (isEdit) {
                    mSelectList.set(holder.getLayoutPosition(), !mSelectList.get(holder.getLayoutPosition()));
                    L.e("mSelectList = " + mSelectList.get(holder.getLayoutPosition()));
                    notifyItemChanged(holder.getLayoutPosition());

                    if (onSelectAllListener != null) {
                        onSelectAllListener.onSelectAll(checkSelectAll());
                    }
                } else {
                }
            }
        });
    }

    //开启删除
    public void openDelete(boolean flag) {
        isEdit = flag;
        notifyDataSetChanged();
    }

    //全选按钮
    public void selectAll() {
        isSelectAll = !isSelectAll;
        for (int i = 0; i < mSelectList.size(); i++) {
            mSelectList.set(i, isSelectAll);
        }

        if (onSelectAllListener != null) {
            onSelectAllListener.onSelectAll(checkSelectAll());
        }
        notifyDataSetChanged();
    }

    //判断是否全选
    public boolean checkSelectAll() {
        for (Boolean is : mSelectList) {
            if (!is) {
                isSelectAll = false;
                return isSelectAll;
            }
        }
        isSelectAll = true;
        return isSelectAll;
    }

    private CollAdapter.OnSelectAllListener onSelectAllListener;

    public void setOnSelectAllListener(CollAdapter.OnSelectAllListener onSelectAllListener) {
        this.onSelectAllListener = onSelectAllListener;
    }

    public interface OnSelectAllListener {
        void onSelectAll(boolean isAll);
    }

}
