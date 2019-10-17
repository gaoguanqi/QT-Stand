package com.maple.qt.utils;

import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.StringRes;

import com.blankj.utilcode.util.ColorUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;

public class UIUtils {

    public static boolean isEmpty(final String s) {
        return StringUtils.isEmpty(s);
    }


    public static String getString(@StringRes int id) {
        return StringUtils.getString(id);
    }


    public static int getColor(@ColorRes int id) {
        return ColorUtils.getColor(id);
    }
}
