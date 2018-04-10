package com.lala.lashop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by JX on 2018/4/10.
 */

public class RectTextView extends android.support.v7.widget.AppCompatTextView {
    public RectTextView(Context context) {
        super(context);
    }

    public RectTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RectTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
