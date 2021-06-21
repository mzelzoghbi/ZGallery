package com.mzelzoghbi.zgallery;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by mohamedzakaria on 8/7/16.
 *
 * Modified by mirjalal on 16/11/20.
 */
public class SquareImageView extends androidx.appcompat.widget.AppCompatImageView {
    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}
