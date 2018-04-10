package com.lala.lashop.fragment;

import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lala.lashop.Constant;
import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseFragment;
import com.lala.lashop.ui.user.activity.AddressActivity;
import com.lala.lashop.ui.user.activity.ApplyActivity;
import com.lala.lashop.ui.user.activity.CollActivity;
import com.lala.lashop.ui.user.activity.DiscountActivity;
import com.lala.lashop.ui.user.activity.IndentActivity;
import com.lala.lashop.ui.user.activity.LoginActivity;
import com.lala.lashop.ui.user.activity.PointActivity;
import com.lala.lashop.ui.user.activity.UserDetailActivity;
import com.lala.lashop.ui.user.bean.UserBean;
import com.lala.lashop.utils.GlideUtil;
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

    @Override
    public int setContentView() {
        return R.layout.fragment_user;
    }

    @Override
    public void onCreate() {
        initUserData();
    }

    @Override
    public void onRxBus(int bus) {
        if (bus == Constant.LOGIN) {
            initUserData();
        }
    }

    private void initUserData() {
        if (App.getUser() == null) return;
        UserBean user = App.getUser();
        GlideUtil.loadImage(getActivity(), user.getU_img(), R.drawable.user_head, userIvHead);
        userTvLogin.setVisibility(View.GONE);
        userTvName.setVisibility(View.VISIBLE);
        userTvName.setText(user.getU_account());
    }

    @OnClick({R.id.user_iv_head, R.id.user_tv_login, R.id.user_ly_pay, R.id.user_ly_fa, R.id.user_ly_tui, R.id.user_ly_pos, R.id.user_ly_you, R.id.user_ly_ji, R.id.user_ly_zu, R.id.user_ly_shou})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.user_iv_head) {
            //头像
            if (App.getUser() == null) {
                startActivity(LoginActivity.class);
            } else {
                startActivity(UserDetailActivity.class);
            }
            return;
        }
        if (!checkUser()) return;
        switch (view.getId()) {
            case R.id.user_tv_login:
                break;
            case R.id.user_ly_pay: //待付款
                startActivity(IndentActivity.class);
                break;
            case R.id.user_ly_fa://待发货
                startActivity(IndentActivity.class);
                break;
            case R.id.user_ly_tui://退货 售后
                startActivity(ApplyActivity.class);
                break;
            case R.id.user_ly_pos://收货地址
                startActivity(AddressActivity.class);
                break;
            case R.id.user_ly_you://优惠券
                startActivity(DiscountActivity.class);
                break;
            case R.id.user_ly_ji://积分
                startActivity(PointActivity.class);
                break;
            case R.id.user_ly_zu: //我的足迹
                break;
            case R.id.user_ly_shou: //收藏
                startActivity(CollActivity.class);
                break;
        }
    }
}
