package com.example.mvpdemo.api;


import com.example.mvpdemo.model.Book;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface DoubanApi {
    public final static String HOST = "Https://api.douban.com/";


    /**
     * 根据tag获取图书
     *
     * @param tag   搜索关键字
     * @param start 从多少开始，如从"0"开始
     * @param count 一次请求的数目 最多100
     */

    @GET("v2/book/search")
    Observable<Book.BookListBean> getBookListWithTag(@Query("tag") String tag, @Query("start") int
            start, @Query("count") int count);

}
