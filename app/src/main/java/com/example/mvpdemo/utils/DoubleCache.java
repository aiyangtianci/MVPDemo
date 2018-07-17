package com.example.mvpdemo.utils;

import android.graphics.Bitmap;

/**
 * 开闭原则
 * Created by aiyang on 2018/7/16.
 * 双缓冲执行策略
 */

public class DoubleCache implements ImageCache{
    MemoryCache mMemoryCache = new MemoryCache();
    DiskCache mDiskCache = new DiskCache();

    //先从内存中获取，内存中没有再从SD卡中获取，
    @Override
    public Bitmap get(String url){
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null){
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    //将图片缓存到内存和SD卡中
    @Override
    public void put(String url ,Bitmap bmp){
        mMemoryCache.put(url,bmp);
        mDiskCache.put(url,bmp);
    }
}
