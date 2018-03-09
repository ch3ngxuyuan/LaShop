package com.lala.lashop.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 所有Presenter的基类，并不强制实现这些方法，有需要在重写
 * Created by JX on 2017/12/7.
 */

public class BasePresenter<V extends BaseView> {

    private final String TAG = "BasePresenter";

    private V mView;

    /**
     * Presenter被创建后调用
     *
     * @param savedState 被意外销毁后重建后的Bundle
     */
    public void onCreatePresenter(@Nullable Bundle savedState) {
//        Log.e(TAG, "onCreatePresenter");
    }

    /**
     * 绑定View
     */
    public void onAttchView(V view) {
        mView = view;
//        Log.e(TAG, "onAttchView");
    }

    /**
     * 解绑View
     */
    public void onDetachView() {
        mView = null;
        Log.e(TAG, "onDetachView");
    }

    /**
     * Presenter被销毁时调用
     */
    public void onDestroyPresenter() {
        Log.e(TAG, "onDestroyPresenter");
    }

    /**
     * 在Presenter意外销毁的时候被调用，它的调用时机和Activity、Fragment、View中的onSaveInstanceState
     * 时机相同
     *
     * @param outState
     */
    public void onSaveInstanceState(Bundle outState) {
        Log.e(TAG, "onSaveInstanceState");
    }

    /**
     * 获取V层接口View
     *
     * @return 返回当前BaseView
     */
    public V getView() {
        return mView;
    }

    /**
     * Activity线程调度
     */
    public <T> ObservableTransformer<T, T> composeAct() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(mView.getRxAct().<T>bindToLifecycle());
            }
        };
    }

    /**
     * Fragment线程调度
     */
    public <T> ObservableTransformer<T, T> composeFra() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(mView.getRxFra().<T>bindToLifecycle());
            }
        };
    }

    /**
     * 通用
     *
     * @param <T>
     * @return
     */
    public <T> ObservableTransformer<T, T> compose() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose((mView.getRxAct() == null ? mView.getRxFra() : mView.getRxAct()).<T>bindToLifecycle());
            }
        };
    }
}
