package com.mul.diaolg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @ProjectName: MulDialog
 * @Package: com.mul.diaolg
 * @ClassName: DialogActivity
 * @Author: zdd
 * @CreateDate: 2019/8/13 17:35
 * @Description: 类的作用描述
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/13 17:35
 * @UpdateRemark: 更新说明
 * @Version: v1.0.0
 */
public class DialogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.text1:
//                // 正常dialog弹出框
//                DiaLogs.getInstance().with(this)
//                        .setLayoutPadd(DialogStaticVariable.PADD_lEFT_25, DialogStaticVariable.PADD_TOP_0, DialogStaticVariable.PADD_RIGHT_25, DialogStaticVariable.PADD_BOTTOM_0)
//                        .setGravity(Gravity.CENTER)
//                        .setContent("确定要取消吗？")
//                        .showDialog(new DialogOnClick() {
//                            @Override
//                            public void onClickConfirm(View view) {
//                                Toast.makeText(HomeActivity.this, "测试", Toast.LENGTH_LONG).show();
//                            }
//                        });
//                break;
//            case R.id.text2:
//                // 自定义界面的dialog
//                View view1 = DiaLogs.getInstance().with(this)
//                        .setLayoutPadd(DialogStaticVariable.PADD_lEFT_25, DialogStaticVariable.PADD_TOP_0, DialogStaticVariable.PADD_RIGHT_25, DialogStaticVariable.PADD_BOTTOM_0)
//                        .layoutId(R.layout.dialog_default).setView();
//                DiaLogs.getInstance().showDialog(view1);
//                break;
//            case R.id.text3:
//                // 竖着列表式的dialog
//                strings.clear();
//                strings.add("男");
//                strings.add("女");
//                strings.add("取消");
//                DiaLogs.getInstance().with(this)
//                        .setContents(strings)
//                        .setGravity(Gravity.BOTTOM)
//                        .setLayoutPadd(0, 0, 0, 0)
//                        .isLinearOrGrid(true)
//                        .isWindowCanceled(true)
//                        .showDialog(new DialogListClick() {
//                            @Override
//                            public void onItemClick(int position, View view) {
//                                Toast.makeText(HomeActivity.this, "测试", Toast.LENGTH_LONG).show();
//                            }
//                        });
//                break;
//            case R.id.text4:
//                // 横向列表式的dialog
////                DiaLogs.getInstance().with(this)
////                        .setContents(getList())
////                        .setLayoutPadd(0, 0, 0, 0)
////                        .isGridCancel(true)
////                        .setGravity(Gravity.BOTTOM)
////                        .isWindowCanceled(true)
////                        .isLinearOrGrid(false)
////                        .setGridCount(4)
////                        .showDialog(new DialogListClick() {
////                            @Override
////                            public void onItemClick(int position, View view) {
////                                String tag = (String) view.getTag();
////                                /**
////                                 * 同过tag值获取到输入的什么文字
////                                 */
////                                if (StringUtils.isNotEmpty(tag)) {
////
////                                } else {
////
////                                }
////                            }
////                        });
//                break;
//            case R.id.text5:
//                new DialogDefBuilder()
//                        .with(this)
//                        .setContent("搜索正在加紧研发中")
//                        .setSubmitBold(true)
//                        .setCanAndConBold(true)
//                        .setClick(new IDialogAllClick() {
//                            @Override
//                            public void cancelClick(View v) {
//
//                            }
//
//                            @Override
//                            public void touchClick(View v) {
//
//                            }
//
//                            @Override
//                            public void confirmClick(View v) {
//
//                            }
//                        })
//                        .create();
//                break;
//            case R.id.text6:
//                new DialogListBuilder()
//                        .with(this)
//                        .setCancel("取消", true)
//                        .addData(new DialogListBean().setTop("男", true))
//                        .addData(new DialogListBean().setTop("女", true))
//                        .addData(new DialogListBean().setTop("中型", true))
//                        .setClick(new IDialogListCancelClick() {
//                            @Override
//                            public void cancelClick(View v) {
//
//                            }
//
//                            @Override
//                            public void btnClick(View v, int position) {
//
//                            }
//                        })
//                        .create();
//                break;
//        }
//    }
//
//    public static List<DialogListBean> getList() {
//        List<DialogListBean> strings = new ArrayList<>();
////        strings.add(new DialogListBean(R.mipmap.ic_launcher, "测试一", "测试一"));
////        strings.add(new DialogListBean(R.mipmap.ic_launcher, "测试二", "测试二"));
////        strings.add(new DialogListBean(R.mipmap.ic_launcher, "测试三", "测试三"));
////        strings.add(new DialogListBean(R.mipmap.ic_launcher, "测试四", "测试四"));
//        return strings;
//    }
}
