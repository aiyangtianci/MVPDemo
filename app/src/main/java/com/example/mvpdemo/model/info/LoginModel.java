package com.example.mvpdemo.model.info;

/**
 * Created by aiyang on 2018/7/3.
 */

public interface LoginModel {

    interface OnLoginListener {
        void onLoginSuccess();

        void onLoginFail();
    }

    void loginSubmit(String username, String password, OnLoginListener listener);
}
