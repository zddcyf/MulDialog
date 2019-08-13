package com.mul.diaolg.dialog.bean;

/**
 * Created by Admin on 2017/9/28.
 */

public class DialogListBean {
    private int icon;
    private String iconName;
    private String iconNameTag;

    public DialogListBean() {
    }

    public DialogListBean(int icon, String iconName) {
        this.icon = icon;
        this.iconName = iconName;
    }

    public DialogListBean(int icon, String iconName, String iconNameTag) {
        this.icon = icon;
        this.iconName = iconName;
        this.iconNameTag = iconNameTag;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getIconNameTag() {
        return iconNameTag;
    }

    public void setIconNameTag(String iconNameTag) {
        this.iconNameTag = iconNameTag;
    }
}
