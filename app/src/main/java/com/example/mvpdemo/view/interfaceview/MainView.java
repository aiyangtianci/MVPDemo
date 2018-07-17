package com.example.mvpdemo.view.interfaceview;

import com.example.mvpdemo.model.entity.Book;
import com.example.mvpdemo.view.activity.base.BaseConstract;

/**
 * Created by aiyang on 2018/7/4.
 */

public interface MainView extends BaseConstract.IBaseView {

    /**
     * 登录成功处理UI
     */
    void setBooksUISuccess(Book book);
}
