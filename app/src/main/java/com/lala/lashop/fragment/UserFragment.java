package com.lala.lashop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.ui.user.activity.LoginActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by JX on 2018/3/17.
 */

public class UserFragment extends BaseFragment {

    @BindView(R.id.user_iv_head)
    RoundedImageView userIvHead;
    @BindView(R.id.user_tv_login)
    TextView userTvLogin;
    @BindView(R.id.user_tv_name)
    TextView userTvName;
    @BindView(R.id.user_ly_pay)
    LinearLayout userLyPay;
    @BindView(R.id.user_ly_fa)
    LinearLayout userLyFa;
    @BindView(R.id.user_ly_tui)
    LinearLayout userLyTui;
    @BindView(R.id.user_ly_pos)
    LinearLayout userLyPos;
    @BindView(R.id.user_ly_you)
    LinearLayout userLyYou;
    @BindView(R.id.user_ly_ji)
    LinearLayout userLyJi;
    @BindView(R.id.user_ly_zu)
    LinearLayout userLyZu;
    @BindView(R.id.user_ly_shou)
    LinearLayout userLyShou;
    Unbinder unbinder;

    @Override
    public int setContentView() {
        return R.layout.fragment_user;
    }

    @Override
    public void onCreate() {

    }

    @OnClick({R.id.user_iv_head, R.id.user_tv_login, R.id.user_ly_pay, R.id.user_ly_fa, R.id.user_ly_tui, R.id.user_ly_pos, R.id.user_ly_you, R.id.user_ly_ji, R.id.user_ly_zu, R.id.user_ly_shou})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_iv_head:
                startActivity(LoginActivity.class);
                break;
            case R.id.user_tv_login:
                break;
            case R.id.user_ly_pay:
                break;
            case R.id.user_ly_fa:
                break;
            case R.id.user_ly_tui:
                break;
            case R.id.user_ly_pos:
                break;
            case R.id.user_ly_you:
                break;
            case R.id.user_ly_ji:
                break;
            case R.id.user_ly_zu:
                break;
            case R.id.user_ly_shou:
                break;
        }
    }
}
