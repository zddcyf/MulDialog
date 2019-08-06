package com.mul.dialog.constant;

/**
 * @ProjectName: MulFragmentDialog
 * @Package: com.mul.dialog.constant
 * @ClassName: DialogPositionEnum
 * @Author: zdd
 * @CreateDate: 2019/8/3 10:26
 * @Description: 弹框所在位置
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/3 10:26
 * @UpdateRemark: 更新说明
 * @Version: 版本号
 */
public enum DialogPositionEnum {
    /**
     * 中间布局的位置
     */
    top(0), // 弹框展示布局在顶部
    center(1), // 弹框展示布局在中间
    bottom(2); // 弹框展示布局在底部

    private int code; // 编码标识
    DialogPositionEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
