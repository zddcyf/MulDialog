package com.mul.dialog.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.mul.dialog.constant.DialogListTopEnum;
import com.mul.dialog.dialog.MulFragmentDialog;
import com.mul.dialog.ScreenUtils;
import com.mul.dialog.bean.DialogListBean;
import com.mul.dialog.build.DialogListBuilder;
import com.mul.dialog.click.list.IDialogListCancelClick;
import com.mul.dialog.muldiaolg.R;

/**
 * Created by 盈东科技
 * on 2018/11/26
 * at 14:39
 * summary:
 */
public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogHolder> {

    private final DialogListBuilder mListBuilder;
    private final MulFragmentDialog cmDialog;
    private Context mContext;

    public static int CANCEL = 2;

    public DialogAdapter(DialogListBuilder mListBuilder, MulFragmentDialog cmDialog) {
        this.mListBuilder = mListBuilder;
        this.cmDialog = cmDialog;
    }

    @NonNull
    @Override
    public DialogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (null == mContext) {
            mContext = parent.getContext();
        }
        ConstraintLayout view = new ConstraintLayout(mContext);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        if (viewType == CANCEL) {
            createCancelView(view);
        } else {
            createView(view);
        }
        return new DialogHolder(view, viewType);
    }

    private void createView(ConstraintLayout view) {
        AppCompatTextView topView = new AppCompatTextView(mContext);
        AppCompatTextView bottomView = new AppCompatTextView(mContext);
        AppCompatImageView imageView = new AppCompatImageView(mContext);
        View lineView = new View(mContext);
        topView.setId(R.id.mListTop);
        bottomView.setId(R.id.mListBottom);
        imageView.setId(R.id.mListImage);
        lineView.setId(R.id.mListLine);

        view.addView(topView);
        view.addView(bottomView);
        view.addView(imageView);
        view.addView(lineView);

        ConstraintSet topSet = new ConstraintSet();
        topSet.clone(view);
        topSet.constrainWidth(topView.getId(), ConstraintSet.WRAP_CONTENT);
        topSet.constrainHeight(topView.getId(), ConstraintSet.WRAP_CONTENT);
        setId(topSet, topView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
        setId(topSet, topView.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(topSet, topView.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);

        topSet.constrainWidth(bottomView.getId(), 0);
        topSet.constrainHeight(bottomView.getId(), ConstraintSet.WRAP_CONTENT);
        setId(topSet, bottomView.getId(), ConstraintSet.TOP, topView.getId(), ConstraintSet.BOTTOM);
        setId(topSet, bottomView.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(topSet, bottomView.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);

        topSet.constrainWidth(lineView.getId(), ConstraintSet.MATCH_CONSTRAINT);
        topSet.constrainHeight(lineView.getId(), ScreenUtils.px(mListBuilder.getLineWidth()));
        setId(topSet, lineView.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);

        topSet.applyTo(view);
    }

    private void createCancelView(ConstraintLayout view) {
        AppCompatTextView cancel = new AppCompatTextView(mContext);

        cancel.setId(R.id.mListCancel);

        view.addView(cancel);

        ConstraintSet bottomSet = new ConstraintSet();
        bottomSet.clone(view);
        bottomSet.constrainWidth(cancel.getId(), 0);
        bottomSet.constrainHeight(cancel.getId(), ScreenUtils.px(mListBuilder.getCancelHeight() == 0 ? 57 : mListBuilder.getCancelHeight()));
        setId(bottomSet, cancel.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
        setId(bottomSet, cancel.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(bottomSet, cancel.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        bottomSet.applyTo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType != CANCEL) {
            DialogListBean dialogListBean = mListBuilder.getDatas().get(position);

            /**
             * 设置整体
             */
            if (mListBuilder.getTopViewGroupBg() == -1) {
                if (position == 0) {
                    holder.viewGroup.setBackground(mContext.getResources().getDrawable(mListBuilder.getTopViewGroupBgStart() == -1 ? R.drawable.dialog_list_bg_start : mListBuilder.getTopViewGroupBgStart()));
                    holder.lineView.setVisibility(View.VISIBLE);
                } else if (position == mListBuilder.getDatas().size() - 1) {
                    holder.viewGroup.setBackground(mContext.getResources().getDrawable(mListBuilder.getTopViewGroupBgEnd() == -1 ? R.drawable.dialog_list_bg_end : mListBuilder.getTopViewGroupBgEnd()));
                    holder.lineView.setVisibility(View.GONE);
                } else {
                    holder.viewGroup.setBackground(mContext.getResources().getDrawable(mListBuilder.getTopViewGroupBgCenter() == -1 ? R.drawable.dialog_list_bg_center : mListBuilder.getTopViewGroupBgCenter()));
                    holder.lineView.setVisibility(View.VISIBLE);
                }
            } else {
                if (position == mListBuilder.getDatas().size() - 1) {
                    holder.lineView.setVisibility(View.GONE);
                } else {
                    holder.lineView.setVisibility(View.VISIBLE);
                }
                holder.viewGroup.setBackground(mContext.getResources().getDrawable(mListBuilder.getTopViewGroupBg()));
            }

            /**
             * 设置上面的view
             */
            holder.topView.setText(dialogListBean.getTopStr());
            holder.topView.setTextColor(mContext.getResources().getColor(dialogListBean.getTopColor() == -1 ? R.color.color_007AFF : dialogListBean.getTopColor()));
            holder.topView.setTextSize(TypedValue.COMPLEX_UNIT_SP, dialogListBean.getTopSize() == -1 ? 18 : dialogListBean.getTopSize());
            holder.topView.setPadding(ScreenUtils.px(dialogListBean.getTopPaddLeft())
                    , ScreenUtils.px(dialogListBean.getTopPaddTop())
                    , ScreenUtils.px(dialogListBean.getTopPaddRight())
                    , ScreenUtils.px(dialogListBean.getTopPaddBottom()));
            setTextGrivate(holder.topView, dialogListBean.getDialogListTopGrivate());

            /**
             * 设置下面的view
             */
            if (!TextUtils.isEmpty(dialogListBean.getBottomStr())) {
                holder.bottomView.setVisibility(View.VISIBLE);
                holder.bottomView.setText(dialogListBean.getBottomStr());
                holder.bottomView.setTextColor(mContext.getResources().getColor(dialogListBean.getBottomColor() == -1 ? R.color.color_007AFF : dialogListBean.getBottomColor()));
                holder.bottomView.setTextSize(TypedValue.COMPLEX_UNIT_SP, dialogListBean.getBottomSize() == -1 ? 18 : dialogListBean.getBottomSize());
                holder.bottomView.setPadding(ScreenUtils.px(dialogListBean.getBottomPaddLeft())
                        , ScreenUtils.px(dialogListBean.getBottomPaddTop())
                        , ScreenUtils.px(dialogListBean.getBottomPaddRight())
                        , ScreenUtils.px(dialogListBean.getBottomPaddBottom()));
                setTextGrivate(holder.bottomView, dialogListBean.getBottomGrivate());
            } else {
                holder.bottomView.setVisibility(View.GONE);
                if (dialogListBean.getUnSelectImage() == -1)
                    holder.topView.setHeight(ScreenUtils.px(57));
            }

            if (dialogListBean.getUnSelectImage() == -1) {
                holder.imageView.setVisibility(View.GONE);
            } else {
                holder.imageView.setVisibility(View.VISIBLE);
                holder.imageView.setImageResource(dialogListBean.getUnSelectImage());
                setImageView(holder);
                holder.imageView.setPadding(ScreenUtils.px(dialogListBean.getImgPaddLeft())
                        , ScreenUtils.px(dialogListBean.getImgPaddTop())
                        , ScreenUtils.px(dialogListBean.getImgPaddRight())
                        , ScreenUtils.px(dialogListBean.getImgPaddBottom()));
            }
            setBold(holder.topView, dialogListBean.isTopBold());
            setBold(holder.bottomView, dialogListBean.isBottomBold());
            holder.viewGroup.setTag(holder.topView.getText().toString());
            holder.viewGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cmDialog.dismiss();
                    if (null != mListBuilder.getiDialogListClick()) {
                        mListBuilder.getiDialogListClick().btnClick(v, position);
                    }
                }
            });

            /**
             * 设置线
             */
            holder.lineView.setBackgroundColor(mContext.getResources().getColor(mListBuilder.getLineColor() == -1 ? R.color.color_774D4D4D : mListBuilder.getLineColor()));
            if (dialogListBean.isLineVisiable()) {
                holder.lineView.setVisibility(View.VISIBLE);
            } else {
                holder.lineView.setVisibility(View.GONE);
            }
        } else {
            holder.viewGroup.setPadding(0, ScreenUtils.px(mListBuilder.getCancelPaddTop()), 0, ScreenUtils.px(mListBuilder.getCancelPaddBottom()));
            holder.cancel.setBackground(mContext.getResources().getDrawable(mListBuilder.getCancelBg() == -1 ? R.drawable.dialog_list_bg_cancel : mListBuilder.getCancelBg()));
            holder.cancel.setText(mListBuilder.getCancelStr());
            holder.cancel.setTextSize(TypedValue.COMPLEX_UNIT_SP, mListBuilder.getCancelSize() == -1 ? 18 : mListBuilder.getCancelSize());
            holder.cancel.setTextColor(mContext.getResources().getColor(mListBuilder.getCancelColor() == -1 ? R.color.color_505050 : mListBuilder.getCancelColor()));
            holder.cancel.setGravity(Gravity.CENTER);
            setBold(holder.cancel, mListBuilder.isBottomCanCel());
            holder.viewGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cmDialog.dismiss();
                    if (null != mListBuilder.getiDialogListClick() && mListBuilder.getiDialogListClick() instanceof IDialogListCancelClick) {
                        ((IDialogListCancelClick) mListBuilder.getiDialogListClick()).cancelClick(v);
                    }
                }
            });
        }
    }

    private void setImageView(DialogHolder holder) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(holder.viewGroup);
        constraintSet.constrainWidth(holder.imageView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainHeight(holder.imageView.getId(), ConstraintSet.WRAP_CONTENT);
        setId(constraintSet, holder.imageView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
        setId(constraintSet, holder.imageView.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        setId(constraintSet, holder.imageView.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);

        setId(constraintSet, holder.topView.getId(), ConstraintSet.TOP, holder.imageView.getId(), ConstraintSet.BOTTOM);
        constraintSet.applyTo(holder.viewGroup);
    }

    private void setBold(AppCompatTextView textView, boolean isBold) {
        if (isBold) {
            TextPaint paint = textView.getPaint();
            paint.setFakeBoldText(true);
        }
    }

    private void setId(ConstraintSet constraintSet, int id, int startSide, int endId, int endSide) {
        constraintSet.connect(id, startSide, endId, endSide);
    }

    private void setTextGrivate(AppCompatTextView topView, int topGrivate) {
        topView.setGravity(topGrivate == DialogListTopEnum.bottom.getCode() ? Gravity.BOTTOM
                : topGrivate == DialogListTopEnum.top.getCode() ? Gravity.TOP
                : topGrivate == DialogListTopEnum.left.getCode() ? Gravity.LEFT
                : topGrivate == DialogListTopEnum.right.getCode() ? Gravity.RIGHT
                : topGrivate == DialogListTopEnum.center.getCode() ? Gravity.CENTER
                : Gravity.CENTER);
    }

    @Override
    public int getItemCount() {
        return null != mListBuilder.getDatas() && mListBuilder.getDatas().size() != 0 ? mListBuilder.isBottomCanCel() ? mListBuilder.getDatas().size() + 1 : mListBuilder.getDatas().size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mListBuilder.getDatas().size() && mListBuilder.isBottomCanCel()) {
            return CANCEL;
        }
        return super.getItemViewType(position);
    }

    public class DialogHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout viewGroup;
        private AppCompatTextView topView;
        private AppCompatTextView bottomView;
        private AppCompatImageView imageView;
        private View lineView;

        private AppCompatTextView cancel;

        public DialogHolder(View itemView, int viewType) {
            super(itemView);
            viewGroup = (ConstraintLayout) itemView;
            if (viewType == CANCEL) {
                cancel = itemView.findViewById(R.id.mListCancel);
            } else {
                topView = itemView.findViewById(R.id.mListTop);
                bottomView = itemView.findViewById(R.id.mListBottom);
                imageView = itemView.findViewById(R.id.mListImage);
                lineView = itemView.findViewById(R.id.mListLine);
            }
        }
    }
}
