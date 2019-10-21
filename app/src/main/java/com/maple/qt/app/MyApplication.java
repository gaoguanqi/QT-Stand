package com.maple.qt.app;

import android.app.Application;
import android.content.Context;

import com.maple.qt.app.global.AppController;
import com.maple.qt.utils.LogUtils;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener;

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //单利的APP
        AppController.getInstance().init(this, this.getApplicationContext(), RxErrorHandler
                .builder()
                .with(this)
                .responseErrorListener(new ResponseErrorListener() {
                    @Override
                    public void handleResponseError(Context context, Throwable t) {
                        if (t instanceof UnknownHostException) {
                            //do something ...
                        } else if (t instanceof SocketTimeoutException) {
                            //do something ...
                        } else {
                            //handle other Exception ...
                        }
                        LogUtils.logGGQ("Error handle");
                    }
                }).build());
    }

}
