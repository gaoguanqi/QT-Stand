package com.maple.qt.widget.loading;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.ScreenUtils;
import com.maple.qt.R;
import com.maple.qt.widget.dialog.BaseDialog;

public class LoadingDialog extends BaseDialog {
    private String msg = "请稍后...";

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.BaseDialog);
        initView(context);
    }

    public LoadingDialog(@NonNull Context context, String msg) {
        super(context, R.style.BaseDialog);
        this.msg = msg;
        initView(context);
    }


    @Override
    public boolean hasFullScreen() {
        return  false;
    }


    private void initView(Context context) {
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.loading_dialog_anim);
            window.setGravity(Gravity.TOP);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = (int) (ScreenUtils.getScreenWidth() * 0.96);
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//            window.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_dialog_bg));
            window.setAttributes(lp);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        setCanceledOnTouchOutside(false);
        TextView tvLoading = this.findViewById(R.id.tv_loading);
        if(tvLoading != null) tvLoading.setText(msg);
    }
}
