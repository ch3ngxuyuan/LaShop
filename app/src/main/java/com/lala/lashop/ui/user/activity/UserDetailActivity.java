package com.lala.lashop.ui.user.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.user.bean.UserBean;
import com.lala.lashop.ui.user.presenter.UserDetailPresenter;
import com.lala.lashop.ui.user.view.UserDetailView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 用户资料
 * Created by JX on 2018/3/22.
 */

@CreatePresenter(UserDetailPresenter.class)
public class UserDetailActivity extends BaseActivity<UserDetailView, UserDetailPresenter> implements UserDetailView {

    @BindView(R.id.user_tv_name)
    TextView userTvName;
    @BindView(R.id.tv_phone)
    TextView tvName;

    private UserBean user;

    private String name;
    private String sex;
    private String email;
    private String headImg;

    @Override
    public int setContentView() {
        return R.layout.user_detail_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("");

        initView();
    }

    private void initView() {
        user = App.getUser();

        userTvName.setText(user.getU_phone());
        tvName.setText(user.getU_phone());
    }

    @OnClick({R.id.user_ll_accout, R.id.user_ll_sex, R.id.user_ll_email})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_ll_accout:
                break;
            case R.id.user_ll_sex:
                selectSex();
                break;
            case R.id.user_ll_email:
                break;
        }
    }

    private void selectSex() {
        String[] sexs = {"男", "女"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(sexs, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toast("选择了 = " + which);
            }
        });
        builder.create().show();
    }

    @Override
    public void updateSuccess() {

    }

    @Override
    public String getUserId() {
        return App.getUser().getId();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImg() {
        return headImg;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getBirthday() {
        return "";
    }
}
