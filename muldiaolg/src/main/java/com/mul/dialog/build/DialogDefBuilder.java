package com.mul.dialog.build;

import android.app.Activity;
import android.view.Gravity;

import com.mul.dialog.dialog.MulDialog;
import com.mul.dialog.click.def.IDialogDefClick;
import com.mul.dialog.muldiaolg.R;

/**
 * Created by 盈东科技
 * on 2018/11/24
 * at 17:38
 * summary:
 */
public class DialogDefBuilder extends DialogBuilder {
    private int centerLayBgImg = R.drawable.dialog_def_bg; // 针对内容布局背景用图片或者XML文件
    private float mLineWidth = 0.5f; // 线的宽度,像素值
    private int mLineColor = -1; // 线的颜色
    private boolean isSubmitLine = false; // 是否显示提示下方的线
    private boolean isContentLine = true; // 是否显示内容下方的线
    private boolean isCanAndConCenterLine = true; // 是否显示确认取消中间的线
    private String mSubmit; // 提示文字
    private int mSubmitLeftPadd = 0, mSubmitTopPadd = 0, mSubmitRightPadd = 0, mSubmitBottomPadd = 0; // 提示文字距离上下左右的距离
    private int mSubmitSize = -1; // 提示文字大小
    private int mSubmitColor = -1; // 提示文字颜色
    private String mContentStr; // 中间的文字
    private int mContentGravite = Gravity.CENTER; // 中间文字的显示位置
    private int mContentSize = -1; // 中间文字的大小
    private int mContentColor = -1; // 中间文字的颜色
    private int mContentLeftPadd = 0, mContentTopPadd = 30, mContentRightPadd = 0, mContentBottomPadd = 30; // 内容上下左右的距离
    private int btnNumber = 4; // 底部按钮显示几个
    private String mCancelStr; // 取消的文字，默认为取消
    private int mCancelSize = -1; // 取消文字的大小
    private int mCancelColor = -1; // 取消文字的颜色
    private String mConfirmStr; // 确认的显示文字默认为确认
    private int mConfirmSize = -1; // 确认文字的大小
    private int mConfirmColor = -1; // 确认文字的颜色
    private boolean isSubmitBold; // 是否对提示文字进行加粗处理
    private boolean isContentBold; // 是否对内容文字进行加粗处理
    private boolean isCanAndConBold; // 是否对确认取消文字进行加粗处理
    private IDialogDefClick iDialogDefClick;

    public DialogDefBuilder with(Activity mContext) {
        super.with(mContext);
        return this;
    }

    public DialogDefBuilder setLayoutId(int layoutId) {
        super.setLayoutId(layoutId);
        return this;
    }

    public DialogDefBuilder setBgColor(int bgColor) {
        super.setBgColor(bgColor);
        return this;
    }

    public DialogDefBuilder setCenterLayBg(int centerLayBg) {
        super.setCenterLayBg(centerLayBg);
        return this;
    }

    public DialogDefBuilder setDialogGrivate(int dialogGrivate) {
        super.setDialogGrivate(dialogGrivate);
        return this;
    }

    public DialogDefBuilder setDialogEnum(int dialogEnum) {
        super.setDialogEnum(dialogEnum);
        return this;
    }

    public DialogDefBuilder setCenterLeftMar(int mCenterLeftMar) {
        super.setCenterLeftMar(mCenterLeftMar);
        return this;
    }

    public DialogDefBuilder setCenterTopMar(int mCenterTopMar) {
        super.setCenterTopMar(mCenterTopMar);
        return this;
    }

    public DialogDefBuilder setCenterRightMar(int mCenterRightMar) {
        super.setCenterRightMar(mCenterRightMar);
        return this;
    }

    public DialogDefBuilder setCenterBottomMar(int mCenterBottomMar) {
        super.setCenterBottomMar(mCenterBottomMar);
        return this;
    }

    public DialogDefBuilder setCenterMargin(int mCenterLeftMar, int centerRightMar) {
        super.setCenterMargin(mCenterLeftMar, centerRightMar);
        return this;
    }

    public DialogDefBuilder setCenterMargin(int mCenterLeftMar, int centerTopMar, int centerRightMar, int centerBottomMar) {
        super.setCenterMargin(mCenterLeftMar, centerTopMar, centerRightMar, centerBottomMar);
        return this;
    }

    public DialogDefBuilder setSubmitPadd(int mSubmitTopPadd, int mSubmitBottomPadd) {
        this.mSubmitTopPadd = mSubmitTopPadd;
        this.mSubmitBottomPadd = mSubmitBottomPadd;
        return this;
    }

    public DialogDefBuilder setSubmitPadd(int mSubmitLeftPadd, int mSubmitTopPadd, int mSubmitRightPadd, int mSubmitBottomPadd) {
        this.mSubmitLeftPadd = mSubmitLeftPadd;
        this.mSubmitTopPadd = mSubmitTopPadd;
        this.mSubmitRightPadd = mSubmitRightPadd;
        this.mSubmitBottomPadd = mSubmitBottomPadd;
        return this;
    }

    public DialogDefBuilder setSubmit(String mSubmit, int mSubmitSize, int mSubmitColor) {
        this.mSubmit = mSubmit;
        this.mSubmitSize = mSubmitSize;
        this.mSubmitColor = mSubmitColor;
        return this;
    }

    public DialogDefBuilder setSubmit(String mSubmit, int mSubmitSize, int mSubmitColor, boolean isSubmitBold) {
        this.mSubmit = mSubmit;
        this.mSubmitSize = mSubmitSize;
        this.mSubmitColor = mSubmitColor;
        this.isSubmitBold = isSubmitBold;
        return this;
    }

    public DialogDefBuilder setContentPadd(int contentTopPadd, int contentBottomPadd) {
        this.mContentTopPadd = contentTopPadd;
        this.mContentBottomPadd = contentBottomPadd;
        return this;
    }

    public DialogDefBuilder setContentPadd(int mContentLeftPadd, int contentTopPadd, int contentRightPadd, int contentBottomPadd) {
        this.mContentLeftPadd = mContentLeftPadd;
        this.mContentTopPadd = contentTopPadd;
        this.mContentRightPadd = contentRightPadd;
        this.mContentBottomPadd = contentBottomPadd;
        return this;
    }

    public DialogDefBuilder setContent(String mContentStr, int mContentSize, int mContentColor) {
        this.mContentStr = mContentStr;
        this.mContentSize = mContentSize;
        this.mContentColor = mContentColor;
        return this;
    }

    public DialogDefBuilder setContent(String mContentStr, int mContentSize, int mContentColor, boolean isContentBold) {
        this.mContentStr = mContentStr;
        this.mContentSize = mContentSize;
        this.mContentColor = mContentColor;
        this.isContentBold = isContentBold;
        return this;
    }

    public DialogDefBuilder setCancel(String mCancelStr, int mCancelSize, int mCancelColor) {
        this.mCancelStr = mCancelStr;
        this.mCancelSize = mCancelSize;
        this.mCancelColor = mCancelColor;
        return this;
    }

    public DialogDefBuilder setConfirm(String mConfirmStr, int mConfirmSize, int mConfirmColor) {
        this.mConfirmStr = mConfirmStr;
        this.mConfirmSize = mConfirmSize;
        this.mConfirmColor = mConfirmColor;
        return this;
    }

    public DialogDefBuilder setCanAndCon(String mCancelStr, String mContentStr, int mCanAndConSize, int mCanAndConColor) {
        this.mCancelStr = mCancelStr;
        this.mContentStr = mContentStr;
        this.mCancelSize = mCanAndConSize;
        this.mConfirmSize = mCanAndConSize;
        this.mCancelColor = mCanAndConColor;
        this.mConfirmColor = mCanAndConColor;
        return this;
    }

    public DialogDefBuilder setCanAndCon(String mCancelStr, String mContentStr, int mCanAndConSize, int mCanAndConColor, boolean isCanAndConBold) {
        this.mCancelStr = mCancelStr;
        this.mContentStr = mContentStr;
        this.mCancelSize = mCanAndConSize;
        this.mConfirmSize = mCanAndConSize;
        this.mCancelColor = mCanAndConColor;
        this.mConfirmColor = mCanAndConColor;
        this.isCanAndConBold = isCanAndConBold;
        return this;
    }

    public DialogDefBuilder setCenterLayBgImg(int centerLayBgImg) {
        this.centerLayBgImg = centerLayBgImg;
        return this;
    }

    public DialogDefBuilder setLineWidth(int mLineWidth) {
        this.mLineWidth = mLineWidth;
        return this;
    }

    public DialogDefBuilder setLineWidth(float mLineWidthF) {
        this.mLineWidth = mLineWidthF;
        return this;
    }

    public DialogDefBuilder setLineColor(int mLineColor) {
        this.mLineColor = mLineColor;
        return this;
    }

    public DialogDefBuilder setSubmitLine(boolean submitLine) {
        this.isSubmitLine = submitLine;
        return this;
    }

    public DialogDefBuilder setContentLine(boolean contentLine) {
        this.isContentLine = contentLine;
        return this;
    }

    public DialogDefBuilder setCanAndConCenterLine(boolean canAndConCenterLine) {
        this.isCanAndConCenterLine = canAndConCenterLine;
        return this;
    }

    public DialogDefBuilder setSubmit(String mSubmit) {
        this.mSubmit = mSubmit;
        return this;
    }

    public DialogDefBuilder setSubmitSize(int mSubmitSize) {
        this.mSubmitSize = mSubmitSize;
        return this;
    }

    public DialogDefBuilder setSubmitColor(int mSubmitColor) {
        this.mSubmitColor = mSubmitColor;
        return this;
    }

    public DialogDefBuilder setContent(String mContentStr) {
        this.mContentStr = mContentStr;
        return this;
    }

    public DialogDefBuilder setContentGravite(int mContentGravite) {
        this.mContentGravite = mContentGravite;
        return this;
    }

    public DialogDefBuilder setContentSize(int mContentSize) {
        this.mContentSize = mContentSize;
        return this;
    }

    public DialogDefBuilder setContentColor(int mContentColor) {
        this.mContentColor = mContentColor;
        return this;
    }

    public DialogDefBuilder setBtnNumber(int btnNumber) {
        this.btnNumber = btnNumber;
        return this;
    }

    public DialogDefBuilder setCancel(String mCancelStr) {
        this.mCancelStr = mCancelStr;
        return this;
    }

    public DialogDefBuilder setCancelSize(int mCancelSize) {
        this.mCancelSize = mCancelSize;
        return this;
    }

    public DialogDefBuilder setCancelColor(int mCancelColor) {
        this.mCancelColor = mCancelColor;
        return this;
    }

    public DialogDefBuilder setConfirm(String mConfirmStr) {
        this.mConfirmStr = mConfirmStr;
        return this;
    }

    public DialogDefBuilder setConfirmSize(int mConfirmSize) {
        this.mConfirmSize = mConfirmSize;
        return this;
    }

    public DialogDefBuilder setConfirmColor(int mConfirmColor) {
        this.mConfirmColor = mConfirmColor;
        return this;
    }

    public DialogDefBuilder setmContentLeftPadd(int mContentLeftPadd) {
        this.mContentLeftPadd = mContentLeftPadd;
        return this;
    }

    public DialogDefBuilder setmContentTopPadd(int mContentTopPadd) {
        this.mContentTopPadd = mContentTopPadd;
        return this;
    }

    public DialogDefBuilder setmContentRightPadd(int mContentRightPadd) {
        this.mContentRightPadd = mContentRightPadd;
        return this;
    }

    public DialogDefBuilder setmContentBottomPadd(int mContentBottomPadd) {
        this.mContentBottomPadd = mContentBottomPadd;
        return this;
    }

    public DialogDefBuilder setDefLine(int mLineWidth, int mLineColor) {
        this.mLineWidth = mLineWidth;
        this.mLineColor = mLineColor;
        return this;
    }

    public DialogDefBuilder setDefLine(float mLineWidth, int mLineColor) {
        this.mLineWidth = mLineWidth;
        this.mLineColor = mLineColor;
        return this;
    }

    public DialogDefBuilder setSubmitBold(boolean isSubmitBold) {
        this.isSubmitBold = isSubmitBold;
        return this;
    }

    public DialogDefBuilder setContentBold(boolean isContentBold) {
        this.isContentBold = isContentBold;
        return this;
    }

    public DialogDefBuilder setCanAndConBold(boolean isCanAndConBold) {
        this.isCanAndConBold = isCanAndConBold;
        return this;
    }

    public DialogDefBuilder setSubmitLeftPadd(int mSubmitLeftPadd) {
        this.mSubmitLeftPadd = mSubmitLeftPadd;
        return this;
    }

    public DialogDefBuilder setSubmitTopPadd(int mSubmitTopPadd) {
        this.mSubmitTopPadd = mSubmitTopPadd;
        return this;
    }

    public DialogDefBuilder setSubmitRightPadd(int mSubmitRightPadd) {
        this.mSubmitRightPadd = mSubmitRightPadd;
        return this;
    }

    public DialogDefBuilder setSubmitBottomPadd(int mSubmitBottomPadd) {
        this.mSubmitBottomPadd = mSubmitBottomPadd;
        return this;
    }

    public DialogDefBuilder setClick(IDialogDefClick iDialogDefClick) {
        this.iDialogDefClick = iDialogDefClick;
        return this;
    }

    public int getCenterLayBgImg() {
        return centerLayBgImg;
    }

    public float getmLineWidth() {
        return mLineWidth;
    }

    public void setmLineWidth(float mLineWidth) {
        this.mLineWidth = mLineWidth;
    }

    public int getmLineColor() {
        return mLineColor;
    }

    public void setmLineColor(int mLineColor) {
        this.mLineColor = mLineColor;
    }

    public boolean isSubmitLine() {
        return isSubmitLine;
    }

    public boolean isContentLine() {
        return isContentLine;
    }

    public boolean isCanAndConCenterLine() {
        return isCanAndConCenterLine;
    }

    public String getmSubmit() {
        return mSubmit;
    }

    public void setmSubmit(String mSubmit) {
        this.mSubmit = mSubmit;
    }

    public int getmSubmitLeftPadd() {
        return mSubmitLeftPadd;
    }

    public void setmSubmitLeftPadd(int mSubmitLeftPadd) {
        this.mSubmitLeftPadd = mSubmitLeftPadd;
    }

    public int getmSubmitTopPadd() {
        return mSubmitTopPadd;
    }

    public void setmSubmitTopPadd(int mSubmitTopPadd) {
        this.mSubmitTopPadd = mSubmitTopPadd;
    }

    public int getmSubmitRightPadd() {
        return mSubmitRightPadd;
    }

    public void setmSubmitRightPadd(int mSubmitRightPadd) {
        this.mSubmitRightPadd = mSubmitRightPadd;
    }

    public int getmSubmitBottomPadd() {
        return mSubmitBottomPadd;
    }

    public void setmSubmitBottomPadd(int mSubmitBottomPadd) {
        this.mSubmitBottomPadd = mSubmitBottomPadd;
    }

    public int getmSubmitSize() {
        return mSubmitSize;
    }

    public void setmSubmitSize(int mSubmitSize) {
        this.mSubmitSize = mSubmitSize;
    }

    public int getmSubmitColor() {
        return mSubmitColor;
    }

    public void setmSubmitColor(int mSubmitColor) {
        this.mSubmitColor = mSubmitColor;
    }

    public String getmContentStr() {
        return mContentStr;
    }

    public void setmContentStr(String mContentStr) {
        this.mContentStr = mContentStr;
    }

    public int getmContentGravite() {
        return mContentGravite;
    }

    public void setmContentGravite(int mContentGravite) {
        this.mContentGravite = mContentGravite;
    }

    public int getmContentSize() {
        return mContentSize;
    }

    public void setmContentSize(int mContentSize) {
        this.mContentSize = mContentSize;
    }

    public int getmContentColor() {
        return mContentColor;
    }

    public void setmContentColor(int mContentColor) {
        this.mContentColor = mContentColor;
    }

    public int getmContentLeftPadd() {
        return mContentLeftPadd;
    }

    public int getmContentTopPadd() {
        return mContentTopPadd;
    }

    public int getmContentRightPadd() {
        return mContentRightPadd;
    }

    public int getmContentBottomPadd() {
        return mContentBottomPadd;
    }

    public int getBtnNumber() {
        return btnNumber;
    }

    public String getmCancelStr() {
        return mCancelStr;
    }

    public void setmCancelStr(String mCancelStr) {
        this.mCancelStr = mCancelStr;
    }

    public int getmCancelSize() {
        return mCancelSize;
    }

    public void setmCancelSize(int mCancelSize) {
        this.mCancelSize = mCancelSize;
    }

    public int getmCancelColor() {
        return mCancelColor;
    }

    public void setmCancelColor(int mCancelColor) {
        this.mCancelColor = mCancelColor;
    }

    public String getmConfirmStr() {
        return mConfirmStr;
    }

    public void setmConfirmStr(String mConfirmStr) {
        this.mConfirmStr = mConfirmStr;
    }

    public int getmConfirmSize() {
        return mConfirmSize;
    }

    public void setmConfirmSize(int mConfirmSize) {
        this.mConfirmSize = mConfirmSize;
    }

    public int getmConfirmColor() {
        return mConfirmColor;
    }

    public void setmConfirmColor(int mConfirmColor) {
        this.mConfirmColor = mConfirmColor;
    }

    public boolean isSubmitBold() {
        return isSubmitBold;
    }

    public boolean isContentBold() {
        return isContentBold;
    }

    public boolean isCanAndConBold() {
        return isCanAndConBold;
    }

    public IDialogDefClick getiDialogDefClick() {
        return iDialogDefClick;
    }

    public void setiDialogDefClick(IDialogDefClick iDialogDefClick) {
        this.iDialogDefClick = iDialogDefClick;
    }

    public MulDialog create() {
        MulDialog cmDialog = new MulDialog();
        cmDialog.setBuilder(this);
        cmDialog.show(getContext().getFragmentManager(), "弹框");
        return cmDialog;
    }
}
