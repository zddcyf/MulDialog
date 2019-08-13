package com.mul.diaolg.dialog.click;

import android.view.View;

/**
 * Created by Admin on 2017/9/21.
 */

public interface DialogConAndCanOnClick extends DialogOnClick {
    /**
     * 取消的点击事件
     *
     * @param view
     */
    void onClickCancel(View view);
}
