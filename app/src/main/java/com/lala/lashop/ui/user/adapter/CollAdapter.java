package com.lala.lashop.ui.user.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.http.ApiPath;
import com.lala.lashop.ui.cate.ShopInfoActivity;
import com.lala.lashop.ui.user.bean.CollBean;
import com.lala.lashop.utils.L;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JX on 2018/3/20.
 */

public class CollAdapter extends BaseAdapter<CollBean> {

    public boolean deleteFlag = false; //是否删除
    private boolean isSelectAll = false; //是否全选
    private List<Boolean> mSelectList;

    public CollAdapter(int layoutResId, @Nullable List<CollBean> data) {
        super(layoutResId, data);
        mSelectList = new ArrayList<>();
    }

    public void initSelectFlag(int size) {
        mSelectList.clear();
        for (int i = 0; i < size; i++) {
            mSelectList.add(false);
        }
    }

    @Override
    protected void convert(final BaseViewHolder holder, final CollBean item) {
        holder.loadImage(R.id.coll_iv, ApiPath.IMG_URL + item.getSp_simg());
        holder.setText(R.id.coll_tv_title, item.getSp_title());
//        holder.setText(R.id.coll_tv_location, item.getSp_city());
        holder.setText(R.id.coll_tv_price, "￥" + item.getSp_mprice());

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

                    if (onSelectAllListener != null) {
                        onSelectAllListener.onSelectAll(checkSelectAll());
                    }
                } else {
                    Intent intent = new Intent(mContext, ShopInfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(ShopInfoActivity.SHOP_ID, item.getShop_id());
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    //开启删除
    public void openDelete(boolean flag) {
        deleteFlag = flag;
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

    private OnSelectAllListener onSelectAllListener;

    public void setOnSelectAllListener(OnSelectAllListener onSelectAllListener) {
        this.onSelectAllListener = onSelectAllListener;
    }

    public interface OnSelectAllListener {
        void onSelectAll(boolean isAll);
    }

    public String getSelectId() {
        String ids = "";
        for (int i = 0; i < mSelectList.size(); i++) {
            if (mSelectList.get(i)) {
                ids += getData().get(i).getId() + ",";
            }
        }
        return ids.substring(0, ids.length() - 1);
    }
}
