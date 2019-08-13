package com.mul.diaolg.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mul.diaolg.R;
import com.mul.diaolg.dialog.adapter.DialogAdapter;
import com.mul.diaolg.dialog.bean.DialogListBean;
import com.mul.diaolg.dialog.click.DialogCanceledTouClick;
import com.mul.diaolg.dialog.click.DialogConAndCanOnClick;
import com.mul.diaolg.dialog.click.DialogListClick;
import com.mul.diaolg.dialog.click.DialogListTouchClick;
import com.mul.diaolg.dialog.click.DialogOnClick;
import com.mul.diaolg.utils.DensityUtils;
import com.mul.diaolg.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/8/28.
 * 自定义弹框
 */

public class DiaLogs {
    private static final DiaLogs u_dialog = new DiaLogs();
    private Dialog dialog; // 弹框
    private Context context; // 上下文
    private boolean isWindowCanceled = false; // 是否按屏幕别的地方消失掉弹框
    private int visible = View.GONE; // 是否显示提示文字
    private int layoutId; // 布局文件
    private int gravity; // 显示位置
    private String contentStr; // 中间提示文字
    private Spanned contentSpanned; // 中间提示文字
    private int leftPadd = 0; // 左边边距
    private int topPadd = 0; // 上边边距
    private int rightPadd = 0; // 右边边距
    private int bottomPadd = 0; // 下边边距

    private String cancelStr; // 取消按钮文本
    private String confirmStr; // 确认按钮文本

    private DialogAdapter adapter;
    private ArrayList<String> lists;
    private List<DialogListBean> beans;
    private boolean isLinearOrGrid; // 是那种列表式的
    private int gridCount; // 如果选择grid的话是几列
    private boolean isGridCancel; // 如果选择grid的话是几列

    public static DiaLogs getInstance() {
        return u_dialog;
    }

    /**
     * 上下文
     *
     * @param context 上下文
     * @return
     */
    public DiaLogs with(Context context) {
        this.context = context;
        return this;
    }

    /**
     * 是否显示提示文字
     *
     * @param visible
     * @return
     */
    public DiaLogs setVisible(int visible) {
        this.visible = visible;
        return this;
    }

    public DiaLogs setContents(ArrayList<String> lists) {
        this.lists = lists;
        return this;
    }

    public DiaLogs setContents(List<DialogListBean> beans) {
        this.beans = beans;
        return this;
    }

    /**
     * 是否为点击屏幕外消失弹框 true为点击外部小时 false为点击外部不消失
     *
     * @param isCanceled
     * @return
     */
    public DiaLogs isWindowCanceled(boolean isCanceled) {
        this.isWindowCanceled = isCanceled;
        return this;
    }

    /**
     * 添加布局文件
     *
     * @param layoutId
     * @return
     */
    public DiaLogs layoutId(int layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    /**
     * 设置弹出位置
     *
     * @param gravity
     * @return
     */
    public DiaLogs setGravity(int gravity) {
        if (StringUtils.isNotEmpty(gravity)) {
            this.gravity = gravity;
        } else {
            this.gravity = Gravity.CENTER;
        }
        return this;
    }

    /**
     * 设置内容
     *
     * @param contentStr
     * @return
     */
    public DiaLogs setContent(String contentStr) {
        contentSpanned= Html.fromHtml("");
        this.contentStr = contentStr;
        return this;
    }

    /**
     * 设置内容
     *
     * @param confirmStr
     * @param cancelStr
     * @return
     */
    public DiaLogs setConfirmAndCancel(String confirmStr, String cancelStr) {
        this.confirmStr = confirmStr;
        this.cancelStr = cancelStr;
        return this;
    }

    /**
     * 设置中间布局距离屏幕的距离
     *
     * @param leftPadd
     * @param topPadd
     * @param rightPadd
     * @param bottomPadd
     * @return
     */
    public DiaLogs setLayoutPadd(int leftPadd, int topPadd, int rightPadd, int bottomPadd) {
        this.leftPadd = leftPadd;
        this.rightPadd = rightPadd;
        this.topPadd = topPadd;
        this.bottomPadd = bottomPadd;
        return this;
    }

    /**
     * 设置列表形式的是linear形式还是grid形式 true为linear   false为grid
     *
     * @param isLinearOrGrid
     * @return
     */
    public DiaLogs isLinearOrGrid(boolean isLinearOrGrid) {
        this.isLinearOrGrid = isLinearOrGrid;
        return this;
    }

    /**
     * grid几列
     *
     * @param gridCount
     * @return
     */
    public DiaLogs setGridCount(int gridCount) {
        this.gridCount = gridCount;
        return this;
    }

    public DiaLogs isGridCancel(boolean isGridCancel) {
        this.isGridCancel = isGridCancel;
        return this;
    }

    /**
     * 对话框弹出到中间位置（非列表形式的） 只有确认的点击事件
     */
    public void showDialog(final DialogOnClick click) {
        dialog = new Dialog(context, R.style.Theme_Light_Dialog);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_default, null);
        RelativeLayout viewGroup = dialogView.findViewById(R.id.viewGroup);
        TextView prompt = dialogView.findViewById(R.id.prompt);
        TextView content = dialogView.findViewById(R.id.content);
        TextView cancel = dialogView.findViewById(R.id.cancel);
        TextView confirm = dialogView.findViewById(R.id.confirm);
        // 设置padding值
        viewGroup.setPadding(DensityUtils.dip2px(context, leftPadd), DensityUtils.dip2px(context, topPadd), DensityUtils.dip2px(context, rightPadd), DensityUtils.dip2px(context, bottomPadd));
        // 设置上方的提示是否显示
        prompt.setVisibility(visible);
        // 设置内容
        if (StringUtils.isNotEmpty(contentStr)) {
            content.setText(contentStr);
        }
        // 设置确认按钮
        if (StringUtils.isNotEmpty(confirmStr)) {
            confirm.setText(confirmStr);
        }
        // 设置取消按钮
        if (StringUtils.isNotEmpty(cancelStr)) {
            cancel.setText(cancelStr);
        }
        // 设置确定和取消按钮
        if (StringUtils.isNotEmpty(confirmStr) && StringUtils.isNotEmpty(cancelStr)) {
            confirm.setText(confirmStr);
            cancel.setText(cancelStr);
        }
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (click instanceof DialogConAndCanOnClick) {
                    ((DialogConAndCanOnClick) click).onClickCancel(v);
                }
                if (click instanceof DialogCanceledTouClick) {
                    ((DialogCanceledTouClick) click).onClickCancel(v);
                }
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                click.onClickConfirm(v);
            }
        });
        //获得dialog的window窗口
        Window window = dialog.getWindow();
        //设置dialog在屏幕底部
        window.setGravity(gravity);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        if (gravity == Gravity.BOTTOM) {
            window.setWindowAnimations(R.style.dialogStyle);
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
        if (click instanceof DialogCanceledTouClick) {
            viewGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                    ((DialogCanceledTouClick) click).onTouchCancel(view);
                }
            });
//            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                @Override
//                public void onCancel(DialogInterface dialogInterface) {
//                    dismiss();
//                    ((U_DialogCanceledTouClick) click).onTouchCancel(dialogInterface);
//                }
//            });
        } else {
//            dialog.setCanceledOnTouchOutside(isWindowCanceled);
            viewGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isWindowCanceled) {
                        dismiss();
                    }
                }
            });
        }
        showDialog(dialogView);
    }

    /**
     * 对话框弹出到中间位置（列表形式的）
     */
    public void showDialog(final DialogListClick click) {
        dialog = new Dialog(context, R.style.Theme_Light_Dialog);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_list_default, null);
        RecyclerView recyclerView = dialogView.findViewById(R.id.recyclerView);
        RelativeLayout viewGroup = dialogView.findViewById(R.id.viewGroup);
        if (isLinearOrGrid) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            adapter = new DialogAdapter(lists, isLinearOrGrid);
        } else {
            GridLayoutManager manager = new GridLayoutManager(context, gridCount);
            adapter = new DialogAdapter(beans, isLinearOrGrid, isGridCancel);
            if (isGridCancel) {
                manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if (position == beans.size()) {
                            return gridCount;
                        }
                        return 1;
                    }
                });
            }
            recyclerView.setLayoutManager(manager);
        }
        recyclerView.setAdapter(adapter);
        adapter.setonClick(new DialogListClick() {
            @Override
            public void onItemClick(int position, View view) {
                dismiss();
                click.onItemClick(position, view);
            }
        });

        //获得dialog的window窗口
        Window window = dialog.getWindow();
        //设置dialog在屏幕底部
        window.setGravity(gravity);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        if (gravity == Gravity.BOTTOM) {
            window.setWindowAnimations(R.style.dialogStyle);
        }
        window.getDecorView().setPadding(DensityUtils.dip2px(context, leftPadd), DensityUtils.dip2px(context, topPadd), DensityUtils.dip2px(context, rightPadd), DensityUtils.dip2px(context, bottomPadd));
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
//        dialog.setCanceledOnTouchOutside(isWindowCanceled);
        if (click instanceof DialogListTouchClick) {
            viewGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                    ((DialogListTouchClick) click).onTouchCancel(view);
                }
            });
        } else {
            viewGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isWindowCanceled) {
                        dismiss();
                    }
                }
            });
        }
        showDialog(dialogView);
    }

    /**
     * 弹出对话框（可扩展）
     */
    public View setView() {
        dialog = new Dialog(context, R.style.Theme_Light_Dialog);
        View dialogView = LayoutInflater.from(context).inflate(layoutId, null);
        //获得dialog的window窗口
        Window window = dialog.getWindow();
        //设置dialog在屏幕底部
        window.setGravity(gravity);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        if (gravity == Gravity.BOTTOM) {
            window.setWindowAnimations(R.style.dialogStyle);
        }
        window.getDecorView().setPadding(DensityUtils.dip2px(context, leftPadd), DensityUtils.dip2px(context, topPadd), DensityUtils.dip2px(context, rightPadd), DensityUtils.dip2px(context, bottomPadd));
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
        dialog.setCanceledOnTouchOutside(isWindowCanceled);
        showDialog(dialogView);
        return dialogView;
    }

    /**
     * 将自定义布局加载到dialog上
     *
     * @param dialogView
     */
    public void showDialog(View dialogView) {
        dialog.setContentView(dialogView);
        dialog.show();
    }

    /**
     * 将自定义布局的dialog消失掉
     */
    public void dismiss() {
        dialog.dismiss();
    }
}
