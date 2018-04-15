package com.lala.lashop.ui.user.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.adapter.IndentAdapter;
import com.lala.lashop.ui.user.bean.IndentBean;
import com.lala.lashop.ui.user.bean.IndentItemBean;
import com.lala.lashop.ui.user.presenter.IndentPresenter;
import com.lala.lashop.ui.user.view.IndentView;
import com.lala.lashop.utils.L;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by JX on 2018/3/23.
 */

@CreatePresenter(IndentPresenter.class)
public class IndentFragment extends BaseFragment<IndentView, IndentPresenter> implements IndentView {

    private static final String POSITION = "position";

    @BindView(R.id.indent_rv)
    RecyclerView rv;

    private IndentAdapter mAdapter;

    private List<IndentItemBean> mData;

    private String or_flag = "";

    public static IndentFragment newInstance(int position) {
        IndentFragment fragment = new IndentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int setContentView() {
        return R.layout.indent_fragment;
    }

    @Override
    public void onCreate() {
        int position = getArguments().getInt(POSITION);
        if (position == 1) {
            or_flag = "0";
        } else if (position == 2) {
            or_flag = "1,2";
        }

        mData = new ArrayList<>();

        mAdapter = new IndentAdapter(R.layout.indent_rv_item, mData);
        rv.setAdapter(mAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        getPresenter().getData();
    }

    @Override
    public void setData(IndentBean data) {
        mAdapter.setNewData(data.getPagination());
    }

    @Override
    public String getUserId() {
        return App.getUser().getUser_id();
    }

    @Override
    public String getOrFlag() {
        return or_flag;
    }
}
