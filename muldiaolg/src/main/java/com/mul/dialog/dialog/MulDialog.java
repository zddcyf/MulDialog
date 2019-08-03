package com.mul.dialog.dialog;

import android.app.DialogFragment;
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

import com.mul.dialog.DialogEnum;
import com.mul.dialog.ScreenUtils;
import com.mul.dialog.adapter.DialogAdapter;
import com.mul.dialog.build.DialogBuilder;
import com.mul.dialog.build.DialogDefBuilder;
import com.mul.dialog.build.DialogListBuilder;
import com.mul.dialog.click.def.IDialogDefAllClick;
import com.mul.dialog.click.def.IDialogDefCancelClick;
import com.mul.dialog.muldiaolg.R;

/**
 * Created by 盈东科技
 * on 2018/11/24
 * at 11:12
 * summary:
 */
public class MulDialog extends DialogFragment {
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
    private DialogBuilder mBuilder;
    private DialogDefBuilder mDefBuilder;
    private DialogListBuilder mListBuilder;
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
            if (mBuilder.getDialogGrivate() == DialogEnum.top.getCode()) {
                layoutParams.gravity = Gravity.TOP; // 位置
            } else if (mBuilder.getDialogGrivate() == DialogEnum.center.getCode()) {
                layoutParams.gravity = Gravity.CENTER; // 位置
            } else if (mBuilder.getDialogGrivate() == DialogEnum.bottom.getCode()) {
                layoutParams.gravity = Gravity.BOTTOM; // 位置
            } else {
                layoutParams.gravity = Gravity.CENTER; // 位置
            }
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;//宽度满屏
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;//高度满屏

            window.setAttributes(layoutParams);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mBgConslay = new RelativeLayout(mBuilder.getContext());
        mContentConslay = new ConstraintLayout(mBuilder.getContext());
        if (mBuilder.getDialogEnum() == DialogEnum.def.getCode()) {
            mDefBuilder = (DialogDefBuilder) mBuilder;
            getDefaultView();
            setDefClick();
        } else if (mBuilder.getDialogEnum() == DialogEnum.list.getCode() || mBuilder.getDialogEnum() == DialogEnum.recy.getCode()) {
            mListBuilder = (DialogListBuilder) mBuilder;
            getListView();
        } else {
            custView = View.inflate(mBuilder.getContext(), mBuilder.getLayoutId(), null);
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
        mBgConslay.setBackgroundColor(mBuilder.getContext().getResources().getColor(android.R.color.transparent));
        /**
         * 默认弹出框为中间时。中间的父布局
         */
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mContentConslay.getLayoutParams();
        if (mBuilder.getDialogGrivate() == DialogEnum.top.getCode()) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        } else if (mBuilder.getDialogGrivate() == DialogEnum.center.getCode()) {
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        } else if (mBuilder.getDialogGrivate() == DialogEnum.bottom.getCode()) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        } else {
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        }
        layoutParams.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.setMargins(ScreenUtils.px(mBuilder.getCenterLeftMar()), ScreenUtils.px(mBuilder.getCenterTopMar())
                , ScreenUtils.px(mBuilder.getCenterRightMar()), ScreenUtils.px(mBuilder.getCenterBottomMar()));
        mContentConslay.setLayoutParams(layoutParams);
        return mBgConslay;
    }

    private void getDefaultView() {
        mTitle = new AppCompatTextView(mBuilder.getContext());
        mSubmitLine = new View(mBuilder.getContext());
        mContent = new AppCompatTextView(mBuilder.getContext());
        mContentLine = new View(mBuilder.getContext());
        mCancel = new AppCompatTextView(mBuilder.getContext());
        mConfirm = new AppCompatTextView(mBuilder.getContext());
        mCanAndConCenterLine = new View(mBuilder.getContext());
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

    private void setDefClick() {
        mContentConslay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mDefBuilder.getiDialogDefClick()) {
                    if (mDefBuilder.getiDialogDefClick() instanceof IDialogDefAllClick) {
                        dismiss();
                        ((IDialogDefAllClick) mDefBuilder.getiDialogDefClick()).touchClick(v);
                    }
                }
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mDefBuilder.getiDialogDefClick()) {
                    dismiss();
                    if (mDefBuilder.getiDialogDefClick() instanceof IDialogDefAllClick) {
                        ((IDialogDefAllClick) mDefBuilder.getiDialogDefClick()).cancelClick(v);
                    } else if (mDefBuilder.getiDialogDefClick() instanceof IDialogDefCancelClick) {
                        ((IDialogDefCancelClick) mDefBuilder.getiDialogDefClick()).cancelClick(v);
                    }
                }
            }
        });

        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mDefBuilder.getiDialogDefClick()) {
                    dismiss();
                    mDefBuilder.getiDialogDefClick().confirmClick(v);
                }
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
        mTitle.setVisibility(TextUtils.isEmpty(mDefBuilder.getmSubmit()) ? View.GONE : View.VISIBLE);
        mSubmitLine.setVisibility(mDefBuilder.isSubmitLine() ? View.VISIBLE : View.GONE);
        mContentLine.setVisibility(mDefBuilder.isContentLine() ? View.VISIBLE : View.GONE);
        if (mDefBuilder.getBtnNumber() == DialogEnum.first.getCode()) {
            mCancel.setVisibility(View.GONE);
            mCanAndConCenterLine.setVisibility(View.GONE);
        } else if (mDefBuilder.getBtnNumber() == DialogEnum.second.getCode()) {
            mCancel.setVisibility(View.VISIBLE);
            mCanAndConCenterLine.setVisibility(View.VISIBLE);
        }
    }

    private void setContentLayout() {
        if (mBuilder.getCenterLayBg() != -1) {
            String resourceTypeName = getResources().getResourceTypeName(mBuilder.getCenterLayBg());
            if (resourceTypeName.contains("drawable")) {
                mContentConslay.setBackground(getResources().getDrawable(mBuilder.getCenterLayBg()));
            } else if (resourceTypeName.contains("color")) {
                mContentConslay.setBackgroundColor(getResources().getColor(mBuilder.getCenterLayBg()));
            }
        } else {
            if (mBuilder.getDialogEnum() == DialogEnum.def.getCode()) {
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
        mTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, mDefBuilder.getmSubmitSize() == -1 ? 14 : mDefBuilder.getmSubmitSize());
        mTitle.setTextColor(mBuilder.getContext().getResources().getColor(mDefBuilder.getmSubmitColor() == -1 ? R.color.color_323232 : mDefBuilder.getmSubmitColor()));
        mTitle.setPadding(mDefBuilder.getmSubmitLeftPadd(), mDefBuilder.getmSubmitTopPadd(), mDefBuilder.getmSubmitRightPadd(), mDefBuilder.getmSubmitBottomPadd());
        mTitle.setText(mDefBuilder.getmSubmit());
        if (mDefBuilder.isSubmitBold()) {
            TextPaint paint = mTitle.getPaint();
            paint.setFakeBoldText(true);
        }
    }

    /**
     * 提示下方的线
     */
    private void setSubmitLine() {
        constraintSet.constrainWidth(mSubmitLine.getId(), 0);
        constraintSet.constrainHeight(mSubmitLine.getId(), ScreenUtils.px(mDefBuilder.getmLineWidth()));
        setId(constraintSet, mSubmitLine.getId(), ConstraintSet.TOP, mTitle.getId(), ConstraintSet.BOTTOM);
        setId(constraintSet, mSubmitLine.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, mSubmitLine.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        mSubmitLine.setBackgroundColor(mBuilder.getContext().getResources().getColor(mDefBuilder.getmLineColor() == -1 ? R.color.color_774D4D4D : mDefBuilder.getmLineColor()));

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
        mContent.setGravity(mDefBuilder.getmContentGravite() == -1 ? Gravity.CENTER : mDefBuilder.getmContentGravite());
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, mDefBuilder.getmContentSize() == -1 ? 14 : mDefBuilder.getmContentSize());
        mContent.setTextColor(mBuilder.getContext().getResources().getColor(mDefBuilder.getmContentColor() == -1 ? R.color.color_323232 : mDefBuilder.getmContentColor()));
        mContent.setText(TextUtils.isEmpty(mDefBuilder.getmContentStr()) ? "请填写内容" : mDefBuilder.getmContentStr());
        mContent.setPadding(ScreenUtils.px(mDefBuilder.getmContentLeftPadd())
                , ScreenUtils.px(mDefBuilder.getmContentTopPadd())
                , ScreenUtils.px(mDefBuilder.getmContentRightPadd())
                , ScreenUtils.px(mDefBuilder.getmContentBottomPadd()));
        if (mDefBuilder.isContentBold()) {
            TextPaint paint = mContent.getPaint();
            paint.setFakeBoldText(true);
        }
    }

    /**
     * 内容下方的线
     */
    private void setDefContentLine() {
        constraintSet.constrainWidth(mContentLine.getId(), 0);
        constraintSet.constrainHeight(mContentLine.getId(), ScreenUtils.px(mDefBuilder.getmLineWidth()));
        setId(constraintSet, mContentLine.getId(), ConstraintSet.TOP, mContent.getId(), ConstraintSet.BOTTOM);
        setId(constraintSet, mContentLine.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, mContentLine.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        mContentLine.setBackgroundColor(mBuilder.getContext().getResources().getColor(mDefBuilder.getmLineColor() == -1 ? R.color.color_774D4D4D : mDefBuilder.getmLineColor()));
    }

    /**
     * 确认取消中间的线
     */
    private void setCanAndConCenterLine() {
        constraintSet.constrainWidth(mCanAndConCenterLine.getId(), ScreenUtils.px(mDefBuilder.getmLineWidth()));
        constraintSet.constrainHeight(mCanAndConCenterLine.getId(), 0);
        setId(constraintSet, mCanAndConCenterLine.getId(), ConstraintSet.TOP, mCancel.getId(), ConstraintSet.TOP);
        setId(constraintSet, mCanAndConCenterLine.getId(), ConstraintSet.BOTTOM, mCancel.getId(), ConstraintSet.BOTTOM);
        setId(constraintSet, mCanAndConCenterLine.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, mCanAndConCenterLine.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        mCanAndConCenterLine.setBackgroundColor(mBuilder.getContext().getResources().getColor(mDefBuilder.getmLineColor() == -1 ? R.color.color_774D4D4D : mDefBuilder.getmLineColor()));
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
        mCancel.setTextSize(TypedValue.COMPLEX_UNIT_SP, mDefBuilder.getmCancelSize() == -1 ? 14 : mDefBuilder.getmCancelSize());
        mCancel.setTextColor(mBuilder.getContext().getResources().getColor(mDefBuilder.getmCancelColor() == -1 ? R.color.color_007AFF : mDefBuilder.getmCancelColor()));
        mCancel.setText(TextUtils.isEmpty(mDefBuilder.getmCancelStr()) ? "取消" : mDefBuilder.getmCancelStr());
        if (mDefBuilder.isCanAndConBold()) {
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
        if (mDefBuilder.getBtnNumber() == DialogEnum.first.getCode()) {
            setId(constraintSet, mConfirm.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        } else if (mDefBuilder.getBtnNumber() == DialogEnum.second.getCode()) {
            setId(constraintSet, mConfirm.getId(), ConstraintSet.LEFT, mCanAndConCenterLine.getId(), ConstraintSet.RIGHT);
        }
        setId(constraintSet, mConfirm.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        mConfirm.setTextSize(TypedValue.COMPLEX_UNIT_SP, mDefBuilder.getmConfirmSize() == -1 ? 14 : mDefBuilder.getmConfirmSize());
        mConfirm.setTextColor(mBuilder.getContext().getResources().getColor(mDefBuilder.getmConfirmColor() == -1 ? R.color.color_007AFF : mDefBuilder.getmConfirmColor()));
        mConfirm.setText(TextUtils.isEmpty(mDefBuilder.getmConfirmStr()) ? "确认" : mDefBuilder.getmConfirmStr());
        if (mDefBuilder.isCanAndConBold()) {
            TextPaint paint = mConfirm.getPaint();
            paint.setFakeBoldText(true);
        }
    }

    private void setId(ConstraintSet constraintSet, int id, int startSide, int endId, int endSide) {
        constraintSet.connect(id, startSide, endId, endSide);
    }

    private void getListView() {
        mRecyclerView = new RecyclerView(mBuilder.getContext());
        mRecyclerView.setId(R.id.mRecyclerView);
        if (mListBuilder.getDialogEnum() == DialogEnum.list.getCode()) {
            // 类似于list列表形式的
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mBuilder.getContext()));
        } else if (mListBuilder.getDialogEnum() == DialogEnum.recy.getCode()) {
            // 类似于gridview形式的
            GridLayoutManager gridLayoutManager = new GridLayoutManager(mBuilder.getContext(), mListBuilder.getColumns());
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int itemViewType = mRecyclerView.getAdapter().getItemViewType(position);
                    if (itemViewType == DialogAdapter.CANCEL) {
                        return mListBuilder.getColumns();
                    }
                    return 1;
                }
            });
            mRecyclerView.setLayoutManager(gridLayoutManager);
        }
        mAdapter = new DialogAdapter((DialogListBuilder) mBuilder, this);
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
        if (((DialogListBuilder) mBuilder).getRecyclerViewBg() != -1) {
            String resourceTypeName = getResources().getResourceTypeName(((DialogListBuilder) mBuilder).getRecyclerViewBg());
            if (resourceTypeName.contains("drawable")) {
                mRecyclerView.setBackground(getResources().getDrawable(((DialogListBuilder) mBuilder).getRecyclerViewBg()));
            } else if (resourceTypeName.contains("color")) {
                mRecyclerView.setBackgroundColor(getResources().getColor(((DialogListBuilder) mBuilder).getRecyclerViewBg()));
            }
        }
    }

    public void setBuilder(DialogBuilder mBuilder) {
        this.mBuilder = mBuilder;
    }

    public void configCustView(ConfigView configView) {
        this.configView = configView;
    }


    public interface ConfigView {
        void configCustView(View v);
    }
}
