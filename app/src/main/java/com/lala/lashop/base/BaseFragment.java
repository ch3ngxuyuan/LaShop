package com.lala.lashop.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.mvp.AbstractFragment;
import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.ui.user.activity.LoginActivity;
import com.lala.lashop.utils.RxBus;
import com.lala.lashop.utils.SupportMultipleScreensUtil;
import com.lala.lashop.utils.Tos;
import com.lala.lashop.widget.LoadingDialog;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by JX on 2017/12/11.
 */

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends AbstractFragment<V, P> implements BaseView {

    private View mView;
    private Unbinder unbinder;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(setContentView(), container, false);
        unbinder = ButterKnife.bind(this, mView);
        SupportMultipleScreensUtil.scale(mView);
        onCreate();
        return mView;
    }

    public abstract int setContentView();

    public abstract void onCreate();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
        Tos.toast(getActivity(), toast);
    }

    @Override
    public void toast(int strId) {
        Tos.toast(getActivity(), getResources().getString(strId));
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
        startActivity(new Intent(getActivity(), activity));
    }

    @Override
    public void startActivityForResult(Class<? extends Activity> activity, int requestCode) {
        getActivity().startActivityForResult(new Intent(getActivity(), activity), requestCode);
    }

    @Override
    public void startActivity(Class<? extends Activity> activity, Bundle bundle) {
        startActivity(new Intent(getActivity(), activity).putExtras(bundle));
    }

    @Override
    public void showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(getActivity());
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
//            multipleStatusView = (MultipleStatusView) mView.findViewById(R.id.multiple_status);
//        }
//        multipleStatusView.setVisibility(View.VISIBLE);
//        multipleStatusView.showLoading();
    }

    @Override
    public void showErrorView() {
//        if (multipleStatusView == null) {
//            multipleStatusView = (MultipleStatusView) mView.findViewById(R.id.multiple_status);
//        }
//        if (multipleStatusView == null) return;
//        multipleStatusView.setVisibility(View.VISIBLE);
//        multipleStatusView.showError();
    }

    @Override
    public void showEmptyView() {
//        if (multipleStatusView == null) {
    }

    @Override
    public void showNonetView() {
//        if (multipleStatusView == null) {
//            multipleStatusView = (MultipleStatusView) mView.findViewById(R.id.multiple_status);
//        }
//        if (multipleStatusView == null) return;
//        multipleStatusView.setVisibility(View.VISIBLE);
//        multipleStatusView.showNoNetwork();
    }

    @Override
    public void hideMultipleView() {
//        if (multipleStatusView == null) {
//            multipleStatusView = (MultipleStatusView) mView.findViewById(R.id.multiple_status);
//        }
//        if (multipleStatusView == null) return;
//        multipleStatusView.setVisibility(View.GONE);
    }

    /**
     * 显示未登录状态
     */
    public void showNologinView() {
//        if (multipleStatusView == null) {
//            multipleStatusView = (MultipleStatusView) mView.findViewById(R.id.multiple_status);
//        }
//        if (multipleStatusView == null) return;
//        multipleStatusView.setVisibility(View.VISIBLE);
//        multipleStatusView.showNoLogin();
    }

//    /**
//     * 多状态视图点击监听器
//     */
//    public void setOnMultipleClickListener(View.OnClickListener onMultipleClickListener) {
//        multipleStatusView.setOnClickListener(onMultipleClickListener);
//    }

    @Override
    public RxAppCompatActivity getRxAct() {
        return null;
    }

    @Override
    public RxFragment getRxFra() {
        return this;
    }
}
