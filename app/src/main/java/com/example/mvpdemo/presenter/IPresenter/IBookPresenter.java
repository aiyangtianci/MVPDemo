package com.example.mvpdemo.presenter.IPresenter;

import android.view.View;

/**
 * Created by aiyang on 2018/2/8.
 */

public interface IBookPresenter {
    void onCreate();
    void onStop();

    void attachView(Object view);
}
