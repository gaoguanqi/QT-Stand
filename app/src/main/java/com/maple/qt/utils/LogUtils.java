package com.maple.qt.utils;

import android.util.Log;

import com.maple.qt.BuildConfig;

public class LogUtils {

    private LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }


    public static void logGGQ(String s){
        if(BuildConfig.DEBUG){
            Log.i("GGQ", s);
        }
    }
}
