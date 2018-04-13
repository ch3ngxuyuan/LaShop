package com.lala.lashop.ui.shop;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.shop.adapter.InvoiceAdapter;
import com.lala.lashop.ui.shop.bean.InvoiceBean;
import com.lala.lashop.ui.shop.presenter.InvoicePresenter;
import com.lala.lashop.ui.shop.view.InvoiceView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 选择发票
 * Created by JX on 2018/4/12.
 */

@CreatePresenter(InvoicePresenter.class)
public class InvoiceActivity extends BaseActivity<InvoiceView, InvoicePresenter> implements InvoiceView {

    @BindView(R.id.invoice_rv)
    RecyclerView rv;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.iv_select)
    ImageView ivSelect;

    private InvoiceAdapter mAdapter;

    private List<InvoiceBean> mData;

    private int moren = 1; //是否默认

    @Override
    public int setContentView() {
        return R.layout.invoice_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("选择发票");

        mData = new ArrayList<>();

        mData.add(new InvoiceBean());

        mAdapter = new InvoiceAdapter(R.layout.invoice_rv_item, mData);
        mAdapter.bindToRecyclerView(rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        getPresenter().getList();
    }

    @Override
    public void setListData(List<InvoiceBean> data) {
        mAdapter.setNewData(data);
    }

    @Override
    public void addSuccess() {

    }

    @Override
    public String getUserId() {
        return App.getUser() == null ? "" : App.getUser().getUser_id();
    }

    @Override
    public String getHead() {
        return etName.getText().toString();
    }

    @Override
    public String getTaxnumber() {
        return etNumber.getText().toString();
    }

    @Override
    public int getMoren() {
        return moren;
    }

    @OnClick({R.id.iv_select, R.id.tv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_select:
                selectMoren();
                break;
            case R.id.tv_add:
                getPresenter().addInvoice();
                break;
        }
    }

    private void selectMoren() {
        if (moren == 1) {
            moren = 0;
        } else {
            moren = 1;
        }
        ivSelect.setImageResource(moren == 1 ? R.drawable.invoice_select : R.drawable.invoice_noselect);
    }

}
