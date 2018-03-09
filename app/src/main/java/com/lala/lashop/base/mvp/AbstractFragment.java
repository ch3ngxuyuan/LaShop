package com.lala.lashop.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by JX on 2017/12/12.
 */

public class AbstractFragment<V extends BaseView, P extends BasePresenter<V>> extends RxFragment implements PresenterProxyInterface<V, P> {

    private static final String TAG = "AbstractActivity";

    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";

    private BaseProxy<V, P> mProxy = new BaseProxy<>(PresenterFactoryImpl.<V, P>createFactory(getClass()));

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mProxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mProxy.onResume((V) this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mProxy.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBundle(PRESENTER_SAVE_KEY, mProxy.onSaveInstanceState());
    }

    /**
     * 可以实现自己PresenterMvpFactory工厂
     *
     * @param presenterFactory PresenterFactory类型
     */
    @Override
    public void setPresenterFactory(PresenterFactory<V, P> presenterFactory) {
        mProxy.setPresenterFactory(presenterFactory);
    }

    /**
     * 获取创建Presenter的工厂
     *
     * @return PresenterMvpFactory类型
     */
    @Override
    public PresenterFactory<V, P> getPresenterFactory() {
        return mProxy.getPresenterFactory();
    }

    @Override
    public P getPresenter() {
        return mProxy.getPresenter();
    }
}
