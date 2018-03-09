package com.lala.lashop.base.mvp;

import android.os.Bundle;

import com.lala.lashop.utils.L;


/**
 * Created by JX on 2017/12/8.
 */

public class BaseProxy<V extends BaseView, P extends BasePresenter<V>> implements PresenterProxyInterface<V, P> {

    private static final String TAG = "BaseProxy";

    /**
     * 获取onSaveInstanceState中bundle的key
     */
    private static final String PRESENTER_KEY = "presenter_key";

    /**
     * Presenter工厂类
     */
    private PresenterFactory<V, P> mFactory;
    private P mPresenter;
    private Bundle mBundle;
    private boolean mIsAttchView;

    public BaseProxy(PresenterFactory<V, P> presenterFactoryBaseProxy) {
//        L.e(TAG,"presenterFactoryBaseProxy = " + presenterFactoryBaseProxy);
        this.mFactory = presenterFactoryBaseProxy;
    }

    /**
     * 设置Presenter的工厂类,这个方法只能在创建Presenter之前调用,也就是调用getMvpPresenter()之前，如果Presenter已经创建则不能再修改
     *
     * @param presenterFactory PresenterFactory类型
     */
    @Override
    public void setPresenterFactory(PresenterFactory<V, P> presenterFactory) {
        if (mPresenter != null) {
            throw new IllegalArgumentException("设置Presenter的工厂类,这个方法只能在创建Presenter之前调用,也就是调用getMvpPresenter()之前，如果Presenter已经创建则不能再修改");
        }
        this.mFactory = presenterFactory;
    }

    /**
     * 获取Presenter工厂类
     *
     * @return
     */
    @Override
    public PresenterFactory<V, P> getPresenterFactory() {
        return mFactory;
    }

    @Override
    public P getPresenter() {
//        L.e(TAG, "getPresenter");
//        L.e(TAG, "mFactory = " + mFactory);
        if (mFactory != null) {
            if (mPresenter == null) {
                mPresenter = mFactory.createPresenter();
                mPresenter.onCreatePresenter(mBundle == null ? null : mBundle.getBundle(PRESENTER_KEY));
            }
        }
//        L.e(TAG, "getPresenter = " + mPresenter);
        return mPresenter;
    }

    /**
     * 绑定Presenter和View
     *
     * @param view
     */
    public void onResume(V view) {
        getPresenter();
        if (mPresenter != null && !mIsAttchView) {
            mPresenter.onAttchView(view);
            mIsAttchView = true;
        }
    }

    /**
     * 销毁Presenter持有的View
     */
    public void onDetachView() {
//        L.e(TAG, "onDetachView");
        if (mPresenter != null && mIsAttchView) {
            mPresenter.onDetachView();
            mIsAttchView = false;
        }
    }

    /**
     * 销毁Presenter
     */
    public void onDestroy() {
//        L.e(TAG, "onDestroy");
        if (mPresenter != null) {
            onDetachView();
            mPresenter.onDestroyPresenter();
            mPresenter = null;
        }
    }

    /**
     * 意外销毁的时候调用
     *
     * @return Bundle, 存入回调给Presenter的Bundle和当前presenter的id
     */
    public Bundle onSaveInstanceState() {
//        L.e(TAG, "onSaveInstanceState");
        Bundle bundle = new Bundle();
        getPresenter();
        if (mPresenter != null) {
            Bundle presenterBundle = new Bundle();
            //回调Presenter
            mPresenter.onSaveInstanceState(presenterBundle);
            bundle.putBundle(PRESENTER_KEY, presenterBundle);
        }
        return bundle;
    }

    /**
     * 意外关闭恢复Prsenter
     *
     * @param savedInstanceState 意外关闭时存储的Bundler
     */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        L.e(TAG, "onRestoreInstanceState");
        L.e(TAG, "onRestoreInstanceState Presenter = " + mPresenter);
        mBundle = savedInstanceState;
    }

}
