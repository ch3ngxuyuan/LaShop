package com.lala.lashop.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.lala.lashop.R;
import com.lala.lashop.utils.SupportMultipleScreensUtil;

/**
 * Created by JX on 2018/3/22.
 */

public class LoadingDialog extends Dialog {

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.DialogStyle);
        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        SupportMultipleScreensUtil.scale(contentView);
        setContentView(contentView);
        setCanceledOnTouchOutside(false);

        Window dialogWindow = getWindow();
        WindowManager m = ((Activity) context).getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        int width = (int) (d.getWidth() * 0.3);
        p.width = width;
        p.height = width;
        dialogWindow.setAttributes(p);
    }

}
