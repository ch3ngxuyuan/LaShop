package com.lala.lashop.ui.user.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.user.bean.AddressBean;

import java.util.List;

/**
 * Created by JX on 2018/3/20.
 */

public class AddressAdapter extends BaseAdapter<AddressBean> {

    public AddressAdapter(int layoutResId, @Nullable List<AddressBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, AddressBean item) {
        holder.setText(R.id.address_tv_name, item.getFullName());
        holder.setText(R.id.address_tv_mobile, item.getMobile());
        holder.setText(R.id.address_tv, item.getProv() + item.getCity() + item.getArea() + item.getAddressDetail());
    }
}
