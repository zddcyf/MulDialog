package com.mul.dialog.dialog;

import android.app.DialogFragment;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.mul.dialog.ScreenUtils;
import com.mul.dialog.adapter.DialogAdapter;
import com.mul.dialog.bean.DialogConfigBean;
import com.mul.dialog.build.DialogBuilder;
import com.mul.dialog.click.IDialogAllClick;
import com.mul.dialog.click.IDialogCancelClick;
import com.mul.dialog.constant.DialogPositionEnum;
import com.mul.dialog.constant.DialogStyleEnum;
import com.mul.dialog.muldiaolg.R;

/**
 * @ProjectName: MulDialog
 * @Package: com.mul.dialog.click
 * @ClassName: IDialogTouchClick
 * @Author: zdd
 * @CreateDate: 2019/12/3 20:59
 * @Description: java类作用描述
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/12/3 20:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0.0
 */
public class MulFragmentDialog extends DialogFragment {
    /**
     * 初始化view1
     */
    private RelativeLayout mBgConslay; // 针对于fragmentdialog
    private ConstraintLayout mContentConslay; // 针对内容布局

    /**
     * 初始化非列表式view
     */
    private AppCompatTextView mTitle;
    private View mSubmitLine;
    private AppCompatTextView mContent;
    private View mContentLine;
    private AppCompatTextView mCancel;
    private AppCompatTextView mConfirm;
    private View mCanAndConCenterLine;
    private ConstraintSet constraintSet;

    /**
     * 初始化列表形式view
     */
    private RecyclerView mRecyclerView;
    private DialogAdapter mAdapter;

    /**
     * 参数传递
     */
    private DialogConfigBean mDialogConfigBean;
    private View custView;
    private ConfigView configView;

    @Override
    public void onStart() {
        super.onStart();
        //设置动画、位置、宽度等属性（注意一：必须放在onStart方法中）
        Window window = getDialog().getWindow();
        if (window != null) {
            // 注意二：一定要设置Background，如果不设置，window属性设置无效
            window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
            WindowManager.LayoutParams layoutParams = window.getAttributes();

//            layoutParams.windowAnimations = R.style.MusicDialog;//动画
            if (mDialogConfigBean.getDialogPositionEnum() == DialogPositionEnum.top.getCode()) {
                layoutParams.gravity = Gravity.TOP; // 位置
            } else if (mDialogConfigBean.getDialogPositionEnum() == DialogPositionEnum.center.getCode()) {
                layoutParams.gravity = Gravity.CENTER; // 位置
            } else if (mDialogConfigBean.getDialogPositionEnum() == DialogPositionEnum.bottom.getCode()) {
                layoutParams.gravity = Gravity.BOTTOM; // 位置
            } else {
                layoutParams.gravity = Gravity.CENTER; // 位置
            }
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;//宽度满屏
//            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;//高度满屏
            layoutParams.height = getH(getActivity());//高度满屏

            window.setAttributes(layoutParams);
        }
    }

    /**
     * @return 手机屏幕的高度
     */
    public int getH(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mBgConslay = new RelativeLayout(mDialogConfigBean.getContext());
        mContentConslay = new ConstraintLayout(mDialogConfigBean.getContext());
        if (mDialogConfigBean.getDialogStyleEnum() == DialogStyleEnum.def.getCode()) {
            getDefaultView();
            setDefClick();
        } else if (mDialogConfigBean.getDialogStyleEnum() == DialogStyleEnum.list.getCode() || mDialogConfigBean.getDialogStyleEnum() == DialogStyleEnum.recy.getCode()) {
            getListView();
        } else {
            custView = View.inflate(mDialogConfigBean.getContext(), mDialogConfigBean.getLayoutId(), null);
            custView.setId(R.id.mulView);
            mContentConslay.addView(custView);
            constraintSet = new ConstraintSet();
            constraintSet.clone(mContentConslay);

            constraintSet.constrainWidth(custView.getId(), 0);
            constraintSet.constrainHeight(custView.getId(), ConstraintSet.WRAP_CONTENT);
            setId(constraintSet, custView.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
            setId(constraintSet, custView.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);

            constraintSet.applyTo(mContentConslay);
            if (null != configView) {
                configView.configCustView(custView);
            }
        }
        mBgConslay.addView(mContentConslay);
        mBgConslay.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mBgConslay.setBackgroundColor(mDialogConfigBean.getContext().getResources().getColor(android.R.color.transparent));
        /**
         * 默认弹出框为中间时。中间的父布局
         */
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mContentConslay.getLayoutParams();
        if (mDialogConfigBean.getDialogPositionEnum() == DialogPositionEnum.top.getCode()) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        } else if (mDialogConfigBean.getDialogPositionEnum() == DialogPositionEnum.center.getCode()) {
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        } else if (mDialogConfigBean.getDialogPositionEnum() == DialogPositionEnum.bottom.getCode()) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        } else {
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        }
        layoutParams.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.setMargins(ScreenUtils.px(mDialogConfigBean.getCenterLeftMar()), ScreenUtils.px(mDialogConfigBean.getCenterTopMar())
                , ScreenUtils.px(mDialogConfigBean.getCenterRightMar()), ScreenUtils.px(mDialogConfigBean.getCenterBottomMar()));
        mContentConslay.setLayoutParams(layoutParams);
        setTouch();
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return mBgConslay;
    }

    private void getDefaultView() {
        mTitle = new AppCompatTextView(mDialogConfigBean.getContext());
        mSubmitLine = new View(mDialogConfigBean.getContext());
        mContent = new AppCompatTextView(mDialogConfigBean.getContext());
        mContentLine = new View(mDialogConfigBean.getContext());
        mCancel = new AppCompatTextView(mDialogConfigBean.getContext());
        mConfirm = new AppCompatTextView(mDialogConfigBean.getContext());
        mCanAndConCenterLine = new View(mDialogConfigBean.getContext());
        /**
         * 设置id
         */
        mTitle.setId(R.id.mTitleId);
        mSubmitLine.setId(R.id.mSubmitLine);
        mContent.setId(R.id.mContentId);
        mContentLine.setId(R.id.mContentLine);
        mCancel.setId(R.id.mCancelId);
        mConfirm.setId(R.id.mConfirmId);
        mCanAndConCenterLine.setId(R.id.mCanAndConCenterLine);
        /**
         * 设置显示位置
         */
        mTitle.setGravity(Gravity.CENTER);
        mCancel.setGravity(Gravity.CENTER);
        mConfirm.setGravity(Gravity.CENTER);
        mContentConslay.addView(mTitle);
        mContentConslay.addView(mSubmitLine);
        mContentConslay.addView(mContent);
        mContentConslay.addView(mContentLine);
        mContentConslay.addView(mCancel);
        mContentConslay.addView(mConfirm);
        mContentConslay.addView(mCanAndConCenterLine);
        setDefParams();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogFullScreen);
    }

    private void setTouch() {
        mBgConslay.setOnClickListener(v -> {
            if (null != mDialogConfigBean.getiDialogClick()) {
                if (mDialogConfigBean.getiDialogClick() instanceof IDialogAllClick) {
                    ((IDialogAllClick) mDialogConfigBean.getiDialogClick()).touchClick(v);
                }
            } else if (null != mDialogConfigBean.getiDialogTouchClick()) {
                mDialogConfigBean.getiDialogTouchClick().touchClick(v);
            }
        });
    }

    private void setDefClick() {
        mCancel.setOnClickListener(v -> {
            if (null != mDialogConfigBean.getiDialogClick()) {
                dismiss();
                if (mDialogConfigBean.getiDialogClick() instanceof IDialogAllClick) {
                    ((IDialogAllClick) mDialogConfigBean.getiDialogClick()).cancelClick(v);
                } else if (mDialogConfigBean.getiDialogClick() instanceof IDialogCancelClick) {
                    ((IDialogCancelClick) mDialogConfigBean.getiDialogClick()).cancelClick(v);
                }
            }
        });

        mConfirm.setOnClickListener(v -> {
            if (null != mDialogConfigBean.getiDialogClick()) {
                dismiss();
                mDialogConfigBean.getiDialogClick().confirmClick(v, 0);
            }
        });
    }

    private void setDefParams() {
        constraintSet = new ConstraintSet();
        constraintSet.clone(mContentConslay);

        /**
         * 设置整体内容布局文件
         */
        setContentLayout();

        /**
         * 提示文字
         */
        setSubmit();
        /**
         * 提示下方的线
         */
        setSubmitLine();
        /**
         * 内容
         */
        setDefContentView();
        /**
         * 内容下方的线
         */
        setDefContentLine();
        /**
         * 取消按键
         */
        setDefCancelView();
        /**
         * 确认按键
         */
        setDefConfirmView();
        /**
         * 确认取消中间的线
         */
        setCanAndConCenterLine();

        constraintSet.applyTo(mContentConslay);
        mTitle.setVisibility(TextUtils.isEmpty(mDialogConfigBean.getmSubmit()) ? View.GONE : View.VISIBLE);
        mSubmitLine.setVisibility(mDialogConfigBean.isSubmitLine() ? View.VISIBLE : View.GONE);
        mContentLine.setVisibility(mDialogConfigBean.isSontentLine() ? View.VISIBLE : View.GONE);
        if (mDialogConfigBean.getBtnNumber() == DialogStyleEnum.first.getCode()) {
            mCancel.setVisibility(View.GONE);
            mCanAndConCenterLine.setVisibility(View.GONE);
        } else if (mDialogConfigBean.getBtnNumber() == DialogStyleEnum.second.getCode()) {
            mCancel.setVisibility(View.VISIBLE);
            mCanAndConCenterLine.setVisibility(View.VISIBLE);
        }
    }

    private void setContentLayout() {
        if (mDialogConfigBean.getCenterLayoutBg() != -1) {
            String resourceTypeName = getResources().getResourceTypeName(mDialogConfigBean.getCenterLayoutBg());
            if (resourceTypeName.contains("drawable")) {
                mContentConslay.setBackground(getResources().getDrawable(mDialogConfigBean.getCenterLayoutBg()));
            } else if (resourceTypeName.contains("color")) {
                mContentConslay.setBackgroundColor(getResources().getColor(mDialogConfigBean.getCenterLayoutBg()));
            }
        } else {
            if (mDialogConfigBean.getDialogStyleEnum() == DialogStyleEnum.def.getCode()) {
                mContentConslay.setBackground(getResources().getDrawable(R.drawable.dialog_def_bg));
            }
        }
    }

    /**
     * 设置提示文字
     */
    private void setSubmit() {
        constraintSet.constrainWidth(mTitle.getId(), 0);
        constraintSet.constrainHeight(mTitle.getId(), ConstraintSet.WRAP_CONTENT);
        setId(constraintSet, mTitle.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
        setId(constraintSet, mTitle.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, mTitle.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        mTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, mDialogConfigBean.getSubmitSize() == -1 ? 14 : mDialogConfigBean.getSubmitSize());
        mTitle.setTextColor(mDialogConfigBean.getContext().getResources().getColor(mDialogConfigBean.getSubmitColor() == -1 ? R.color.color_323232 : mDialogConfigBean.getSubmitColor()));
        mTitle.setPadding(mDialogConfigBean.getSubmitLeftPadd(), mDialogConfigBean.getSubmitTopPadd(), mDialogConfigBean.getmSubmitRightPadd(), mDialogConfigBean.getSubmitBottomPadd());
        mTitle.setText(mDialogConfigBean.getmSubmit());
        if (mDialogConfigBean.isSubmitBold()) {
            TextPaint paint = mTitle.getPaint();
            paint.setFakeBoldText(true);
        }
    }

    /**
     * 提示下方的线
     */
    private void setSubmitLine() {
        constraintSet.constrainWidth(mSubmitLine.getId(), 0);
        constraintSet.constrainHeight(mSubmitLine.getId(), ScreenUtils.px(mDialogConfigBean.getLineWidth()));
        setId(constraintSet, mSubmitLine.getId(), ConstraintSet.TOP, mTitle.getId(), ConstraintSet.BOTTOM);
        setId(constraintSet, mSubmitLine.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, mSubmitLine.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        mSubmitLine.setBackgroundColor(mDialogConfigBean.getContext().getResources().getColor(mDialogConfigBean.getLineColor() == -1 ? R.color.color_774D4D4D : mDialogConfigBean.getLineColor()));

    }

    /**
     * 设置内容
     */
    private void setDefContentView() {
        constraintSet.constrainWidth(mContent.getId(), 0);
        constraintSet.constrainHeight(mContent.getId(), ConstraintSet.WRAP_CONTENT);
        setId(constraintSet, mContent.getId(), ConstraintSet.TOP, mSubmitLine.getId(), ConstraintSet.BOTTOM);
        setId(constraintSet, mContent.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, mContent.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        mContent.setGravity(mDialogConfigBean.getContentGravite() == -1 ? Gravity.CENTER : mDialogConfigBean.getContentGravite());
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, mDialogConfigBean.getContentSize() == -1 ? 14 : mDialogConfigBean.getContentSize());
        mContent.setTextColor(mDialogConfigBean.getContext().getResources().getColor(mDialogConfigBean.getContentColor() == -1 ? R.color.color_323232 : mDialogConfigBean.getContentColor()));
        mContent.setText(TextUtils.isEmpty(mDialogConfigBean.getContentStr()) ? "请填写内容" : mDialogConfigBean.getContentStr());
        mContent.setPadding(ScreenUtils.px(mDialogConfigBean.getContentLeftPadd())
                , ScreenUtils.px(mDialogConfigBean.getContentTopPadd())
                , ScreenUtils.px(mDialogConfigBean.getContentRightPadd())
                , ScreenUtils.px(mDialogConfigBean.getContentBottomPadd()));
        if (mDialogConfigBean.isContentBold()) {
            TextPaint paint = mContent.getPaint();
            paint.setFakeBoldText(true);
        }
    }

    /**
     * 内容下方的线
     */
    private void setDefContentLine() {
        constraintSet.constrainWidth(mContentLine.getId(), 0);
        constraintSet.constrainHeight(mContentLine.getId(), ScreenUtils.px(mDialogConfigBean.getLineWidth()));
        setId(constraintSet, mContentLine.getId(), ConstraintSet.TOP, mContent.getId(), ConstraintSet.BOTTOM);
        setId(constraintSet, mContentLine.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, mContentLine.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        mContentLine.setBackgroundColor(mDialogConfigBean.getContext().getResources().getColor(mDialogConfigBean.getLineColor() == -1 ? R.color.color_774D4D4D : mDialogConfigBean.getLineColor()));
    }

    /**
     * 确认取消中间的线
     */
    private void setCanAndConCenterLine() {
        constraintSet.constrainWidth(mCanAndConCenterLine.getId(), ScreenUtils.px(mDialogConfigBean.getLineWidth()));
        constraintSet.constrainHeight(mCanAndConCenterLine.getId(), 0);
        setId(constraintSet, mCanAndConCenterLine.getId(), ConstraintSet.TOP, mCancel.getId(), ConstraintSet.TOP);
        setId(constraintSet, mCanAndConCenterLine.getId(), ConstraintSet.BOTTOM, mCancel.getId(), ConstraintSet.BOTTOM);
        setId(constraintSet, mCanAndConCenterLine.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, mCanAndConCenterLine.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        mCanAndConCenterLine.setBackgroundColor(mDialogConfigBean.getContext().getResources().getColor(mDialogConfigBean.getLineColor() == -1 ? R.color.color_774D4D4D : mDialogConfigBean.getLineColor()));
    }

    /**
     * 设置取消按钮
     */
    private void setDefCancelView() {
        constraintSet.constrainWidth(mCancel.getId(), 0);
        constraintSet.constrainHeight(mCancel.getId(), ScreenUtils.px(43));
        setId(constraintSet, mCancel.getId(), ConstraintSet.TOP, mContentLine.getId(), ConstraintSet.BOTTOM);
        setId(constraintSet, mCancel.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, mCancel.getId(), ConstraintSet.RIGHT, mCanAndConCenterLine.getId(), ConstraintSet.LEFT);
        mCancel.setTextSize(TypedValue.COMPLEX_UNIT_SP, mDialogConfigBean.getCancelSize() == -1 ? 14 : mDialogConfigBean.getCancelSize());
        mCancel.setTextColor(mDialogConfigBean.getContext().getResources().getColor(mDialogConfigBean.getCancelColor() == -1 ? R.color.color_007AFF : mDialogConfigBean.getCancelColor()));
        mCancel.setText(TextUtils.isEmpty(mDialogConfigBean.getCancelStr()) ? "取消" : mDialogConfigBean.getCancelStr());
        if (mDialogConfigBean.isCanAndConBold()) {
            TextPaint paint = mCancel.getPaint();
            paint.setFakeBoldText(true);
        }
    }

    /**
     * 设置确认按钮
     */
    private void setDefConfirmView() {
        constraintSet.constrainWidth(mConfirm.getId(), 0);
        constraintSet.constrainHeight(mConfirm.getId(), ScreenUtils.px(43));
        setId(constraintSet, mConfirm.getId(), ConstraintSet.TOP, mContentLine.getId(), ConstraintSet.BOTTOM);
        if (mDialogConfigBean.getBtnNumber() == DialogStyleEnum.first.getCode()) {
            setId(constraintSet, mConfirm.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        } else if (mDialogConfigBean.getBtnNumber() == DialogStyleEnum.second.getCode()) {
            setId(constraintSet, mConfirm.getId(), ConstraintSet.LEFT, mCanAndConCenterLine.getId(), ConstraintSet.RIGHT);
        }
        setId(constraintSet, mConfirm.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        mConfirm.setTextSize(TypedValue.COMPLEX_UNIT_SP, mDialogConfigBean.getConfirmSize() == -1 ? 14 : mDialogConfigBean.getConfirmSize());
        mConfirm.setTextColor(mDialogConfigBean.getContext().getResources().getColor(mDialogConfigBean.getConfirmColor() == -1 ? R.color.color_007AFF : mDialogConfigBean.getConfirmColor()));
        mConfirm.setText(TextUtils.isEmpty(mDialogConfigBean.getConfirmStr()) ? "确认" : mDialogConfigBean.getConfirmStr());
        if (mDialogConfigBean.isCanAndConBold()) {
            TextPaint paint = mConfirm.getPaint();
            paint.setFakeBoldText(true);
        }
    }

    private void setId(ConstraintSet constraintSet, int id, int startSide, int endId, int endSide) {
        constraintSet.connect(id, startSide, endId, endSide);
    }

    private void getListView() {
        mRecyclerView = new RecyclerView(mDialogConfigBean.getContext());
        mRecyclerView.setId(R.id.mRecyclerView);
        if (mDialogConfigBean.getDialogStyleEnum() == DialogStyleEnum.list.getCode()) {
            // 类似于list列表形式的
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mDialogConfigBean.getContext()));
        } else if (mDialogConfigBean.getDialogStyleEnum() == DialogStyleEnum.recy.getCode()) {
            // 类似于gridview形式的
            GridLayoutManager gridLayoutManager = new GridLayoutManager(mDialogConfigBean.getContext(), mDialogConfigBean.getColumns());
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int itemViewType = mRecyclerView.getAdapter().getItemViewType(position);
                    if (itemViewType == DialogAdapter.CANCEL) {
                        return mDialogConfigBean.getColumns();
                    }
                    return 1;
                }
            });
            mRecyclerView.setLayoutManager(gridLayoutManager);
        }
        mAdapter = new DialogAdapter(mDialogConfigBean, this);
        mRecyclerView.setAdapter(mAdapter);
        mContentConslay.addView(mRecyclerView);
        constraintSet = new ConstraintSet();
        constraintSet.clone(mContentConslay);

        constraintSet.constrainWidth(mRecyclerView.getId(), 0);
        constraintSet.constrainHeight(mRecyclerView.getId(), ConstraintSet.WRAP_CONTENT);
        setId(constraintSet, mRecyclerView.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, mRecyclerView.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);

        constraintSet.applyTo(mContentConslay);

        recyBg();
    }

    private void recyBg() {
        if (mDialogConfigBean.getRecyclerViewBg() != -1) {
            String resourceTypeName = getResources().getResourceTypeName(mDialogConfigBean.getRecyclerViewBg());
            if (resourceTypeName.contains("drawable")) {
                mRecyclerView.setBackground(getResources().getDrawable(mDialogConfigBean.getRecyclerViewBg()));
            } else if (resourceTypeName.contains("color")) {
                mRecyclerView.setBackgroundColor(getResources().getColor(mDialogConfigBean.getRecyclerViewBg()));
            }
        }
    }

    public void setBuilder(DialogConfigBean mBuilder) {
        this.mDialogConfigBean = mBuilder;
    }

    public void configCustView(ConfigView configView) {
        this.configView = configView;
    }

    public interface ConfigView {
        void configCustView(View v);
    }
}
