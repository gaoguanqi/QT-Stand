package com.maple.qt.utils;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.maple.qt.R;

/**
 * author: gaogq
 * time: 2018/12/18 14:09
 * description:
 */
public class ToastUtil {
    private ToastUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }


    public static void showToast(String msg) {
        if (UIUtils.isEmpty(msg)) {
            return;
        }
        ToastUtils.setBgColor(UIUtils.getColor(R.color.colorToast));
        ToastUtils.showShort(msg);
    }
}
