package com.lala.lashop.ui.user.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.user.bean.ProvinceBean;

import java.util.List;

/**
 * Created by JX on 2018/3/29.
 */

public class SelectAddressAdapter extends BaseAdapter<ProvinceBean> {

    private int type = 1; //1省份，2市，3区

    public SelectAddressAdapter(int layoutResId, @Nullable List<ProvinceBean> data) {
        super(layoutResId, data);
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    protected void convert(BaseViewHolder holder, ProvinceBean item) {
        if (type == 1) {
            holder.setText(R.id.select_tv, item.getName());
        }
    }
}
