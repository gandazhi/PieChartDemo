package com.gandazhi.piechartdemo;

import android.content.Context;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.utils.Utils;

/**
 * Created by gandazhiPc on 2016/12/15.
 */

public class MyPieChart extends PieChart {
    public MyPieChart(Context context) {
        super(context);
    }

    public MyPieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPieChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = (int) Utils.convertDpToPixel(MeasureSpec.getSize(widthMeasureSpec));
        setMeasuredDimension(
                Math.max(getSuggestedMinimumWidth(),
                        resolveSize(size,widthMeasureSpec)),
                Math.max(getSuggestedMinimumWidth(),
                        resolveSize(size,widthMeasureSpec)));
    }

    private void setMeasuredDimension(int max) {
    }
}
