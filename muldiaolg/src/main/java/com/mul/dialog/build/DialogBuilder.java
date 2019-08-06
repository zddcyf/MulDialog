package com.mul.dialog.build;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.mul.dialog.constant.DialogPositionEnum;
import com.mul.dialog.constant.DialogStyleEnum;
import com.mul.dialog.dialog.DialogFactory;
import com.mul.dialog.dialog.MulDialog;

/**
 * Created by zdd
 * on 2018/12/5
 * at 14:38
 * summary:
 */
public class DialogBuilder {
    private Context mContext; // 必填
    private int layoutId = -1; // 自定义的布局id
    private int bgColor = -1; // 针对整体布局颜色
    private int centerLayBg = -1; // 针对内容布局背景用图片或者XML文件
    private int dialogPositionEnum = DialogPositionEnum.center.getCode(); // 弹框位置
    private int dialogStyleEnum = DialogStyleEnum.def.getCode(); // 设置弹出框的样式
    private int mCenterLeftMar, mCenterTopMar, mCenterRightMar, mCenterBottomMar;

    public Context getContext() {
        return mContext;
    }

    public DialogBuilder with(Activity mContext) {
        this.mContext = mContext;
        return this;
    }

    public DialogBuilder with(AppCompatActivity mContext) {
        this.mContext = mContext;
        return this;
    }

    public DialogBuilder with(Fragment mContext) {
        this.mContext = mContext.getActivity();
        return this;
    }

    public DialogBuilder with(android.support.v4.app.Fragment mContext) {
        this.mContext = mContext.getActivity();
        return this;
    }

    public DialogBuilder with(Application mContext) {
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

    public int getDialogPositionEnum() {
        return dialogPositionEnum;
    }

    public DialogBuilder setDialogPositionEnum(int dialogPositionEnum) {
        this.dialogPositionEnum = dialogPositionEnum;
        return this;
    }

    public int getDialogStyleEnum() {
        return dialogStyleEnum;
    }

    public DialogBuilder setDialogStyleEnum(int dialogStyleEnum) {
        this.dialogStyleEnum = dialogStyleEnum;
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

    public MulDialog create() {
        return DialogFactory.createDialog(this);
    }
}
