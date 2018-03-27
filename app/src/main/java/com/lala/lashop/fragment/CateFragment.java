package com.lala.lashop.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.cate.adapter.CateAdapter;
import com.lala.lashop.ui.cate.presenter.CatePresenter;
import com.lala.lashop.ui.cate.view.CateView;
import com.lala.lashop.ui.home.bean.CategoryBean;
import com.lala.lashop.utils.L;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by JX on 2018/3/17.
 */

@CreatePresenter(CatePresenter.class)
public class CateFragment extends BaseFragment<CateView, CatePresenter> implements CateView {

    @BindView(R.id.cate_rv)
    RecyclerView rv;

    private List<CategoryBean> mData;
    private CateAdapter mAdapter;

    private String smallId;

    @Override
    public int setContentView() {
        return R.layout.fragment_cate;
    }

    @Override
    public void onCreate() {
        mData = new ArrayList<>();
        mAdapter = new CateAdapter(R.layout.cate_rv_item, mData);
        rv.setAdapter(mAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter.setOnAdapterItemClickListener(new CateAdapter.OnAdapterItemClickListener() {
            @Override
            public void onItemClick(View view, int parent, int position) {
                L.e("parent = " + parent + ",position = " + position);
                smallId = mData.get(parent).getChildren().get(position).getSmall_id();
                getPresenter().search();
            }
        });

        getPresenter().getCategory();
    }

    @Override
    public void setData(List<CategoryBean> data) {
        mAdapter.setNewData(data);
        mData = mAdapter.getData();
    }

    @Override
    public String getSmallId() {
        return smallId;
    }
}
