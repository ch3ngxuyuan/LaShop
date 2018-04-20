package com.lala.lashop.app;

import android.app.Application;
import android.content.Context;

import com.lala.lashop.ui.user.bean.UserBean;
import com.lala.lashop.utils.SpUtils;
import com.lala.lashop.utils.SupportMultipleScreensUtil;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by JX on 2018/3/13.
 */

public class App extends Application {

    private static Context mContext;

    private static UserBean mUser;

    @Override
    public void onCreate() {
        super.onCreate();
        //屏幕适配
        SupportMultipleScreensUtil.init(this);

        mContext = this;

        //测试
        CrashReport.initCrashReport(getApplicationContext(), "4da3e1c515", false);

        mUser = SpUtils.getUser();
    }

    public static Context getContext() {
        return mContext;
    }

    public static UserBean getUser() {
        return mUser;
    }

    public static void cacheUser(UserBean user) {
        mUser = user;
        SpUtils.putUser(user);
    }
}
