package com.mul.dialog.constant;

/**
 * @ProjectName: MulDialog
 * @Package: com.mul.dialog.constant
 * @ClassName: DialogListTopEnum
 * @Author: zdd
 * @CreateDate: 2019/8/6 9:15
 * @Description: 类的作用描述
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/6 9:15
 * @UpdateRemark: 更新说明
 * @Version: v1.0.0
 */
public enum DialogListTopEnum {
    /**
     * list中的文字和图片的位置
     */
    left(0),
    top(1),
    center(2),
    right(3),
    bottom(4);

    private int code; // 编码标识
    DialogListTopEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
