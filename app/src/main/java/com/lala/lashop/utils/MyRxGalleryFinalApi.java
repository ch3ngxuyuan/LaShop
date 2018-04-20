package com.lala.lashop.utils;

import android.app.Activity;

import com.yalantis.ucrop.model.AspectRatio;

import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.RxGalleryFinalApi;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultDisposable;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageRadioResultEvent;
import cn.finalteam.rxgalleryfinal.utils.Logger;

/**
 * Created by JX on 2018/4/20.
 */

public class MyRxGalleryFinalApi extends RxGalleryFinalApi {

    private static MyRxGalleryFinalApi mRxApi = new MyRxGalleryFinalApi();
    private static RxGalleryFinal rxGalleryFinal;

    /**
     * 默认使用 ImageLoaderType.GLIDE
     */
    public static RxGalleryFinalApi getInstance(Activity context) {
        if (context == null) {
            throw new NullPointerException("context == null");
        }
        rxGalleryFinal = RxGalleryFinal.with(context)
                .imageLoader(ImageLoaderType.GLIDE)
                .subscribe(null);
        Logger.i("==========" + mRxApi + "====" + rxGalleryFinal);
        return mRxApi;
    }

    public static RxGalleryFinalApi openRadioSelectImage(Activity context, RxBusResultDisposable<ImageRadioResultEvent> rxBusResultDisposable, boolean flag) {
        getInstance(context);
        if (flag) {
            rxGalleryFinal
                    .image()
                    .radio()
                    .imageLoader(ImageLoaderType.GLIDE)
                    .subscribe(rxBusResultDisposable)
                    .openGallery();
        } else {
            rxGalleryFinal
                    .image()
                    .radio()
                    .crop()
                    .cropAspectRatioOptions(0, new AspectRatio("1:1", 100, 100))
                    .imageLoader(ImageLoaderType.GLIDE)
                    .subscribe(rxBusResultDisposable)
                    .openGallery();
        }
        return mRxApi;
    }
}
