package com.example.mvpdemo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aiyang on 2018/7/16.
 *
 * 图片加载类
 */

public class ImageLoader {
    //内存缓存
    ImageCache mImageCache = new MemoryCache();
   /* //sd卡缓存
    DiskCache mDiskCache = new DiskCache();
    //双缓存
    DoubleCache mDoubleCache = new DoubleCache();
    //使用Sd卡缓存
    boolean isUseDiskCache = false;
    //使用双缓存
    boolean isUseDoubleCache = false;*/

    public void setImageLoader(ImageCache cache) {
        this.mImageCache = cache;
    }

    //固定线程池，数量为CPU数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());



    public void displayImage(final String url , final ImageView imageView){
        Bitmap bitmap = null;
     /*   if (isUseDoubleCache){
            bitmap = mDoubleCache.get(url);
        }else if (isUseDiskCache){
            bitmap = mDiskCache.get(url);
        }else{
            bitmap = mImageCache.get(url);
        }*/
        bitmap = mImageCache.get(url);
        if (bitmap != null){
            imageView.setImageBitmap(bitmap);
            return;
        }
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null){
                    return;
                }
                if (imageView.getTag().equals(url)){
                    imageView.setImageBitmap(bitmap);
                }
               /* if (isUseDoubleCache){
                    mDiskCache.put(url,bitmap);
                }else if (isUseDiskCache){
                    mDiskCache.put(url,bitmap);
                }else{
                    mImageCache.put(url,bitmap);
                }*/
                mImageCache.put(url,bitmap);
            }
        });
    }

    public Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try{
            URL url =new URL(imageUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

}
