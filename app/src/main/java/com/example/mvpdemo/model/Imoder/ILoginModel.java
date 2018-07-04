package com.example.mvpdemo.model.Imoder;

/**
 * Created by aiyang on 2018/7/3.
 */

public interface ILoginModel {

    interface OnLoginListener {
        void onLoginSuccess();

        void onLoginFail();
    }

    void loginSubmit(String username, String password, OnLoginListener listener);
}
