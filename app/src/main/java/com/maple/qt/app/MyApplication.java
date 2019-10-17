package com.maple.qt.app;

import android.app.Application;

import com.maple.qt.app.global.AppController;

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //单利的APP
        AppController.getInstance().init(this, this.getApplicationContext());
    }

}
