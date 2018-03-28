package com.lala.lashop.ui.cate;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.cate.activity.ShopInfoActivity;
import com.lala.lashop.ui.cate.adapter.SearchAdapter;
import com.lala.lashop.ui.cate.presenter.SearchPresenter;
import com.lala.lashop.ui.cate.view.SearchView;
import com.lala.lashop.ui.home.bean.ShopsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 查询结果
 * Created by JX on 2018/3/28.
 */

@CreatePresenter(SearchPresenter.class)
public class SearchFragment extends BaseFragment<SearchView, SearchPresenter> implements SearchView {

    @BindView(R.id.cate_search_rv)
    RecyclerView rv;
    @BindView(R.id.cate_search_progress)
    ProgressBar progressBar;

    private SearchAdapter mAdapter;
    private List<ShopsBean> mData;

    private String smallId;

    @Override
    public int setContentView() {
        return R.layout.cate_search_fragment;
    }

    @Override
    public void onCreate() {
        mData = new ArrayList<>();
        mAdapter = new SearchAdapter(R.layout.cate_search_rv_item, mData);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(mAdapter);
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString(ShopInfoActivity.SHOP_ID, mData.get(position).getId());
                startActivity(ShopInfoActivity.class, bundle);
            }
        });
    }

    public void getData(String smallId) {
        this.smallId = smallId;
        showLoadingView();
        getPresenter().search();
    }

    @Override
    public void setData(List<ShopsBean> data) {
        mAdapter.setNewData(data);
        mData = mAdapter.getData();
    }

    @Override
    public String getSmallId() {
        return smallId;
    }

    @Override
    public void showLoadingView() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideMultipleView() {
        progressBar.setVisibility(View.GONE);
    }
}
