package com.mul.dialog;

/**
 * Created by 盈东科技
 * on 2018/11/24
 * at 11:55
 * summary:
 */
public enum DialogEnum {
    def(0), // 默认的样式
    list(1), // 列表式的样式
    recy(2), // recyclerview的多行列表样式
    first(3), // 弹框底部显示几个按钮。。此为一个
    second(4), // 弹框底部显示几个按钮。。此为两个

    /**
     * 中间布局的位置
     */
    top(5), // 弹框展示布局在顶部
    center(6), // 弹框展示布局在中间
    bottom(7), // 弹框展示布局在底部

    /**
     * list中的文字和图片的位置
     */
    listLeft(8),
    listTop(9),
    listCenter(10),
    listRight(11),
    listBottom(12);

    private int code; // 编码标识
    DialogEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
