package com.lala.lashop.app;

import android.app.Application;
import android.content.Context;

import com.lala.lashop.utils.SupportMultipleScreensUtil;

/**
 * Created by JX on 2018/3/13.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        //屏幕适配
        SupportMultipleScreensUtil.init(this);

        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
