package com.example.mvpdemo.model.info;

import android.content.Context;


import com.example.mvpdemo.model.utils.RetrofitHelper;
import com.example.mvpdemo.model.utils.RetrofitService;

import rx.Observable;

/**
 * Created by win764-1 on 2016/12/12.
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }
    public Observable<Book> getSearchBooks(String name, String tag, int start, int count){
        return mRetrofitService.getSearchBooks(name,tag,start,count);
    }
}
