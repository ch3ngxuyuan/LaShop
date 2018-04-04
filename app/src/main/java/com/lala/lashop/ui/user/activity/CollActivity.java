package com.lala.lashop.ui.user.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.adapter.CollAdapter;
import com.lala.lashop.ui.user.bean.CollBean;
import com.lala.lashop.ui.user.presenter.CollPresenter;
import com.lala.lashop.ui.user.view.CollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 收藏
 * Created by JX on 2018/3/20.
 */

@CreatePresenter(CollPresenter.class)
public class CollActivity extends BaseActivity<CollView, CollPresenter> implements CollView {

    @BindView(R.id.coll_rv)
    RecyclerView rv;
    @BindView(R.id.coll_fl_delete)
    FrameLayout flDelete;
    @BindView(R.id.coll_iv_select)
    ImageView ivSelect;

    private CollAdapter mAdapter;
    private List<CollBean> mData;

    private boolean deleteFlag = false;

    @Override
    public int setContentView() {
        return R.layout.coll_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("我的收藏");
        getToolbar().setRightImage(R.drawable.general_icon_delete)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toast("删除");
                        deleteFlag = !deleteFlag;
                        flDelete.setVisibility(deleteFlag ? View.VISIBLE : View.GONE);
                        mAdapter.openDelete(deleteFlag);
                    }
                });

        mData = new ArrayList<>();
        mAdapter = new CollAdapter(R.layout.coll_rv_item, mData);
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.getItemAnimator().setChangeDuration(0);

        mAdapter.setOnSelectAllListener(new CollAdapter.OnSelectAllListener() {
            @Override
            public void onSelectAll(boolean isAll) {
                checkSelectAll(isAll);
            }
        });

        getPresenter().getColl();
    }

    private void checkSelectAll(boolean isAll) {
        ivSelect.setImageResource(isAll ? R.drawable.general_icon_select : R.drawable.general_icon_unselect);
    }

    @OnClick({R.id.coll_ll_all, R.id.coll_tv_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.coll_ll_all:
                mAdapter.selectAll();
                break;
            case R.id.coll_tv_delete:
                getPresenter().deleteColl();
                break;
        }
    }

    @Override
    public void setData(List<CollBean> data) {
        mAdapter.initSelectFlag(data.size());
        mAdapter.setNewData(data);
        mData = mAdapter.getData();
    }

    @Override
    public void deleteSuccess() {
        getPresenter().getColl();
    }

    @Override
    public String getUserId() {
        return App.getUser() != null ? App.getUser().getUser_id() : "";
    }

    @Override
    public String getCollectId() {
        return mAdapter.getSelectId();
    }
}
