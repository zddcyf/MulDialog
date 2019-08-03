package com.mul.dialog.build;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mul.dialog.bean.DialogListBean;
import com.mul.dialog.click.list.IDialogListClick;
import com.mul.dialog.dialog.MulDialog;
import com.mul.dialog.dialog.MulFragmentDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 盈东科技
 * on 2018/11/26
 * at 15:36
 * summary:
 */
public class DialogListBuilder extends DialogBuilder {
    private List<DialogListBean> datas = new ArrayList<>();
    private int columns = 1; // 有多少列
    private int centerLayBgImg = -1; // 针对内容布局背景用图片或者XML文件

    private int topViewGroupBg = -1;
    private int topViewGroupBgStart = -1;
    private int topViewGroupBgCenter = -1;
    private int topViewGroupBgEnd = -1;

    private boolean bottomCanCel = true; // 是否有底部取消按钮

    private int recyclerViewBg = -1; // 列表的整体背景

    /**
     * 底部线的颜色和高度以及是否展示
     */
    private boolean line = true;
    private float lineWidth = 0.5f;
    private int lineColor = -1;

    /**
     * 设置取消按钮
     *
     * @return
     */
    private int cancelBg = -1;
    private int cancelPaddTop = 8;
    private int cancelPaddBottom = 10;
    private String cancelStr;
    private boolean cancelBold = false;
    private int cancelColor = -1;
    private int cancelSize = -1;

    /**
     * 设置item的高
     */
    private boolean setHeight; // 是否设置item的高
    private int height; // item的高度
    private int cancelHeight; // item的高度
    private IDialogListClick iDialogListClick;

    private DialogListBuilder(){}

    public static DialogListBuilder builder() {
        return DialogListBuilderHolder.DIALOG_BUILDER;
    }

    private static class DialogListBuilderHolder {
        private static final DialogListBuilder DIALOG_BUILDER = new DialogListBuilder();
    }

    public DialogListBuilder with(Activity mContext) {
        super.with(mContext);
        return this;
    }

    public DialogListBuilder with(AppCompatActivity mContext) {
        super.with(mContext);
        return this;
    }

    public DialogListBuilder with(Fragment mContext) {
        super.with(mContext);
        return this;
    }

    public DialogListBuilder with(android.support.v4.app.Fragment mContext) {
        super.with(mContext);
        return this;
    }

    public DialogListBuilder with(Application mContext) {
        super.with(mContext);
        return this;
    }

    public DialogListBuilder setLayoutId(int layoutId) {
        super.setLayoutId(layoutId);
        return this;
    }

    public DialogListBuilder setBgColor(int bgColor) {
        super.setBgColor(bgColor);
        return this;
    }

    public DialogListBuilder setCenterLayBg(int centerLayBg) {
        super.setCenterLayBg(centerLayBg);
        return this;
    }

    public DialogListBuilder setDialogGrivate(int dialogGrivate) {
        super.setDialogGrivate(dialogGrivate);
        return this;
    }

    public DialogListBuilder setDialogEnum(int dialogEnum) {
        super.setDialogEnum(dialogEnum);
        return this;
    }

    public DialogListBuilder setCenterLeftMar(int mCenterLeftMar) {
        super.setCenterLeftMar(mCenterLeftMar);
        return this;
    }

    public DialogListBuilder setCenterTopMar(int mCenterTopMar) {
        super.setCenterTopMar(mCenterTopMar);
        return this;
    }

    public DialogListBuilder setCenterRightMar(int mCenterRightMar) {
        super.setCenterRightMar(mCenterRightMar);
        return this;
    }

    public DialogListBuilder setCenterBottomMar(int mCenterBottomMar) {
        super.setCenterBottomMar(mCenterBottomMar);
        return this;
    }

    public DialogListBuilder setCenterMargin(int mCenterLeftMar, int centerRightMar) {
        super.setCenterMargin(mCenterLeftMar, centerRightMar);
        return this;
    }

    public DialogListBuilder setCenterMargin(int mCenterLeftMar, int centerTopMar, int centerRightMar, int centerBottomMar) {
        super.setCenterMargin(mCenterLeftMar, centerTopMar, centerRightMar, centerBottomMar);
        return this;
    }

    public DialogListBuilder setRecyclerViewBg(int recyclerViewBg) {
        this.recyclerViewBg = recyclerViewBg;
        return this;
    }

    public int getCancelBg() {
        return cancelBg;
    }

    public DialogListBuilder setCancelBg(int cancelBg) {
        this.cancelBg = cancelBg;
        return this;
    }

    public int getCancelPaddTop() {
        return cancelPaddTop;
    }

    public DialogListBuilder setCancelPaddTop(int cancelPaddTop) {
        this.cancelPaddTop = cancelPaddTop;
        return this;
    }

    public int getCancelPaddBottom() {
        return cancelPaddBottom;
    }

    public DialogListBuilder setCancelPadd(int cancelPaddTop, int cancelPaddBottom) {
        this.cancelPaddTop = cancelPaddTop;
        this.cancelPaddBottom = cancelPaddBottom;
        return this;
    }

    public DialogListBuilder setCancelPaddBottom(int cancelPaddBottom) {
        this.cancelPaddBottom = cancelPaddBottom;
        return this;
    }

    public int getTopViewGroupBg() {
        return topViewGroupBg;
    }

    public int getTopViewGroupBgStart() {
        return topViewGroupBgStart;
    }

    public DialogListBuilder setTopViewGroupBgStart(int topViewGroupBgStart) {
        this.topViewGroupBgStart = topViewGroupBgStart;
        return this;
    }

    public int getTopViewGroupBgCenter() {
        return topViewGroupBgCenter;
    }

    public DialogListBuilder setTopViewGroupBgCenter(int topViewGroupBgCenter) {
        this.topViewGroupBgCenter = topViewGroupBgCenter;
        return this;
    }

    public int getTopViewGroupBgEnd() {
        return topViewGroupBgEnd;
    }

    public DialogListBuilder setTopViewGroupBgEnd(int topViewGroupBgEnd) {
        this.topViewGroupBgEnd = topViewGroupBgEnd;
        return this;
    }

    public DialogListBuilder setTopBg(int topViewGroupBgStart, int topViewGroupBgCenter, int topViewGroupBgEnd) {
        this.topViewGroupBgStart = topViewGroupBgStart;
        this.topViewGroupBgCenter = topViewGroupBgCenter;
        this.topViewGroupBgEnd = topViewGroupBgEnd;
        return this;
    }

    public DialogListBuilder setTopViewGroupBg(int topViewGroupBg) {
        this.topViewGroupBg = topViewGroupBg;
        return this;
    }

    public DialogListBuilder addData(DialogListBean dialogListBean) {
        datas.add(dialogListBean);
        return this;
    }

    public DialogListBuilder setDatas(List<DialogListBean> dialogListBeans) {
        datas.clear();
        datas.addAll(dialogListBeans);
        return this;
    }

    public DialogListBuilder setColumns(int columns) {
        this.columns = columns;
        return this;
    }

    public DialogListBuilder setCenterLayBgImg(int centerLayBgImg) {
        this.centerLayBgImg = centerLayBgImg;
        return this;
    }

    public boolean isBottomCanCel() {
        return bottomCanCel;
    }

    public int getCancelHeight() {
        return cancelHeight;
    }

    public DialogListBuilder setCancelHeight(int cancelHeight) {
        this.cancelHeight = cancelHeight;
        return this;
    }

    public DialogListBuilder setBottomCanCel(boolean bottomCanCel) {
        this.bottomCanCel = bottomCanCel;
        return this;
    }

    public boolean isSetHeight() {
        return setHeight;
    }

    public DialogListBuilder setSetHeight(boolean setHeight) {
        this.setHeight = setHeight;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public DialogListBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public String getCancelStr() {
        return cancelStr;
    }

    public DialogListBuilder setCancel(String cancelStr) {
        this.cancelStr = cancelStr;
        return this;
    }

    public boolean getCancelBold() {
        return cancelBold;
    }

    public DialogListBuilder setCancelBold(boolean cancelBold) {
        this.cancelBold = cancelBold;
        return this;
    }

    public DialogListBuilder setCancel(String cancelStr, boolean cancelBold) {
        this.cancelStr = cancelStr;
        this.cancelBold = cancelBold;
        return this;
    }

    public DialogListBuilder setCancel(String cancelStr, int cancelSize, int cancelColor) {
        this.cancelStr = cancelStr;
        this.cancelSize = cancelSize;
        this.cancelColor = cancelColor;
        return this;
    }

    public DialogListBuilder setCancel(String cancelStr, int cancelSize, int cancelColor, boolean cancelBold) {
        this.cancelStr = cancelStr;
        this.cancelSize = cancelSize;
        this.cancelColor = cancelColor;
        this.cancelBold = cancelBold;
        return this;
    }

    public int getCancelColor() {
        return cancelColor;
    }

    public DialogListBuilder setCancelColor(int cancelColor) {
        this.cancelColor = cancelColor;
        return this;
    }

    public int getCancelSize() {
        return cancelSize;
    }

    public DialogListBuilder setCancelSize(int cancelSize) {
        this.cancelSize = cancelSize;
        return this;
    }

    public boolean isLine() {
        return line;
    }

    public DialogListBuilder setLine(boolean line) {
        this.line = line;
        return this;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public DialogListBuilder setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public DialogListBuilder setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    public int getLineColor() {
        return lineColor;
    }

    public DialogListBuilder setLineColor(int lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    public List<DialogListBean> getDatas() {
        return datas;
    }

    public DialogListBuilder setClick(IDialogListClick iDialogListClick) {
        this.iDialogListClick = iDialogListClick;
        return this;
    }

    public IDialogListClick getiDialogListClick() {
        return iDialogListClick;
    }

    public int getColumns() {
        return columns;
    }

    public int getCenterLayBgImg() {
        return centerLayBgImg;
    }

    public int getRecyclerViewBg() {
        return recyclerViewBg;
    }

    public boolean isCancelBold() {
        return cancelBold;
    }
}
