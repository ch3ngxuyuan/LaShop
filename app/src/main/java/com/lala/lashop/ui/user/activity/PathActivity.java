package com.lala.lashop.ui.user.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.adapter.PathAdapter;
import com.lala.lashop.ui.user.bean.PathBean;
import com.lala.lashop.ui.user.presenter.PathPresenter;
import com.lala.lashop.ui.user.view.PathView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我的足迹
 * Created by JX on 2018/4/15.
 */

@CreatePresenter(PathPresenter.class)
public class PathActivity extends BaseActivity<PathView, PathPresenter> implements PathView {

    @BindView(R.id.path_rv)
    RecyclerView rv;

    private PathAdapter mAdapter;

    @Override
    public int setContentView() {
        return R.layout.path_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("我的足迹");

        mAdapter = new PathAdapter(R.layout.path_rv_item, new ArrayList<List<PathBean>>());
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        getPresenter().getData();
    }

    @Override
    public void setData(List<PathBean> data) {
        List<List<PathBean>> list = new ArrayList<>();
        List<String> times = new ArrayList<>();
        for (PathBean bean : data) {
            String time = bean.getAddtime().substring(0, 10);
            if (!times.contains(time)) {
                times.add(time);
            }
        }

        for (int i = 0; i < times.size(); i++) {
            List<PathBean> item = new ArrayList<>();
            for (PathBean bean : data) {
                String time = bean.getAddtime().substring(0, 10);
                if (times.get(i).equals(time)) {
                    item.add(bean);
                }
            }
            list.add(item);
        }
        mAdapter.setTimes(times);
        mAdapter.setNewData(list);
    }

    @Override
    public String getUserIdId() {
        return App.getUser() == null ? "" : App.getUser().getId();
    }
}
