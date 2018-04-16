package com.lala.lashop.ui.home;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.home.adapter.ShopListAdapter;
import com.lala.lashop.ui.home.bean.HomeBean;
import com.lala.lashop.ui.home.bean.ShopsBean;
import com.lala.lashop.ui.home.presenter.ShopListPresenter;
import com.lala.lashop.ui.home.view.ShopListView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 商品列表
 * Created by JX on 2018/4/16.
 */

@CreatePresenter(ShopListPresenter.class)
public class ShopListActivity extends BaseActivity<ShopListView, ShopListPresenter> implements ShopListView {

    public static final String TYPE = "type";

    @BindView(R.id.shoplist_rv)
    RecyclerView rv;

    private ShopListAdapter mAdapter;

    private int type;

    @Override
    public int setContentView() {
        return R.layout.shoplist_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("商品列表");

        type = getIntent().getIntExtra(TYPE, 0);

        mAdapter = new ShopListAdapter(R.layout.shoplist_rv_item, new ArrayList<ShopsBean>());
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        getPresenter().getHomeData();
    }

    @Override
    public void setData(HomeBean data) {
        if (data.getCategory().size() >= type + 1) {
            mAdapter.setNewData(data.getCategory().get(type).getShops());
        }
    }
}
