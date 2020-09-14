package com.mul.diaolg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mul.dialog.click.IDialogAllClick;
import com.mul.dialog.click.IDialogCancelClick;
import com.mul.dialog.constant.DialogPositionEnum;
import com.mul.dialog.constant.DialogStyleEnum;
import com.mul.dialog.dialog.MulFragmentDialog;
import com.mul.dialog.bean.DialogListBean;
import com.mul.dialog.proxy.DialogProxy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text1:
                DialogProxy.obtain().builder()
                        .with(this)
                        .setDialogStyleEnum(DialogStyleEnum.def.getCode())
                        .setDialogPositionEnum(DialogPositionEnum.center.getCode())
                        .setCenterMargin(50, 50)
                        .setContent("搜索正在加紧研发中")
                        .setSubmitBold(true)
                        .setCanAndConBold(true)
                        .onTouch(v1 -> Log.i("mainActivity", "touch"))
                        .setClick(new IDialogAllClick() {
                            @Override
                            public void cancelClick(View v) {

                            }

                            @Override
                            public void touchClick(View v) {
                                Log.i("mainActivity", "touchClick");
                            }

                            @Override
                            public void confirmClick(View v, int position) {

                            }
                        }).create();
                break;
            case R.id.text2:
                DialogProxy.obtain().builder()
                        .with(this)
                        .setDialogStyleEnum(DialogStyleEnum.list.getCode())
                        .setDialogPositionEnum(DialogPositionEnum.bottom.getCode())
                        .setCenterMargin(50, 50)
                        .setCancelHeight(30)
                        .setHeight(30)
                        .setCancel("取消", true)
                        .addData(new DialogListBean().setTop("男", true))
                        .addData(new DialogListBean().setTop("女", true))
                        .addData(new DialogListBean().setTop("中型", true))
                        .setClick(new IDialogCancelClick() {
                            @Override
                            public void confirmClick(View v, int position) {

                            }

                            @Override
                            public void cancelClick(View v) {

                            }
                        }).create();
                break;
            case R.id.text3:
                DialogProxy.obtain().builder()
                        .with(this)
                        .setDialogStyleEnum(-1)
                        .setLayoutId(R.layout.ac_rel_dialog_surr)
                        .onTouch(v1 -> DialogProxy.obtain().dismiss())
                        .setCenterMargin(50, 50).create();
                DialogProxy.obtain().configCustView(new MulFragmentDialog.ConfigView() {
                    @Override
                    public void configCustView(View v) {
                        v.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (v.getId() == R.id.mulView) {
                                    Toast.makeText(MainActivity.this, "我是设置后的总布局", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        AppCompatTextView submit = v.findViewById(R.id.submit);
                        AppCompatTextView cancel = v.findViewById(R.id.cancel);
                        AppCompatTextView confirm = v.findViewById(R.id.confirm);
                        final AppCompatEditText content = v.findViewById(R.id.content);
                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                DialogProxy.obtain().dismiss();
                            }
                        });
                        confirm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                DialogProxy.obtain().dismiss();
                            }
                        });
                    }
                });
                break;
            case R.id.text4:
                DialogProxy.obtain().builder()
                        .with(this)
                        .setDialogStyleEnum(DialogStyleEnum.recy.getCode())
                        .setColumns(4)
                        .setDialogPositionEnum(DialogPositionEnum.bottom.getCode())
                        .setRecyclerViewBg(android.R.color.white)
                        .setCancel("取消", 16, R.color.color_323232, true)
                        .setCancelPadd(0, 0)
                        .setCenterMargin(0, 0)
                        .addData(new DialogListBean().setLineVisiable(false).setTop("微信好友", 12, R.color.color_505050).setTopPaddTB(15, 7).setUnSelectImage(R.mipmap.ic_launcher).setImgPaddTop(15))
                        .addData(new DialogListBean().setLineVisiable(false).setTop("朋友圈", 12, R.color.color_505050).setTopPaddTB(15, 7).setUnSelectImage(R.mipmap.ic_launcher).setImgPaddTop(15))
                        .addData(new DialogListBean().setLineVisiable(false).setTop("QQ好友", 12, R.color.color_505050).setTopPaddTB(15, 7).setUnSelectImage(R.mipmap.ic_launcher).setImgPaddTop(15))
                        .addData(new DialogListBean().setLineVisiable(false).setTop("新浪微博", 12, R.color.color_505050).setTopPaddTB(15, 7).setUnSelectImage(R.mipmap.ic_launcher).setImgPaddTop(15))
                        .addData(new DialogListBean().setLineVisiable(false).setTop("复制链接", 12, R.color.color_505050).setTopPaddTB(15, 7).setUnSelectImage(R.mipmap.ic_launcher).setImgPaddTop(15))
                        .addData(new DialogListBean().setLineVisiable(false).setTop("举报", 12, R.color.color_505050).setTopPaddTB(15, 7).setUnSelectImage(R.mipmap.ic_launcher).setImgPaddTop(15))
                        .setClick(new IDialogCancelClick() {
                            @Override
                            public void confirmClick(View v, int position) {
                                String tag = (String) v.getTag();
                                switch (tag) {
                                    case "微信好友":
                                        break;
                                    case "朋友圈":
                                        break;
                                    case "QQ好友":
                                        break;
                                    case "新浪微博":
                                        break;
                                    case "复制链接":
                                        break;
                                    case "举报":
                                        break;
                                }
                            }

                            @Override
                            public void cancelClick(View v) {

                            }
                        })
                        .create();
                break;
        }
    }

    public static void getObjectAll(Object obj, JSONObject json) throws JSONException {
        Method[] methods = obj.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method m = methods[i];
            if (m.getName().startsWith("set")) {
                if (m.getParameterTypes().length != 1) {
                    continue;
                }

                if (m.getName().length() > 3) {
                    String temp = m.getName().substring(3);
                    String key = temp.toLowerCase();
                    Object value = json.opt(key);
                    if (value == null) {
                        key = temp.substring(0, 1).toLowerCase() + temp.substring(1);
                        value = json.opt(key);
                    }
                    if (m.getParameterTypes()[0].toString().endsWith("List")) {
                        JSONArray jsonArray = new JSONArray(json.optString(key));
                        ParameterizedType parameterizedType = (ParameterizedType) m.getGenericParameterTypes()[0];
                        Class<?> actualTypeArgument = (Class<?>) parameterizedType.getActualTypeArguments()[0];
                        List<Object> lists = new ArrayList<>();
                        for (int j = 0; j < jsonArray.length(); j++) {
                            Object list = null;
                            try {
                                list = actualTypeArgument.newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            getObjectAll(list, jsonArray.getJSONObject(j));
                            lists.add(list);
                        }
                        try {
                            m.invoke(obj, lists);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }

                    if (value != null) {
                        try {
                            m.invoke(obj, value);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }
}
