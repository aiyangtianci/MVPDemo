package com.example.mvpdemo.presenter.IPresenter;

import com.example.mvpdemo.view.activity.base.BaseConstract;
import com.example.mvpdemo.view.interfaceview.MainView;

/**
 * Created by aiyang on 2018/7/4.
 */

public interface ImainPresenter extends BaseConstract.IBasePersenter<MainView>{

    void getSearchBooks(String name,String tag,int start,int count);

}
