package com.maple.qt.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.maple.qt.R;
import com.maple.qt.app.global.AppController;
import com.maple.qt.base.BaseActivity;
import com.maple.qt.utils.LogUtils;
import com.maple.qt.utils.PermissionUtil;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        applyPermissions();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        applyPermissions();
    }


    private void applyPermissions() {
        //请求外部存储权限用于适配android6.0的权限管理机制
        PermissionUtil.applyPermissions(new PermissionUtil.RequestPermission() {
            @Override
            public void onRequestPermissionSuccess() {
                //全部权限通过的回调
                LogUtils.logGGQ("onRequestPermissionSuccess");
                startTagetActivity();
            }

            @Override
            public void onRequestPermissionFailure(List<String> permissions) {
                //某一个权限拒绝的回调
                LogUtils.logGGQ("onRequestPermissionFailure");
                for (String permission : permissions) {
                    LogUtils.logGGQ(permission + "被拒绝了");
                }
               // showPermissionDialog(permissions);
                showTopMessage("被拒绝了");
            }

            @Override
            public void onRequestPermissionFailureWithAskNeverAgain(List<String> permissions) {
                //拒绝后点击不再询问的回调
                LogUtils.logGGQ("onRequestPermissionFailureWithAskNeverAgain");
                for (String permission : permissions) {
                    LogUtils.logGGQ(permission + "不在询问");
                }
                //showPermissionDialog(permissions);
                showTopMessage("不在询问");
            }
        }, new RxPermissions(this), AppController.getInstance().getRxErrorHandler());
    }

    private void startTagetActivity() {
        startActivity(new Intent(this, HomeActivity.class));
        this.finish();
    }
}
