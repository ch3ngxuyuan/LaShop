package com.lala.lashop.http;

import com.google.gson.Gson;
import com.lala.lashop.app.App;
import com.lala.lashop.base.mvp.BaseView;
import com.lala.lashop.http.exception.ApiException;
import com.lala.lashop.utils.L;
import com.lala.lashop.utils.Tos;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by JX on 2017/12/20.
 */

public abstract class ApiSubscribers<T> implements Observer<T> {

    private BaseView mView;

    public ApiSubscribers(BaseView mView) {
        this.mView = mView;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {
        HttpResult result = (HttpResult) t;
        String json = new Gson().toJson(t);
        L.e("ApiSubscribers", "json:" + json);

        if (mView != null) {
            mView.hideLoadingDialog();
            mView.hideMultipleView();
        }

        if (result.getCode() != 200) {
            onFail("访问不成功");
        } else {
            onSuccess(t);
        }

    }

    /**
     * @return 是否显示Toast
     */
    public boolean getDisplay() {
        return true;
    }

    public void onFail(String msg) {
        if (getDisplay()) {
            Tos.toast(App.getContext(), msg);
        }
    }

    public abstract void onSuccess(T t);

    @Override
    public void onError(@NonNull Throwable e) {
        L.e(e.getMessage());
        e.printStackTrace();
        ApiException apiException = new ApiException(e);
        if (mView != null) {
            if (apiException.getCode() == ApiException.SERVICE_ERROR) {
                mView.showErrorView();
            } else {
                mView.showNonetView();
            }
        }

        if (apiException.getCode() == ApiException.SERVICE_ERROR) {
            Tos.toast(App.getContext(), "连接服务器失败");
        } else {
            Tos.toast(App.getContext(), "网络连接失败");
        }

        onError(apiException);
        onComplete();
    }

    public abstract void onError(ApiException e);

    @Override
    public void onComplete() {
        if (mView != null) mView.hideLoadingDialog();
    }
}
