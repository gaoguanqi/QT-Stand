package com.maple.qt.view.activity;

import android.os.Bundle;
import android.os.Handler;

import com.maple.qt.R;
import com.maple.qt.base.BaseActivity;
import com.maple.qt.utils.ToastUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {


    }


    @OnClick(R.id.btn_home)
    public void onViewClicked() {
        showLoading();
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               hideLoading();
           }
       },3000);
    }
}
