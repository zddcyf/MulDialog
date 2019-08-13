package com.mul.diaolg.dialog.click;

import android.view.View;

/**
 * Created by Admin on 2017/8/31.
 * dialog中带recycleview的dialog的点击事件
 */

public interface DialogListTouchClick extends DialogListClick {
    /**
     * 点击屏幕外的点击事件
     *
     * @param view
     */
    void onTouchCancel(View view);
}
