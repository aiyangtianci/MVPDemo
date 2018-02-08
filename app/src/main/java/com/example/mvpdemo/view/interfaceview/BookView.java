package com.example.mvpdemo.view.interfaceview;


import com.example.mvpdemo.model.info.Book;

/**
 * Created by win764-1 on 2016/12/12.
 */

public interface BookView {
    void onSuccess(Book mBook);
    void onError(String result);
}
