package com.lala.lashop.base.mvp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by JX on 2017/12/8.
 */

public abstract class AbstractActivity<V extends BaseView, P extends BasePresenter<V>> extends RxAppCompatActivity implements PresenterProxyInterface<V, P> {

    private static final String TAG = "AbstractActivity";

    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";

    private BaseProxy<V, P> mProxy = new BaseProxy<>(PresenterFactoryImpl.<V, P>createFactory(getClass()));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mProxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
        }
        mProxy.onResume((V) this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
//        Log.e(TAG, "onDestroy");
        super.onDestroy();
        mProxy.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
//        Log.e(TAG, "onSaveInstanceState");
        outState.putBundle(PRESENTER_SAVE_KEY, mProxy.onSaveInstanceState());
    }

    @Override
    public void setPresenterFactory(PresenterFactory<V, P> presenterFactory) {
//        Log.e(TAG, "setPresenterFactory");
        mProxy.setPresenterFactory(presenterFactory);
    }

    @Override
    public PresenterFactory<V, P> getPresenterFactory() {
//        Log.e(TAG, "getPresenterFactory");
        return mProxy.getPresenterFactory();
    }

    @Override
    public P getPresenter() {
//        Log.e(TAG, "getPresenter");
        return mProxy.getPresenter();
    }
}
