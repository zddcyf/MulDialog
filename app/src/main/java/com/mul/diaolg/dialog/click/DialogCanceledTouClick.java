package com.mul.diaolg.dialog.click;

import android.content.DialogInterface;
import android.view.View;

/**
 * Created by Admin on 2017/9/21.
 */

public interface DialogCanceledTouClick extends DialogOnClick {
    /**
     * 取消的点击事件
     *
     * @param view
     */
    void onClickCancel(View view);

    /**
     * 点击屏幕外的点击事件
     *
     * @param view
     */
    void onTouchCancel(View view);

    /**
     * 点击屏幕外的点击事件
     *
     * @param dialogInterface
     */
    void onTouchCancel(DialogInterface dialogInterface);
}
