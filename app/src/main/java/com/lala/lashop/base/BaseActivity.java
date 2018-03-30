package com.lala.lashop.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.mvp.AbstractActivity;
import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.activity.LoginActivity;
import com.lala.lashop.utils.RxBus;
import com.lala.lashop.utils.SupportMultipleScreensUtil;
import com.lala.lashop.utils.ToolbarManager;
import com.lala.lashop.utils.Tos;
import com.lala.lashop.utils.Utils;
import com.lala.lashop.widget.LoadingDialog;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by JX on 2017/12/11.
 */

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends AbstractActivity<V, P> implements BaseView {

    private ToolbarManager mToolbarManager;

    //加载框
    private LoadingDialog loadingDialog;

    //多状态View
//    private MultipleStatusView multipleStatusView;

    private Disposable disposable = RxBus.getInstance()
            .toObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .map(new Function<Object, Integer>() {
                @Override
                public Integer apply(@NonNull Object o) throws Exception {
                    return (Integer) o;
                }
            })
            .subscribe(new Consumer<Integer>() {
                @Override
                public void accept(@NonNull Integer integer) throws Exception {
                    onRxBus(integer);
                }
            });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //禁止横屏
        Utils.setStatusbarColor(this, getResources().getColor(R.color.main)); //状态栏颜色
        setContentView(setContentView());
        View rootView = findViewById(android.R.id.content);
        SupportMultipleScreensUtil.scale(rootView);
        ButterKnife.bind(this);

        mToolbarManager = new ToolbarManager(this);

        onCreate();
    }

    public abstract int setContentView();

    public abstract void onCreate();

    public ToolbarManager getToolbar() {
        return mToolbarManager;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null && disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    /**
     * 重写该方法来执行操作
     *
     * @param bus
     */
    public void onRxBus(int bus) {
    }

    @Override
    public void toast(String toast) {
        Tos.toast(this, toast);
    }

    @Override
    public void toast(int strId) {
        Tos.toast(this, getResources().getString(strId));
    }

    /**
     * 检查用户是否登录
     *
     * @return
     */
    @Override
    public boolean checkUser() {
        if (App.getUser() == null) {
            startActivityForResult(LoginActivity.class, 1111);
            toast("未登录");
            return false;
        }
        return true;
    }

    @Override
    public void startActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    @Override
    public void startActivityForResult(Class<? extends Activity> activity, int requestCode) {
        startActivityForResult(new Intent(this, activity), requestCode);
    }

    @Override
    public void startActivity(Class<? extends Activity> activity, Bundle bundle) {
        startActivity(new Intent(this, activity).putExtras(bundle));
    }

    public void startActivity(Class<? extends Activity> activity, String key, int interger) {
        Bundle bundle = new Bundle();
        bundle.putInt(key, interger);
        startActivity(activity, bundle);
    }

    @Override
    public void showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    @Override
    public void hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void showLoadingView() {
//        if (multipleStatusView == null) {
//            multipleStatusView = (MultipleStatusView) findViewById(R.id.multiple_status);
//        }
//        multipleStatusView.setVisibility(View.VISIBLE);
//        multipleStatusView.showLoading();
    }

    @Override
    public void showErrorView() {
//        if (multipleStatusView == null) {
//            multipleStatusView = (MultipleStatusView) findViewById(R.id.multiple_status);
//        }
//        if (multipleStatusView == null) return;
//        multipleStatusView.setVisibility(View.VISIBLE);
//        multipleStatusView.showError();
    }

    @Override
    public void showEmptyView() {
//        if (multipleStatusView == null) {
//            multipleStatusView = (MultipleStatusView) findViewById(R.id.multiple_status);
//        }
//        if (multipleStatusView == null) return;
//        multipleStatusView.setVisibility(View.VISIBLE);
//        multipleStatusView.showEmpty();
    }

    @Override
    public void showNonetView() {
//        if (multipleStatusView == null) {
//            multipleStatusView = (MultipleStatusView) findViewById(R.id.multiple_status);
//        }
//        multipleStatusView.setVisibility(View.VISIBLE);
//        multipleStatusView.showNoNetwork();
    }

    /**
     * 显示未登录状态
     */
    public void showNologinView() {
//        if (multipleStatusView == null) {
//            multipleStatusView = (MultipleStatusView) findViewById(R.id.multiple_status);
//        }
//        if (multipleStatusView == null) return;
//        multipleStatusView.setVisibility(View.VISIBLE);
//        multipleStatusView.showNoLogin();
    }

    @Override
    public void hideMultipleView() {
//        if (multipleStatusView == null) {
//            multipleStatusView = (MultipleStatusView) findViewById(R.id.multiple_status);
//        }
//        if (multipleStatusView == null) return;
//        multipleStatusView.setVisibility(View.GONE);
    }

//    /**
//     * 多状态视图点击监听器
//     *
//     * @param onMultipleClickListener
//     */
//    public void setOnMultipleClickListener(View.OnClickListener onMultipleClickListener) {
//        multipleStatusView.setOnClickListener(onMultipleClickListener);
//    }

    @Override
    public RxAppCompatActivity getRxAct() {
        return this;
    }

    @Override
    public RxFragment getRxFra() {
        return null;
    }
}
