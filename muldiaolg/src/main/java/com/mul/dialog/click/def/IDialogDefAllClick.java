package com.mul.dialog.click.def;

import android.view.View;

/**
 * Created by 盈东科技
 * on 2018/11/26
 * at 11:57
 * summary:
 */
public interface IDialogDefAllClick extends IDialogDefClick {
    /**
     * 取消按钮的点击事件
     *
     * @param v
     */
    void cancelClick(View v);

    /**
     * 空白的点击事件
     *
     * @param v
     */
    void touchClick(View v);
}
