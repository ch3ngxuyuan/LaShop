package com.lala.lashop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 正方形ImageView
 * Created by JX on 2018/3/20.
 */

public class RectImage extends android.support.v7.widget.AppCompatImageView {

    public RectImage(Context context) {
        super(context);
    }

    public RectImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RectImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
