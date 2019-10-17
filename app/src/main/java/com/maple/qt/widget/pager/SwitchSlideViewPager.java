package com.maple.qt.widget.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * author: gaogq
 * time: 2018/12/19 16:32
 * description:设置滑动开关的ViewPager
 */
public class SwitchSlideViewPager extends ViewPager {
    private boolean noScroll = true;

    public SwitchSlideViewPager(@NonNull Context context) {
        super(context);
    }

    public SwitchSlideViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (noScroll) {
            return false;
        } else {
            return super.onInterceptTouchEvent(ev);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (noScroll) {
            return false;
        } else {
            return super.onTouchEvent(ev);
        }
    }

}
