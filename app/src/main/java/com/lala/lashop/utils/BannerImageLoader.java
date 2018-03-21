package com.lala.lashop.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lala.lashop.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by JX on 2017/4/22.
 */

public class BannerImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(context).load(path).placeholder(R.drawable.image).into(imageView);
    }
}
