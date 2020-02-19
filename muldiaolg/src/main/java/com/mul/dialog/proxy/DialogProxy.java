package com.mul.dialog.proxy;

import com.mul.dialog.build.DialogBuilder;
import com.mul.dialog.dialog.MulFragmentDialog;

/**
 * @ProjectName: MulDialog
 * @Package: com.mul.dialog.proxy
 * @ClassName: DialogProxy
 * @Author: zdd
 * @CreateDate: 2020/1/17 13:53
 * @Description: java类作用描述
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/17 13:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0.0
 */
public class DialogProxy {
    private DialogBuilder dialogBuilder;
    private MulFragmentDialog dialogFragment;

    private DialogProxy() {

    }

    public static DialogProxy obtain() {
        return DialogProxySingleton.DIALOG_PROXY;
    }

    private static class DialogProxySingleton {
        private static final DialogProxy DIALOG_PROXY = new DialogProxy();
    }

    public MulFragmentDialog getDialogFragment() {
        return dialogFragment;
    }

    public DialogBuilder builder() {
        if (null != dialogFragment) {
            dialogFragment.dismiss();
            dialogFragment = null;
        }
        dialogBuilder = new DialogBuilder();
        dialogFragment = new MulFragmentDialog();
        return dialogBuilder;
    }

    public void configCustView(MulFragmentDialog.ConfigView configView) {
        dialogFragment.configCustView(configView);
    }

    public void dismiss() {
        dialogFragment.dismiss();
    }
}
