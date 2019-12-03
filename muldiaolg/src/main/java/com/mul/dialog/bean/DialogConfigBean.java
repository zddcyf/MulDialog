package com.mul.dialog.bean;

import android.content.Context;
import android.view.Gravity;

import com.mul.dialog.click.IDialogClick;
import com.mul.dialog.constant.DialogPositionEnum;
import com.mul.dialog.constant.DialogStyleEnum;
import com.mul.dialog.muldiaolg.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: MulDialog
 * @Package: com.mul.dialog.bean
 * @ClassName: DialogConfigBean
 * @Author: zdd
 * @CreateDate: 2019/8/7 12:45
 * @Description: 弹框的配置信息
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/7 12:45
 * @UpdateRemark: 更新说明
 * @Version: v1.0.0
 */
public class DialogConfigBean {
    private Context mContext; // 必填
    /**
     * 整体部分的配置
     */
    private int mLayoutId = -1; // 自定义的布局id
    private int mBgColor = -1; // 针对整体布局颜色
    private int mCenterLayoutBg = R.drawable.dialog_def_bg; // 针对内容布局背景用图片或者XML文件
    private int mDialogPositionEnum = DialogPositionEnum.center.getCode(); // 弹框位置
    private int mDialogStyleEnum = DialogStyleEnum.def.getCode(); // 设置弹出框的样式
    private int mCenterLeftMar, mCenterTopMar, mCenterRightMar, mCenterBottomMar;

    /**
     * 设置线的显示与隐藏以及配置信息
     */
    private float mLineWidth = 0.5f; // 线的宽度,像素值
    private int mLineColor = -1; // 线的颜色
    private boolean submitLine = false; // 是否显示提示下方的线(默认弹框是使用)
    private boolean sontentLine = true; // 是否显示内容下方的线(默认弹框是使用)
    private boolean canAndConCenterLine = true; // 是否显示确认取消中间的线(默认弹框是使用)
    private boolean line = true; // 是否显示线(列表弹框是使用)
    /**
     * 提示文字的配置信息
     */
    private String mSubmit; // 提示文字
    private int mSubmitLeftPadd = 0, mSubmitTopPadd = 0, mSubmitRightPadd = 0, mSubmitBottomPadd = 0; // 提示文字距离上下左右的距离
    private int mSubmitSize = -1; // 提示文字大小
    private int mSubmitColor = -1; // 提示文字颜色
    /**
     * 中间文字的配置信息
     */
    private String mContentStr; // 中间的文字
    private int mContentGravite = Gravity.CENTER; // 中间文字的显示位置
    private int mContentSize = -1; // 中间文字的大小
    private int mContentColor = -1; // 中间文字的颜色
    private int mContentLeftPadd = 0, mContentTopPadd = 30, mContentRightPadd = 0, mContentBottomPadd = 30; // 内容上下左右的距离
    /**
     * 底部按钮的配置信息
     */
    private int btnNumber = DialogStyleEnum.second.getCode(); // 底部按钮显示几个
    private String mCancelStr; // 取消的文字，默认为取消
    private int mCancelSize = -1; // 取消文字的大小
    private int mCancelColor = -1; // 取消文字的颜色
    private int mCancelBg = -1; // 取消按钮的背景色（列表时使用）
    private int mCancelPaddTop = 8; // 取消按钮距离顶部的距离（列表时使用）
    private int mCancelPaddBottom = 10; // 取消按钮距离底部的距离（列表时使用）
    private boolean mCancelBold = false; // 取消按钮是否加粗（列表时使用）

    private String mConfirmStr; // 确认的显示文字默认为确认
    private int mConfirmSize = -1; // 确认文字的大小
    private int mConfirmColor = -1; // 确认文字的颜色
    private boolean submitBold; // 是否对提示文字进行加粗处理
    private boolean contentBold; // 是否对内容文字进行加粗处理
    private boolean canAndConBold; // 是否对确认取消文字进行加粗处理
    private IDialogClick iDialogClick;

    /**
     * 设置列表弹框的数据源
     */
    private List<DialogListBean> datas = new ArrayList<>();
    /**
     * 设置列数 默认一列
     */
    private int columns = 1; // 有多少列
    /**
     * 设置列表的时候列表的背景设置
     */
    private int topViewGroupBg = -1;
    private int topViewGroupBgStart = -1;
    private int topViewGroupBgCenter = -1;
    private int topViewGroupBgEnd = -1;

    private boolean bottomCanCel = true; // 是否有底部取消按钮

    private int recyclerViewBg = -1; // 列表的整体背景

    /**
     * 设置item的高
     */
    private boolean setHeight; // 是否设置item的高
    private int height; // item的高度
    private int cancelHeight; // item的高度

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }

    public int getLayoutId() {
        return mLayoutId;
    }

    public void setLayoutId(int mLayoutId) {
        this.mLayoutId = mLayoutId;
    }

    public int getBgColor() {
        return mBgColor;
    }

    public void setBgColor(int mBgColor) {
        this.mBgColor = mBgColor;
    }

    public int getCenterLayoutBg() {
        return mCenterLayoutBg;
    }

    public void setCenterLayoutBg(int mCenterLayoutBg) {
        this.mCenterLayoutBg = mCenterLayoutBg;
    }

    public int getDialogPositionEnum() {
        return mDialogPositionEnum;
    }

    public void setDialogPositionEnum(int mDialogPositionEnum) {
        this.mDialogPositionEnum = mDialogPositionEnum;
    }

    public int getDialogStyleEnum() {
        return mDialogStyleEnum;
    }

    public void setDialogStyleEnum(int mDialogStyleEnum) {
        this.mDialogStyleEnum = mDialogStyleEnum;
    }

    public int getCenterLeftMar() {
        return mCenterLeftMar;
    }

    public void setCenterLeftMar(int mCenterLeftMar) {
        this.mCenterLeftMar = mCenterLeftMar;
    }

    public int getCenterTopMar() {
        return mCenterTopMar;
    }

    public void setCenterTopMar(int mCenterTopMar) {
        this.mCenterTopMar = mCenterTopMar;
    }

    public int getCenterRightMar() {
        return mCenterRightMar;
    }

    public void setCenterRightMar(int mCenterRightMar) {
        this.mCenterRightMar = mCenterRightMar;
    }

    public int getCenterBottomMar() {
        return mCenterBottomMar;
    }

    public void setCenterBottomMar(int mCenterBottomMar) {
        this.mCenterBottomMar = mCenterBottomMar;
    }

    public float getLineWidth() {
        return mLineWidth;
    }

    public int getLineColor() {
        return mLineColor;
    }

    public void setLineColor(int mLineColor) {
        this.mLineColor = mLineColor;
    }

    public boolean isSubmitLine() {
        return submitLine;
    }

    public void setSubmitLine(boolean submitLine) {
        this.submitLine = submitLine;
    }

    public boolean isSontentLine() {
        return sontentLine;
    }

    public void setSontentLine(boolean sontentLine) {
        this.sontentLine = sontentLine;
    }

    public boolean isCanAndConCenterLine() {
        return canAndConCenterLine;
    }

    public void setCanAndConCenterLine(boolean canAndConCenterLine) {
        this.canAndConCenterLine = canAndConCenterLine;
    }

    public String getmSubmit() {
        return mSubmit;
    }

    public void setSubmit(String mSubmit) {
        this.mSubmit = mSubmit;
    }

    public int getSubmitLeftPadd() {
        return mSubmitLeftPadd;
    }

    public void setSubmitLeftPadd(int mSubmitLeftPadd) {
        this.mSubmitLeftPadd = mSubmitLeftPadd;
    }

    public int getSubmitTopPadd() {
        return mSubmitTopPadd;
    }

    public void setSubmitTopPadd(int mSubmitTopPadd) {
        this.mSubmitTopPadd = mSubmitTopPadd;
    }

    public int getmSubmitRightPadd() {
        return mSubmitRightPadd;
    }

    public void setSubmitRightPadd(int mSubmitRightPadd) {
        this.mSubmitRightPadd = mSubmitRightPadd;
    }

    public int getSubmitBottomPadd() {
        return mSubmitBottomPadd;
    }

    public void setSubmitBottomPadd(int mSubmitBottomPadd) {
        this.mSubmitBottomPadd = mSubmitBottomPadd;
    }

    public int getSubmitSize() {
        return mSubmitSize;
    }

    public void setSubmitSize(int mSubmitSize) {
        this.mSubmitSize = mSubmitSize;
    }

    public int getSubmitColor() {
        return mSubmitColor;
    }

    public void setSubmitColor(int mSubmitColor) {
        this.mSubmitColor = mSubmitColor;
    }

    public String getContentStr() {
        return mContentStr;
    }

    public void setContentStr(String mContentStr) {
        this.mContentStr = mContentStr;
    }

    public int getContentGravite() {
        return mContentGravite;
    }

    public void setContentGravite(int mContentGravite) {
        this.mContentGravite = mContentGravite;
    }

    public int getContentSize() {
        return mContentSize;
    }

    public void setContentSize(int mContentSize) {
        this.mContentSize = mContentSize;
    }

    public int getContentColor() {
        return mContentColor;
    }

    public void setContentColor(int mContentColor) {
        this.mContentColor = mContentColor;
    }

    public int getContentLeftPadd() {
        return mContentLeftPadd;
    }

    public void setContentLeftPadd(int mContentLeftPadd) {
        this.mContentLeftPadd = mContentLeftPadd;
    }

    public int getContentTopPadd() {
        return mContentTopPadd;
    }

    public void setContentTopPadd(int mContentTopPadd) {
        this.mContentTopPadd = mContentTopPadd;
    }

    public int getContentRightPadd() {
        return mContentRightPadd;
    }

    public void setContentRightPadd(int mContentRightPadd) {
        this.mContentRightPadd = mContentRightPadd;
    }

    public int getContentBottomPadd() {
        return mContentBottomPadd;
    }

    public void setContentBottomPadd(int mContentBottomPadd) {
        this.mContentBottomPadd = mContentBottomPadd;
    }

    public int getBtnNumber() {
        return btnNumber;
    }

    public void setBtnNumber(int btnNumber) {
        this.btnNumber = btnNumber;
    }

    public int getCancelSize() {
        return mCancelSize;
    }

    public void setCancelSize(int mCancelSize) {
        this.mCancelSize = mCancelSize;
    }

    public int getCancelColor() {
        return mCancelColor;
    }

    public void setCancelColor(int mCancelColor) {
        this.mCancelColor = mCancelColor;
    }

    public String getConfirmStr() {
        return mConfirmStr;
    }

    public void setConfirmStr(String mConfirmStr) {
        this.mConfirmStr = mConfirmStr;
    }

    public int getConfirmSize() {
        return mConfirmSize;
    }

    public void setConfirmSize(int mConfirmSize) {
        this.mConfirmSize = mConfirmSize;
    }

    public int getConfirmColor() {
        return mConfirmColor;
    }

    public void setConfirmColor(int mConfirmColor) {
        this.mConfirmColor = mConfirmColor;
    }

    public boolean isSubmitBold() {
        return submitBold;
    }

    public void setSubmitBold(boolean submitBold) {
        this.submitBold = submitBold;
    }

    public boolean isContentBold() {
        return contentBold;
    }

    public void setContentBold(boolean contentBold) {
        this.contentBold = contentBold;
    }

    public boolean isCanAndConBold() {
        return canAndConBold;
    }

    public void setCanAndConBold(boolean canAndConBold) {
        this.canAndConBold = canAndConBold;
    }

    public IDialogClick getiDialogClick() {
        return iDialogClick;
    }

    public void setiDialogClick(IDialogClick iDialogClick) {
        this.iDialogClick = iDialogClick;
    }

    public List<DialogListBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DialogListBean> datas) {
        this.datas = datas;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getTopViewGroupBg() {
        return topViewGroupBg;
    }

    public void setTopViewGroupBg(int topViewGroupBg) {
        this.topViewGroupBg = topViewGroupBg;
    }

    public int getTopViewGroupBgStart() {
        return topViewGroupBgStart;
    }

    public void setTopViewGroupBgStart(int topViewGroupBgStart) {
        this.topViewGroupBgStart = topViewGroupBgStart;
    }

    public int getTopViewGroupBgCenter() {
        return topViewGroupBgCenter;
    }

    public void setTopViewGroupBgCenter(int topViewGroupBgCenter) {
        this.topViewGroupBgCenter = topViewGroupBgCenter;
    }

    public int getTopViewGroupBgEnd() {
        return topViewGroupBgEnd;
    }

    public void setTopViewGroupBgEnd(int topViewGroupBgEnd) {
        this.topViewGroupBgEnd = topViewGroupBgEnd;
    }

    public boolean isBottomCanCel() {
        return bottomCanCel;
    }

    public void setBottomCanCel(boolean bottomCanCel) {
        this.bottomCanCel = bottomCanCel;
    }

    public int getRecyclerViewBg() {
        return recyclerViewBg;
    }

    public void setRecyclerViewBg(int recyclerViewBg) {
        this.recyclerViewBg = recyclerViewBg;
    }

    public int getCancelBg() {
        return mCancelBg;
    }

    public void setCancelBg(int mCancelBg) {
        this.mCancelBg = mCancelBg;
    }

    public void setLineWidth(float mLineWidth) {
        this.mLineWidth = mLineWidth;
    }

    public int getCancelPaddTop() {
        return mCancelPaddTop;
    }

    public void setCancelPaddTop(int mCancelPaddTop) {
        this.mCancelPaddTop = mCancelPaddTop;
    }

    public int getCancelPaddBottom() {
        return mCancelPaddBottom;
    }

    public void setCancelPaddBottom(int mCancelPaddBottom) {
        this.mCancelPaddBottom = mCancelPaddBottom;
    }

    public String getCancelStr() {
        return mCancelStr;
    }

    public void setCancelStr(String mCancelStr) {
        this.mCancelStr = mCancelStr;
    }

    public boolean isCancelBold() {
        return mCancelBold;
    }

    public void setCancelBold(boolean mCancelBold) {
        this.mCancelBold = mCancelBold;
    }

    public boolean isSetHeight() {
        return setHeight;
    }

    public void setSetHeight(boolean setHeight) {
        this.setHeight = setHeight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCancelHeight() {
        return cancelHeight;
    }

    public void setCancelHeight(int cancelHeight) {
        this.cancelHeight = cancelHeight;
    }

    public boolean isLine() {
        return line;
    }

    public void setLine(boolean line) {
        this.line = line;
    }
}
