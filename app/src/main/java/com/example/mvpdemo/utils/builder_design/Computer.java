package com.example.mvpdemo.utils.builder_design;

/**
 * Created by aiyang on 2018/7/16.
 * 抽象电脑类
 */

public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOS;
    protected String mColor;

    public Computer() {
    }
    //设置主板
    public void setBoard(String board){
        this.mBoard = board;
    }
    //设置显示器
    public void setDisplay(String display){
        this.mDisplay =display;
    }
    //设置操作系统
    public abstract void setOS();

    //设置颜色
    public void setmColor(String mColor) {
        this.mColor = mColor;
    }


    public abstract MacbookBuilder macbookBuilder();
}
