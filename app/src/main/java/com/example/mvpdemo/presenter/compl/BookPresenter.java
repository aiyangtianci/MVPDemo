package com.example.mvpdemo.presenter.compl;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.example.mvpdemo.model.info.Book;
import com.example.mvpdemo.model.info.DataManager;
import com.example.mvpdemo.presenter.IPresenter.IBookPresenter;
import com.example.mvpdemo.view.interfaceview.BookView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by aiyang on 2018/2/8.
 */

public class BookPresenter implements IBookPresenter{
    private CompositeSubscription mCompositeSubscription;

    private Context mContext;

    private Book mBook;

    private DataManager manager;

    private BookView mBookView;

    public BookPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onCreate() {
        manager = new DataManager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void attachView(Object view) {
        mBookView = (BookView)view;
    }

    public void getSearchBooks(String name,String tag,int start,int count){
        mCompositeSubscription.add(manager.getSearchBooks(name,tag,start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onCompleted() {
                        if (mBook != null){
                            mBookView.onSuccess(mBook);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mBookView.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(Book book) {
                        mBook = book;
                    }
                })
        );
    }
}
