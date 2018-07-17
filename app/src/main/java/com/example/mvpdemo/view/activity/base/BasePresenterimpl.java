package com.example.mvpdemo.view.activity.base;

/**
 * Created by aiyang on 2018/7/12.
 * 继承父类减少复写代码
 */

public class BasePresenterimpl<T extends BaseConstract.IBaseView> implements BaseConstract.IBasePersenter<T>{

    T mViewChild;

    @Override
    public void attachView(T view) {
        this.mViewChild = view;   //原来是以注入方式写在P层细节构造函数中。现在利用父类的接口方法可以省去这一环节
    }

    @Override
    public void detachView() {
        if (mViewChild != null){
            mViewChild = null;
        }
    }
}
