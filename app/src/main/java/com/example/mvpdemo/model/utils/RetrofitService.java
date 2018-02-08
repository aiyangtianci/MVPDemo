package com.example.mvpdemo.model.utils;




import com.example.mvpdemo.model.info.Book;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 */

public interface RetrofitService {
    @GET("book/search")
    Observable<Book> getSearchBooks(@Query("q") String name,
                                    @Query("tag") String tag, @Query("start") int start,
                                    @Query("count") int count);
}
