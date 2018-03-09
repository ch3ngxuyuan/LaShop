package com.lala.lashop.utils;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by JX on 2017/12/18.
 */

public class Tos {

    private static Toast toast = null;
    public static boolean ISSHOW = true;

    /**
     * 显示短Toast
     *
     * @param context
     * @param text
     */
    public static void toast(Context context, String text) {
        if (!ISSHOW) return;

        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
