package com.example.mvpdemo.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by aiyang on 2018/1/8.
 */

public class DialogUtil {

    //显示基本Dialog
    public static void showSimpleDialog(Context context,String title,String message) {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
//        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(title);
        builder.setMessage(message);

        //监听下方button点击事件
        builder.setPositiveButton("确认",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//            }
//        });

        //设置对话框是可取消的
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
