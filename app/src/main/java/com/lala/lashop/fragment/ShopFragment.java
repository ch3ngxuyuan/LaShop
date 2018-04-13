package com.lala.lashop.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lala.lashop.Constant;
import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.shop.adapter.ShopAdapter;
import com.lala.lashop.ui.shop.bean.CartBean;
import com.lala.lashop.ui.shop.bean.JieSuanBean;
import com.lala.lashop.ui.shop.presenter.ShopPresenter;
import com.lala.lashop.ui.shop.view.ShopView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by JX on 2018/3/17.
 */

@CreatePresenter(ShopPresenter.class)
public class ShopFragment extends BaseFragment<ShopView, ShopPresenter> implements ShopView {

    @BindView(R.id.shop_rv)
    RecyclerView rv;
    @BindView(R.id.shop_iv_select)
    ImageView shopIvSelect;
    @BindView(R.id.shop_tv_price)
    TextView shopTvPrice;
    @BindView(R.id.shop_tv_post)
    TextView shopTvPost;

    private ShopAdapter mAdapter;

    private int clickPosition;

    private boolean isAll; //是否全选

    @Override
    public void onRxBus(int bus) {
        if (bus == Constant.CART) {
            getPresenter().getCartList();
        }
    }

    @Override
    public int setContentView() {
        return R.layout.fragment_shop;
    }

    @Override
    public void onCreate() {
        mAdapter = new ShopAdapter(R.layout.shop_rv_item, new ArrayList<CartBean>());
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                clickPosition = position;
                if (view.getId() == R.id.shop_iv_delete) {
                    getPresenter().delete();
                } else if (view.getId() == R.id.shop_iv_select) {
                    mAdapter.select(position);
                    setAllStatus();
                    shopTvPost.setText("结算（" + mAdapter.getSelectData().size() + "）");
                } else if (view.getId() == R.id.shop_tv_count) {
                    toast("改变数量");
                }
            }
        });

        getPresenter().getCartList();
    }

    @Override
    public void setData(List<CartBean> data) {
        mAdapter.setNewData(data);
        mAdapter.initSelect();
    }

    @Override
    public void deleteSuccess() {
        getPresenter().getCartList();
    }

    @Override
    public String getOrderId() {
        return mAdapter.getData().get(clickPosition).getOrder_id();
    }

    @OnClick({R.id.shop_ll_all, R.id.shop_tv_post})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shop_ll_all:
                mAdapter.selectAll(isAll);
                setAllStatus();
                shopTvPost.setText("结算（" + mAdapter.getSelectData().size() + "）");
                break;
            case R.id.shop_tv_post:
                break;
        }
    }

    private void setAllStatus() {
        isAll = mAdapter.isSelectAll();
        shopIvSelect.setImageResource(isAll ? R.drawable.general_icon_select : R.drawable.general_icon_unselect);
    }

    /**
     * 设置结算数据
     */
    private List<JieSuanBean> getJieSuanData() {
        List<JieSuanBean> list = new ArrayList<>();
        for (CartBean bean : mAdapter.getSelectData()) {
            list.add(new JieSuanBean(bean.getOrder_id(),
                    bean.getSp_id(),
                    bean.getSp_count(),
                    bean.getSp_simg(),
                    bean.getSp_title(),
                    bean.getSp_price(),
                    bean.getYunfei(),
                    bean.getColor(),
                    bean.getGui()));
        }
        return list;
    }

}
