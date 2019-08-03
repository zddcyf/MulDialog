package com.mul.dialog.constant;

/**
 * @ProjectName: MulFragmentDialog
 * @Package: com.mul.dialog.constant
 * @ClassName: DialogStyleEnum
 * @Author: zdd
 * @CreateDate: 2019/8/3 10:23
 * @Description: 弹框的风格样式
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/3 10:23
 * @UpdateRemark: 更新说明
 * @Version: 版本号
 */
public enum DialogStyleEnum {
    def(0), // 默认的样式
    list(1), // 列表式的样式
    recy(2), // recyclerview的多行列表样式
    first(3), // 弹框底部显示几个按钮。。此为一个
    second(4); // 弹框底部显示几个按钮。。此为两个

    private int code; // 编码标识
    DialogStyleEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
