package com.mul.dialog.dialog;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.mul.dialog.build.DialogBuilder;

/**
 * @ProjectName: MulDialog
 * @Package: com.mul.dialog.dialog
 * @ClassName: DialogFactory
 * @Author: zdd
 * @CreateDate: 2019/8/6 9:04
 * @Description: 类的作用描述
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/6 9:04
 * @UpdateRemark: 更新说明
 * @Version: v1.0.0
 */
public class DialogFactory {
    public static MulDialog createDialog(DialogBuilder dialogBuilder) {
        MulDialog mulDialog = null;
        if (dialogBuilder.getContext() instanceof Application) {

        } else {
            mulDialog = new MulFragmentDialog();
            mulDialog.setBuilder(dialogBuilder);
            ((MulFragmentDialog) mulDialog).show(((Activity) dialogBuilder.getContext()).getFragmentManager(), "弹框");
        }
        return mulDialog;
    }
}
