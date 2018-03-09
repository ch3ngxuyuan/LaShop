package com.lala.lashop.base.mvp;

import android.app.Activity;
import android.os.Bundle;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by JX on 2017/12/7.
 */

public interface BaseView {

    void toast(String toast);

    void toast(int strId);

    /**
     * 检查用户是否登录
     *
     * @return
     */
    boolean checkUser();

    /**
     * 打开Activity无参数
     *
     * @param activity
     */
    void startActivity(Class<? extends Activity> activity);

    void startActivityForResult(Class<? extends Activity> activity, int requestCode);

    /**
     * 打开Activity带参数
     *
     * @param activity
     * @param bundle
     */
    void startActivity(Class<? extends Activity> activity, Bundle bundle);

    void showLoadingDialog();

    void hideLoadingDialog();

    void showLoadingView();

    /**
     * 显示无网络界面
     */
    void showNonetView();

    /**
     * 显示空视图
     */
    void showEmptyView();

    /**
     * 显示服务器出错界面
     */
    void showErrorView();

    /**
     * 显示未登录界面
     */
    void showNologinView();

    /**
     * 隐藏多状态界面
     */
    void hideMultipleView();

    RxAppCompatActivity getRxAct();

    RxFragment getRxFra();

}
