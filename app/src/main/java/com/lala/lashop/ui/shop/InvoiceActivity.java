package com.lala.lashop.ui.shop;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.ui.shop.adapter.InvoiceAdapter;
import com.lala.lashop.ui.shop.bean.InvoiceBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 选择发票
 * Created by JX on 2018/4/12.
 */

public class InvoiceActivity extends BaseActivity {

    @BindView(R.id.invoice_rv)
    RecyclerView rv;

    private InvoiceAdapter mAdapter;

    private List<InvoiceBean> mData;

    @Override
    public int setContentView() {
        return R.layout.invoice_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("选择发票");

        mData = new ArrayList<>();

        mData.add(new InvoiceBean());

        mAdapter = new InvoiceAdapter(R.layout.invoice_rv_item, mData);
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
}
