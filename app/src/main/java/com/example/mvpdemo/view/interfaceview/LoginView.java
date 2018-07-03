package com.example.mvpdemo.view.interfaceview;

/**
 * Created by aiyang on 2018/1/8.
 *
 * UI接口
 */

public interface LoginView {
    /**
     * 显示进度条
     */
    void showProgress();

    /**
     * 隐藏进度条
     */
    void hideProgress();

    /**
     * 登录成功处理UI
     */
    void loginSuccess();

    /**
     * 登录失败处理UI
     */
    void loginFail();
}
