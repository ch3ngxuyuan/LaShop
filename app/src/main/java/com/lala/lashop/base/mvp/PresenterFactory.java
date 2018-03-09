package com.lala.lashop.base.mvp;

/**
 * Presenter工厂接口
 * Created by JX on 2017/12/7.
 */

public interface PresenterFactory<V extends BaseView, P extends BasePresenter> {

    P createPresenter();

}
