package com.maple.qt.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public abstract class BaseViewModel extends AndroidViewModel {
    private Application mApplication;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        this.mApplication = application;
    }




}
