package com.lala.lashop.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lala.lashop.R;

/**
 * Created by JX on 2017/5/3.
 */

public class GlideUtil {

    /**
     * 加载普通图片
     *
     * @param context
     * @param path
     * @param imageView
     */
    public static void loadImage(Context context, String path, ImageView imageView) {
        loadImage(context, path, R.drawable.image, imageView);
    }

    public static void loadImage(Context context, String path, int resId, ImageView imageView) {
        Glide.with(context).load(path).dontAnimate().placeholder(resId).into(imageView);
    }

//    /**
//     * 加载头像
//     *
//     * @param context
//     * @param path
//     * @param imageView
//     */
//    public static void loadHead(Context context, String path, ImageView imageView) {
//        Glide.with(context).load(path).dontAnimate().placeholder(R.drawable.head).error(R.drawable.head).into(imageView);
//    }
}
