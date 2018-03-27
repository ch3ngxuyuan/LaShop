package com.lala.lashop.ui.user.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.ui.user.adapter.ApplyAdapter;
import com.lala.lashop.ui.user.bean.ApplyBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 申请售后
 * Created by JX on 2018/3/27.
 */

public class ApplyFragment extends BaseFragment {

    @BindView(R.id.apply_rv)
    RecyclerView rv;

    private ApplyAdapter mAdapter;
    private List<ApplyBean> mData;

    @Override
    public int setContentView() {
        return R.layout.apply_fragment;
    }

    @Override
    public void onCreate() {
        mData = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            mData.add(new ApplyBean());
        }

        mAdapter = new ApplyAdapter(R.layout.apply_rv_item, mData);
        rv.setAdapter(mAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
