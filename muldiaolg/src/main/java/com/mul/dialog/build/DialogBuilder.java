package com.mul.dialog.build;

import android.app.Activity;

import com.mul.dialog.DialogEnum;

/**
 * Created by zdd
 * on 2018/12/5
 * at 14:38
 * summary:
 */
public class DialogBuilder {
    private Activity mContext; // 必填
    private int layoutId = -1; // 自定义的布局id
    private int bgColor = -1; // 针对整体布局颜色
    private int centerLayBg = -1; // 针对内容布局背景用图片或者XML文件
    private int dialogGrivate = DialogEnum.center.getCode(); // 弹框位置
    private int dialogEnum; // 设置弹出框的样式
    private int mCenterLeftMar, mCenterTopMar, mCenterRightMar, mCenterBottomMar;

    public Activity getContext() {
        return mContext;
    }

    public DialogBuilder with(Activity mContext) {
        this.mContext = mContext;
        return this;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public DialogBuilder setLayoutId(int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    public int getBgColor() {
        return bgColor;
    }

    public DialogBuilder setBgColor(int bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public int getCenterLayBg() {
        return centerLayBg;
    }

    public DialogBuilder setCenterLayBg(int centerLayBg) {
        this.centerLayBg = centerLayBg;
        return this;
    }

    public int getDialogGrivate() {
        return dialogGrivate;
    }

    public DialogBuilder setDialogGrivate(int dialogGrivate) {
        this.dialogGrivate = dialogGrivate;
        return this;
    }

    public int getDialogEnum() {
        return dialogEnum;
    }

    public DialogBuilder setDialogEnum(int dialogEnum) {
        this.dialogEnum = dialogEnum;
        return this;
    }

    public DialogBuilder setCenterLeftMar(int mCenterLeftMar) {
        this.mCenterLeftMar = mCenterLeftMar;
        return this;
    }

    public DialogBuilder setCenterTopMar(int mCenterTopMar) {
        this.mCenterTopMar = mCenterTopMar;
        return this;
    }

    public DialogBuilder setCenterRightMar(int mCenterRightMar) {
        this.mCenterRightMar = mCenterRightMar;
        return this;
    }

    public DialogBuilder setCenterBottomMar(int mCenterBottomMar) {
        this.mCenterBottomMar = mCenterBottomMar;
        return this;
    }

    public DialogBuilder setCenterMargin(int mCenterLeftMar, int centerRightMar) {
        this.mCenterLeftMar = mCenterLeftMar;
        this.mCenterRightMar = centerRightMar;
        return this;
    }

    public DialogBuilder setCenterMargin(int mCenterLeftMar, int centerTopMar, int centerRightMar, int centerBottomMar) {
        this.mCenterLeftMar = mCenterLeftMar;
        this.mCenterTopMar = centerTopMar;
        this.mCenterRightMar = centerRightMar;
        this.mCenterBottomMar = centerBottomMar;
        return this;
    }

    public int getCenterLeftMar() {
        return mCenterLeftMar;
    }

    public int getCenterTopMar() {
        return mCenterTopMar;
    }

    public int getCenterRightMar() {
        return mCenterRightMar;
    }

    public int getCenterBottomMar() {
        return mCenterBottomMar;
    }
}
