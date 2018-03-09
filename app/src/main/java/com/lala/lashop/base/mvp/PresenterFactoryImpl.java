package com.lala.lashop.base.mvp;

/**
 * Created by JX on 2017/12/7.
 */

public class PresenterFactoryImpl<V extends BaseView, P extends BasePresenter<V>> implements PresenterFactory<V, P> {

    /**
     * 需要创建的Presenter类型
     */
    private final Class<P> mPresenterClass;

    public PresenterFactoryImpl(Class<P> mPresenterClass) {
        this.mPresenterClass = mPresenterClass;
    }

    public static <V extends BaseView, P extends BasePresenter<V>> PresenterFactoryImpl<V, P> createFactory(Class<?> viewClazz) {
        CreatePresenter annotation = viewClazz.getAnnotation(CreatePresenter.class);
        Class<P> aClass = null;
        if (annotation != null) {
            aClass = (Class<P>) annotation.value();
        }
        return aClass == null ? null : new PresenterFactoryImpl<V, P>(aClass);
    }

    @Override
    public P createPresenter() {
        try{
            return mPresenterClass.newInstance();
        }catch (Exception e) {
            throw new RuntimeException("Presenter创建失败!，检查是否声明了@CreatePresenter(xx.class)注解");
        }
    }
}
