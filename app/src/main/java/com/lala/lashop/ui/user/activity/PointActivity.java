package com.lala.lashop.ui.user.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.adapter.PointAdapter;
import com.lala.lashop.ui.user.bean.PointBean;
import com.lala.lashop.ui.user.presenter.PointPresenter;
import com.lala.lashop.ui.user.view.PointView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 积分
 * Created by JX on 2018/3/20.
 */

@CreatePresenter(PointPresenter.class)
public class PointActivity extends BaseActivity<PointView, PointPresenter> implements PointView {

    @BindView(R.id.point_rv)
    RecyclerView rv;

    private PointAdapter mAdapter;
    private List<PointBean> mData;

    @Override
    public int setContentView() {
        return R.layout.point_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("积分");

        mData = new ArrayList<>();

        //测试数据
        for (int i = 0; i < 10; i++) {
            mData.add(new PointBean());
        }

        mAdapter = new PointAdapter(R.layout.point_rv_item, mData);
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        getPresenter().getCreditData();
    }

    @Override
    public void setData(List<PointBean> data) {
        mAdapter.setNewData(data);
    }

    @Override
    public String getUserId() {
        return App.getUser().getUser_id();
    }
}
