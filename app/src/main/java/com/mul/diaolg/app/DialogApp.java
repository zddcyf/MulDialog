package com.mul.diaolg.app;

import android.app.Application;

/**
 * @ProjectName: MulFragmentDialog
 * @Package: com.mul.diaolg.app
 * @ClassName: DialogApp
 * @Author: zdd
 * @CreateDate: 2019/8/3 10:15
 * @Description: 类的作用描述
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/3 10:15
 * @UpdateRemark: 更新说明
 * @Version: 版本号
 */
public class DialogApp extends Application {
    private static DialogApp dialogApp;

    public static DialogApp getInstance() {
        return dialogApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dialogApp = this;
    }
}
