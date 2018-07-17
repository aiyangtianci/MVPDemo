package com.example.mvpdemo.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by aiyang on 2018/7/16.
 */

public final class CloseUtils {
    public static void closeQuietly(Closeable closeable){
        if (null != closeable){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
