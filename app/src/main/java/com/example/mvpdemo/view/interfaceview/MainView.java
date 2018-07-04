package com.example.mvpdemo.view.interfaceview;

import com.example.mvpdemo.model.entity.Book;

/**
 * Created by aiyang on 2018/7/4.
 */

public interface MainView {

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
    void setBooksUISuccess(Book book);

    /**
     * 登录失败处理UI
     */
    void setBooksUIFail(String onError);
}
