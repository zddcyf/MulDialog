package com.mul.diaolg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.mul.dialog.DialogEnum;
import com.mul.dialog.MulDialog;
import com.mul.dialog.bean.DialogListBean;
import com.mul.dialog.build.DialogDefBuilder;
import com.mul.dialog.build.DialogListBuilder;
import com.mul.dialog.click.def.IDialogDefAllClick;
import com.mul.dialog.click.list.IDialogListCancelClick;

public class MainActivity extends AppCompatActivity {
    private MulDialog cmDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text1:
                new DialogDefBuilder()
                        .with(this)
                        .setCenterMargin(50, 50)
                        .setContent("搜索正在加紧研发中")
                        .setSubmitBold(true)
                        .setCanAndConBold(true)
                        .setClick(new IDialogDefAllClick() {
                            @Override
                            public void cancelClick(View v) {

                            }

                            @Override
                            public void touchClick(View v) {

                            }

                            @Override
                            public void confirmClick(View v) {

                            }
                        })
                        .create();
                break;
            case R.id.text2:
                new DialogListBuilder()
                        .with(this)
                        .setDialogEnum(DialogEnum.list.getCode())
                        .setDialogGrivate(DialogEnum.bottom.getCode())
                        .setCenterMargin(50, 50)
                        .setCancel("取消", true)
                        .addData(new DialogListBean().setTop("男", true))
                        .addData(new DialogListBean().setTop("女", true))
                        .addData(new DialogListBean().setTop("中型", true))
                        .setClick(new IDialogListCancelClick() {
                            @Override
                            public void cancelClick(View v) {

                            }

                            @Override
                            public void btnClick(View v, int position) {

                            }
                        })
                        .create();
                break;
            case R.id.text3:
                cmDialog = new DialogDefBuilder()
                        .with(this)
                        .setDialogEnum(-1)
                        .setLayoutId(R.layout.ac_rel_dialog_surr)
                        .setCenterMargin(50, 50)
                        .create();
                cmDialog.configCustView(new MulDialog.ConfigView() {
                    @Override
                    public void configCustView(View v) {
                        AppCompatTextView submit = v.findViewById(R.id.submit);
                        AppCompatTextView cancel = v.findViewById(R.id.cancel);
                        AppCompatTextView confirm = v.findViewById(R.id.confirm);
                        final AppCompatEditText content = v.findViewById(R.id.content);

                        confirm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        });
                    }
                });
                break;
        }
    }
}
