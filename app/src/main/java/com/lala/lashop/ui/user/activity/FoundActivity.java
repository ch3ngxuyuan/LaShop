package com.lala.lashop.ui.user.activity;

import android.os.Handler;
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

    private String sendCode;

    private int recLen = 60;

    private boolean isDestory = false;

    Handler mHandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            recLen--;
            if (recLen == 0) {
                recLen = 60;
                if (foundTvSend != null) {
                    foundTvSend.setClickable(true);
                    foundTvSend.setText("重新发送");
                }
                return;
            }

            if (!isDestory) {
                foundTvSend.setText(recLen + "s");
                mHandler.postDelayed(this, 1000);
            }
        }
    };

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
    public void sendSuccess(String code) {
        toast("验证码发送成功");
        foundTvSend.setClickable(false);
        mHandler.postDelayed(runnable, 1000);
        sendCode = code;
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

    @Override
    public String getCode() {
        return foundEtCode.getText().toString();
    }

    @Override
    public String getSendCode() {
        return sendCode;
    }

    @OnClick({R.id.found_tv_send, R.id.found_tv_next, R.id.found_tv_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.found_tv_send:
                getPresenter().smsSend();
                break;
            case R.id.found_tv_next:
                if (getSendCode().equals(getCode())) {
                    foundLyOne.setVisibility(View.GONE);
                    foundLyTwo.setVisibility(View.VISIBLE);
                } else {
                    toast("验证码不正确");
                }
                break;
            case R.id.found_tv_complete:
                getPresenter().updatePwd();
                break;
        }
    }
}
