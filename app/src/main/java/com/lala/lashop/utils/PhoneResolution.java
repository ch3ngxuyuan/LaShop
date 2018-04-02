package com.lala.lashop.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by JX on 2017/5/4.
 */

public class PhoneResolution {

    /**
     * 获取相对于指定手机分辨率的比例
     * 算法 = 本机高度 / 指定手机的高度
     * 如  1280 / 1920  = 2/3  比例就是2/3
     *
     * @param height
     * @param activity
     * @return 比例
     */
    public static float getPhoneHeightPX(float height, Activity activity) {
        float f = (float) getPhoneHeight(activity) / height;
        return f;
    }


    /**
     * ---------  以下为新增方法  防止手机内存不足系统回收掉所有静态变量
     */

    /**
     * 获取屏幕信息
     *
     * @param activity
     * @return
     */
    private static DisplayMetrics getDisplayMetrics(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    /**
     * 获取屏幕宽度
     *
     * @param activity
     * @return
     */
    public static int getPhoneWidth(Activity activity) {
        return getDisplayMetrics(activity).widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param activity
     * @return
     */
    public static int getPhoneHeight(Activity activity) {
        return getDisplayMetrics(activity).heightPixels;
    }

    /**
     * 获取状态栏高度
     *
     * @param activity
     * @return
     */
    public static int getStatusBarHeights(Activity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取屏幕密度
     *
     * @param activity
     * @return
     */
    public static float getDensity(Activity activity) {
        return getDisplayMetrics(activity).density;
    }

}
