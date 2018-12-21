package com.mul.dialog;

import android.content.res.Resources;

/**
 * Created by zdd
 * on 2018/12/21
 * at 13:58
 * summary:
 */
public class ScreenUtils {
    public static int px(float dipValue) {
        Resources r = Resources.getSystem();
        final float scale = r.getDisplayMetrics().scaledDensity;
        return (int) (dipValue * scale + 0.5f);
    }
}
