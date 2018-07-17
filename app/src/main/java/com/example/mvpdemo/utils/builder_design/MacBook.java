package com.example.mvpdemo.utils.builder_design;

/**
 * Created by aiyang on 2018/7/16.
 */

public class MacBook extends Computer {
    public MacBook() {
    }

    @Override
    public void setOS() {
        mOS = "Mac OS X 10.10";
    }

    @Override
    public MacbookBuilder macbookBuilder(){

        return new MacbookBuilder(this);
    }


}
