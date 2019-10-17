package com.maple.qt.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.maple.qt.R;
import com.maple.qt.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        startActivity(new Intent(this, HomeActivity.class));
        this.finish();
    }
}
