package com.example.mvpdemo.utils.builder_design;

/**
 * Created by aiyang on 2018/7/16.
 */

public class main_test {

    public  void main(String[] args){
        //构建
        Builder mBuilder = new MacbookBuilder();
        //director组装
        Director pcDirector = new Director(mBuilder);
        //封装构建过程，4核、2g、mac系统
        pcDirector.construct("英特尔主板","Retina显示器");


        //链式
        Computer mComputer = new MacBook().macbookBuilder()
                .setBoard("英特尔主板")
                .setDisplay("Retina显示器")
                .setColor("银白色")
                .setBuildOS()
                .create();

    }
}
