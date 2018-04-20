package com.lala.lashop.ui.user.activity;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.presenter.RegisterPresenter;
import com.lala.lashop.ui.user.view.RegisterView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册
 * Created by JX on 2018/3/19.
 */

@CreatePresenter(RegisterPresenter.class)
public class RegisterActivity extends BaseActivity<RegisterView, RegisterPresenter> implements RegisterView {

    @BindView(R.id.register_et_phone)
    EditText registerEtPhone;
    @BindView(R.id.register_et_pass)
    EditText registerEtPass;
    @BindView(R.id.register_et_code)
    EditText registerEtCode;
    @BindView(R.id.register_tv_send)
    TextView registerTvSend;

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
                if (registerTvSend != null) {
                    registerTvSend.setClickable(true);
                    registerTvSend.setText("重新发送");
                }
                return;
            }

            if (!isDestory) {
                registerTvSend.setText(recLen + "s");
                mHandler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    public int setContentView() {
        return R.layout.register_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("注册");
    }

    @Override
    public String getPhone() {
        return registerEtPhone.getText().toString();
    }

    @Override
    public String getPwd() {
        return registerEtPass.getText().toString();
    }

    @Override
    public String getCode() {
        return registerEtCode.getText().toString();
    }

    @Override
    public String getSendCode() {
        return sendCode;
    }

    @Override
    public void registerSuccess() {
        toast("注册成功");
        finish();
    }

    @Override
    public void sendSuccess(String code) {
        toast("验证码发送成功");
        registerTvSend.setClickable(false);
        mHandler.postDelayed(runnable, 1000);
        sendCode = code;
    }

    @OnClick({R.id.register_tv_send, R.id.register_tv_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_tv_send:
                getPresenter().smsSend();
                break;
            case R.id.register_tv_complete:
                getPresenter().register();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestory = true;
    }
}
