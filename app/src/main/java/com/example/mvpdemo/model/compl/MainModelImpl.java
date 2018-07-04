package com.example.mvpdemo.model.compl;

import android.content.Context;
import android.os.Handler;

import com.example.mvpdemo.https.APIManager;
import com.example.mvpdemo.model.Imoder.IMainModel;
import com.example.mvpdemo.model.entity.Book;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by aiyang on 2018/7/4.
 */

public class MainModelImpl implements IMainModel {

    private CompositeSubscription mCompositeSubscription;
    private APIManager mAPIManager;
    private Book mBook;
    @Override
    public void getSearchBooks(String name, String tag, int start, int count, final GetBooksListener listener) {
        mCompositeSubscription.add(mAPIManager.getSearchBooks(name,tag,start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onCompleted() {
                        if (mBook != null){
                            //为了效果，我延迟一下下
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    listener.getBooksAPISuccess(mBook);
                                }
                            }, 1000);

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        listener.getBooksAPIError("请求失败！！");
                    }

                    @Override
                    public void onNext(Book book) {
                        mBook = book;
                    }
                })
        );
    }

    @Override
    public void bind(Context context) {
        mCompositeSubscription = new CompositeSubscription();
        mAPIManager = new APIManager(context);
    }

    @Override
    public void unbind() {
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }
}
