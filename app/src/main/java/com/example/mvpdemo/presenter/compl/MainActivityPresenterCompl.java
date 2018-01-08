package com.example.mvpdemo.presenter.compl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvpdemo.model.info.UserInfo;
import com.example.mvpdemo.model.utils.DialogUtil;
import com.example.mvpdemo.presenter.IPresenter.IMainActivityPresenter;

import java.util.List;

/**
 * Created by aiyang on 2018/1/8.
 */

public class MainActivityPresenterCompl implements IMainActivityPresenter {
    /**
     * 提交数据
     * @param context
     * @param editList
     * @param progressBar
     */
    @Override
    public void submitData(final Context context, final List<EditText> editList, final ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
        final Handler mainHandler = new Handler(Looper.getMainLooper());
        new Thread() {
            @Override
            public void run() {
                /*模拟提交信息*/
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                UserInfo info = new UserInfo();
                info.setAge(editList.get(0).getText().toString());
                info.setGender(editList.get(1).getText().toString());
                info.setName(editList.get(2).getText().toString());
                info.setHobby(editList.get(3).getText().toString());
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                        DialogUtil.showSimpleDialog(context,"提示","提交数据完成");
                        initData(editList);
                    }
                });
            }
        }.start();
    }

    /**
     * 初始化数据
     * @param editList
     */
    @Override
    public void initData(List<EditText> editList) {
        for (EditText editText:editList)
            editText.setText("");
    }
}
