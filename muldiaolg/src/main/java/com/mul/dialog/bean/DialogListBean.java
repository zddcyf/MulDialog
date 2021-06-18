package com.mul.dialog.bean;

/**
 * @ProjectName: MulDialog
 * @Package: com.mul.dialog.click
 * @ClassName: IDialogTouchClick
 * @Author: zdd
 * @CreateDate: 2019/12/3 20:59
 * @Description: 列表弹框的配置信息
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/12/3 20:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0.0
 */
public class DialogListBean {
    /**
     * 设置上面view的数据
     */
    private String topStr;
    private boolean topBold;
    private int topSize = -1;
    private int topColor = -1;
    private int topGravity = -1;
    private int topPaddingLeft, topPaddingTop, topPaddingRight, topPaddingBottom;

    /**
     * 设置下面的textview
     */
    private String bottomStr;
    private boolean bottomBold;
    private int bottomSize;
    private int bottomColor;
    private int bottomGravity = -1;
    private int bottomPaddingLeft, bottomPaddingTop, bottomPaddingRight, bottomPaddingBottom;

    /**
     * 设置图片
     */
    private int imageWidth = 0, imageHeight = 0;
    private int imageGravity;
    private int selectImage = -1;
    private int unSelectImage = -1;
    private int imgPaddingLeft, imgPaddingTop, imgPaddingRight, imgPaddingBottom;

    private boolean lineVisible = true;

    public boolean isLineVisible() {
        return lineVisible;
    }

    public DialogListBean setLineVisible(boolean lineVisible) {
        this.lineVisible = lineVisible;
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

    public int getTopGravity() {
        return topGravity;
    }

    public DialogListBean setTopGravity(int dialogListTopGravity) {
        this.topGravity = dialogListTopGravity;
        return this;
    }

    public DialogListBean setTop(String topStr, boolean topBold, int topGravity) {
        this.topStr = topStr;
        this.topBold = topBold;
        this.topGravity = topGravity;
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

    public DialogListBean setTop(String topStr, boolean topBold, int topSize, int topColor, int topGravity) {
        this.topStr = topStr;
        this.topBold = topBold;
        this.topSize = topSize;
        this.topColor = topColor;
        this.topGravity = topGravity;
        return this;
    }

    public DialogListBean setTopPaddingTB(int topPaddingTop, int topPaddingBottom) {
        this.topPaddingTop = topPaddingTop;
        this.topPaddingBottom = topPaddingBottom;
        return this;
    }

    public DialogListBean setTopPaddingLR(int topPaddingLeft, int topPaddingRight) {
        this.topPaddingLeft = topPaddingLeft;
        this.topPaddingRight = topPaddingRight;
        return this;
    }

    public DialogListBean setTopPadding(int topPaddingLeft, int topPaddingTop, int topPaddingRight, int topPaddingBottom) {
        this.topPaddingLeft = topPaddingLeft;
        this.topPaddingTop = topPaddingTop;
        this.topPaddingRight = topPaddingRight;
        this.topPaddingBottom = topPaddingBottom;
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

    public DialogListBean setBottom(String bottomStr, boolean bottomBold, int bottomSize, int bottomColor, int bottomGravity) {
        this.bottomStr = bottomStr;
        this.bottomBold = bottomBold;
        this.bottomSize = bottomSize;
        this.bottomColor = bottomColor;
        this.bottomGravity = bottomGravity;
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

    public int getTopPaddingLeft() {
        return topPaddingLeft;
    }

    public DialogListBean setTopPaddingLeft(int topPaddingLeft) {
        this.topPaddingLeft = topPaddingLeft;
        return this;
    }

    public int getTopPaddingTop() {
        return topPaddingTop;
    }

    public DialogListBean setTopPaddingTop(int topPaddingTop) {
        this.topPaddingTop = topPaddingTop;
        return this;
    }

    public int getTopPaddingRight() {
        return topPaddingRight;
    }

    public DialogListBean setTopPaddingRight(int topPaddingRight) {
        this.topPaddingRight = topPaddingRight;
        return this;
    }

    public int getTopPaddingBottom() {
        return topPaddingBottom;
    }

    public DialogListBean setTopPaddingBottom(int topPaddingBottom) {
        this.topPaddingBottom = topPaddingBottom;
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

    public int getBottomGravity() {
        return bottomGravity;
    }

    public DialogListBean setBottomGravity(int bottomGravity) {
        this.bottomGravity = bottomGravity;
        return this;
    }

    public int getBottomPaddingLeft() {
        return bottomPaddingLeft;
    }

    public DialogListBean setBottomPaddingLeft(int bottomPaddingLeft) {
        this.bottomPaddingLeft = bottomPaddingLeft;
        return this;
    }

    public int getBottomPaddingTop() {
        return bottomPaddingTop;
    }

    public DialogListBean setBottomPaddingTop(int bottomPaddingTop) {
        this.bottomPaddingTop = bottomPaddingTop;
        return this;
    }

    public int getBottomPaddingRight() {
        return bottomPaddingRight;
    }

    public DialogListBean setBottomPaddingRight(int bottomPaddingRight) {
        this.bottomPaddingRight = bottomPaddingRight;
        return this;
    }

    public int getBottomPaddingBottom() {
        return bottomPaddingBottom;
    }

    public DialogListBean setBottomPaddingBottom(int bottomPaddingBottom) {
        this.bottomPaddingBottom = bottomPaddingBottom;
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

    public int getImageGravity() {
        return imageGravity;
    }

    public DialogListBean setImageGravity(int imageGravity) {
        this.imageGravity = imageGravity;
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

    public int getImgPaddingLeft() {
        return imgPaddingLeft;
    }

    public DialogListBean setImgPaddingLeft(int imgPaddingLeft) {
        this.imgPaddingLeft = imgPaddingLeft;
        return this;
    }

    public int getImgPaddingTop() {
        return imgPaddingTop;
    }

    public DialogListBean setImgPaddingTop(int imgPaddingTop) {
        this.imgPaddingTop = imgPaddingTop;
        return this;
    }

    public int getImgPaddingRight() {
        return imgPaddingRight;
    }

    public DialogListBean setImgPaddingRight(int imgPaddingRight) {
        this.imgPaddingRight = imgPaddingRight;
        return this;
    }

    public int getImgPaddingBottom() {
        return imgPaddingBottom;
    }

    public DialogListBean setImgPaddingBottom(int imgPaddingBottom) {
        this.imgPaddingBottom = imgPaddingBottom;
        return this;
    }

    public DialogListBean setImgPaddingTB(int imgPaddingTop, int imgPaddingBottom) {
        this.imgPaddingTop = imgPaddingTop;
        this.imgPaddingBottom = imgPaddingBottom;
        return this;
    }

    public DialogListBean setImgPaddingLR(int imgPaddingLeft, int imgPaddingRight) {
        this.imgPaddingLeft = imgPaddingLeft;
        this.imgPaddingRight = imgPaddingRight;
        return this;
    }

    public DialogListBean setImgPadding(int imgPaddingLeft, int imgPaddingTop, int imgPaddingRight, int imgPaddingBottom) {
        this.imgPaddingLeft = imgPaddingLeft;
        this.imgPaddingTop = imgPaddingTop;
        this.imgPaddingRight = imgPaddingRight;
        this.imgPaddingBottom = imgPaddingBottom;
        return this;
    }
}
