package com.lala.lashop.ui.user.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.http.ApiPath;
import com.lala.lashop.ui.user.bean.UserBean;
import com.lala.lashop.ui.user.presenter.UserDetailPresenter;
import com.lala.lashop.ui.user.view.UserDetailView;
import com.lala.lashop.utils.GlideUtil;
import com.lala.lashop.utils.L;
import com.lala.lashop.utils.MyRxGalleryFinalApi;
import com.makeramen.roundedimageview.RoundedImageView;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultDisposable;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageRadioResultEvent;
import cn.finalteam.rxgalleryfinal.ui.base.IRadioImageCheckedListener;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import top.zibin.luban.Luban;

/**
 * 用户资料
 * Created by JX on 2018/3/22.
 */

@CreatePresenter(UserDetailPresenter.class)
public class UserDetailActivity extends BaseActivity<UserDetailView, UserDetailPresenter> implements UserDetailView {

    @BindView(R.id.user_tv_name)
    TextView userTvName;
    @BindView(R.id.tv_accout)
    TextView tvAccout;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.user_iv_head)
    RoundedImageView ivHead;

    private UserBean user;

    private String name;
    private String sex;
    private String email;
    private String headImg;

    private AlertDialog sexDialog;

    private RxPermissions rxPermissions;

    private File headFile;

    @Override
    public int setContentView() {
        return R.layout.user_detail_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("");

        rxPermissions = new RxPermissions(this);

        initView();
    }

    private void initView() {
        user = App.getUser();

        GlideUtil.loadImage(this, ApiPath.BASE_URL + user.getU_img(), ivHead);
        userTvName.setText(user.getU_phone());
        tvAccout.setText(user.getU_name());
        tvEmail.setText(user.getU_email());

        name = user.getU_name();
        sex = user.getU_sex();
        email = user.getU_email();
        headImg = user.getU_img();

        if (!TextUtils.isEmpty(user.getU_sex())) {
            tvSex.setText(user.getU_sex().equals("1") ? "男" : "女");
        }
    }

    @OnClick({R.id.user_iv_head, R.id.user_ll_accout, R.id.user_ll_sex, R.id.user_ll_email})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_iv_head:
                rxPermissions.requestEach(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                        .subscribe(new Consumer<Permission>() {
                            @Override
                            public void accept(@NonNull Permission permission) throws Exception {
                                if (permission.granted) {
                                    openGallery();
                                } else if (permission.shouldShowRequestPermissionRationale) {
                                    toast("打开失败");
                                    L.e("用户拒绝了权限申请");
                                } else {
                                    toast("打开失败，请前往应用设置打开权限");
                                    L.e("用户拒绝，并且选择不再提示");
                                }
                            }
                        });
                break;
            case R.id.user_ll_accout:
                Intent intent = new Intent(this, UserEditActivity.class);
                intent.putExtra(UserEditActivity.CONTENT, name);
                startActivityForResult(intent, 1);
                break;
            case R.id.user_ll_sex:
                selectSex();
                break;
            case R.id.user_ll_email:
                Intent intent1 = new Intent(this, UserEditActivity.class);
                intent1.putExtra(UserEditActivity.CONTENT, email);
                startActivityForResult(intent1, 2);
                break;
        }
    }

    private void selectSex() {
        String[] sexs = {"男", "女"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(sexs, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sex = which == 0 ? "1" : "0";
                getPresenter().update();
                sexDialog.dismiss();
            }
        });
        sexDialog = builder.create();
        sexDialog.show();
    }

    private void openGallery() {
        MyRxGalleryFinalApi.openRadioSelectImage(this, new RxBusResultDisposable<ImageRadioResultEvent>() {
            @Override
            protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
            }
        }, false).onCropImageResult(new IRadioImageCheckedListener() {
            @Override
            public void cropAfter(Object t) {
                L.e("裁剪后的图片 = " + t.toString());
                Flowable.just(t.toString())
                        .observeOn(Schedulers.io())
                        .map(new Function<String, File>() {
                            @Override
                            public File apply(@NonNull String s) throws Exception {
                                return Luban.with(UserDetailActivity.this).get(s);
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<File>() {
                            @Override
                            public void accept(@NonNull File file) throws Exception {
                                headFile = file;
                                getPresenter().uploadImage();
                            }
                        });
            }

            @Override
            public boolean isActivityFinish() {
                return true;
            }
        });
        MyRxGalleryFinalApi.getModelPath();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            name = data.getStringExtra(UserEditActivity.CONTENT);
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            email = data.getStringExtra(UserEditActivity.CONTENT);
        }
        getPresenter().update();
    }

    @Override
    public void updateSuccess() {
        user.setU_name(name);
        user.setU_sex(sex);
        user.setU_email(email);
        user.setU_img(headImg);

        App.getUser().setU_name(name);
        App.getUser().setU_sex(sex);
        App.getUser().setU_email(email);
        App.getUser().setU_img(headImg);

        initView();
    }

    @Override
    public void uploadSuccess(String headName) {
        headImg = headName;
        getPresenter().update();
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

    @Override
    public File getHeadFile() {
        return headFile;
    }
}
