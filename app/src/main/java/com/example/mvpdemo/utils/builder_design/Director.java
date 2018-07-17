package com.example.mvpdemo.utils.builder_design;

/**
 * Created by aiyang on 2018/7/16.
 * 负责构建Computer
 */

public class Director {
    Builder mBuilder =null;

    public Director(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }
    /*
     *构造对象
     */
    public void construct(String board ,String display){
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOS();
    }
}
