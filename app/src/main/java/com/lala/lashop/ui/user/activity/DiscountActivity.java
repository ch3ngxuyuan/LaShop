package com.lala.lashop.ui.user.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.adapter.CollAdapter;
import com.lala.lashop.ui.user.adapter.DiscountAdapter;
import com.lala.lashop.ui.user.bean.DiscountBean;
import com.lala.lashop.ui.user.presenter.DiscountPresenter;
import com.lala.lashop.ui.user.view.DiscountView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 优惠券
 * Created by JX on 2018/3/20.
 */

@CreatePresenter(DiscountPresenter.class)
public class DiscountActivity extends BaseActivity<DiscountView, DiscountPresenter> implements DiscountView {

    @BindView(R.id.discount_rv)
    RecyclerView rv;
    @BindView(R.id.discount_fl_delete)
    FrameLayout flDelete;
    @BindView(R.id.discount_iv_select)
    ImageView ivSelect;

    private DiscountAdapter mAdapter;

    private List<DiscountBean> mData;

    private boolean isEdit = false;

    @Override
    public int setContentView() {
        return R.layout.discount_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("优惠券");
        getToolbar().setRightText("编辑").setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEdit = !isEdit;
                flDelete.setVisibility(isEdit ? View.VISIBLE : View.GONE);
                mAdapter.openDelete(isEdit);
            }
        });

        mData = new ArrayList<>();

//        mData.add(new DiscountBean());
//        mData.add(new DiscountBean());
//        mData.add(new DiscountBean());
//        mData.add(new DiscountBean());
//        mData.add(new DiscountBean());
//        mData.add(new DiscountBean());

        mAdapter = new DiscountAdapter(R.layout.discount_rv_item, mData);
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        mAdapter.setOnSelectAllListener(new CollAdapter.OnSelectAllListener() {
            @Override
            public void onSelectAll(boolean isAll) {
                checkSelectAll(isAll);
            }
        });

        getPresenter().getDisCountData();
    }

    private void checkSelectAll(boolean isAll) {
        ivSelect.setImageResource(isAll ? R.drawable.general_icon_select : R.drawable.general_icon_unselect);
    }

    @OnClick({R.id.discount_ll_all, R.id.discount_tv_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.discount_ll_all:
                mAdapter.selectAll();
                break;
            case R.id.discount_tv_delete:
//                getPresenter().deleteColl();
                toast("删除");
                break;
        }
    }

    @Override
    public void setData(List<DiscountBean> data) {
//        mAdapter.setNewData(data);
    }

    @Override
    public String getUserId() {
        return App.getUser() == null ? "" : App.getUser().getId();
    }
}
