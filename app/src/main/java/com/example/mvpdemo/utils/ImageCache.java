package com.example.mvpdemo.utils;

import android.graphics.Bitmap;

/**
 * Created by aiyang on 2018/7/16.
 */

public interface ImageCache {

    void put (String url , Bitmap bitmap);

    Bitmap get(String url);
}
