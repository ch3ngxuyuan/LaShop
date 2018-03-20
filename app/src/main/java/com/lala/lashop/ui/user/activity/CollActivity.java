package com.lala.lashop.ui.user.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.ui.user.adapter.CollAdapter;
import com.lala.lashop.ui.user.bean.CollBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 收藏
 * Created by JX on 2018/3/20.
 */

public class CollActivity extends BaseActivity {

    @BindView(R.id.coll_rv)
    RecyclerView rv;
    @BindView(R.id.coll_fl_delete)
    FrameLayout flDelete;

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

        //测试数据
        for (int i = 0; i < 10; i++) {
            mData.add(new CollBean());
        }

        mAdapter = new CollAdapter(R.layout.coll_rv_item, mData);
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.getItemAnimator().setChangeDuration(0);
    }
}
