package com.example.mvpdemo.presenter.compl;

import android.content.Context;

import com.example.mvpdemo.model.Imoder.IMainModel;
import com.example.mvpdemo.model.entity.Book;
import com.example.mvpdemo.presenter.IPresenter.ImainPresenter;
import com.example.mvpdemo.view.interfaceview.MainView;

/**
 * Created by aiyang on 2018/7/4.
 */

public class MainPresentImpl implements ImainPresenter , IMainModel.GetBooksListener{

    private IMainModel mainModel;
    private MainView mainView;

    public MainPresentImpl(IMainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;

    }

    @Override
    public void bind(Context context) {
        mainModel.bind(context);
    }

    @Override
    public void unbind() {
        mainModel.unbind();
    }

    @Override
    public void getSearchBooks(String name, String tag, int start, int count) {
        mainView.showProgress();
        mainModel.getSearchBooks(name,tag,start,count,this);
    }

    @Override
    public void getBooksAPISuccess(Book mBook) {
        mainView.hideProgress();
        mainView.setBooksUISuccess(mBook);
    }

    @Override
    public void getBooksAPIError(String result) {
        mainView.hideProgress();
        mainView.setBooksUIFail(result);
    }
}
