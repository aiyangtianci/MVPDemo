package com.example.mvpdemo.view.activity.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * P层 与 V层 的抽象行为
 * Created by aiyang on 2018/7/17.
 * 依赖倒置原则：要求调用者和被调用者都依赖抽象，这样两者没有直接的关联和接触，在变动的时候，一方的变动不会影响另一方的变动。
 * 依赖倒置强调了抽象的重要性，针对接口编程，依赖于抽象而不依赖于具体。
 */

public interface BaseConstract {

    /*
     *定义p层行为
     */
    interface IBasePersenter<T extends IBaseView > {
        //连接V
        void attachView(T view);
        //分离
        void detachView();
    }

    /**
     * 定义v层行为
     */
    interface IBaseView{
        /**
         * 显示进度条
         */
        void showProgress();

        /**
         * 隐藏进度条
         */
        void hideProgress();

        /**
         * 登录失败处理UI
         */
        void showFaild(String onError);

        /**
         * 绑定生命周期
         *
         * @param <T>
         * @return
         */
        <T> LifecycleTransformer<T> bindToLife();
    }
}
