package com.lala.lashop.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * Created by JX on 2017/12/18.
 */

public abstract class BaseAdapter<T extends Object> extends BaseQuickAdapter<T, BaseViewHolder> {

    public BaseAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    @Override
    protected abstract void convert(BaseViewHolder holder, T item);
}
