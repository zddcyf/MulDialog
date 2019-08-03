package com.mul.dialog.dialog;

import com.mul.dialog.build.DialogBuilder;

/**
 * @ProjectName: MulDialog
 * @Package: com.mul.dialog.dialog
 * @ClassName: MulDialog
 * @Author: zdd
 * @CreateDate: 2019/8/3 10:38
 * @Description: 类的作用描述
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/3 10:38
 * @UpdateRemark: 更新说明
 * @Version: 版本号
 */
public interface MulDialog {
    MulDialog getInstance();
    void setBuilder(DialogBuilder dialogBuilder);
}
