package com.mul.diaolg.dialog.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mul.diaolg.R;
import com.mul.diaolg.dialog.bean.DialogListBean;
import com.mul.diaolg.dialog.click.DialogListClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/8/31.
 * dialog弹框中的recycleview的adapter
 */

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.U_DialogHolder> {
    private Context context;
    private ArrayList<String> lists;
    private List<DialogListBean> beans;
    private DialogListClick onClick;
    private boolean isLinearOrGrid = true;
    private boolean isCancel = true;

    public DialogAdapter(ArrayList<String> lists, boolean isLinearOrGrid) {
        this.lists = lists;
        this.isLinearOrGrid = isLinearOrGrid;
    }

    public DialogAdapter(List<DialogListBean> beans, boolean isLinearOrGrid, boolean isCancel) {
        this.beans = beans;
        this.isLinearOrGrid = isLinearOrGrid;
        this.isCancel = isCancel;
    }

    @Override
    public U_DialogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (null == context) {
            context = parent.getContext();
        }
        View view = null;
        if (isLinearOrGrid) {
            view = View.inflate(context, R.layout.adapter_dialog, null);
        } else {
            view = View.inflate(context, R.layout.adapter_dialog_list, null);
            view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
        return new U_DialogHolder(view);
    }

    @Override
    public void onBindViewHolder(U_DialogHolder holder, final int position) {
        if (isLinearOrGrid) {
            setLinearLayout(holder, position);
        } else {
            setGirdLinearLayout(holder, position);
        }
    }

    /**
     * 上下列表式的加载
     *
     * @param holder
     * @param position
     */
    private void setLinearLayout(U_DialogHolder holder, final int position) {
        holder.content.setText(lists.get(position));
        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != onClick) {
                    onClick.onItemClick(position, view);
                }
            }
        });
    }

    /**
     * grid式的加载
     *
     * @param holder
     * @param position
     */
    private void setGirdLinearLayout(U_DialogHolder holder, final int position) {
        if (isCancel && position == beans.size()) {
            holder.icon.setVisibility(View.GONE);
            holder.iconName.setVisibility(View.GONE);
            holder.cancel.setVisibility(View.VISIBLE);
        } else {
            DialogListBean bean = beans.get(position);
            holder.iconLayout.setTag(bean.getIconNameTag());
            holder.icon.setBackgroundResource(bean.getIcon());
            holder.iconName.setText(bean.getIconName());
            holder.icon.setVisibility(View.VISIBLE);
            holder.iconName.setVisibility(View.VISIBLE);
            holder.cancel.setVisibility(View.GONE);
        }
        holder.iconLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != onClick) {
                    onClick.onItemClick(position, view);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return isLinearOrGrid ? null != lists ? lists.size() : 0 : null != beans ? isCancel ? beans.size() + 1 : beans.size() : 0;
    }

    public class U_DialogHolder extends RecyclerView.ViewHolder {
        private TextView content;
        private RelativeLayout iconLayout;
        private ImageView icon;
        private TextView iconName;
        private TextView cancel;

        public U_DialogHolder(View itemView) {
            super(itemView);
            if (isLinearOrGrid) {
                content = itemView.findViewById(R.id.content);
            } else {
                iconLayout = itemView.findViewById(R.id.iconLayout);
                icon = itemView.findViewById(R.id.icon);
                iconName = itemView.findViewById(R.id.iconName);
                cancel = itemView.findViewById(R.id.cancel);
            }
        }
    }

    public void setonClick(DialogListClick onClick) {
        this.onClick = onClick;
    }
}
