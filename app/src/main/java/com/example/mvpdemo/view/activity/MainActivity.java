package com.example.mvpdemo.view.activity;

import android.os.Bundle;

import com.example.mvpdemo.R;
import com.example.mvpdemo.view.activity.base.BaseActivity;

public class MainActivity extends BaseActivity{


    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("首页");
        setBack(true);
    }
}
