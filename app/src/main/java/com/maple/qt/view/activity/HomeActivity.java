package com.maple.qt.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.maple.qt.R;
import com.maple.qt.base.BaseActivity;
import com.maple.qt.widget.indicator.MapleIndicator;
import com.maple.qt.widget.view.LoadingButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.mapleIndicator)
    MapleIndicator mapleIndicator;
    @BindView(R.id.lbtn_login)
    LoadingButton loadingButton;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {


        mapleIndicator.startLoop();
    }


    @OnClick({R.id.btn_home, R.id.lbtn_login,R.id.btn_cancle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                showLoading();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoading();
                    }
                },3000);
                break;
            case R.id.lbtn_login:
                loadingButton.showLoading();
                break;
            case R.id.btn_cancle:
                loadingButton.hideLoading();
                break;
        }
    }
}
