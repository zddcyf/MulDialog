package com.mul.dialog.bean;

/**
 * Created by 盈东科技
 * on 2018/11/26
 * at 14:40
 * summary:
 */
public class DialogListBean {
    /**
     * 设置上面view的数据
     */
    private String topStr;
    private boolean topBold;
    private int topSize = -1;
    private int topColor = -1;
    private int topGrivate = 10;
    private int topPaddLeft, topPaddTop, topPaddRight, topPaddBottom;

    /**
     * 设置下面的textview
     */
    private String bottomStr;
    private boolean bottomBold;
    private int bottomSize;
    private int bottomColor;
    private int bottomGrivate;
    private int bottomPaddLeft, bottomPaddTop, bottomPaddRight, bottomPaddBottom;

    /**
     * 设置图片
     */
    private int imageWidth = 0, imageHeight = 0;
    private int imageGrivate;
    private int selectImage = -1;
    private int unSelectImage = -1;
    private int imgPaddLeft, imgPaddTop, imgPaddRight, imgPaddBottom;

    private boolean lineVisiable = true;

    public boolean isLineVisiable() {
        return lineVisiable;
    }

    public DialogListBean setLineVisiable(boolean lineVisiable) {
        this.lineVisiable = lineVisiable;
        return this;
    }

    public String getTopStr() {
        return topStr;
    }

    public DialogListBean setTop(String topStr) {
        this.topStr = topStr;
        return this;
    }

    public int getTopSize() {
        return topSize;
    }

    public DialogListBean setTopSize(int topSize) {
        this.topSize = topSize;
        return this;
    }

    public int getTopColor() {
        return topColor;
    }

    public DialogListBean setTopColor(int topColor) {
        this.topColor = topColor;
        return this;
    }

    public int getTopGrivate() {
        return topGrivate;
    }

    public DialogListBean setTopGrivate(int topGrivate) {
        this.topGrivate = topGrivate;
        return this;
    }

    public DialogListBean setTop(String topStr, boolean topBold, int topGrivate) {
        this.topStr = topStr;
        this.topBold = topBold;
        this.topGrivate = topGrivate;
        return this;
    }

    public DialogListBean setTop(String topStr, boolean topBold) {
        this.topStr = topStr;
        this.topBold = topBold;
        return this;
    }

    public DialogListBean setTop(String topStr, int topSize, int topColor) {
        this.topStr = topStr;
        this.topSize = topSize;
        this.topColor = topColor;
        return this;
    }

    public DialogListBean setTop(String topStr, boolean topBold, int topSize, int topColor) {
        this.topStr = topStr;
        this.topBold = topBold;
        this.topSize = topSize;
        this.topColor = topColor;
        return this;
    }

    public DialogListBean setTop(String topStr, boolean topBold, int topSize, int topColor, int topGrivate) {
        this.topStr = topStr;
        this.topBold = topBold;
        this.topSize = topSize;
        this.topColor = topColor;
        this.topGrivate = topGrivate;
        return this;
    }

    public DialogListBean setTopPaddTB(int topPaddTop, int topPaddBottom) {
        this.topPaddTop = topPaddTop;
        this.topPaddBottom = topPaddBottom;
        return this;
    }

    public DialogListBean setTopPaddLR(int topPaddLeft, int topPaddRight) {
        this.topPaddLeft = topPaddLeft;
        this.topPaddRight = topPaddRight;
        return this;
    }

    public DialogListBean setTopPadd(int topPaddLeft, int topPaddTop, int topPaddRight, int topPaddBottom) {
        this.topPaddLeft = topPaddLeft;
        this.topPaddTop = topPaddTop;
        this.topPaddRight = topPaddRight;
        this.topPaddBottom = topPaddBottom;
        return this;
    }

    public DialogListBean setBottom(String bottomStr, boolean bottomBold) {
        this.bottomStr = bottomStr;
        this.bottomBold = bottomBold;
        return this;
    }

    public DialogListBean setBottom(String bottomStr, int bottomSize, int bottomColor) {
        this.bottomStr = bottomStr;
        this.bottomSize = bottomSize;
        this.bottomColor = bottomColor;
        return this;
    }

    public DialogListBean setBottom(String bottomStr, boolean bottomBold, int bottomSize, int bottomColor) {
        this.bottomStr = bottomStr;
        this.bottomBold = bottomBold;
        this.bottomSize = bottomSize;
        this.bottomColor = bottomColor;
        return this;
    }

    public DialogListBean setBottom(String bottomStr, boolean bottomBold, int bottomSize, int bottomColor, int bottomGrivate) {
        this.bottomStr = bottomStr;
        this.bottomBold = bottomBold;
        this.bottomSize = bottomSize;
        this.bottomColor = bottomColor;
        this.bottomGrivate = bottomGrivate;
        return this;
    }

    public boolean isTopBold() {
        return topBold;
    }

    public DialogListBean setTopBold(boolean topBold) {
        this.topBold = topBold;
        return this;
    }

    public boolean isBottomBold() {
        return bottomBold;
    }

    public DialogListBean setBottomBold(boolean bottomBold) {
        this.bottomBold = bottomBold;
        return this;
    }

    public int getTopPaddLeft() {
        return topPaddLeft;
    }

    public DialogListBean setTopPaddLeft(int topPaddLeft) {
        this.topPaddLeft = topPaddLeft;
        return this;
    }

    public int getTopPaddTop() {
        return topPaddTop;
    }

    public DialogListBean setTopPaddTop(int topPaddTop) {
        this.topPaddTop = topPaddTop;
        return this;
    }

    public int getTopPaddRight() {
        return topPaddRight;
    }

    public DialogListBean setTopPaddRight(int topPaddRight) {
        this.topPaddRight = topPaddRight;
        return this;
    }

    public int getTopPaddBottom() {
        return topPaddBottom;
    }

    public DialogListBean setTopPaddBottom(int topPaddBottom) {
        this.topPaddBottom = topPaddBottom;
        return this;
    }

    public String getBottomStr() {
        return bottomStr;
    }

    public DialogListBean setBottom(String bottomStr) {
        this.bottomStr = bottomStr;
        return this;
    }

    public int getBottomSize() {
        return bottomSize;
    }

    public DialogListBean setBottomSize(int bottomSize) {
        this.bottomSize = bottomSize;
        return this;
    }

    public int getBottomColor() {
        return bottomColor;
    }

    public DialogListBean setBottomColor(int bottomColor) {
        this.bottomColor = bottomColor;
        return this;
    }

    public int getBottomGrivate() {
        return bottomGrivate;
    }

    public DialogListBean setBottomGrivate(int bottomGrivate) {
        this.bottomGrivate = bottomGrivate;
        return this;
    }

    public int getBottomPaddLeft() {
        return bottomPaddLeft;
    }

    public DialogListBean setBottomPaddLeft(int bottomPaddLeft) {
        this.bottomPaddLeft = bottomPaddLeft;
        return this;
    }

    public int getBottomPaddTop() {
        return bottomPaddTop;
    }

    public DialogListBean setBottomPaddTop(int bottomPaddTop) {
        this.bottomPaddTop = bottomPaddTop;
        return this;
    }

    public int getBottomPaddRight() {
        return bottomPaddRight;
    }

    public DialogListBean setBottomPaddRight(int bottomPaddRight) {
        this.bottomPaddRight = bottomPaddRight;
        return this;
    }

    public int getBottomPaddBottom() {
        return bottomPaddBottom;
    }

    public DialogListBean setBottomPaddBottom(int bottomPaddBottom) {
        this.bottomPaddBottom = bottomPaddBottom;
        return this;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public DialogListBean setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
        return this;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public DialogListBean setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
        return this;
    }

    public int getImageGrivate() {
        return imageGrivate;
    }

    public DialogListBean setImageGrivate(int imageGrivate) {
        this.imageGrivate = imageGrivate;
        return this;
    }

    public int getSelectImage() {
        return selectImage;
    }

    public DialogListBean setSelectImage(int selectImage) {
        this.selectImage = selectImage;
        return this;
    }

    public int getUnSelectImage() {
        return unSelectImage;
    }

    public DialogListBean setUnSelectImage(int unSelectImage) {
        this.unSelectImage = unSelectImage;
        return this;
    }

    public int getImgPaddLeft() {
        return imgPaddLeft;
    }

    public DialogListBean setImgPaddLeft(int imgPaddLeft) {
        this.imgPaddLeft = imgPaddLeft;
        return this;
    }

    public int getImgPaddTop() {
        return imgPaddTop;
    }

    public DialogListBean setImgPaddTop(int imgPaddTop) {
        this.imgPaddTop = imgPaddTop;
        return this;
    }

    public int getImgPaddRight() {
        return imgPaddRight;
    }

    public DialogListBean setImgPaddRight(int imgPaddRight) {
        this.imgPaddRight = imgPaddRight;
        return this;
    }

    public int getImgPaddBottom() {
        return imgPaddBottom;
    }

    public DialogListBean setImgPaddBottom(int imgPaddBottom) {
        this.imgPaddBottom = imgPaddBottom;
        return this;
    }

    public DialogListBean setImgPaddTB(int imgPaddTop, int imgPaddBottom) {
        this.imgPaddTop = imgPaddTop;
        this.imgPaddBottom = imgPaddBottom;
        return this;
    }

    public DialogListBean setImgPaddLR(int imgPaddLeft, int imgPaddRight) {
        this.imgPaddLeft = imgPaddLeft;
        this.imgPaddRight = imgPaddRight;
        return this;
    }

    public DialogListBean setImgPadd(int imgPaddLeft, int imgPaddTop, int imgPaddRight, int imgPaddBottom) {
        this.imgPaddLeft = imgPaddLeft;
        this.imgPaddTop = imgPaddTop;
        this.imgPaddRight = imgPaddRight;
        this.imgPaddBottom = imgPaddBottom;
        return this;
    }
}
