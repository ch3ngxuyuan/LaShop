package com.lala.lashop.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by JX on 2018/3/30.
 */

public class CusRoundedImageView extends RoundedImageView {
    public CusRoundedImageView(Context context) {
        super(context);
    }

    public CusRoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CusRoundedImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec * 2 + widthMeasureSpec / 2);
    }
}
