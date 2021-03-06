package com.mul.dialog;

import android.content.res.Resources;

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
public class ScreenUtils {
    public static int px(float dipValue) {
        Resources r = Resources.getSystem();
        final float scale = r.getDisplayMetrics().scaledDensity;
        return (int) (dipValue * scale + 0.5f);
    }
}
