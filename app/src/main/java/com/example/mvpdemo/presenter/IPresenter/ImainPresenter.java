package com.example.mvpdemo.presenter.IPresenter;

import android.content.Context;

/**
 * Created by aiyang on 2018/7/4.
 */

public interface ImainPresenter {

    void getSearchBooks(String name,String tag,int start,int count);

    void bind(Context context);

    void unbind();


}
