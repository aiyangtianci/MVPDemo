package com.example.mvpdemo.model.Imoder;

import android.content.Context;

import com.example.mvpdemo.model.entity.Book;

/**
 * Created by aiyang on 2018/7/4.
 */

public interface IMainModel {

    interface GetBooksListener {

        void getBooksAPISuccess(Book mBook);

        void getBooksAPIError(String result);


    }

    void getSearchBooks(String name,String tag,int start,int count, IMainModel.GetBooksListener listener);

    void bind(Context context);

    void unbind();
}
