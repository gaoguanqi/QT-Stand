package com.maple.qt.widget.timer;

import android.os.CountDownTimer;

public class MyCountDownTimer extends CountDownTimer {

    private long mMillisInFuture,mCountDownInterval;
    private MyCountDownTimerListener mListener;
    public MyCountDownTimer(long millisInFuture, long countDownInterval, MyCountDownTimerListener listener) {
        super(millisInFuture, countDownInterval);
        this.mMillisInFuture = millisInFuture;
        this.mCountDownInterval = countDownInterval;
        this.mListener = listener;
        mListener.onStart();
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mListener.onTick(millisUntilFinished);
    }

    @Override
    public void onFinish() {
        mListener.onFinish();
    }

    public interface MyCountDownTimerListener{
        void onStart();
        void onTick(long millisUntilFinished);
        void onFinish();
    }
}
