package com.lala.lashop.base.mvp;

/**
 * 代理接口
 * Created by JX on 2017/12/7.
 */

public interface PresenterProxyInterface<V extends BaseView, P extends BasePresenter<V>> {

    /**
     * 设置创建Presenter的工厂
     *
     * @param presenterFactory PresenterFactory类型
     */
    void setPresenterFactory(PresenterFactory<V, P> presenterFactory);

    /**
     * 获取Prsenter的工厂类
     *
     * @return PresenterFactory类型
     */
    PresenterFactory<V, P> getPresenterFactory();

    /**
     * 获取创建的Presenter
     *
     * @return 指定类型的Presenter
     */
    P getPresenter();

}
