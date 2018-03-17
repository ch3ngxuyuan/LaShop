package com.lala.lashop.app;

import android.app.Application;

import com.lala.lashop.utils.SupportMultipleScreensUtil;

/**
 * Created by JX on 2018/3/13.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SupportMultipleScreensUtil.init(this);
    }
}
