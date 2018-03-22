package com.lala.lashop.ui.user.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.adapter.AddressAdapter;
import com.lala.lashop.ui.user.bean.AddressBean;
import com.lala.lashop.ui.user.presenter.AddressPresenter;
import com.lala.lashop.ui.user.view.AddressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 地址
 * Created by JX on 2018/3/20.
 */

@CreatePresenter(AddressPresenter.class)
public class AddressActivity extends BaseActivity<AddressView, AddressPresenter> implements AddressView {

    @BindView(R.id.address_rv_list)
    RecyclerView rvList;

    private AddressAdapter mAdapter;

    private List<AddressBean> mData;

    @Override
    public int setContentView() {
        return R.layout.address_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("选择收货地址");

        mData = new ArrayList<>();

        //测试
        for (int i = 0; i < 3; i++) {
            mData.add(new AddressBean());
        }

        mAdapter = new AddressAdapter(R.layout.address_rv_item, mData);
        mAdapter.bindToRecyclerView(rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        getPresenter().getAddress();
    }

    @OnClick(R.id.address_tv_add)
    public void onViewClicked() {
        startActivity(AddressAddActivity.class);
    }

    @Override
    public void setData(List<AddressBean> data) {

    }

    @Override
    public void deleteSuccess() {

    }
}
