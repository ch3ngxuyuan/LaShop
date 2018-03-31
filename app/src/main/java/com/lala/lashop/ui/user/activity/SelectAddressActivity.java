package com.lala.lashop.ui.user.activity;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.adapter.SelectAddressAdapter;
import com.lala.lashop.ui.user.bean.ProvinceBean;
import com.lala.lashop.ui.user.presenter.SelectAddressPresenter;
import com.lala.lashop.ui.user.view.SelectAddressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 选择地址
 * Created by JX on 2018/3/29.
 */

@CreatePresenter(SelectAddressPresenter.class)
public class SelectAddressActivity extends BaseActivity<SelectAddressView, SelectAddressPresenter> implements SelectAddressView {

    @BindView(R.id.address_select_rv)
    RecyclerView rv;

    private SelectAddressAdapter mAdapter;

    private List<ProvinceBean> mData;

    private String pid = "1";

    private int count = 0;

    private String province;
    private String city;
    private String area;

    private StringBuilder stringBuilder;

    @Override
    public int setContentView() {
        return R.layout.address_select_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("选择地址");

        stringBuilder = new StringBuilder();

        mData = new ArrayList<>();
        mAdapter = new SelectAddressAdapter(R.layout.address_select_rv_item, mData);
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                stringBuilder.append(mData.get(position).getName());

                if (count == 1) {
                    province = mData.get(position).getCode();
                } else if (count == 2) {
                    city = mData.get(position).getCode();
                } else if (count == 3) {
                    area = mData.get(position).getCode();
                }

                if (count == 3) {
                    Intent intent = new Intent();
                    intent.putExtra("address", stringBuilder.toString());
                    intent.putExtra("province", province);
                    intent.putExtra("city", city);
                    intent.putExtra("area", area);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    pid = mData.get(position).getCode();
                    getPresenter().getProvince();
                }
            }
        });

        getPresenter().getProvince();
    }

    @Override
    public void setData(List<ProvinceBean> data) {
        count += 1;
        mAdapter.setNewData(data);
        mData = mAdapter.getData();
    }

    @Override
    public String getPid() {
        return pid;
    }
}
