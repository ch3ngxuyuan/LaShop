package com.lala.lashop.ui.user.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.ui.user.adapter.DiscountAdapter;
import com.lala.lashop.ui.user.bean.DiscountBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 优惠券
 * Created by JX on 2018/3/20.
 */

public class DiscountActivity extends BaseActivity {

    @BindView(R.id.discount_rv)
    RecyclerView rv;

    private DiscountAdapter mAdapter;

    private List<DiscountBean> mData;

    @Override
    public int setContentView() {
        return R.layout.discount_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("优惠券");

        mData = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            mData.add(new DiscountBean());
        }

        mAdapter = new DiscountAdapter(R.layout.discount_rv_item, mData);
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
