package com.example.mvpdemo.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.mvpdemo.R;

/**
 * 弹框工具类
 */
public class DialogUtil {

    /**
     *  显示基本Dialog
     */
    public static void showSimpleDialog(Context context, String title, String message , DialogInterface.OnClickListener clickListener) {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
//        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(title);
        builder.setMessage(message);
        //监听事件
        if (clickListener != null){
            builder.setPositiveButton("确认",clickListener);
        }else{
            builder.setPositiveButton("确认",null);
        }
        builder.setNegativeButton("取消",null);
        //设置对话框是可取消的
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private static ProgressDialog progressDialog;

    /**
     * 显示进度条
     * @param context
     * @param msg
     */
    public static void showProgress(Context context,String msg){
        if (progressDialog == null){
            progressDialog = new ProgressDialog(context);
        } else if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    /**
     * 关闭进度条
     */
    public static void dismissProgress(){
        if (progressDialog != null ){
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }
}
