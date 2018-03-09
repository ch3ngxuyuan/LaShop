package com.lala.lashop.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.Collections;
import java.util.List;

/**
 * Created by JX on 2017/12/12.
 */

public class Utils {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 4.4以上 设置状态栏透明
     *
     * @param activity
     */
    public static void setStatusbarTranslucent(Activity activity) {
        setStatusbarColor(activity, 0x00000000);
    }

    public static void setStatusbarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup decorViewGroup = (ViewGroup) window.getDecorView();
            if (decorViewGroup.findViewById(android.R.id.title) == null) {
                View mStatusBarTintView = new View(activity);
                mStatusBarTintView.setId(android.R.id.title);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
                mStatusBarTintView.setLayoutParams(params);
                mStatusBarTintView.setBackgroundColor(color);
                decorViewGroup.addView(mStatusBarTintView);
            } else {
                decorViewGroup.findViewById(android.R.id.title).setBackgroundColor(color);
            }
        }
    }

    public static void setStatusbarColor(Activity activity, View view, int color) {

        //对于Lollipop 的设备，只需要在style.xml中设置colorPrimaryDark即可
        //对于4.4的设备，如下设置padding即可，颜色同样在style.xml中配置
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            view.setBackgroundColor(color);
            setStatusbarHeight(activity, view);
        }
    }

    public static void setStatusbarHeight(Activity activity, View view) {
        if (!isKitkat()) return;
        int statusBarHeight = getStatusBarHeight(activity);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = params.height + statusBarHeight;

        view.setLayoutParams(params);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + statusBarHeight, view.getPaddingRight(), view.getPaddingBottom());
    }

    private static boolean isKitkat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    //获取状态栏高度
    public static int getStatusBarHeight(Context context) {
        Context appContext = context.getApplicationContext();
        int result = 0;
        int resourceId =
                appContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = appContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

//    /**
//     * 复制文本
//     *
//     * @param context
//     * @param content
//     */
//    public static void copyContent(Context context, String content) {
//        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
//        ClipData clipData = ClipData.newPlainText("text", content);
//        clipboardManager.setPrimaryClip(clipData);
//        Tos.toast(context, context.getResources().getString(R.string.copy_success));
//    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置字体颜色
     *
     * @param str   文本
     * @param start 开始的位置
     * @param end   结束的位置
     * @param color 颜色
     * @return
     */
    public static SpannableStringBuilder setColorString(String str, int start, int end, int color) {
        SpannableStringBuilder builder = new SpannableStringBuilder(str);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        builder.setSpan(foregroundColorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return builder;
    }

    /**
     * String[]倒序
     *
     * @param strings
     */
    public static String[] sort(String[] strings) {
        for (int start = 0, end = strings.length - 1; start < end; start++, end--) {
            String temp = strings[end];
            strings[end] = strings[start];
            strings[start] = temp;
        }
        return strings;
    }

    /**
     * List转 String
     *
     * @param strings
     * @return
     */
    public static String listConvertString(List<String> strings) {
        Collections.reverse(strings); //倒序
        String str = "";
        for (int i = 0; i < strings.size(); i++) {
            if (i == 0) {
                str += strings.get(i);
            } else {
                str += "," + strings.get(i);
            }
        }
        return str;
    }

}
