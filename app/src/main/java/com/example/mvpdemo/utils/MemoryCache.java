package com.example.mvpdemo.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by aiyang on 2018/7/16.
 * 图片缓存
 */

public class MemoryCache implements  ImageCache {

    LruCache<String,Bitmap> mImageCache ;

    public MemoryCache() {
        initImageCache();
    }


    private void initImageCache() {
        //计算可使用的最大内存
        final int maxMemory =(int)(Runtime.getRuntime().maxMemory() / 1024);
        //取4分之1位缓存内存
        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String ,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }
    @Override
    public void put (String url , Bitmap bitmap){
        mImageCache.put(url,bitmap);
    }

    @Override
    public Bitmap get(String url){
        return mImageCache.get(url);
    }
}
