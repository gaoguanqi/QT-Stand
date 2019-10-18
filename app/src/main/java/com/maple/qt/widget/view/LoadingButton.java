package com.maple.qt.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maple.qt.R;
import com.maple.qt.widget.indicator.MapleIndicator;


public class LoadingButton extends RelativeLayout {
    private TextView tvText;
    private MapleIndicator miLoading;
    private boolean hasLoging;

    public LoadingButton(Context context) {
        this(context, null);
    }

    public LoadingButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        View view = View.inflate(context, R.layout.layout_loading_button, this);
        tvText = view.findViewById(R.id.tv_text);
        miLoading = view.findViewById(R.id.mi_loading);
    }


    public void showLoading() {
        if(tvText != null && miLoading != null){
            tvText.setVisibility(GONE);
            miLoading.setVisibility(VISIBLE);
            if (!hasLoging) {
                hasLoging = true;
                miLoading.startLoop();
            }
        }
    }

    public void hideLoading() {
        if(tvText != null && miLoading != null){
            tvText.setVisibility(VISIBLE);
            miLoading.setVisibility(GONE);
            miLoading.stopLoop();
            hasLoging = false;
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        hideLoading();
        super.onDetachedFromWindow();
    }
}
