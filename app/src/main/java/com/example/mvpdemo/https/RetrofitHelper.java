package com.example.mvpdemo.https;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aiyang on 2018/7/4.
 *  Retrofit网络框架封装层
 */

public class RetrofitHelper {
    /**
     * 饿汉单例模式
     */
    private static RetrofitHelper instance = null;
    /**
     * 上下文
     */
    private Context mCntext;
    /**
     * OkHttp客户端
     */
    private OkHttpClient client = new OkHttpClient();
    /**
     * Gson转换工厂
     */
    private GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    /**
     * Retrofit对象
     */
    private Retrofit mRetrofit = null;

    /**
     * 对外静态实例化方法
     * @param context
     * @return
     */
    public static RetrofitHelper getInstance(Context context){
        if (instance == null){
            instance = new RetrofitHelper(context);
        }
        return instance;
    }

    //内部方法
    private RetrofitHelper(Context mContext){
        mCntext = mContext;
        resetApp();
    }

    //内部方法
    private void resetApp() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")//域名
                .client(client)                       //支持okhttp
                .addConverterFactory(factory)         //支持gson
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//支持rxjava
                .build();
    }

    //动态代理API
    public RetrofitAPI getRetrofitAPI(){
        return mRetrofit.create(RetrofitAPI.class);
    }
}
