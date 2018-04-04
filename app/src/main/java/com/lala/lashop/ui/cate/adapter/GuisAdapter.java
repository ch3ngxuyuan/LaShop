package com.lala.lashop.ui.cate.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.cate.bean.GuisBean;

import java.util.List;

/**
 * Created by JX on 2018/4/2.
 */

public class GuisAdapter extends BaseAdapter<GuisBean> {

    private int selectPos = 0;

    public void setSelectPos(int position) {
        selectPos = position;
        notifyDataSetChanged();
    }

    public GuisAdapter(int layoutResId, @Nullable List<GuisBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, GuisBean item) {
        TextView tv = holder.getView(R.id.tv);
        FrameLayout fl = holder.getView(R.id.fl_bg);

        tv.setText(item.getName());

        if (selectPos == holder.getLayoutPosition()) {
            tv.setTextColor(Color.parseColor("#FFFFFF"));
            fl.setBackgroundResource(R.drawable.round_bg_blue);
        } else {
            tv.setTextColor(Color.parseColor("#333333"));
            fl.setBackgroundResource(R.drawable.round_bg_gray);
        }
    }

    public String getGuis() {
        return getData().get(selectPos).getName();
    }
}
