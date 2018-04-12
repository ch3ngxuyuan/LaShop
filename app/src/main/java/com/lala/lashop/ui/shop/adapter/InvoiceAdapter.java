package com.lala.lashop.ui.shop.adapter;

import android.support.annotation.Nullable;

import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.ui.shop.bean.InvoiceBean;

import java.util.List;

/**
 * Created by JX on 2018/4/12.
 */

public class InvoiceAdapter extends BaseAdapter<InvoiceBean> {

    public InvoiceAdapter(int layoutResId, @Nullable List<InvoiceBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, InvoiceBean item) {

    }
}
