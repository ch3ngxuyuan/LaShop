package com.lala.lashop.ui.cate.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.home.bean.ChildrenBean;

import java.util.List;

/**
 * Created by JX on 2018/3/27.
 */

public class CateSubAdapter extends BaseAdapter<ChildrenBean> {

    private int selectPosition = -1; //选中的位置

    public void setSelectPosition(int position) {
        selectPosition = position;
        notifyDataSetChanged();
    }

    public CateSubAdapter(int layoutResId, @Nullable List<ChildrenBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ChildrenBean item) {
        TextView tv = holder.getView(R.id.cate_tv_name);
        tv.setText(item.getTitle());

        if (selectPosition == holder.getLayoutPosition()) {
            tv.setBackgroundColor(mContext.getResources().getColor(R.color.bg));
        } else {
            tv.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        }
    }
}
