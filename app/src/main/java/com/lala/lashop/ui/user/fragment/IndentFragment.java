package com.lala.lashop.ui.user.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.ui.user.adapter.IndentAdapter;
import com.lala.lashop.ui.user.bean.IndentBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by JX on 2018/3/23.
 */

public class IndentFragment extends BaseFragment {

    @BindView(R.id.indent_rv)
    RecyclerView rv;

    private IndentAdapter mAdapter;

    private List<IndentBean> mData;

    @Override
    public int setContentView() {
        return R.layout.indent_fragment;
    }

    @Override
    public void onCreate() {
        mData = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            mData.add(new IndentBean());
        }

        mAdapter = new IndentAdapter(R.layout.indent_rv_item, mData);
        rv.setAdapter(mAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
