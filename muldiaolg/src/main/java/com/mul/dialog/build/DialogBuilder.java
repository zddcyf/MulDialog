package com.mul.dialog.build;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.mul.dialog.bean.DialogConfigBean;
import com.mul.dialog.bean.DialogListBean;
import com.mul.dialog.click.IDialogClick;
import com.mul.dialog.click.IDialogTouchClick;
import com.mul.dialog.proxy.DialogProxy;

import java.util.List;

/**
 * @ProjectName: MulDialog
 * @Package: com.mul.dialog.click
 * @ClassName: IDialogTouchClick
 * @Author: zdd
 * @CreateDate: 2019/12/3 20:59
 * @Description: 弹框的构建者
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/12/3 20:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0.0
 */
public class DialogBuilder {
    private DialogConfigBean dialogConfigBean;

    public DialogBuilder() {
        Log.i("初始化成功", ":::dialogConfigBean");
        dialogConfigBean = new DialogConfigBean();
    }

    public DialogBuilder with(AppCompatActivity mContext) {
        dialogConfigBean.setContext(mContext);
        return this;
    }

    public DialogBuilder with(Fragment mContext) {
        dialogConfigBean.setFragment(mContext);
        return this;
    }

    public DialogBuilder with(Application mContext) {
        dialogConfigBean.setContext(mContext);
        return this;
    }

    public DialogBuilder setLayoutId(int layoutId) {
        dialogConfigBean.setLayoutId(layoutId);
        return this;
    }

    public DialogBuilder setBgColor(int bgColor) {
        dialogConfigBean.setBgColor(bgColor);
        return this;
    }

    public DialogBuilder setCenterLayBg(int centerLayBg) {
        dialogConfigBean.setCenterLayoutBg(centerLayBg);
        return this;
    }

    public DialogBuilder setDialogPositionEnum(int dialogPositionEnum) {
        dialogConfigBean.setDialogPositionEnum(dialogPositionEnum);
        return this;
    }

    public DialogBuilder setDialogStyleEnum(int dialogStyleEnum) {
        dialogConfigBean.setDialogStyleEnum(dialogStyleEnum);
        return this;
    }

    public DialogBuilder setCenterLeftMar(int mCenterLeftMar) {
        dialogConfigBean.setCenterLeftMar(mCenterLeftMar);
        return this;
    }

    public DialogBuilder setCenterTopMar(int mCenterTopMar) {
        dialogConfigBean.setCenterTopMar(mCenterTopMar);
        return this;
    }

    public DialogBuilder setCenterRightMar(int mCenterRightMar) {
        dialogConfigBean.setCenterRightMar(mCenterRightMar);
        return this;
    }

    public DialogBuilder setCenterBottomMar(int mCenterBottomMar) {
        dialogConfigBean.setCenterBottomMar(mCenterBottomMar);
        return this;
    }

    public DialogBuilder setCenterMargin(int mCenterLeftMar, int mCenterRightMar) {
        dialogConfigBean.setCenterLeftMar(mCenterLeftMar);
        dialogConfigBean.setCenterRightMar(mCenterRightMar);
        return this;
    }

    public DialogBuilder setCenterMargin(int mCenterLeftMar, int mCenterTopMar, int mCenterRightMar, int mCenterBottomMar) {
        dialogConfigBean.setCenterLeftMar(mCenterLeftMar);
        dialogConfigBean.setCenterTopMar(mCenterTopMar);
        dialogConfigBean.setCenterRightMar(mCenterRightMar);
        dialogConfigBean.setCenterBottomMar(mCenterBottomMar);
        return this;
    }

    public DialogBuilder setSubmitPadd(int mSubmitTopPadd, int mSubmitBottomPadd) {
        dialogConfigBean.setSubmitTopPadd(mSubmitTopPadd);
        dialogConfigBean.setSubmitBottomPadd(mSubmitBottomPadd);
        return this;
    }

    public DialogBuilder setSubmitPadd(int mSubmitLeftPadd, int mSubmitTopPadd, int mSubmitRightPadd, int mSubmitBottomPadd) {
        dialogConfigBean.setSubmitLeftPadd(mSubmitLeftPadd);
        dialogConfigBean.setSubmitTopPadd(mSubmitTopPadd);
        dialogConfigBean.setSubmitRightPadd(mSubmitRightPadd);
        dialogConfigBean.setSubmitBottomPadd(mSubmitBottomPadd);
        return this;
    }

    public DialogBuilder setSubmit(String mSubmit, int mSubmitSize, int mSubmitColor) {
        dialogConfigBean.setSubmit(mSubmit);
        dialogConfigBean.setSubmitSize(mSubmitSize);
        dialogConfigBean.setSubmitColor(mSubmitColor);
        return this;
    }

    public DialogBuilder setSubmit(String mSubmit, int mSubmitSize, int mSubmitColor, boolean isSubmitBold) {
        dialogConfigBean.setSubmit(mSubmit);
        dialogConfigBean.setSubmitSize(mSubmitSize);
        dialogConfigBean.setSubmitColor(mSubmitColor);
        dialogConfigBean.setSubmitBold(isSubmitBold);
        return this;
    }

    public DialogBuilder setContentPadd(int mContentTopPadd, int mContentBottomPadd) {
        dialogConfigBean.setContentTopPadd(mContentTopPadd);
        dialogConfigBean.setContentBottomPadd(mContentBottomPadd);
        return this;
    }

    public DialogBuilder setContentPadd(int mContentLeftPadd, int mContentTopPadd, int mContentRightPadd, int mContentBottomPadd) {
        dialogConfigBean.setContentLeftPadd(mContentLeftPadd);
        dialogConfigBean.setContentTopPadd(mContentTopPadd);
        dialogConfigBean.setContentRightPadd(mContentRightPadd);
        dialogConfigBean.setContentBottomPadd(mContentBottomPadd);
        return this;
    }

    public DialogBuilder setContent(String mContentStr, int mContentSize, int mContentColor) {
        dialogConfigBean.setContentStr(mContentStr);
        dialogConfigBean.setContentSize(mContentSize);
        dialogConfigBean.setContentColor(mContentColor);
        return this;
    }

    public DialogBuilder setContent(String mContentStr, int mContentSize, int mContentColor, boolean isContentBold) {
        dialogConfigBean.setContentStr(mContentStr);
        dialogConfigBean.setContentSize(mContentSize);
        dialogConfigBean.setContentColor(mContentColor);
        dialogConfigBean.setContentBold(isContentBold);
        return this;
    }

    public DialogBuilder setCancel(String mCancelStr, boolean mCancelBold) {
        dialogConfigBean.setCancelStr(mCancelStr);
        dialogConfigBean.setCancelBold(mCancelBold);
        return this;
    }

    public DialogBuilder setCancel(String mCancelStr, int mCancelSize, int mCancelColor) {
        dialogConfigBean.setCancelStr(mCancelStr);
        dialogConfigBean.setCancelSize(mCancelSize);
        dialogConfigBean.setCancelColor(mCancelColor);
        return this;
    }

    public DialogBuilder setCancel(String mCancelStr, int mCancelSize, int mCancelColor, boolean mCancelBold) {
        dialogConfigBean.setCancelStr(mCancelStr);
        dialogConfigBean.setCancelSize(mCancelSize);
        dialogConfigBean.setCancelColor(mCancelColor);
        dialogConfigBean.setCancelBold(mCancelBold);
        return this;
    }

    public DialogBuilder setConfirm(String mConfirmStr, int mConfirmSize, int mConfirmColor) {
        dialogConfigBean.setConfirmStr(mConfirmStr);
        dialogConfigBean.setConfirmSize(mConfirmSize);
        dialogConfigBean.setConfirmColor(mConfirmColor);
        return this;
    }

    public DialogBuilder setCanAndCon(String mCancelStr, String mContentStr, int mCanAndConSize, int mCanAndConColor) {
        dialogConfigBean.setCancelStr(mCancelStr);
        dialogConfigBean.setCancelSize(mCanAndConSize);
        dialogConfigBean.setCancelColor(mCanAndConColor);

        dialogConfigBean.setContentStr(mContentStr);
        dialogConfigBean.setConfirmSize(mCanAndConSize);
        dialogConfigBean.setConfirmColor(mCanAndConColor);
        return this;
    }

    public DialogBuilder setCanAndCon(String mCancelStr, String mContentStr, int mCanAndConSize, int mCanAndConColor, boolean isCanAndConBold) {
        dialogConfigBean.setCancelStr(mCancelStr);
        dialogConfigBean.setCancelSize(mCanAndConSize);
        dialogConfigBean.setCancelColor(mCanAndConColor);

        dialogConfigBean.setContentStr(mContentStr);
        dialogConfigBean.setConfirmSize(mCanAndConSize);
        dialogConfigBean.setConfirmColor(mCanAndConColor);

        dialogConfigBean.setCanAndConBold(isCanAndConBold);
        return this;
    }

    public DialogBuilder setLineWidth(int mLineWidth) {
        dialogConfigBean.setLineWidth(mLineWidth);
        return this;
    }

    public DialogBuilder setLineColor(int mLineColor) {
        dialogConfigBean.setLineColor(mLineColor);
        return this;
    }

    public DialogBuilder setSubmitLine(boolean submitLine) {
        dialogConfigBean.setSubmitLine(submitLine);
        return this;
    }

    public DialogBuilder setSontentLine(boolean sontentLine) {
        dialogConfigBean.setSontentLine(sontentLine);
        return this;
    }

    public DialogBuilder setCanAndConCenterLine(boolean canAndConCenterLine) {
        dialogConfigBean.setCanAndConCenterLine(canAndConCenterLine);
        return this;
    }

    public DialogBuilder setSubmit(String mSubmit) {
        dialogConfigBean.setSubmit(mSubmit);
        return this;
    }

    public DialogBuilder setSubmitSize(int mSubmitSize) {
        dialogConfigBean.setSubmitSize(mSubmitSize);
        return this;
    }

    public DialogBuilder setSubmitColor(int mSubmitColor) {
        dialogConfigBean.setSubmitColor(mSubmitColor);
        return this;
    }

    public DialogBuilder setContent(String mContentStr) {
        dialogConfigBean.setContentStr(mContentStr);
        return this;
    }

    public DialogBuilder setContentGravite(int mContentGravite) {
        dialogConfigBean.setContentGravite(mContentGravite);
        return this;
    }

    public DialogBuilder setContentSize(int mContentSize) {
        dialogConfigBean.setContentSize(mContentSize);
        return this;
    }

    public DialogBuilder setContentColor(int mContentColor) {
        dialogConfigBean.setContentColor(mContentColor);
        return this;
    }

    public DialogBuilder setBtnNumber(int btnNumber) {
        dialogConfigBean.setBtnNumber(btnNumber);
        return this;
    }

    public DialogBuilder setCancel(String mCancelStr) {
        dialogConfigBean.setCancelStr(mCancelStr);
        return this;
    }

    public DialogBuilder setCancelSize(int mCancelSize) {
        dialogConfigBean.setCancelSize(mCancelSize);
        return this;
    }

    public DialogBuilder setCancelColor(int mCancelColor) {
        dialogConfigBean.setCancelSize(mCancelColor);
        return this;
    }

    public DialogBuilder setConfirm(String mConfirmStr) {
        dialogConfigBean.setConfirmStr(mConfirmStr);
        return this;
    }

    public DialogBuilder setConfirmSize(int mConfirmSize) {
        dialogConfigBean.setConfirmSize(mConfirmSize);
        return this;
    }

    public DialogBuilder setConfirmColor(int mConfirmColor) {
        dialogConfigBean.setConfirmColor(mConfirmColor);
        return this;
    }

    public DialogBuilder setContentLeftPadd(int mContentLeftPadd) {
        dialogConfigBean.setContentLeftPadd(mContentLeftPadd);
        return this;
    }

    public DialogBuilder setContentTopPadd(int mContentTopPadd) {
        dialogConfigBean.setContentTopPadd(mContentTopPadd);
        return this;
    }

    public DialogBuilder setContentRightPadd(int mContentRightPadd) {
        dialogConfigBean.setContentRightPadd(mContentRightPadd);
        return this;
    }

    public DialogBuilder setContentBottomPadd(int mContentBottomPadd) {
        dialogConfigBean.setContentBottomPadd(mContentBottomPadd);
        return this;
    }

    public DialogBuilder setDefLine(int mLineWidth, int mLineColor) {
        dialogConfigBean.setLineWidth(mLineWidth);
        dialogConfigBean.setLineColor(mLineColor);
        return this;
    }

    public DialogBuilder setSubmitBold(boolean isSubmitBold) {
        dialogConfigBean.setSubmitBold(isSubmitBold);
        return this;
    }

    public DialogBuilder setContentBold(boolean isContentBold) {
        dialogConfigBean.setContentBold(isContentBold);
        return this;
    }

    public DialogBuilder setCanAndConBold(boolean isCanAndConBold) {
        dialogConfigBean.setCanAndConBold(isCanAndConBold);
        return this;
    }

    public DialogBuilder setSubmitLeftPadd(int mSubmitLeftPadd) {
        dialogConfigBean.setSubmitLeftPadd(mSubmitLeftPadd);
        return this;
    }

    public DialogBuilder setSubmitTopPadd(int mSubmitTopPadd) {
        dialogConfigBean.setSubmitTopPadd(mSubmitTopPadd);
        return this;
    }

    public DialogBuilder setSubmitRightPadd(int mSubmitRightPadd) {
        dialogConfigBean.setSubmitRightPadd(mSubmitRightPadd);
        return this;
    }

    public DialogBuilder setSubmitBottomPadd(int mSubmitBottomPadd) {
        dialogConfigBean.setSubmitBottomPadd(mSubmitBottomPadd);
        return this;
    }

    public DialogBuilder setClick(IDialogClick iDialogClick) {
        dialogConfigBean.setiDialogClick(iDialogClick);
        return this;
    }

    public DialogBuilder onTouch(IDialogTouchClick iDialogTouchClick) {
        dialogConfigBean.setiDialogTouchClick(iDialogTouchClick);
        return this;
    }

    public DialogBuilder setRecyclerViewBg(int recyclerViewBg) {
        dialogConfigBean.setRecyclerViewBg(recyclerViewBg);
        return this;
    }

    public DialogBuilder setCancelBg(int mCancelBg) {
        dialogConfigBean.setCancelBg(mCancelBg);
        return this;
    }

    public DialogBuilder setCancelPaddTop(int mCancelPaddTop) {
        dialogConfigBean.setCancelPaddTop(mCancelPaddTop);
        return this;
    }

    public DialogBuilder setCancelPaddBottom(int mCancelPaddBottom) {
        dialogConfigBean.setCancelPaddBottom(mCancelPaddBottom);
        return this;
    }

    public DialogBuilder setCancelPadd(int mCancelPaddTop, int mCancelPaddBottom) {
        dialogConfigBean.setCancelPaddTop(mCancelPaddTop);
        dialogConfigBean.setCancelPaddBottom(mCancelPaddBottom);
        return this;
    }

    public DialogBuilder setTopViewGroupBgStart(int topViewGroupBgStart) {
        dialogConfigBean.setTopViewGroupBgStart(topViewGroupBgStart);
        return this;
    }

    public DialogBuilder setTopViewGroupBgCenter(int topViewGroupBgCenter) {
        dialogConfigBean.setTopViewGroupBgCenter(topViewGroupBgCenter);
        return this;
    }

    public DialogBuilder setTopViewGroupBgEnd(int topViewGroupBgEnd) {
        dialogConfigBean.setTopViewGroupBgEnd(topViewGroupBgEnd);
        return this;
    }

    public DialogBuilder setTopBg(int topViewGroupBgStart, int topViewGroupBgCenter, int topViewGroupBgEnd) {
        dialogConfigBean.setTopViewGroupBgStart(topViewGroupBgStart);
        dialogConfigBean.setTopViewGroupBgCenter(topViewGroupBgCenter);
        dialogConfigBean.setTopViewGroupBgEnd(topViewGroupBgEnd);
        return this;
    }

    public DialogBuilder setTopViewGroupBg(int topViewGroupBg) {
        dialogConfigBean.setTopViewGroupBg(topViewGroupBg);
        return this;
    }

    public DialogBuilder addData(DialogListBean dialogListBean) {
        dialogConfigBean.getDatas().add(dialogListBean);
        return this;
    }

    public DialogBuilder setDatas(List<DialogListBean> dialogListBeans) {
        dialogConfigBean.getDatas().clear();
        dialogConfigBean.getDatas().addAll(dialogListBeans);
        return this;
    }

    public DialogBuilder setColumns(int columns) {
        dialogConfigBean.setColumns(columns);
        return this;
    }

    public DialogBuilder setCancelHeight(int mCancelHeight) {
        dialogConfigBean.setCancelHeight(mCancelHeight);
        return this;
    }

    public DialogBuilder setBottomCanCel(boolean bottomCanCel) {
        dialogConfigBean.setBottomCanCel(bottomCanCel);
        return this;
    }

    public DialogBuilder setSetHeight(boolean setHeight) {
        dialogConfigBean.setSetHeight(setHeight);
        return this;
    }

    public DialogBuilder setHeight(int height) {
        dialogConfigBean.setHeight(height);
        return this;
    }

    public DialogBuilder setLine(boolean line) {
        dialogConfigBean.setLine(line);
        return this;
    }

    public void create() {
        Context mContext = dialogConfigBean.getContext();
        Fragment mFragment = dialogConfigBean.getFragment();
        DialogProxy.obtain().getDialogFragment().setBuilder(dialogConfigBean);
        if (null != mContext && mContext instanceof AppCompatActivity) {
            DialogProxy.obtain().getDialogFragment().show(((AppCompatActivity) mContext).getSupportFragmentManager(), "弹框");
        } else if (null != mFragment) {
            DialogProxy.obtain().getDialogFragment().show(mFragment.getChildFragmentManager(), "弹框");
        }
    }
}
