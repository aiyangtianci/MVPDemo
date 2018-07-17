package com.example.mvpdemo.model.compl;

import android.content.Context;
import android.os.Handler;

import com.example.mvpdemo.https.APIManager;
import com.example.mvpdemo.model.Imoder.IMainModel;
import com.example.mvpdemo.model.entity.Book;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by aiyang on 2018/7/4.
 */

public class MainModelImpl implements IMainModel {

    private APIManager mAPIManager;
    private Book mBook;
    @Override
    public void getSearchBooks(String name, String tag, int start, int count, final GetBooksListener listener) {
       mAPIManager.getSearchBooks(name,tag,start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {

                    @Override
                    public void onComplete() {
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
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Book book) {
                        mBook = book;
                    }
                }
        );
    }

    @Override
    public void bind(Context context) {
        mAPIManager = new APIManager(context);
    }

    @Override
    public void unbind() {
    }
}
