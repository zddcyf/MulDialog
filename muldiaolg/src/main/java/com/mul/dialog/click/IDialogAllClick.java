package com.mul.dialog.click;

import android.view.View;

/**
 * @ProjectName: MulDialog
 * @Package: com.mul.dialog.click
 * @ClassName: IDialogTouchClick
 * @Author: zdd
 * @CreateDate: 2019/12/3 20:59
 * @Description: java类作用描述
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/12/3 20:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0.0
 */
public interface IDialogAllClick extends IDialogClick {
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
