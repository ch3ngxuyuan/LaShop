package com.lala.lashop.ui.home;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.ui.home.adapter.ShopListAdapter;
import com.lala.lashop.ui.home.bean.ShopsBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 商品列表
 * Created by JX on 2018/4/16.
 */

public class ShopListActivity extends BaseActivity {

    @BindView(R.id.shoplist_rv)
    RecyclerView rv;

    private ShopListAdapter mAdapter;

    @Override
    public int setContentView() {
        return R.layout.shoplist_activity;
    }

    @Override
    public void onCreate() {
        mAdapter = new ShopListAdapter(R.layout.shoplist_rv_item, new ArrayList<ShopsBean>());
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
}
