package com.lala.lashop.ui.user.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.presenter.FoundPresenter;
import com.lala.lashop.ui.user.view.FoundView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 忘记密码
 * Created by JX on 2018/3/19.
 */

@CreatePresenter(FoundPresenter.class)
public class FoundActivity extends BaseActivity<FoundView, FoundPresenter> implements FoundView {

    @BindView(R.id.found_ly_one)
    LinearLayout foundLyOne;
    @BindView(R.id.found_et_phone)
    EditText foundEtPhone;
    @BindView(R.id.found_et_code)
    EditText foundEtCode;
    @BindView(R.id.found_tv_send)
    TextView foundTvSend;
    @BindView(R.id.found_ly_two)
    LinearLayout foundLyTwo;
    @BindView(R.id.found_et_pass)
    EditText foundEtPass;
    @BindView(R.id.found_et_confirm)
    EditText foundEtConfirm;

    @Override
    public int setContentView() {
        return R.layout.found_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("忘记密码");
    }

    @Override
    public void updateSuccess() {
        finish();
    }

    @Override
    public String getPhone() {
        return foundEtPhone.getText().toString();
    }

    @Override
    public String getNewPwd() {
        return foundEtPass.getText().toString();
    }

    @Override
    public String getConfirmPwd() {
        return foundEtConfirm.getText().toString();
    }

    @OnClick({R.id.found_tv_send, R.id.found_tv_next, R.id.found_tv_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.found_tv_send:
                break;
            case R.id.found_tv_next:
                break;
            case R.id.found_tv_complete:
                getPresenter().updatePwd();
                break;
        }
    }
}
