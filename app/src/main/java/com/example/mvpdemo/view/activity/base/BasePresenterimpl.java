package com.example.mvpdemo.view.activity.base;

import com.example.mvpdemo.https.APIManager;

/**
 * Created by aiyang on 2018/7/12.
 * 继承父类减少复写代码
 */

public class BasePresenterimpl<T extends BaseConstract.IBaseView> implements BaseConstract.IBasePersenter<T>{

    protected T mView;
    protected APIManager mAPIManager;
    @Override
    public void attachView(T view) {
        this.mView = view;   //原来是以注入方式写在P层细节构造函数中。现在利用父类的接口方法可以省去这一环节
    }

    @Override
    public void detachView() {
        if (mView != null){
            mView = null;
        }
    }
}
