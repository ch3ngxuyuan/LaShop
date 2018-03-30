package com.lala.lashop.ui.user.activity;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lala.lashop.R;
import com.lala.lashop.app.App;
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

    private static final int UPDATE = 1;
    private static final int ADD = 2;

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

        mAdapter = new AddressAdapter(R.layout.address_rv_item, mData);
        mAdapter.bindToRecyclerView(rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(AddressActivity.this, AddressAddActivity.class);
                intent.putExtra(AddressAddActivity.ADDRESS_UPDATE, true);
                intent.putExtra(AddressAddActivity.ADDRESSBEAN, mData.get(position));
                startActivityForResult(intent, UPDATE);
            }
        });

        getPresenter().getAddress();
    }

    @OnClick(R.id.address_tv_add)
    public void onViewClicked() {
        startActivityForResult(AddressAddActivity.class, ADD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == UPDATE || requestCode == ADD) && resultCode == RESULT_OK) {
            getPresenter().getAddress();
        }
    }

    @Override
    public void setData(List<AddressBean> data) {
        mAdapter.setNewData(data);
        mData = mAdapter.getData();
    }

    @Override
    public void deleteSuccess() {

    }

    @Override
    public String getUserId() {
        return App.getUser().getUser_id();
    }
}
